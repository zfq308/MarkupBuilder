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
    A       ("a", new String[] {"href", "title"}, false, false),
    BODY    ("body"),
    DIV     ("div"),
    P       ("p", false, false),
    BR      ("br", true),
    SPAN    ("span"),
    IMG     ("img", new String[] {"src", "alt"}, true),
    H       ("h", false, false),
    NONE    (null);

    private final String tag;
    private final Map<String, String> attributes;
    private final boolean selfTerminating;
    private final boolean linebreakOnStartTag;
    private String headingLevel;

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
     * @param selfTerminating
     */
    Tag(String tag, boolean selfTerminating) {
        this(tag, new String[] {}, selfTerminating, true);
    }

    /**
     *
     * @param tag
     * @param selfTerminating
     * @param linebreakOnStartTag
     */
    Tag(String tag, boolean selfTerminating, boolean linebreakOnStartTag) {
        this(tag, new String[] {}, selfTerminating, linebreakOnStartTag);
    }

    /**
     *
     * @param tag
     * @param attributes
     * @param selfTerminating
     */
    Tag(String tag, String[] attributes, boolean selfTerminating) {
        this(tag, attributes, selfTerminating, true);
    }



    /**
     * Initializes the Tag with a tag name it any mandatory attributes.
     * @param tag
     * @param attributes
     */
    Tag(String tag, String[] attributes) {
        this(tag, attributes, false, true);
    }

    /**
     * Initializes the Tag with a tag name it any mandatory attributes.
     * @param tag String representation of an html tag, such as "p"
     * @param attributes A list if attribute keys. Values will be set to empty strings. These can later be set with addAttribute().
     * @param selfTerminating Indicates whether the tag is self terminating or not. "img" and "br" are self terminating.
     */
    Tag(String tag, String[] attributes, boolean selfTerminating, boolean linebreakOnStartTag) {
        this.attributes = new HashMap<>();
        for (String a : attributes) {
            this.attributes.put(a, "");
        }

        this.tag = tag;
        this.headingLevel = null;
        this.selfTerminating = selfTerminating;
        this.linebreakOnStartTag = linebreakOnStartTag;
    }

    void setHeadingLevel(HeadingLevel level) {
        if ("h".equals(this.tag)) {
            this.headingLevel = level.getLevel();
        }
    }

    /**
     * Method to add additional attributes to the Tag.
     * Manadatory attributes are simply overwritten.
     * @param key The attribute key (e.g "href")
     * @param value The attribute value (e.g "http://github.com")
     * @return The current Tag (itself).
     */
    public Tag addAttribute(String key, String value) {
        attributes.put(key, value);
        return this;
    }

    /**
     * @return
     */
    public String getValue() {
        return this.headingLevel == null ? tag : tag + headingLevel;
    }

    public boolean isSelfTerminating() {
        return selfTerminating;
    }
    public boolean isLinebreakOnStartTag() { return linebreakOnStartTag; }
    public Map<String, String> getAttributes() {
        return attributes;
    }
}
