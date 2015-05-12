package com.mlindb.markupbuilder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mlindberg on 12/05/15.
 */
public class LiteralTest {
    private static final String BR = System.lineSeparator();

    @Test
    public void testSetContent() throws Exception {
        Literal a = new Literal(Tag.A);
        a.setContent("Link text");
        String content = a.build();
        String expected = "<a href=\"\" title=\"\">Link text</a>";
        assertEquals(expected, content);

    }

    @Test
    public void testSetInlineStyle() throws Exception {

    }

    @Test
    public void testSetId() throws Exception {

    }

    @Test
    public void testSetClass() throws Exception {

    }
}