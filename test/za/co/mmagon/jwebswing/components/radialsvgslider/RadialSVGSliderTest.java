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
package za.co.mmagon.jwebswing.components.radialsvgslider;

import org.junit.Test;
import za.co.mmagon.BaseTestClass;
import za.co.mmagon.jwebswing.Page;
import za.co.mmagon.jwebswing.base.html.Div;

/**
 *
 * @author GedMarc
 */
public class RadialSVGSliderTest extends BaseTestClass
{
    
    public RadialSVGSliderTest()
    {
    }

    @Test
    public void testStructure()
    {
        RadialSVGSlider slider = new RadialSVGSlider();
        System.out.println(slider.toString(true));
    }
    
    @Test
    public void testFaces()
    {
        RadialSVGSlider slider = new RadialSVGSlider();
        slider.addFace(new Div(),"bower_components/radial-svg-slider-jwebswing/img/img-1.jpg");
        slider.addFace(new Div(),"bower_components/radial-svg-slider-jwebswing/img/img-2.jpg");
        System.out.println(slider.toString(true));
    }
    
    @Test
    public void testDefaultSlide()
    {
        RadialSVGSlider slider = new RadialSVGSlider();
        slider.addFace(new Div(),"bower_components/radial-svg-slider-jwebswing/img/img-1.jpg");
        slider.addFace(RadialSVGSliderListItem.createDefaultSlide("Slide 2", "This is slide 2", "#0", "Learn More"));
        System.out.println(slider.toString(true));
    }
    
    @Test
    public void testReferences()
    {
        Page p = getInstance();
        p.getBody().add(new RadialSVGSlider());
        System.out.println(p.toString(true));
    }
    
}
