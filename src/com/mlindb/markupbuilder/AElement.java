package com.mlindb.markupbuilder;

/*
Copyright 2015 Magnus Lindberg - magnus.m.lindberg@gmail.com

This file is part of MarkupBuilder.

MarkupBuilder is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

MarkupBuilder is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with MarkupBuilder.  If not, see <http://www.gnu.org/licenses/>.
*/

import java.util.ArrayList;
import java.util.List;

abstract class AElement implements Html5Builder.Element {

    protected final Tag tag;
    protected String id;
    protected final List<String> classes;
    protected final List<Builder> children;

    AElement(Tag tag) {
        this.tag = tag;
        this.id = null;

        children = new ArrayList<>();
        classes = new ArrayList<>();
    }

    protected void addChild(Builder child) {
        children.add(child);
    }

    /**
     * Interface Element implementation
     * @return
     */
    public Html5Builder.Element setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Interface Element implementation
     * @return
     */
    public Html5Builder.Element addClass(String classname) {
        classes.add(classname);
        return this;
    }

    /**
     * Interface Element implementation
     * @return
     */
    public Html5Builder.Element setInlineStyle(InlineStyle style) {
        return this;
    }

    /**
     * Interface Builder implementation
     * @return
     */
    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append(makeStartTag());
        children.forEach(child -> sb.append(child.build()));

        if (!tag.isSelfTerminating())
            sb.append(makeEndTag());

        return sb.toString();
    }

    public String build(String content) {
        return content;
    }

    private String makeStartTag() {
        String classesString = null;
        if (!classes.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            classes.forEach(s -> {
                sb.append(" ");
                sb.append(s);
            });
            classesString = sb.toString().substring(1);
        }

        return "<" + tag.getValue()
                + (id != null ? " id=\" + id + \"" : "")
                + (classes.isEmpty() ? "" : " class=\"" + classesString + "\"")
                + (tag.isSelfTerminating() ? "/>" : ">")
                + (tag.isLinebreakOnStartTag() ? System.lineSeparator() : "");
    }

    private String makeEndTag() {
        return "</" + tag.getValue() + ">" + System.lineSeparator();
    }
}
