/*
 * Copyright (C) 2015 Marc Magon
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
package za.co.mmagon.jwebswing.components.bootstrap.progressbar.bar;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.Span;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;

/**
 * An implementation 
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class BSProgressBarDisplay extends Div<BSProgressBarDisplayChildren, BSProgressBarDisplayAttributes, BSProgressBarDisplayFeatures, BSProgressBarDisplayEvents, BSProgressBarDisplay>
{

    private static final long serialVersionUID = 1L;
    private BSProgressBarDisplayFeature feature;
    
    private Span span;
    private BSProgressBarThemes theme;

    /**
     * The min value to apply
     */
    private double min;
    /**
     * The max value to apply
     */
    private double max;
    /**
     * The value to apply
     */
    private double value;
    /**
     * The label of the bar
     */
    private String label;
    
    /**
     * Constructs an empty progress bar display
     */
    public BSProgressBarDisplay()
    {
        //addFeature(getFeature());
        this(0,100,0);
    }

    /**
     * Construct a new progress bar display with the given values
     * @param value  The actual percentage value
     */
    public BSProgressBarDisplay(double value)
    {
        this(0,100,value);
    }

    /**
     * Construct a new progress bar display with the given values
     * @param min The minimum value
     * @param max The maximum value
     * @param value The actual percentage value
     */
    public BSProgressBarDisplay(double min, double max, double value)
    {
        this(min,max,value,null);
    }

    /**
     * Construct a new progress bar display with the given values
     * @param value The actual percentage value
     * @param label The label to display
     */
    public BSProgressBarDisplay(double value, String label)
    {
        this(0,100,value,label);
    }

    /**
     * Construct a new progress bar display with the given values
     * @param min The minimum value
     * @param max The maximum value
     * @param value The actual percentage value
     * @param label The label to display
     */
    public BSProgressBarDisplay(double min, double max, double value, String label)
    {
        setMin(min);
        setMax(max);
        setValue(value);
        setLabel(label);
        addClass("progress-bar");
        addAttribute(BSProgressBarDisplayAttributes.Role, "progressbar");
    }

    @Override
    public void preConfigure()
    {
        if(!isConfigured())
        {
            addClass(getTheme().getClassText());
        }
        super.preConfigure(); 
    }
    
    
    
    /**
     * Returns the current min value
     * @return 
     */
    public double getMin()
    {
        return min;
    }

    /**
     * Returns the current min value
     * @param min 
     */
    public final void setMin(double min)
    {
        this.min = min;
        addAttribute(BSProgressBarDisplayAttributes.Aria_ValueMin, min + "");
    }

    /**
     * Gets the current max value
     * @return 
     */
    public double getMax()
    {
        return max;
    }

    /**
     * Sets the current max value
     * @param max 
     */
    public final void setMax(double max)
    {
        this.max = max;
        addAttribute(BSProgressBarDisplayAttributes.Aria_ValueMax, max + "");
    }

    /**
     * Returns the current percentage
     * @return 
     */
    public double getValue()
    {
        return value;
    }

    /**
     * Sets the current percentage / width
     * @param value 
     */
    public final void setValue(double value)
    {
        this.value = value;
        addAttribute(BSProgressBarDisplayAttributes.Aria_Valuenow, value + "");
        addAttribute(GlobalAttributes.Style, "width:" + value + "%;");
        
    }

    /**
     * Returns this associated span
     * @return 
     */
    public Span getSpan()
    {
        if(span == null)
        {
            span = new Span();
            add(span); 
        }
        span.addClass("sr-only");
        return span;
    }

    /**
     * Returns this label
     * @return 
     */
    public String getLabel()
    {
        return label;
    }

    /**
     * Sets this label
     * @param label 
     */
    public final void setLabel(String label)
    {
        this.label = label;
        getSpan().setText(label);
    }

    public final BSProgressBarDisplayFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSProgressBarDisplayFeature(this);
        }
        return feature;
    }

    @Override
    public BSProgressBarDisplayOptions getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * Returns a current theme, default is success
     * @return 
     */
    public BSProgressBarThemes getTheme()
    {
        if(theme == null)
        {
            setTheme(BSProgressBarThemes.Success);
        }
        return theme;
    }

    /**
     * Sets the current theme
     * @param theme 
     */
    public void setTheme(BSProgressBarThemes theme)
    {
        if(this.theme != null)
        {
            removeClass(theme.getClassText());
        }
        this.theme = theme;
        if(theme != null)
        {
            addClass(theme.getClassText());
        }
        else
        {
            
        }
    }

}
