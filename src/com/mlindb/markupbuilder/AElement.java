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
    private final String tag;
    private final boolean isSelfTerminating;
    private final boolean isLinebreakOnStartTag;
    protected final String id;
    protected final List<String> classes;
    protected final List<Builder> children;

    AElement(Tag tag) {
        this.tag = tag.getValue();
        this.isSelfTerminating = tag.isSelfTerminating();
        this.isLinebreakOnStartTag = tag.isLinebreakOnStartTag();
        this.id = null;

        children = new ArrayList<>();
        classes = new ArrayList<>();
    }

    protected void addChild(Builder child) {
        children.add(child);
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append(makeStartTag());
        children.forEach(child -> sb.append(child.build()));

        if (!isSelfTerminating)
            sb.append(makeEndTag());

        return sb.toString();
    }

    private String makeStartTag() {
        String classesString = null;
        if (!classes.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            classes.forEach(s -> {
                sb.append(" ");
                sb.append(s);
            });
            classesString = sb.toString();
        }

        return "<" + tag
                + (id != null ? " id=\" + id + \"" : "")
                + (classes.isEmpty() ? "" : " class=\"" + classesString + "\"")
                + (isSelfTerminating ? "/>" : ">")
                + (isLinebreakOnStartTag ? System.lineSeparator() : "");
    }

    private String makeEndTag() {
        return "</" + tag + ">" + System.lineSeparator();
    }
}
