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

public class Container extends AElement implements Html5Builder.ContainerElement {
    Container(String tag) {
        super(tag);
    }

    Container(String tag, Boolean selfTerminating) {
        super(tag, selfTerminating);
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
    public Html5Builder.ContainerElement addHeading(String text, HeadingLevel level) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement addHeading(String text, HeadingLevel level, String className) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement addHeading(String text, HeadingLevel level, InlineStyle style) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement addHeading(String text, HeadingLevel level, String className, String id) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement addDiv() {
        return new Container("div");
    }

    @Override
    public Html5Builder.ContainerElement addDiv(String className) {
        return (Container)new Container("div").setClass(className);
    }

    @Override
    public Html5Builder.ContainerElement addDiv(InlineStyle style) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement addDiv(String className, String id) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement addSpan() {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement addSpan(String className) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement addSpan(InlineStyle style) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement addSpan(String className, String id) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement addBreak() {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement addBreak(String className) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement addBreak(InlineStyle style) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement addParagraph(String text) {
        Literal le = new Literal("p");
        le.setContent(text);
        return this;
    }

    @Override
    public Html5Builder.ContainerElement addParagraph(String text, String className) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement addParagraph(String text, InlineStyle style) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement addParagraph(String text, String className, String id) {
        return null;
    }
}
