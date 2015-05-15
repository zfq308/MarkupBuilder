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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AElement implements Html5Builder.Element {

    protected final Tag tag;
    private String id;
    private final List<String> classes;
    private final List<Builder> children;
    private final Map<String, String> styles;

    AElement(Tag tag) {
        this.tag = tag;
        this.id = null;

        classes = new ArrayList<>();
        children = new ArrayList<>();
        styles = new HashMap<>();
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
        styles.putAll(style.getStyles());
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
        return "<" + tag.getValue()
                + (classes.isEmpty() ? "" : " class=\"" + makeClassString() + "\"")
                + (id != null ? " id=\"" + id + "\"" : "")
                + (styles.isEmpty() ? "" : makeStyleString())
                + (tag.getAttributes().isEmpty() ? "" : makeAttributeString())
                + (tag.isSelfTerminating() ? "/>" : ">")
                + (tag.isLinebreakOnStartTag() ? System.lineSeparator() : "");
    }

    private String makeEndTag() {
        return "</" + tag.getValue() + ">" + System.lineSeparator();
    }

    private String makeAttributeString() {
        String attributes = "";
        if (!tag.getAttributes().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            tag.getAttributes().keySet().forEach(ak -> {
                sb.append(" ");
                sb.append(ak + "=\"" + tag.getAttributes().get(ak) + "\"");
            });
            attributes = sb.toString();
        }
        return attributes;
    }

    private String makeClassString() {
        String classString = "";
        if (!classes.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            classes.forEach(c -> {
                sb.append(" ");
                sb.append(c);
            });
            classString = sb.toString().substring(1);
        }
        return classString;
    }

    private String makeStyleString() {
        String styleString = "";
        if (!styles.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append(" style=\"");
            styles.keySet().forEach(sk -> sb.append(sk + ":" + styles.get(sk) + ";"));
            sb.append("\"");
            styleString = sb.toString();
        }
        return styleString;
    }
}
