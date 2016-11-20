/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.utilities;

import java.util.*;
import za.co.mmagon.jwebswing.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.heightwidth.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.margins.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.*;

/**
 * This Class
 *
 * @author GedMarc
 * @since 30 Dec 2015
 */
public class ComponentUtils
{

    public static synchronized Component removeAllMargins(Component c)
    {
        c.addClass(CSSClassList.NoMargings.cssClass);
        return c;
    }

    public static synchronized Component setWidth100Percent(Component c)
    {
        c.addClass(CSSClassList.Width100Percent.cssClass);
        return c;
    }

    public static synchronized Component setWidth50Percent(Component c)
    {
        c.addClass(CSSClassList.Width50Percent.cssClass);
        return c;
    }

    public static synchronized Component setFullScreen(Component c)
    {
        c.addClass(CSSClassList.FullScreen.cssClass);
        return c;
    }

    /**
     * Converts a HashMap to a 2d array for JSON Reading
     *
     * @param map
     *
     * @return an array that can be read in JSON as an array
     */
    public static synchronized Object[][] HashMapToArray(HashMap map)
    {
        Object[][] map2D = new Object[map.size()][2];
        Set entries = map.entrySet();
        Iterator entriesIterator = entries.iterator();
        int i = 0;
        while (entriesIterator.hasNext())
        {

            Map.Entry mapping = (Map.Entry) entriesIterator.next();
            map2D[i][0] = mapping.getKey();
            map2D[i][1] = mapping.getValue();
            i++;
        }

        return map2D;
    }

    public ComponentUtils()
    {
    }

    @Override
    public String toString()
    {
        return super.toString();
    }

    public enum CSSClassList
    {
        NoMargings(new NoMarginsPadding()),
        Width50Percent(new WidthFiftyPercent()),
        Width100Percent(new WidthHundredPercent()),
        FullScreen(new FullScreenCSSClass());

        private CSSComponent cssClass;

        private CSSClassList(CSSComponent comp)
        {
            this.cssClass = comp;
        }

        public CSSComponent getCssClass()
        {
            return cssClass;
        }

        public void setCssClass(CSSComponent cssClass)
        {
            this.cssClass = cssClass;
        }

    }

    @MarginsCSS(MarginTop = @MeasurementCSS(0), MarginLeft = @MeasurementCSS(0), MarginRight = @MeasurementCSS(0))
    public static class NoMarginsPadding extends CSSComponent
    {

        public NoMarginsPadding()
        {
            super("noMargins");
        }

        public String getString()
        {
            return "noMargins";
        }
    }

    @HeightWidthCSS(Width = @MeasurementCSS(value = 100, MeasurementType = MeasurementTypes.Percent))
    public static class WidthHundredPercent extends CSSComponent
    {

        public WidthHundredPercent()
        {
            super("width100percent");
        }

        public String getCSSClassName()
        {
            return "width100percent";
        }

    }

    @HeightWidthCSS(Width = @MeasurementCSS(value = 50, MeasurementType = MeasurementTypes.Percent))
    public static class WidthFiftyPercent extends CSSComponent
    {

        public WidthFiftyPercent()
        {
            super("width50percent");
        }

        public String getCSSClassName()
        {
            return "width50percent";
        }

    }

    @HeightWidthCSS(Width = @MeasurementCSS(value = 100, MeasurementType = MeasurementTypes.Percent),
            Height = @MeasurementCSS(value = 100, MeasurementType = MeasurementTypes.Percent))
    public static class FullScreenCSSClass extends CSSComponent
    {

        private static final long serialVersionUID = 1L;

        public FullScreenCSSClass()
        {
            super("fullscreen");
        }

        public String getCSSClassName()
        {
            return "fullscreen";
        }
    }
}
