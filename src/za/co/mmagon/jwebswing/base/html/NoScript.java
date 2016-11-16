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
package za.co.mmagon.jwebswing.base.html;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.NoIDTag;
import za.co.mmagon.jwebswing.base.html.interfaces.children.BodyChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &gt;noscript&lt; tag defines an alternate content for users that have disabled scripts in their browser or have a browser that doesn't support script.<p>
 * <p>
 * The &gt;noscript&lt; element can be used in both &gt;head&lt; and &gt;body&lt;
 * .<p>
 * <p>
 * When used inside the &gt;head&lt; element: &gt;noscript&lt; must contain &gt;link&lt;, &gt;style&lt;, and &gt;meta&lt; elements.<p>
 * <p>
 * The content inside the &gt;noscript&lt; element will be displayed if scripts are not supported, or are disabled in the user's browser.<p>
 *
 * @author GedMarc
 * @since Feb 9, 2015
 * @version 1.0
 * <p>
 *
 */
public class NoScript extends Component<GlobalChildren, NoAttributes, GlobalFeatures, GlobalEvents, NoScript> implements BodyChildren, NoIDTag
{

    /**
     *
     */
    public NoScript()
    {
        super(ComponentTypes.NoScript);
    }

    /**
     * Means no script available, so no point in rendering ID tags
     */
    @Override
    public void preConfigure()

    {
        setRenderIDAttibute(false);
        super.preConfigure(); //To change body of generated methods, choose Tools | Templates.
    }

}
