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
package za.co.mmagon.jwebswing.components.bootstrap.popovers;

import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.components.bootstrap.BootstrapReferencePool;

/**
 * Popovers
 * <p>
 * Add small overlay content, like those found in iOS, to any element for housing secondary information.
 * <p>
 * Overview
 * <p>
 * Things to know when using the popover plugin:
 * <p>
 * Popovers rely on the 3rd party library Tether for positioning. You must include tether.min.js before bootstrap.js in order for popovers to work! Popovers require the tooltip plugin as a dependency.
 * Popovers are opt-in for performance reasons, so you must initialize them yourself. Zero-length title and content values will never show a popover. Specify container: 'body' to avoid rendering
 * problems in more complex components (like our input groups, button groups, etc). Triggering popovers on hidden elements will not work. Popovers for .disabled or disabled elements must be triggered
 * on a wrapper element. When triggered from hyperlinks that span multiple lines, popovers will be centered. Use white-space: nowrap; on your as to avoid this behavior.
 * <p>
 * <p>
 * @author Marc Magon
 * @since 17 Jan 2017
 * @version 1.0
 */
public class BSPopOver extends Div<BSPopOverChildren, BSPopOverAttributes, BSPopOverFeatures, BSPopOverEvents, BSPopOver>
{

    private static final long serialVersionUID = 1L;
    /**
     * P
     */
    private BSPopOverFeature feature;

    /**
     * Popovers
     * <p>
     * Add small overlay content, like those found in iOS, to any element for housing secondary information.
     * <p>
     * Overview
     * <p>
     * Things to know when using the popover plugin:
     * <p>
     * Popovers rely on the 3rd party library Tether for positioning.
     * <p>
     * You must include tether.min.js before bootstrap.js in order for popovers to work!
     * <p>
     * Popovers require the tooltip plugin as a
     * <p>
     * dependency. Popovers are opt-in for performance reasons, so you must initialize them yourself.
     * <p>
     * Zero-length title and content values will never show a popover. Specify container: 'body' to avoid
     * <p>
     * rendering problems in more complex components (like our input groups, button groups, etc).
     * <p>
     * Triggering popovers on hidden elements will not work. Popovers for .disabled or disabled elements must be triggered on a wrapper element. When triggered from hyperlinks that span multiple
     * lines, popovers will be centered.
     * <p>
     * Use white-space: nowrap; on your as to avoid this behavior.
     * <p>
     * <p>
     * @param displayedComponent Shortcut for getOptions().setContent
     */
    public BSPopOver(ComponentHierarchyBase displayedComponent)
    {
        addFeature(getFeature());
        getJavascriptReferences().add(BootstrapReferencePool.Bootstrap4TetherReference.getJavaScriptReference());
        addAttribute("rel", "bs4popover");
        if (displayedComponent != null)
        {
            displayedComponent.setTiny(true);
            getOptions().setContent(displayedComponent.toString(true));
        }
        setBootstrapRequired(true);
    }

    /**
     * Returns the feature if any is required
     *
     * @return
     */
    public final BSPopOverFeature getFeature()
    {
        if (feature == null)
        {
            feature = new BSPopOverFeature(this);
        }
        return feature;
    }

    @Override
    public void init()
    {
        if (!isInitialized())
        {
            getPage().getOptions().setBootstrapEnabled(true);
        }
        super.init();
    }

    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            getPage().getOptions().setBootstrapEnabled(true);
        }
        super.preConfigure();
    }

    /**
     * Returns the options if any is required
     *
     * @return
     */
    @Override
    public final BSPopOverOptions getOptions()
    {
        return getFeature().getOptions();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 79 * hash + (this.getID().hashCode());
        return hash;
    }

}
