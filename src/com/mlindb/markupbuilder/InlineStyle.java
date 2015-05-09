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

import java.util.HashMap;
import java.util.Map;

public class InlineStyle {
    private Map<String, String> values;

    public InlineStyle() {
        values = new HashMap<>();
    }

    public InlineStyle addStyle(String property, String value) {
        values.put(property, value);
        return this;
    }

    Map<String, String> getStyles() {
        return values;
    }
}
