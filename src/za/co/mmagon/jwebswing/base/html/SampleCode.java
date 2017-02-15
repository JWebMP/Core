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
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.PhraseChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;samp&gt; tag is a phrase tag. It defines sample output from a computer program.<p>
 * <p>
 * Tip: This tag is not deprecated, but it is possible to achieve richer effect with CSS.<p>
 *
 * @author GedMarc
 * @param <J>
 *
 * @since Mar 1, 2015
 * @version 1.0
 * <p>
 *
 */
public class SampleCode<J extends SampleCode>
        extends Component<PhraseChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements ParagraphChildren, PhraseChildren
{

    private static final long serialVersionUID = 1L;

    /**
     * Defines a set of sample code
     *
     * @param code
     */
    public SampleCode(String code)
    {
        super(ComponentTypes.SampleCode);
    }
}
