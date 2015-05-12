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
    Container(Tag tag) {
        super(tag);
    }

    /**
     *
     * @param tag
     * @param className
     * @param id
     * @return
     */
    private Html5Builder.ContainerElement newContainerElement(Tag tag, String className, String id) {
        Container c = new Container(tag);
        this.addChild(c);

        if (className != null)
            c.addClass(className);


        if (id != null)
            c.setId(id);

        return c;
    }

    @Override
    public Html5Builder.LiteralElement addHeading(String text, HeadingLevel level) {
        return null;
    }

    @Override
    public Html5Builder.LiteralElement addHeading(String text, HeadingLevel level, String className) {
        return null;
    }

    @Override
    public Html5Builder.LiteralElement addHeading(String text, HeadingLevel level, InlineStyle style) {
        return null;
    }

    @Override
    public Html5Builder.LiteralElement addHeading(String text, HeadingLevel level, String className, String id) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement newDiv() {
        return newContainerElement(Tag.DIV, null, null);
    }

    @Override
    public Html5Builder.ContainerElement newDiv(String className) {
        return newContainerElement(Tag.DIV, className, null);
    }

    @Override
    public Html5Builder.ContainerElement newDiv(InlineStyle style) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement newDiv(String className, String id) {
        return newContainerElement(Tag.DIV, className, id);
    }

    @Override
    public Html5Builder.ContainerElement newSpan() {
        return newContainerElement(Tag.SPAN, null, null);
    }

    @Override
    public Html5Builder.ContainerElement newSpan(String className) {
        return newContainerElement(Tag.SPAN, className, null);
    }

    @Override
    public Html5Builder.ContainerElement newSpan(InlineStyle style) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement newSpan(String className, String id) {
        return newContainerElement(Tag.SPAN, className, id);
    }

    @Override
    public Html5Builder.LiteralElement addBreak() {
        return null;
    }

    @Override
    public Html5Builder.LiteralElement addBreak(String className) {
        return null;
    }

    @Override
    public Html5Builder.LiteralElement addBreak(InlineStyle style) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement newParagraph(String text) {
        Container c = new Container(Tag.P);
        this.addChild(c);

        c.addChild(new Literal().setContent(text));
        return c;
    }

    @Override
    public Html5Builder.ContainerElement newParagraph(String text, String className) {
        Container c = new Container(Tag.P);
        this.addChild(c);

        c.addChild(new Literal().setContent(text));
        c.addClass(className);
        return c;
    }

    @Override
    public Html5Builder.ContainerElement newParagraph(String text, InlineStyle style) {
        Container c = new Container(Tag.P);
        this.addChild(c);

        c.addChild(new Literal().setContent(text));
        c.setInlineStyle(style);
        return c;
    }

    @Override
    public Html5Builder.ContainerElement newParagraph(String text, String className, String id) {
        Container c = new Container(Tag.P);
        this.addChild(c);

        c.addChild(new Literal().setContent(text));
        c.addClass(className);
        c.setId(id);
        return c;
    }

    @Override
    public Html5Builder.LiteralElement addAnchor(String text) {
        return null;
    }

    @Override
    public Html5Builder.LiteralElement addAnchor(String text, String className) {
        return null;
    }

    @Override
    public Html5Builder.LiteralElement addAnchor(String text, InlineStyle style) {
        return null;
    }

    @Override
    public Html5Builder.LiteralElement addAnchor(String text, String className, String id) {
        return null;
    }

    @Override
    public Html5Builder.ContainerElement setId(String id) {
        super.setId(id);
        return this;
    }

    @Override
    public Html5Builder.ContainerElement addClass(String classname) {
        super.addClass(classname);
        return this;
    }

    @Override
    public Html5Builder.ContainerElement setInlineStyle(InlineStyle style) {
        super.setInlineStyle(style);
        return this;
    }
}
