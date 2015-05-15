package com.mlindb.markupbuilder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

public class ContainerTest {
    private static final String BR = System.lineSeparator();
    private static final String STYLE = "font-family:sans-serif;margin-top:5px;";

    private Container instance;
    private InlineStyle style;

    @Before
    public void setUp() {
        instance = new Container(Tag.DIV);
        style = new InlineStyle();
        style.addStyle("font-family", "sans-serif");
        style.addStyle("margin-top", "5px");
    }

    @Test
    public void testAddHeading() throws Exception {
        Html5Builder.LiteralElement h = instance.addHeading("My heading", HeadingLevel.H1);
        String actual = h.build();
        String expected = "<h1>My heading</h1>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testAddHeading1() throws Exception {
        Html5Builder.LiteralElement h = instance.addHeading("My heading", HeadingLevel.H1, style);
        String actual = h.build();
        String expected = "<h1 style=\"" + STYLE + "\">My heading</h1>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testAddHeading2() throws Exception {
        Html5Builder.LiteralElement h = instance.addHeading("My heading", HeadingLevel.H1, "myClass");
        String actual = h.build();
        String expected = "<h1 class=\"myClass\">My heading</h1>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testAddHeading3() throws Exception {
        Html5Builder.LiteralElement h = instance.addHeading("My heading", HeadingLevel.H1, "myClass", "myId");
        String actual = h.build();
        String expected = "<h1 class=\"myClass\" id=\"myId\">My heading</h1>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testNewDiv() throws Exception {
        Html5Builder.ContainerElement div = instance.newDiv();

        String actual = div.build();
        String expected = "<div>" + BR + "</div>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testNewDiv1() throws Exception {
        Html5Builder.ContainerElement div = instance.newDiv("myClass");

        String actual = div.build();
        String expected = "<div class=\"myClass\">" + BR + "</div>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testNewDiv2() throws Exception {
        Html5Builder.ContainerElement div = instance.newDiv(style);

        String actual = div.build();
        String expected = "<div style=\"" + STYLE + "\">" + BR + "</div>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testNewDiv3() throws Exception {
        Html5Builder.ContainerElement div = instance.newDiv("myClass", "myId");

        String actual = div.build();
        String expected = "<div class=\"myClass\" id=\"myId\">" + BR + "</div>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testNewSpan() throws Exception {
        Html5Builder.ContainerElement span = instance.newSpan();

        String actual = span.build();
        String expected = "<span>" + BR + "</span>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testNewSpan1() throws Exception {
        Html5Builder.ContainerElement span = instance.newSpan("myClass");

        String actual = span.build();
        String expected = "<span class=\"myClass\">" + BR + "</span>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testNewSpan2() throws Exception {
        Html5Builder.ContainerElement span = instance.newSpan(style);

        String actual = span.build();
        String expected = "<span style=\"" + STYLE + "\">" + BR + "</span>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testNewSpan3() throws Exception {
        Html5Builder.ContainerElement span = instance.newSpan("myClass", "myId");

        String actual = span.build();
        String expected = "<span class=\"myClass\" id=\"myId\">" + BR + "</span>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testAddBreak() throws Exception {
        Html5Builder.LiteralElement br = instance.addBreak();
        String actual = br.build();
        String expected = "<br/>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testAddBreak1() throws Exception {
        Html5Builder.LiteralElement br = instance.addBreak("myClass");
        String actual = br.build();
        String expected = "<br class=\"myClass\"/>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testAddBreak2() throws Exception {
        Html5Builder.LiteralElement br = instance.addBreak(style);
        String actual = br.build();
        String expected = "<br style=\"" + STYLE +"\"/>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testNewParagraph() throws Exception {
        Html5Builder.ContainerElement p = instance.newParagraph("My text");

        String actual = p.build();
        String expected = "<p>My text</p>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testNewParagraph1() throws Exception {
        Html5Builder.ContainerElement p = instance.newParagraph("My text","myClass");

        String actual = p.build();
        String expected = "<p class=\"myClass\">My text</p>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testNewParagraph2() throws Exception {
        Html5Builder.ContainerElement p = instance.newParagraph("My text", style);

        String actual = p.build();
        String expected = "<p style=\"" + STYLE + "\">My text</p>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testNewParagraph3() throws Exception {
        Html5Builder.ContainerElement p = instance.newParagraph("My text", "myClass", "myId");

        String actual = p.build();
        String expected = "<p class=\"myClass\" id=\"myId\">My text</p>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testAddAnchor() throws Exception {
        Html5Builder.LiteralElement a = instance.addAnchor("My link");
        String actual = a.build();
        String expected = "<a href=\"\" title=\"\">My link</a>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testAddAnchor1() throws Exception {
        Html5Builder.LiteralElement a = instance.addAnchor("My link", "myClass");
        String actual = a.build();
        String expected = "<a class=\"myClass\" href=\"\" title=\"\">My link</a>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testAddAnchor2() throws Exception {
        Html5Builder.LiteralElement a = instance.addAnchor("My link", style);
        String actual = a.build();
        String expected = "<a style=\"" + STYLE + "\" href=\"\" title=\"\">My link</a>" + BR;

        assertEquals(expected, actual);
    }

    @Test
    public void testAddAnchor3() throws Exception {
        Html5Builder.LiteralElement a = instance.addAnchor("My link", "myClass", "myId");
        String actual = a.build();
        String expected = "<a class=\"myClass\" id=\"myId\" href=\"\" title=\"\">My link</a>" + BR;

        assertEquals(expected, actual);
    }
}