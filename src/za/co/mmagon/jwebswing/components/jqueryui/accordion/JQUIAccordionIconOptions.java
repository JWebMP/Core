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
package za.co.mmagon.jwebswing.components.jqueryui.accordion;

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 *
 * @author GedMarc
 * @since Mar 8, 2015
 * @version 1.0
 * <p>
 *
 */
public class JQUIAccordionIconOptions extends JavaScriptPart
{

    private String header;
    private String activeHeader;

    /**
     * Constructs a blank Icon Options Class
     */
    public JQUIAccordionIconOptions()
    {
    }

    /**
     * Constructs a new Icon Options Class
     *
     * @param header       The icon for closed
     * @param activeHeader The icon for open
     */
    public JQUIAccordionIconOptions(String header, String activeHeader)
    {
        this.header = header;
        this.activeHeader = activeHeader;
    }

    /**
     * Returns the icon class for closed
     * <p>
     * @return
     */
    public String getHeader()
    {
        return header;
    }

    /**
     * Sets the icon class for closed
     * <p>
     * @param header
     */
    public void setHeader(String header)
    {
        this.header = header;
    }

    /**
     * Gets the open icon
     * <p>
     * @return
     */
    public String getActiveHeader()
    {
        return activeHeader;
    }

    /**
     * Sets the open icon
     * <p>
     * @param activeHeader
     */
    public void setActiveHeader(String activeHeader)
    {
        this.activeHeader = activeHeader;
    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }
}
