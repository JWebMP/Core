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
package za.co.mmagon.jwebswing.components.jqueryUI.radiobutton;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.jqueryUI.button.JQUIButtonGroupOptions;
import za.co.mmagon.jwebswing.components.pools.jqueryUI.JQUIReferencePool;

/**
 *
 * @author GedMarc
 * @since Mar 8, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQUIRadioButtonGroupFeature extends Feature<JQUIButtonGroupOptions, JQUIRadioButtonGroupFeature>
{

    private static final long serialVersionUID = 1L;

    private final JQUIRadioButtonGroup radioButtonGroup;
    private JQUIButtonGroupOptions buttongGroupOptions;

    /**
     * Configures a new check box group
     * <p>
     * @param radioButtonGroup The group to apply to
     */
    public JQUIRadioButtonGroupFeature(JQUIRadioButtonGroup radioButtonGroup)
    {
        super("JWCheckBoxGroupFeature");
        this.radioButtonGroup = radioButtonGroup;
        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Widget.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQUIReferencePool.Widget.getCssReference());

        getJavascriptReferences().add(JQUIReferencePool.Button.getJavaScriptReference());
    }

    @Override
    public void assignFunctionsToComponent()
    {
        addQuery(radioButtonGroup.getJQueryID() + "buttonset(" + getOptions() + ");" + getNewLine());
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
