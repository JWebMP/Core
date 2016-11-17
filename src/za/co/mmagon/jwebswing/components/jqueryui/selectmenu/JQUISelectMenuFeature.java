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
package za.co.mmagon.jwebswing.components.jqueryui.selectmenu;

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
public class JQUISelectMenuFeature extends Feature<JQUISelectMenuOptions, JQUISelectMenuFeature> implements JQUISelectMenuFeatures
{

    private static final long serialVersionUID = 1L;

    private final Component selectMenu;
    private JQUISelectMenuOptions options;

    /**
     * Constructs a new Select Menu
     * Add Options or Option Groups to configure
     *
     * @param selectMenu Because off css classing
     */
    public JQUISelectMenuFeature(Component selectMenu)
    {
        super("JWSelectMenuFeature");
        this.selectMenu = selectMenu;

        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Widget.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQUIReferencePool.Widget.getCssReference());

        getJavascriptReferences().add(JQUIReferencePool.Menu.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.SelectMenu.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.SelectMenuIcons.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.SelectMenu.getCssReference());
        getCssReferences().add(JQUIReferencePool.Menu.getCssReference());
    }

    @Override
    public void assignFunctionsToComponent()
    {
        addQuery(selectMenu.getJQueryID() + "selectmenu(" + getOptions() + ");" + getNewLine());
    }

    @Override
    public JQUISelectMenuOptions getOptions()
    {
        if (options == null)
        {
            options = new JQUISelectMenuOptions();
        }
        return options;
    }

}
