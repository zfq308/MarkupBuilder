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

public class Literal extends AElement implements Html5Builder.LiteralElement {
    private String content;

    Literal(String tag) {
        super(tag);
    }

    Literal(String tag, Boolean selfTerminating) {
        super(tag, selfTerminating);
    }

    void setContent(String content) {
        this.content = content;
    }

    @Override
    public Html5Builder.Element setInlineStyle(InlineStyle style) {
        return null;
    }

    @Override
    public Html5Builder.Element setId(String id) {
        return null;
    }

    @Override
    public Html5Builder.Element setClass(String className) {
        return null;
    }

    @Override
    public String build() {
        return content;
    }
}
