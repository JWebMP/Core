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
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.KeyGenAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.base.servlets.interfaces.IFeature;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.interfaces.IEvent;

/**
 * Keygen Object<p>
 *<p>
 * The Keygen Object is new in HTML5.<p>
 *<p>
 * The Keygen object represents an HTML &gt;keygen&lt; element.<p>
 *<p>
 * Note: The &gt;keygen&lt; element is not supported in Internet Explorer.<p>
 *<p>
 * Definition and Usage<p>
 *<p>
 * The &gt;keygen&lt; tag specifies a key-pair generator field used for forms.<p>
 *<p>
 * When the form is submitted, the private key is stored locally, and the public<p>
 * key is sent to the server. Browser Support<p>
 *<p>
 * The numbers in the table specify the first browser version that fully<p>
 * supports the element. Element<p>
 * &gt;keygen&lt; 1.0 Not supported 1.0 1.2 3.0<p>
 *<p>
 * @author GedMarc
 * @since 2015/02/09
 * @version 1.0
 * @deprecated
 */
public class KeyGen extends Component<NoChildren, KeyGenAttributes, GlobalFeatures, GlobalEvents, KeyGen>
{

    /**
     * Constructs a new KeyGen with the given name
     * <p>
     * @param name
     */
    public KeyGen(String name)
    {
        super(ComponentTypes.KeyGen);
        addAttribute(GlobalAttributes.Name, name);
    }

}
