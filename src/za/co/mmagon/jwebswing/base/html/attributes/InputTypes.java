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
package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 *
 * @author mmagon
 */
public enum InputTypes implements AttributeDefinitions
{

    /**
     * A Button Input Type
     */
    Button,
    /**
     * The Input Checkbox object represents an HTML input element with type="checkbox".
     */
    Checkbox,
    /**
     *
     */
    Color,
    /**
     *
     */
    Date,
    /**
     *
     */
    Datetime,
    /**
     *
     */
    Datetime_local,
    /**
     *
     */
    Email,
    /**
     * The Input FileUpload object represents an HTML input element with type="file".
     */
    File,
    /**
     * The Input Hidden object represents an HTML input element with type="hidden".
     */
    Hidden,
    /**
     * Specifies an Image input field
     */
    Image,
    /**
     * The Input Month object represents an HTML input element with type="month".
     * <p>
     * Note: input elements with type="month" are not supported in Internet Explorer or Firefox.
     * <p>
     * Did custom check, enabled from ie10 and up
     */
    Month,
    /**
     * A number input
     */
    Number,
    /**
     * The Input Password object represents an HTML input element with type="password".
     */
    Password,
    /**
     * The Input Radio object represents an HTML input element with type="radio".
     */
    Radio,
    /**
     * A range input selector
     */
    Range,
    /**
     * The Input Reset object represents an HTML input element with type="reset".
     */
    Reset,
    /**
     * The Input Search Object is new in HTML5.
     * <p>
     */
    Search,
    /**
     * The submit button
     */
    Submit,
    /**
     * A telephone entry
     */
    Tel,
    /**
     * The Input Text object represents an HTML input element with type="text".
     */
    Text,
    /**
     * The Input Time Object is new in HTML5.
     * <p>
     * The Input Time object represents an HTML input element with type="time".
     * <p>
     * Note: input elements with type="time" are not supported in Internet Explorer or Firefox.
     * <p>
     * JWebswing excludes this for lack of support
     */
    Time,
    /**
     * Input URL Object
     * <p>
     * The Input URL Object is new in HTML5.
     * <p>
     * The Input URL object represents an HTML input element with type="url".
     * <p>
     * Note: input elements with type="url" are not supported in Internet Explorer 9 (and earlier versions), or Safari.
     */
    Url,
    /**
     * The Input Week Object is new in HTML5.
     * <p>
     * The Input Week object represents an HTML input element with type="week".
     * <p>
     * Note: input elements with type="week" are not supported in Internet Explorer or Firefox.
     */
    Week,
    /**
     * To store values as attributes
     */
    Value;

    @Override
    public String toString()
    {
        return name().toLowerCase().replaceAll("_", "-");
    }

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
