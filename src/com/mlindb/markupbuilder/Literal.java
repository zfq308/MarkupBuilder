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

    Literal(Tag tag) {
        super(tag);
    }

    Literal() {
        super(Tag.NONE);
    }

    private Literal(String content) {
        super(Tag.NONE);
        this.content = content;
    }

    Html5Builder.LiteralElement newLiteral(String content) {
        return new Literal(content);
    }

    @Override
    public String build() {
        return super.tag == Tag.NONE ? super.build(content) : super.build();
    }
}
