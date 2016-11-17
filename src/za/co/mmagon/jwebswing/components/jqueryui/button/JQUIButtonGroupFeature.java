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
package za.co.mmagon.jwebswing.components.jqueryui.button;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.pools.jqueryui.JQUIReferencePool;

/**
 *
 * @author GedMarc
 * @since Mar 8, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQUIButtonGroupFeature extends Feature<JQUIButtonGroupOptions, JQUIButtonGroupFeature> implements JQUIButtonFeatures
{

    private static final long serialVersionUID = 1L;

    private final Component buttonGroup;
    private JQUIButtonGroupOptions buttongGroupOptions;

    /**
     * Configures a new check box group
     * <p>
     * @param buttonGroup The group to apply to
     */
    public JQUIButtonGroupFeature(Component buttonGroup)
    {
        super("JWCheckBoxGroupFeature");
        this.buttonGroup = buttonGroup;
        getJavascriptReferences().add(JQUIReferencePool.Button.getJavaScriptReference());
    }

    @Override
    public void assignFunctionsToComponent()
    {

        addQuery(buttonGroup.getJQueryID() + "buttonset(" + getOptions() + ");" + getNewLine());

    }

    /**
     * Returns the button group options
     * <p>
     * @return
     */
    @Override
    public JQUIButtonGroupOptions getOptions()
    {
        if (buttongGroupOptions == null)
        {
            buttongGroupOptions = new JQUIButtonGroupOptions();
        }
        return buttongGroupOptions; //To change body of generated methods, choose Tools | Templates.
    }

}
