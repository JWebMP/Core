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
package za.co.mmagon.jwebswing.components.jqueryui.spinner;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.pools.jqueryui.JQUIReferencePool;

/**
 *
 * @author GedMarc
 * @since Mar 8, 2015
 * @version 1.0
 * <p>
 *
 */
public class JQUISpinnerFeature extends Feature<JQUISpinnerOptions, JQUISpinnerFeature> implements JQUISpinnerFeatures
{

    private static final long serialVersionUID = 1L;

    private final Component selectMenu;
    private JQUISpinnerOptions options;

    /**
     * Constructs a new slider
     *
     * @param selectMenu
     */
    public JQUISpinnerFeature(Component selectMenu)
    {
        super("JWPSelectMenuFeature");
        this.selectMenu = selectMenu;

        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Widget.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQUIReferencePool.Widget.getCssReference());

        getJavascriptReferences().add(JQUIReferencePool.Button.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Spinner.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Button.getCssReference());
        getCssReferences().add(JQUIReferencePool.Spinner.getCssReference());

    }

    @Override
    public void assignFunctionsToComponent()
    {
        addQuery(selectMenu.getJQueryID() + "spinner(" + getOptions() + ");" + getNewLine());
    }

    /**
     * Returns the options associated with the Spinner Object
     * <p>
     * @return
     */
    @Override
    public JQUISpinnerOptions getOptions()
    {
        if (options == null)
        {
            options = new JQUISpinnerOptions();
        }
        return options;
    }

}
