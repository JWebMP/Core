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
package za.co.mmagon.jwebswing;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.co.mmagon.jwebswing.base.ComponentStyleBase;
import za.co.mmagon.jwebswing.base.html.Paragraph;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.interfaces.ICssStructure;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.logger.LogFactory;

/**
 * The base class for all HTML generation, Everything must extend a component
 * <p>
 * @author Marc Magon
 * @param <C> The allowed children for a component
 * @param <A> The allowed local attributes (Separate from Global Attributes)
 * @param <F> The allowed feature JavaScripts
 * @param <E> The allowed associated Events
 * @param <J> Component output for cloning. Returned on CloneComponent
 * <p>
 * <p>
 * @since 2009/10/01
 * @version 1.0
 */
public class Component<C extends GlobalChildren, A extends Enum & AttributeDefinitions, F extends GlobalFeatures, E extends GlobalEvents, J extends Component>
        extends ComponentStyleBase<C, A, F, E, J> implements ICssStructure<J>
{

    /**
     * Logger for the Component
     */
    @JsonIgnore
    private static final java.util.logging.Logger LOG = LogFactory.getInstance().getLogger("Component");
    /**
     * Serial Version for all Components and their compatibility
     *
     * @version 2 Version 2 - Updated CSS Library and References
     */
    @JsonIgnore
    private static final long serialVersionUID = 2l;

    /**
     * Construct a new Component with a custom tag
     * <p>
     * @param tagName     The tag to apply
     * @param myComponent The HTML component rendering for
     */
    public Component(String tagName, ComponentTypes myComponent)
    {
        this(tagName, myComponent, false);
    }

    /**
     * Construct a new Component with a custom tag
     * <p>
     * @param myComponent The HTML component rendering for
     */
    public Component(ComponentTypes myComponent)
    {
        this(myComponent.getComponentTag(), myComponent, false);
    }

    /**
     * Constructs a component with the tag name, it's associated base HTML component, and whether it closes in line or not
     * <p>
     * @param tagName        The tag name to apply
     * @param myComponent    The component enumeration applied with this component
     * @param inlineTagClose Whether or not to close the tag InLine or not
     */
    public Component(String tagName, ComponentTypes myComponent, boolean inlineTagClose)
    {
        super(myComponent);
    }

    /**
     * Adds a paragraph component with the attached text
     * <p>
     * @param textToAdd The text to add
     * <p>
     * @return The new paragraph component
     */
    @Override
    public J add(String textToAdd)
    {
        Paragraph p = new Paragraph();
        p.setText(textToAdd);
        add((C) p);
        return (J) this;
    }

    /**
     * Returns this component with all the shortcuts for CSS
     *
     * @return The CSS Set of a component
     */
    public ICssStructure asCSS()
    {
        return ICssStructure.class.cast(this);
    }

}
