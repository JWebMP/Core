/* 
 * Copyright (C) 2017 Marc Magon
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

import java.lang.reflect.Field;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.mmagon.jwebswing.CSSComponent;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.htmlbuilder.css.heightwidth.HeightWidthCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.margins.MarginsCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementTypes;
import za.co.mmagon.logger.LogFactory;

/**
 * This Class
 *
 * @author GedMarc
 * @since 30 Dec 2015
 */
public class ComponentUtils
{

    private static final Logger log = LogFactory.getLog("ComponentUtils");

    public ComponentUtils()
    {
    }

    /**
     * Adds a class that removes all margins
     *
     * @param c
     *
     * @return
     */
    public static Component removeAllMargins(Component c)
    {
        c.addClass(CSSClassList.NoMargings.cssClass);
        return c;
    }

    /**
     * Adds a class that sets the width to 100%
     *
     * @param c
     *
     * @return
     */
    public static Component setWidth100Percent(Component c)
    {
        c.addClass(CSSClassList.Width100Percent.cssClass);
        return c;
    }

    /**
     * Sets the width to 50%
     *
     * @param c
     *
     * @return
     */
    public static Component setWidth50Percent(Component c)
    {
        c.addClass(CSSClassList.Width50Percent.cssClass);
        return c;
    }

    /**
     * Sets the screen full screen
     *
     * @param c
     *
     * @return
     */
    public static Component setFullScreen(Component c)
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
    public static Object[][] HashMapToArray(HashMap map)
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

    @Override
    public String toString()
    {
        return super.toString();
    }

    /**
     * The generated class list for singleton's
     */
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

    /**
     * Margin Padding to 0
     */
    @MarginsCSS(MarginTop = @MeasurementCSS(0), MarginLeft = @MeasurementCSS(0), MarginRight = @MeasurementCSS(0))
    public static class NoMarginsPadding extends CSSComponent
    {

        private static final long serialVersionUID = 1L;

        public NoMarginsPadding()
        {
            super("noMargins");
        }

        public String getString()
        {
            return "noMargins";
        }
    }

    /**
     * Sets width to 100%
     */
    @HeightWidthCSS(Width = @MeasurementCSS(value = 100, MeasurementType = MeasurementTypes.Percent))
    public static class WidthHundredPercent extends CSSComponent
    {

        private static final long serialVersionUID = 1L;

        public WidthHundredPercent()
        {
            super("width100percent");
        }

        public String getCSSClassName()
        {
            return "width100percent";
        }

    }

    /**
     * Sets height to 100%
     */
    @HeightWidthCSS(Width = @MeasurementCSS(value = 50, MeasurementType = MeasurementTypes.Percent))
    public static class WidthFiftyPercent extends CSSComponent
    {

        private static final long serialVersionUID = 1L;

        public WidthFiftyPercent()
        {
            super("width50percent");
        }

        public String getCSSClassName()
        {
            return "width50percent";
        }

    }

    /**
     * Sets the full screen
     */
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

    /**
     * Returns null or the field object
     *
     * @param f The field
     * @param o The objects
     *
     * @return
     */
    public static synchronized Object fieldGet(Field f, Object o)
    {
        try
        {
            return f.get(o);
        }
        catch (IllegalArgumentException | IllegalAccessException ex)
        {
            log.log(Level.FINEST, "Field returned null, no worries", ex);
            return null;
        }
    }
}
