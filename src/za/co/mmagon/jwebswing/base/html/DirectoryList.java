/*
 * Copyright (C) 2017 Marc Magon
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
import za.co.mmagon.jwebswing.base.html.attributes.DirectoryListAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.NoFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.DirectoryListChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.NoEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage
 * <p>
 * The dir tag is not supported in HTML5. Use CSS instead.
 * <p>
 * The dir tag is used to list directory titles. Browser Support Element dir Yes Yes Yes Yes Yes
 * <p>
 * Tips and Notes
 * <p>
 * Tip: Use CSS to style lists! In our CSS tutorial you can find more details about styling lists. Differences Between HTML 4.01 and HTML5
 * <p>
 * The dir tag is not supported in HTML5.
 * <p>
 * @author GedMarc
 * @param <J>
 *
 * @deprecated
 */
public class DirectoryList<J extends DirectoryList>
        extends Component<DirectoryListChildren, DirectoryListAttributes, NoFeatures, NoEvents, J>
{

    private static final long serialVersionUID = 1L;

    /**
     * @deprecated
     */
    public DirectoryList()
    {
        super(ComponentTypes.DirectoryList);
    }
}
