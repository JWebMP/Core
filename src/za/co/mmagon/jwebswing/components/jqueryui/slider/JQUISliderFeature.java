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
package za.co.mmagon.jwebswing.components.jqueryui.slider;

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
public class JQUISliderFeature extends Feature<JQUISliderOptions, JQUISliderFeature> implements JQUISliderFeatures
{

    private static final long serialVersionUID = 1L;
    /**
     * The actual slider for the menu
     */
    private final JQUISlider selectMenu;
    /**
     * The options for the select menu
     */
    private JQUISliderOptions options;

    /**
     * Constructs a new slider
     *
     * @param selectMenu
     */
    public JQUISliderFeature(JQUISlider selectMenu)
    {
        super("JWPSelectMenuFeature");
        this.selectMenu = selectMenu;

        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Widget.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQUIReferencePool.Widget.getCssReference());

        getJavascriptReferences().add(JQUIReferencePool.Slider.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Slider.getCssReference());
    }

    @Override
    public void assignFunctionsToComponent()
    {
        addQuery(selectMenu.getJQueryID() + "slider(" + getOptions() + ");");
    }

    @Override
    public JQUISliderOptions getOptions()
    {
        if (options == null)
        {
            options = new JQUISliderOptions();
        }
        return options;
    }

}
