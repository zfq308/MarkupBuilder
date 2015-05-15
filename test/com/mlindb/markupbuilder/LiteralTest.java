package com.mlindb.markupbuilder;

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

public class LiteralTest {
    private static final String BR = System.lineSeparator();

    @Test
    public void testSetContent() throws Exception {
        Literal a = new Literal(Tag.A);
        a.addChild(a.newLiteral("Link text"));
        String content = a.build();
        String expected = "<a href=\"\" title=\"\">Link text</a>" + BR;
        assertEquals(expected, content);
    }
}