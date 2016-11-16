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
package za.co.mmagon.jwebswing.htmlbuilder.css.composer;

import org.junit.Test;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.html.Body;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.H1;
import za.co.mmagon.jwebswing.htmlbuilder.css.BorderStyles;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.BackgroundBlendMode;
import za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.BackgroundClip;
import za.co.mmagon.jwebswing.htmlbuilder.css.borders.BorderCSSObjectTest;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourNames;

/**
 *
 * @author GedMarc
 */
public class CSSComposerTest
{

    public CSSComposerTest()
    {
    }

    @Test
    public void testInnerComposer()
    {
        Div d = new Div();
        d.getCss().setBackgroundColor$(ColourNames.DarkGoldenRod);
        d.getCss().setBorderBottomStyle(BorderStyles.Dotted);
        d.getCss().setHeight(400);
        d.setID("d");
        Div d2 = new Div();
        d2.setID("d2");
        d2.getCss().setHeight(400);
        //test block merging
        Div dClone = (Div) d.cloneComponent();
        dClone.setID("cloned");
        Div dClone2 = (Div) dClone.cloneComponent();
        dClone2.setID("cloned2");
        //dClone2.setBackground_Image(new BackgroundImageImpl("image url"));

        CSSComposer comp = new CSSComposer();
        comp.addComponent(d);
        comp.addComponent(d2);
        comp.addComponent(dClone);
        comp.addComponent(dClone2);
        //Page.getInstance().setTiny(true);
        System.out.println(comp.toString());

        //TODO Cloned object css
        // Assert.assertEquals("#cloned,#cloned2,#d {background-color:darkgoldenrod;border-bottom-style:dotted;height:400px;}#d2 {height:400px;}"
        //         + "", comp.toString());
    }

    @Test
    public void testClassComposer()
    {
        Div d = new Div();
        BorderCSSObjectTest borderClassObject = new BorderCSSObjectTest();
        CSSComposer comp = new CSSComposer();
        comp.addComponent(d);
        comp.addComponent(borderClassObject);
        System.out.println(comp.toString());
    }

    @Test
    public void testInnerClass()
    {
        InnerClass d = new InnerClass();
        d.getCss().setBackgroundColor$(ColourNames.DarkGoldenRod);
        d.getCss().setBackgroundClip(BackgroundClip.content_box);
        BorderCSSObjectTest borderClassObject = new BorderCSSObjectTest();
        CSSComposer comp = new CSSComposer();
        comp.addComponent(d);
        //comp.addComponent(borderClassObject);
        System.out.println(comp.toString());

    }

    @Test
    public void testCSSRender()
    {
        Page p = new Page();
        Body b = new Body(p);
        InnerClass ic;
        b.add(ic = new InnerClass());
        //ComponentUtils.removeAllMargins(ic);
        // ComponentUtils.setWidth50Percent(ic);
        CSSComposer comp = new CSSComposer();
        comp.addComponent(b, true);
        //comp.addComponent(borderClassObject);
        System.out.println(comp.toString());
    }

    @CSS(Background_BlendMode = BackgroundBlendMode.lighten)
    public class InnerClass extends Div
    {

        private H1 comp = new H1("asdf");

        public InnerClass()
        {
            comp.getCss().setBackgroundColor$(ColourNames.White);
        }
    }
}
