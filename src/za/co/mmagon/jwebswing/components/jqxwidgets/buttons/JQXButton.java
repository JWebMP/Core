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
package za.co.mmagon.jwebswing.components.jqxwidgets.buttons;

import za.co.mmagon.jwebswing.base.html.Button;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ListItemChildren;
import za.co.mmagon.jwebswing.components.jqxwidgets.navbar.JQXNavBarChildren;

/**
 * The jqxButton represents a jQuery button widget that allows you to display a button on the Web page.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JQXButton extends Button implements JQXNavBarChildren,GlobalChildren,ListItemChildren
{

    private static final long serialVersionUID = 1L;
    
    private JQXButtonFeature feature;

    /**
     * Constructs a new button feature with the given text
     * @param text 
     */
    public JQXButton(String text)
    {
        super(text);
        addFeature(getFeature());
    }

    /**
     * Constructs a new JQX Button
     */
    public JQXButton()
    {
        addFeature(getFeature());
    }

    @Override
    public void preConfigure()
    {
        if(!isConfigured())
        {
        }
        super.preConfigure();
    }
    
    

    /**
     * Returns the features
     * @return 
     */
    public final JQXButtonFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXButtonFeature(this);
        }
        return feature;
    }

    /**
     * Returns the button options
     * @return 
     */
    @Override
    public JQXButtonOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
