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
package za.co.mmagon.jwebswing.components.jqxwidgets.scheduler;

import za.co.mmagon.jwebswing.base.html.Div;

/**
 * The jqxScheduler widget displays a set of Appointments in Day, Week, Month, Timeline Day, Timeline Week and Timeline Month views.
 * <p>
 * @author Marc Magon
 * @since 29 Aug 2015
 * @version 1.0
 */
public class JQXScheduler extends Div<JQXSchedulerChildren, JQXSchedulerAttributes, JQXSchedulerFeature, JQXSchedulerEvents, JQXScheduler>
{

    private static final long serialVersionUID = 1L;
    private JQXSchedulerFeature feature;

    public JQXScheduler()
    {
        addFeature(getFeature());
    }

    public JQXSchedulerFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQXSchedulerFeature(this);
        }
        return feature;
    }

    @Override
    public JQXSchedulerOptions getOptions()
    {
        return getFeature().getOptions();
    }

}
