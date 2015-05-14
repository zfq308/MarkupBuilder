package com.mlindb.markupbuilder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mlindberg on 12/05/15.
 */
public class ContainerTest {
    private static final String BR = System.lineSeparator();
    private Container instance;

    @Before
    public void setUp() {
        instance = new Container(Tag.DIV);
    }

    @Test
    public void testAddHeading() throws Exception {

    }

    @Test
    public void testAddHeading1() throws Exception {

    }

    @Test
    public void testAddHeading2() throws Exception {

    }

    @Test
    public void testAddHeading3() throws Exception {

    }

    @Test
    public void testNewDiv() throws Exception {
        Html5Builder.ContainerElement div = instance.newDiv();

        String noContent = div.build();
        String expected = "<div>" + BR + "</div>" + BR;

        assertEquals(expected, noContent);
    }

    @Test
    public void testNewDiv1() throws Exception {
        Html5Builder.ContainerElement div = instance.newDiv("myClass");

        String noContent = div.build();
        String expected = "<div class=\"myClass\">" + BR + "</div>" + BR;

        assertEquals(expected, noContent);
    }

    @Test
    public void testNewDiv2() throws Exception {

    }

    @Test
    public void testNewDiv3() throws Exception {
        Html5Builder.ContainerElement div = instance.newDiv("myClass", "myId");

        String noContent = div.build();
        String expected = "<div class=\"myClass\" id=\"myId\">" + BR + "</div>" + BR;

        assertEquals(expected, noContent);
    }

    @Test
    public void testNewSpan() throws Exception {
        Html5Builder.ContainerElement span = instance.newSpan();

        String noContent = span.build();
        String expected = "<span>" + BR + "</span>" + BR;

        assertEquals(expected, noContent);
    }

    @Test
    public void testNewSpan1() throws Exception {
        Html5Builder.ContainerElement span = instance.newSpan("myClass");

        String noContent = span.build();
        String expected = "<span class=\"myClass\">" + BR + "</span>" + BR;

        assertEquals(expected, noContent);
    }

    @Test
    public void testNewSpan2() throws Exception {

    }

    @Test
    public void testNewSpan3() throws Exception {
        Html5Builder.ContainerElement span = instance.newSpan("myClass", "myId");

        String noContent = span.build();
        String expected = "<span class=\"myClass\" id=\"myId\">" + BR + "</span>" + BR;

        assertEquals(expected, noContent);
    }

    @Test
    public void testAddBreak() throws Exception {

    }

    @Test
    public void testAddBreak1() throws Exception {

    }

    @Test
    public void testAddBreak2() throws Exception {

    }

    @Test
    public void testNewParagraph() throws Exception {
        Html5Builder.ContainerElement p = instance.newParagraph("My text");

        String noContent = p.build();
        String expected = "<p>My text</p>" + BR;

        assertEquals(expected, noContent);
    }

    @Test
    public void testNewParagraph1() throws Exception {
        Html5Builder.ContainerElement p = instance.newParagraph("My text","myClass");

        String noContent = p.build();
        String expected = "<p class=\"myClass\">My text</p>" + BR;

        assertEquals(expected, noContent);
    }

    @Test
    public void testNewParagraph2() throws Exception {

    }

    @Test
    public void testNewParagraph3() throws Exception {
        Html5Builder.ContainerElement p = instance.newParagraph("My text", "myClass", "myId");

        String noContent = p.build();
        String expected = "<p class=\"myClass\" id=\"myId\">My text</p>" + BR;

        assertEquals(expected, noContent);
    }

    @Test
    public void testAddAnchor() throws Exception {

    }

    @Test
    public void testAddAnchor1() throws Exception {

    }

    @Test
    public void testAddAnchor2() throws Exception {

    }

    @Test
    public void testAddAnchor3() throws Exception {

    }
}