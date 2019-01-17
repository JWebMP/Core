/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp.core.htmlbuilder.css.composer;

import com.jwebmp.BaseTestClass;
import com.jwebmp.core.Page;
import com.jwebmp.core.base.html.Body;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.base.html.H1;
import com.jwebmp.core.htmlbuilder.css.backgrounds.BackgroundBlendMode;
import com.jwebmp.core.htmlbuilder.css.backgrounds.BackgroundCSS;
import com.jwebmp.core.htmlbuilder.css.backgrounds.BackgroundCSSImpl;
import com.jwebmp.core.htmlbuilder.css.backgrounds.BackgroundClip;
import com.jwebmp.core.htmlbuilder.css.borders.BorderCSSObjectTest;
import com.jwebmp.core.htmlbuilder.css.colours.ColourNames;
import com.jwebmp.core.htmlbuilder.css.enumarations.BorderStyles;
import org.junit.jupiter.api.Test;

/**
 * @author GedMarc
 */
public class CSSComposerTest
		extends BaseTestClass
{

	public CSSComposerTest()
	{
	}

	@Test
	public void testInnerComposer()
	{
		Div d = new Div();
		d.getCss()
		 .getBackground()
		 .setBackgroundColor$(ColourNames.DarkGoldenRod);
		d.getCss()
		 .getBorder()
		 .setBorderBottomStyle(BorderStyles.Dotted);
		d.setID("d");
		Div d2 = new Div();
		d2.setID("d2");
		d2.getCss()
		  .getDimensions()
		  .setHeight(400);
		//test block merging
		Div dClone = (Div) d.cloneComponent();
		dClone.setID("cloned");
		Div dClone2 = (Div) dClone.cloneComponent();
		dClone2.setID("cloned2");

		CSSComposer comp = new CSSComposer();
		comp.addComponent(d);
		comp.addComponent(d2);
		comp.addComponent(dClone);
		comp.addComponent(dClone2);
		System.out.println(comp.toString()); //Direct from the factory
		System.out.println(d.renderCss(0)); //Using the convenience method for the
		//TODO
		// Assertions.assertEquals("#cloned,#cloned2,#d {background-Color:darkgoldenrod;border-bottom-style:dotted}#d2 {height:400px;}", comp.toString());
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
		d.getCss()
		 .getBackground()
		 .setBackgroundColor$(ColourNames.DarkGoldenRod);
		d.getCss()
		 .getBackground()
		 .setBackgroundClip(BackgroundClip.content_box);
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
		CSSComposer comp = new CSSComposer();
		comp.addComponent(b, true);
		System.out.println(comp.toString());

		BackgroundCSSImpl back = new BackgroundCSSImpl();
		back.setBackgroundColor$(ColourNames.DarkGoldenRod);

		comp.addComponent(ic);
		System.out.println(comp.toString());
	}

	@BackgroundCSS(BackgroundBlendMode = BackgroundBlendMode.Lighten)
	public class InnerClass
			extends Div
	{

		private H1 comp = new H1("asdf");

		public InnerClass()
		{
			comp.getCss()
			    .getBackground()
			    .setBackgroundColor$(ColourNames.White);
		}
	}
}
