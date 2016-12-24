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
package za.co.mmagon.jwebswing.components.verticaltimeline;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * An implementation of the Responsive Vertical Timeline - https://codyhouse.co/gem/vertical-timeline/
 * <p>
 * <p>
 * @author Marc Magon
 * @since 24 October 2016
 * @version 1.0
 */
public class VerticalTimeline extends Div<VerticalTimelineChildren, VerticalTimelineAttributes, VerticalTimelineFeatures, VerticalTimelineEvents, VerticalTimeline> implements IVerticalTimeline
{

    private static final long serialVersionUID = 1L;
    private VerticalTimelineFeature feature;

    public VerticalTimeline()
    {
        addFeature(getFeature());
        setTag("section");
        addClass("verticalTimeline");
        addClass("cd-container");
    }

    /**
     * Adds a time line block to this vertical time line
     *
     * @param block
     */
    @Override
    public void add(VerticalTimelineBlock block)
    {
        super.add(block);
    }

    /**
     * Returns the vertical time line with only the fields relevant
     *
     * @return
     */
    public IVerticalTimeline asVerticalTimeline()
    {
        return this;
    }

    public final VerticalTimelineFeature getFeature()
    {
        if (feature == null)
        {
            feature = new VerticalTimelineFeature(this);
        }
        return feature;
    }

    @Override
    public VerticalTimelineOptions getOptions()
    {
        return getFeature().getOptions();
    }

    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            //getPage().getOptions().setModernizrEnabled(true);
            getPage().getOptions().setBootstrapEnabled(true);
        }
        super.preConfigure();
    }
}
