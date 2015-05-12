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
public class HtmlBuilder implements Html5Builder {
    private final Head head;
    private final ContainerElement body;


    HtmlBuilder() {
        head = new com.mlindb.markupbuilder.Head();
        body = new Container(Tag.BODY);
    }

    public String build() {
        return START_DOCUMENT + head.build() + body.build() + END_DOCUMENT;
    }

    @Override
    public Head head() {
        return null;
    }

    @Override
    public ContainerElement body() {
        return body;
    }
}
