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

public class Head implements Html5Builder.Head {
    @Override
    public Html5Builder.Head setTitle(String text) {
        return null;
    }

    @Override
    public Html5Builder.Head addCssReference(String relPath) {
        return null;
    }

    @Override
    public Html5Builder.Head addJsReference(String relPath) {
        return null;
    }

    @Override
    public String build() {
        return "<head></head>" + System.lineSeparator();
    }
}
