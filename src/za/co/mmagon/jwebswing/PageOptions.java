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
package za.co.mmagon.jwebswing;

import com.fasterxml.jackson.annotation.*;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.*;

/**
 * A list of page options available to the page
 *
 * @author GedMarc
 * @since Nov 21, 2016
 *
 */
public class PageOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    private final Page page;

    /**
     * Whether or not to render pace loader
     */
    private boolean paceEnabled = true;
    /**
     * Whether or not to render jQuery
     */
    private boolean jQueryEnabled;
    /**
     * Whether or not to render jQuery UI
     */
    private boolean jQueryUIEnabled;
    /**
     * Whether or not to render angular
     */
    private boolean angularEnabled;
    /**
     * Whether or not to render bootstrap
     */
    private boolean bootstrapEnabled;
    /**
     * Whether or not to dynamic render the requirements
     */
    private boolean dynamicRender = true;
    /**
     * Whether or not modernizr is enabled
     */
    private boolean modernizrEnabled;

    /**
     * Construct directly with the page
     *
     * @param page
     */
    protected PageOptions(Page page)
    {
        this.page = page;
    }

    /**
     * Whether or not to render the JQuery requirements
     *
     * @return
     */
    public boolean isjQueryEnabled()
    {
        return jQueryEnabled;
    }

    /**
     * Whether or not to render the JQuery Requirements
     *
     * @param jQueryEnabled
     */
    public void setjQueryEnabled(boolean jQueryEnabled)
    {
        this.jQueryEnabled = jQueryEnabled;
        if (this.jQueryEnabled)
        {
            page.getBody().configureJQuery();
        }
    }

    /**
     * Whether or not to render the JQuery UI Requirements
     *
     * @return
     */
    public boolean isjQueryUIEnabled()
    {
        return jQueryUIEnabled;
    }

    /**
     * Whether or not to render the JQuery UI Requirements
     *
     * @param jQueryUIEnabled
     */
    public void setjQueryUIEnabled(boolean jQueryUIEnabled)
    {
        this.jQueryUIEnabled = jQueryUIEnabled;
        if (jQueryUIEnabled)
        {
            setjQueryEnabled(true);
            page.getBody().configureJQueryUI();
        }
    }

    /**
     * whether or not to render angular
     *
     * @return
     */
    public boolean isAngularEnabled()
    {
        return angularEnabled;
    }

    /**
     * Whether or not to render angular
     *
     * @param angularEnabled
     */
    public void setAngularEnabled(boolean angularEnabled)
    {
        this.angularEnabled = angularEnabled;
        if (angularEnabled)
        {
            setjQueryEnabled(true);
            page.getBody().configureAngular();
        }
    }

    /**
     * Whether or not to render bootstrap
     *
     * @return
     */
    public boolean isBootstrapEnabled()
    {
        return bootstrapEnabled;
    }

    /**
     * Whether or not to render bootstrap
     *
     * @param bootstrapEnabled
     */
    public void setBootstrapEnabled(boolean bootstrapEnabled)
    {
        this.bootstrapEnabled = bootstrapEnabled;
        if (bootstrapEnabled)
        {
            page.getBody().configureBootstrap();
        }
    }

    /**
     * Returns if pace should be set as the default render
     *
     * @return
     */
    public boolean isPaceEnabled()
    {
        return paceEnabled;
    }

    /**
     * Sets if pace should be rendered s the default loader
     *
     * @param paceEnabled
     */
    public void setPaceEnabled(boolean paceEnabled)
    {
        this.paceEnabled = paceEnabled;
        page.getBody().configurePace();
    }

    /**
     * Is Modernizr Enabled
     *
     * @return
     */
    public boolean isModernizrEnabled()
    {
        return modernizrEnabled;
    }

    /**
     * Sets if Modernizr is enabled
     *
     * @param modernizrEnabled
     */
    public void setModernizrEnabled(boolean modernizrEnabled)
    {
        this.modernizrEnabled = modernizrEnabled;
        page.getBody().configureModernizr();
    }

    /**
     * Whether or not to dynamic render the requirements
     *
     * @return
     */
    public boolean isDynamicRender()
    {
        return dynamicRender;
    }

    /**
     * Whether or not to dynamic render the requirements
     *
     * @param dynamicRender
     */
    public void setDynamicRender(boolean dynamicRender)
    {
        this.dynamicRender = dynamicRender;
    }

}
