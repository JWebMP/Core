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
package za.co.mmagon.jwebswing.base;

import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.*;
import za.co.mmagon.jwebswing.base.interfaces.*;
import za.co.mmagon.jwebswing.base.servlets.enumarations.*;
import za.co.mmagon.jwebswing.components.bootstrap.*;
import za.co.mmagon.jwebswing.components.bootstrap.columnlayout.*;
import za.co.mmagon.jwebswing.components.bootstrap.themes.sbadmin2.*;

/**
 * A convenience class for accessing all the bootstrap methods
 *
 * @author GedMarc
 *
 * @since Oct 10, 2016
 * @version 1.0
 *
 * @param <C> The children allowed for this component
 * @param <A> The allowed local attributes (Separate from Global Attributes)
 * @param <F> The allowed feature JavaScripts
 * @param <E> The allowed associated Events
 * @param <J> Component output for cloning. Returned on CloneComponent
 */
public class ComponentHTMLBootstrapBase<C, A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents, J extends ComponentStyleBase>
        extends ComponentStyleBase<C, A, F, E, J> implements IComponentHTMLBootstrapBase
{

    private static final long serialVersionUID = 1L;

    public ComponentHTMLBootstrapBase(ComponentTypes componentType)
    {
        super(componentType);
    }

    /**
     * Returns this component with only the bootstrap specific methods
     *
     * @return
     */
    public IComponentHTMLBootstrapBase asBootstrap()
    {
        return this;
    }

    /**
     * Adds a class name to the class list
     * <p>
     * @param blockName The class name to add
     * <p>
     * @return True if it was added, false if it already existed
     */
    @Override
    public boolean addClass(BootstrapClasses blockName)
    {
        getPage().getOptions().setBootstrapEnabled(true);
        String className = blockName.toString();
        if (!getClasses().contains(className))
        {
            getClasses().add(className);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Adds a class name to the class list
     * <p>
     * @param blockName The class name to add
     * <p>
     * @return True if it was added, false if it already existed
     */
    @Override
    public boolean addClass(SB2ThemeClasses blockName)
    {
        getPage().getOptions().setBootstrapEnabled(true);
        String className = blockName.toString();
        if (!getClasses().contains(className))
        {
            getClasses().add(className);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Adds a class name to the class list
     * <p>
     * @param position  The position of to add the class
     * @param blockName The class name to add
     * <p>
     * @return True if it was added, false if it already existed
     */
    public boolean addClass(int position, SB2ThemeClasses blockName)
    {
        getPage().getOptions().setBootstrapEnabled(true);
        String className = blockName.toString();
        if (!getClasses().contains(className))
        {
            getClasses().add(position, className);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Adds the specified column width settings to the class
     *
     * @param blockName
     *
     * @return
     */
    @Override
    public boolean addClass(BSColumnWidths blockName)
    {
        getPage().getOptions().setBootstrapEnabled(true);
        String className = blockName.toString();
        if (!getClasses().contains(className))
        {
            getClasses().add(className);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Adds the specified column width settings to the class
     *
     * @param blockName
     *
     * @return
     */
    @Override
    public boolean addClass(BSComponentHiding blockName)
    {
        getPage().getOptions().setBootstrapEnabled(true);
        String className = blockName.toString();
        if (!getClasses().contains(className))
        {
            getClasses().add(className);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Adds the specified column width settings to the class
     *
     * @param blockName
     *
     * @return
     */
    @Override
    public boolean addClass(Glyphicons blockName)
    {
        getPage().getOptions().setBootstrapEnabled(true);
        String className = blockName.toString();
        if (!getClasses().contains(className))
        {
            getClasses().add(className);
            return true;
        }
        else
        {
            return false;
        }
    }
}
