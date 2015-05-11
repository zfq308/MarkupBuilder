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

public interface Html5Builder extends Builder{
    Head head();
    ContainerElement body();

    interface Head {
        Head setTitle(String text);
        Head addCssReference(String relPath);
        Head addJsReference(String relPath);
    }

    interface Element extends Builder {
        Element setInlineStyle(InlineStyle style);
        Element setId(String id);
        Element setClass(String className);
    }

    interface ContainerElement extends Element {
        ContainerElement addHeading(String text, HeadingLevel level);
        ContainerElement addHeading(String text, HeadingLevel level, String className);
        ContainerElement addHeading(String text, HeadingLevel level, InlineStyle style);
        ContainerElement addHeading(String text, HeadingLevel level, String className, String id);

        ContainerElement newDiv();
        ContainerElement newDiv(String className);
        ContainerElement newDiv(InlineStyle style);
        ContainerElement newDiv(String className, String id);

        ContainerElement newSpan();
        ContainerElement newSpan(String className);
        ContainerElement newSpan(InlineStyle style);
        ContainerElement newSpan(String className, String id);

        ContainerElement addBreak();
        ContainerElement addBreak(String className);
        ContainerElement addBreak(InlineStyle style);

        ContainerElement newParagraph(String text);
        ContainerElement newParagraph(String text, String className);
        ContainerElement newParagraph(String text, InlineStyle style);
        ContainerElement newParagraph(String text, String className, String id);

        LiteralElement newAnchor(String text);
        LiteralElement newAnchor(String text, String className);
        LiteralElement newAnchor(String text, InlineStyle style);
        LiteralElement newAnchor(String text, String className, String id);
    }

    interface LiteralElement extends Element {

    }
}
