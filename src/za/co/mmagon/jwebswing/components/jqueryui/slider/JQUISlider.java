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

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;

/**
 *
 * @author GedMarc
 * @since Mar 9, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQUISlider extends Div<JQUISliderChildren, NoAttributes, JQUISliderFeatures, JQUISliderEvents, JQUISlider>
{

    private static final long serialVersionUID = 1L;
    /**
     * The feature for this component
     */
    private final JQUISliderFeature slider;
    /**
     * The options for this component
     */
    private JQUISliderOptions options;

    /**
     *
     */
    public JQUISlider()
    {
        slider = new JQUISliderFeature(this);
        addFeature(slider);
    }

    /**
     * Returns the actual slider
     *
     * @return
     */
    public JQUISliderFeature getSlider()
    {
        return slider;
    }

    /**
     * Returns the slider options
     * <p>
     * @return
     */
    @Override
    public JQUISliderOptions getOptions()
    {
        if (this.options == null)
        {
            this.options = new JQUISliderOptions();
        }
        return options;
    }

}
