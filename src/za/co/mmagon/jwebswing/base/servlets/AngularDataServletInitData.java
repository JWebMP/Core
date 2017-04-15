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
package za.co.mmagon.jwebswing.base.servlets;

import java.util.Map;
import za.co.mmagon.jwebswing.components.modernizr.ModernizrDto;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 *
 * @author Marc Magon
 * @since 05 Apr 2017
 */
class AngularDataServletInitData extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    /**
     * The local storage map to be set for the provider
     */
    private Map<String, String> localStorage;
    /**
     * The session storage map
     */
    private Map<String, String> sessionStorage;
    /**
     * The modernizr dto
     */
    private ModernizrDto modernizr;

    /*
     * Constructs a new AngularDataServletInitData
     */
    public AngularDataServletInitData()
    {
        //Nothing needed
    }

    public Map<String, String> getLocalStorage()
    {
        return localStorage;
    }

    public void setLocalStorage(Map<String, String> localStorage)
    {
        this.localStorage = localStorage;
    }

    public Map<String, String> getSessionStorage()
    {
        return sessionStorage;
    }

    public void setSessionStorage(Map<String, String> sessionStorage)
    {
        this.sessionStorage = sessionStorage;
    }

    public ModernizrDto getModernizr()
    {
        return modernizr;
    }

    public void setModernizr(ModernizrDto modernizr)
    {
        this.modernizr = modernizr;
    }

}
