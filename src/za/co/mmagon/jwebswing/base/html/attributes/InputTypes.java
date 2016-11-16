/*
 * Copyright (C) 2014 GedMarc
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
     * @deprecated no browser support really
     */
    Color,
    /**
     * @deprecated no browser support really
     */
    Date,
    /**
     * @deprecated no browser support really
     */
    Datetime,
    /**
     * @deprecated no browser support really
     */
    Datetime_local,
    /**
     * @deprecated no browser support really
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
     *
     * @deprecated
     */
    Month,
    /**
     * @deprecated
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
     * @deprecated
     */
    Range,
    /**
     * The Input Reset object represents an HTML input element with type="reset".
     */
    Reset,
    /**
     * The Input Search Object is new in HTML5.
     *
     * @deprecated just until people get off ie 8
     */
    Search,
    /**
     * The submit button
     */
    Submit,
    /**
     * @deprecated
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
     *
     * @deprecated
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
     *
     * @deprecated
     */
    Url,
    /**
     * The Input Week Object is new in HTML5.
     * <p>
     * The Input Week object represents an HTML input element with type="week".
     * <p>
     * Note: input elements with type="week" are not supported in Internet Explorer or Firefox.
     *
     * @deprecated
     */
    Week,
    /**
     * @deprecated
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
