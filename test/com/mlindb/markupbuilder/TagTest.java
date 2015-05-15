package com.mlindb.markupbuilder;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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