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
package za.co.mmagon.jwebswing.base.ajax;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author Marc Magon
 * @since 02 May 2017
 */
public class LocalStorageJavascriptPart extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private String key;
    private String value;

    /*
     * Constructs a new LocalStorageJavascriptPart
     */
    public LocalStorageJavascriptPart()
    {
        //Nothing needed
    }

    public LocalStorageJavascriptPart(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    public LocalStorageJavascriptPart(String key, JavaScriptPart value)
    {
        this.key = key;
        this.value = value.toString();
    }

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

}
