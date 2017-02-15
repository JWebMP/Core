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
package za.co.mmagon.jwebswing.components.modernizr;

/**
 * The input section
 *
 * @author GedMarc
 * @since Nov 21, 2016
 * @version 1.0
 *
 */
public class ModernizrInputDto
{

    private Boolean autocomplete;
    private Boolean autofocus;
    private Boolean list;
    private Boolean placeholder;
    private Boolean max;
    private Boolean min;
    private Boolean multiple;
    private Boolean pattern;
    private Boolean required;
    private Boolean step;

    /**
     * Constructs a new input dto
     */
    public ModernizrInputDto()
    {
        //Nothing needed
    }

    /**
     * Returns if autocomplete is available
     *
     * @return
     */
    public Boolean getAutocomplete()
    {
        return autocomplete;
    }

    /**
     * Sets if auto complete is available
     *
     * @param autocomplete
     */
    public void setAutocomplete(Boolean autocomplete)
    {
        this.autocomplete = autocomplete;
    }

    /**
     * Gets if auto focus is available
     *
     * @return
     */
    public Boolean getAutofocus()
    {
        return autofocus;
    }

    /**
     * Sets if auto focus is available
     *
     * @param autofocus
     */
    public void setAutofocus(Boolean autofocus)
    {
        this.autofocus = autofocus;
    }

    /**
     * Gets if list is available
     *
     * @return
     */
    public Boolean getList()
    {
        return list;
    }

    /**
     * Sets if list is available
     *
     * @param list
     */
    public void setList(Boolean list)
    {
        this.list = list;
    }

    /**
     * Gets if place holder is available
     *
     * @return
     */
    public Boolean getPlaceholder()
    {
        return placeholder;
    }

    /**
     * Sets if place holder is available
     *
     * @param placeholder
     */
    public void setPlaceholder(Boolean placeholder)
    {
        this.placeholder = placeholder;
    }

    /**
     * Gets if max is available
     *
     * @return
     */
    public Boolean getMax()
    {
        return max;
    }

    /**
     * Sets if max is available
     *
     * @param max
     */
    public void setMax(Boolean max)
    {
        this.max = max;
    }

    /**
     * Gets the min
     *
     * @return
     */
    public Boolean getMin()
    {
        return min;
    }

    /**
     * Sets min
     *
     * @param min
     */
    public void setMin(Boolean min)
    {
        this.min = min;
    }

    /**
     * Gets multiple
     *
     * @return
     */
    public Boolean getMultiple()
    {
        return multiple;
    }

    /**
     * Sets multiple
     *
     * @param multiple
     */
    public void setMultiple(Boolean multiple)
    {
        this.multiple = multiple;
    }

    /**
     * Gets the pattern
     *
     * @return
     */
    public Boolean getPattern()
    {
        return pattern;
    }

    /**
     * Sets the pattern
     *
     * @param pattern
     */
    public void setPattern(Boolean pattern)
    {
        this.pattern = pattern;
    }

    /**
     * Gets required
     *
     * @return
     */
    public Boolean getRequired()
    {
        return required;
    }

    /**
     * Sets required
     *
     * @param required
     */
    public void setRequired(Boolean required)
    {
        this.required = required;
    }

    /**
     * Gets step
     *
     * @return
     */
    public Boolean getStep()
    {
        return step;
    }

    /**
     * Set step
     *
     * @param step
     */
    public void setStep(Boolean step)
    {
        this.step = step;
    }

}
