package com.mlindb.markupbuilder;

import java.util.HashMap;
import java.util.Map;

/*
 * Copyright 2015 Magnus Lindberg - magnus.m.lindberg@gmail.com
 *
 * This file is part of MarkupBuilder.
 *
 * MarkupBuilder is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MarkupBuilder is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MarkupBuilder.  If not, see <http://www.gnu.org/licenses/>.
 */
public enum Tag {
    A       ("a", new String[] {"href", "title"}),
    BODY    ("body"),
    DIV     ("div"),
    P       ("p"),
    BR      ("br"),
    SPAN    ("span"),
    IMG     ("img", new String[] {"src", "alt"}, true),
    NONE    (null);

    private String tag;
    private Map<String, String> attributes;
    private boolean isSelfTerminating;

    /**
     * Initializes the Tag with just a tag name.
     * @param tag
     */
    Tag(String tag) {
        this(tag, new String[] {});
    }

    /**
     * Initializes the Tag with a tag name and information on self-termination.
     * @param tag
     * @param isSelfTerminating
     */
    Tag(String tag, boolean isSelfTerminating) {
        this(tag, new String[] {}, isSelfTerminating);
    }

    /**
     * Initializes the Tag with a tag name it any mandatory attributes.
     * @param tag
     * @param attributes
     */
    Tag(String tag, String[] attributes) {
        this(tag, attributes, false);
    }

    /**
     * Initializes the Tag with a tag name it any mandatory attributes.
     * @param tag
     * @param attributes
     * @param isSelfTerminating
     */
    Tag(String tag, String[] attributes, boolean isSelfTerminating) {
        this.attributes = new HashMap<>();
        for (String a : attributes) {
            this.attributes.put(a, "");
        }

        this.tag = tag;
        this.isSelfTerminating = isSelfTerminating;
    }

    /**
     * Method to add additional attributes to the Tag.
     * Manadatory attributes are simply overwritten.
     * @param key
     * @param value
     * @return
     */
    public Tag addAttribute(String key, String value) {
        attributes.put(key, value);
        return this;
    }

    /**
     * @return
     */
    public String getValue() {
        return tag;
    }

    public boolean isSelfTerminating() {
        return isSelfTerminating;
    }
}
