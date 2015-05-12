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
    static final String START_DOCUMENT  = "<!DOCTYPE html>" + System.lineSeparator() + "<html>" + System.lineSeparator();
    static final String END_DOCUMENT    = "</html>";

    Head head();
    ContainerElement body();

    interface Head  extends Builder {
        Head setTitle(String text);
        Head addCssReference(String relPath);
        Head addJsReference(String relPath);
    }

    interface Element extends Builder {
        Element setInlineStyle(InlineStyle style);
        Element setId(String id);
        Element addClass(String className);
    }

    interface ContainerElement extends Element{
        LiteralElement addHeading(String text, HeadingLevel level);
        LiteralElement addHeading(String text, HeadingLevel level, String className);
        LiteralElement addHeading(String text, HeadingLevel level, InlineStyle style);
        LiteralElement addHeading(String text, HeadingLevel level, String className, String id);

        ContainerElement newDiv();
        ContainerElement newDiv(String className);
        ContainerElement newDiv(InlineStyle style);
        ContainerElement newDiv(String className, String id);

        ContainerElement newSpan();
        ContainerElement newSpan(String className);
        ContainerElement newSpan(InlineStyle style);
        ContainerElement newSpan(String className, String id);

        LiteralElement addBreak();
        LiteralElement addBreak(String className);
        LiteralElement addBreak(InlineStyle style);

        ContainerElement newParagraph(String text);
        ContainerElement newParagraph(String text, String className);
        ContainerElement newParagraph(String text, InlineStyle style);
        ContainerElement newParagraph(String text, String className, String id);

        LiteralElement addAnchor(String text);
        LiteralElement addAnchor(String text, String className);
        LiteralElement addAnchor(String text, InlineStyle style);
        LiteralElement addAnchor(String text, String className, String id);
    }

    interface LiteralElement extends Element{

    }
}
