/*
 * Copyright (C) 2016 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds;

import org.junit.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.image.*;

/**
 *
 * @author GedMarc
 * @since 17 Jan 2016
 */
@BackgroundCSS(BackgroundImage$ =
{
    @ImageCSS("url 1")
    ,
    @ImageCSS("url 2")
}, BackgroundImage
        = @ImageCSS("image specified"),
        BackgroundAttachment = BackgroundAttachments.Inherit)
public class BackgroundCSSObjectTest
{

    @BackgroundCSS(BackgroundImage = @ImageCSS(value = "Inner Field Annotation Render"))
    private String hello;

    public BackgroundCSSObjectTest()
    {
        hello = "Testing CSS Object Hello Field";
    }

    public static void main(String[] args)
    {
        BackgroundCSSObjectTest t = new BackgroundCSSObjectTest();
        System.out.println(t.getClass().getAnnotations());
    }

    @Test
    public void blank()
    {

    }
}
