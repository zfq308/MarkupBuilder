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
     * @param classname
     * @param id
     * @param style
     * @return
     */
    private Container newContainerElement(Tag tag, String classname, String id, InlineStyle style) {
        Container c = new Container(tag);
        this.addChild(c);

        if (classname != null)
            c.addClass(classname);

        if (id != null)
            c.setId(id);

        if (style != null) {
            c.setInlineStyle(style);
        }

        return c;
    }

    /**
     *
     * @param tag
     * @param classname
     * @param id
     * @param style
     * @return
     */
    private Literal newLiteralElement(Tag tag, String classname, String id, InlineStyle style) {
        Literal l = new Literal(tag);
        this.addChild(l);

        if (classname != null)
            l.addClass(classname);

        if (id != null)
            l.setId(id);

        if (style != null) {
            l.setInlineStyle(style);
        }

        return l;
    }

    @Override
    public Html5Builder.LiteralElement addHeading(String text, HeadingLevel level) {
        Tag tag = Tag.H;
        tag.setHeadingLevel(level);

        Literal h = newLiteralElement(tag, null, null, null);
        h.addChild(h.newLiteral(text));
        return h;
    }

    @Override
    public Html5Builder.LiteralElement addHeading(String text, HeadingLevel level, String classname) {
        Tag tag = Tag.H;
        tag.setHeadingLevel(level);

        Literal h = newLiteralElement(tag, classname, null, null);
        h.addChild(h.newLiteral(text));
        return h;
    }

    @Override
    public Html5Builder.LiteralElement addHeading(String text, HeadingLevel level, InlineStyle style) {
        Tag tag = Tag.H;
        tag.setHeadingLevel(level);

        Literal h = newLiteralElement(tag, null, null, style);
        h.addChild(h.newLiteral(text));
        return h;
    }

    @Override
    public Html5Builder.LiteralElement addHeading(String text, HeadingLevel level, String classname, String id) {
        Tag tag = Tag.H;
        tag.setHeadingLevel(level);

        Literal h = newLiteralElement(tag, classname, id, null);
        h.addChild(h.newLiteral(text));
        return h;
    }

    @Override
    public Html5Builder.ContainerElement newDiv() {
        return newContainerElement(Tag.DIV, null, null, null);
    }

    @Override
    public Html5Builder.ContainerElement newDiv(String className) {
        return newContainerElement(Tag.DIV, className, null, null);
    }

    @Override
    public Html5Builder.ContainerElement newDiv(InlineStyle style) {
        return newContainerElement(Tag.DIV, null, null, style);
    }

    @Override
    public Html5Builder.ContainerElement newDiv(String className, String id) {
        return newContainerElement(Tag.DIV, className, id, null);
    }

    @Override
    public Html5Builder.ContainerElement newSpan() {
        return newContainerElement(Tag.SPAN, null, null, null);
    }

    @Override
    public Html5Builder.ContainerElement newSpan(String className) {
        return newContainerElement(Tag.SPAN, className, null, null);
    }

    @Override
    public Html5Builder.ContainerElement newSpan(InlineStyle style) {
        return newContainerElement(Tag.SPAN, null, null, style);
    }

    @Override
    public Html5Builder.ContainerElement newSpan(String className, String id) {
        return newContainerElement(Tag.SPAN, className, id, null);
    }

    @Override
    public Html5Builder.LiteralElement addBreak() {
        return newLiteralElement(Tag.BR, null, null, null);
    }

    @Override
    public Html5Builder.LiteralElement addBreak(String classname) {
        return newLiteralElement(Tag.BR, classname, null, null);
    }

    @Override
    public Html5Builder.LiteralElement addBreak(InlineStyle style) {
        return newLiteralElement(Tag.BR, null, null, style);
    }

    @Override
    public Html5Builder.ContainerElement newParagraph(String text) {
        Container c = newContainerElement(Tag.P, null, null, null);

        c.addChild(new Literal().newLiteral(text));
        return c;
    }

    @Override
    public Html5Builder.ContainerElement newParagraph(String text, String classname) {
        Container c = newContainerElement(Tag.P, classname, null, null);

        c.addChild(new Literal().newLiteral(text));

        return c;
    }

    @Override
    public Html5Builder.ContainerElement newParagraph(String text, InlineStyle style) {
        Container c = newContainerElement(Tag.P, null, null, style);
        c.addChild(new Literal().newLiteral(text));

        return c;
    }

    @Override
    public Html5Builder.ContainerElement newParagraph(String text, String classname, String id) {
        Container c = newContainerElement(Tag.P, classname, id, null);
        c.addChild(new Literal().newLiteral(text));

        return c;
    }

    @Override
    public Html5Builder.LiteralElement addAnchor(String text) {
        Literal a = newLiteralElement(Tag.A, null, null, null);

        a.addChild(a.newLiteral(text));

        return a;
    }

    @Override
    public Html5Builder.LiteralElement addAnchor(String text, String classname) {
        Literal a = newLiteralElement(Tag.A, classname, null, null);

        a.addChild(a.newLiteral(text));

        return a;
    }

    @Override
    public Html5Builder.LiteralElement addAnchor(String text, InlineStyle style) {
        Literal a = newLiteralElement(Tag.A, null, null, style);

        a.addChild(a.newLiteral(text));

        return a;
    }

    @Override
    public Html5Builder.LiteralElement addAnchor(String text, String classname, String id) {
        Literal a = newLiteralElement(Tag.A, classname, id, null);

        a.addChild(a.newLiteral(text));

        return a;
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
