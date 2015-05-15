package com.mlindb.markupbuilder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mlindberg on 14/05/15.
 */
public class TagTest {
    private Tag a, br, body, p, span, img, h, none;

    @Before
    public void setUp() throws Exception {
        a = Tag.A;
        br = Tag.BR;
        body = Tag.BODY;
        p = Tag.P;
        span = Tag.SPAN;
        img = Tag.IMG;
        h = Tag.H;
        none = Tag.NONE;
    }

    @Test
    public void testGetValue() throws Exception {


    }

    @Test
    public void testIsSelfTerminating() throws Exception {

    }

    @Test
    public void testIsLinebreakOnStartTag() throws Exception {

    }
}