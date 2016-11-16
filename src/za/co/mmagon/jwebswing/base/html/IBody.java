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
package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.base.ComponentFeatureBase;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.servlets.interfaces.Loader;
import za.co.mmagon.jwebswing.components.pace.PaceLoader;

/**
 *
 * @author GedMarc
 * @param <L> Loader Type
 * @since Oct 30, 2016
 * @version 1.0
 *
 */
public interface IBody<L extends ComponentFeatureBase & Loader & GlobalChildren>
{

    /**
     * Will configure for Angular 1
     */
    void configureAngular();

    /**
     *
     * The 3 meta tags *must* come first in the head; any other head content must come *after* these tags
     * <p>
     * HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries
     * WARNING: Respond.js doesn't work if you view the page via file://
     */
    void configureBootstrap();

    void configureJQueryUI();

    void configureModernizr();

    /**
     * Configures pace for use
     */
    void configurePace();

    /**
     * Configures pace for use
     * @param pace
     */
    void configurePace(PaceLoader pace);

    /**
     * Returns this Body AJAX JQXLoader
     *
     * @return The loader associated with this Body object
     */
    L getLoader();

    /**
     * Sets this bodies loader
     * <p>
     * @param loader The loader to set
     */
    void setLoader(L loader);

    /**
     * Gets the pace loader associated with this application
     *
     * @return
     */
    PaceLoader getPace();

    /**
     * Sets the pace loader for this application
     *
     * @param pace The PaceLoader
     */
    void setPace(PaceLoader pace);

    /*
     * If we are using bootstrap 4
     */
    boolean isBootstrap4();

    /**
     * If we are using bootstrap 3
     *
     * @param bootstrap4
     */
    void setBootstrap4(boolean bootstrap4);

    /**
     * Returns if bootstrap is configured
     *
     * @return
     */
    boolean isBootstrapConfigured();

    /**
     * Sets the bootstrap configured flag
     *
     * @param bootstrapConfigured
     */
    void setBootstrapConfigured(boolean bootstrapConfigured);

    /**
     * Sets if this page must use JQuery 3 or 2
     *
     * @return
     */
    boolean isJquery3();

    /**
     * Sets if this page must use JQuery 3 or 2
     *
     * @param jquery3
     */
    void setJquery3(boolean jquery3);
    
}
