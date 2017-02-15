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
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.children.generics.ParagraphChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;wbr&gt; (Word Break Opportunity) tag specifies where in a text it would be ok to add a line-break.<p>
 * <p>
 * Tip: When a word is too long, or you are afraid that the browser will break your lines at the wrong place, you can use the &lt;wbr&gt; element to add word break opportunities.<p>
 * Browser Support<p>
 * <p>
 * The numbers in the table specify the first browser version that fully supports the element.<p>
 * Element
 * <p>
 * &lt;wbr&gt; 1.0 Not supported 3.0 4.0 11.7
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * The &lt;wbr&gt; tag is new in HTML5.<p>
 * @author GedMarc
 * @param <J>
 *
 * @since Mar 1, 2015
 * @version 1.0
 * <p>
 *
 */
public class WordBreak<J extends WordBreak>
        extends Component<ParagraphChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
        implements NoIDTag, NoNewLineBeforeClosingTag, NoNewLineForRawText
{

    /**
     * Static instance of Word Break
     */
    public static final WordBreak wordBreak = new WordBreak();
    private static final long serialVersionUID = 1L;

    /**
     * Singleton instance of word breaks
     */
    private WordBreak()
    {
        super(ComponentTypes.WordBreak);
    }
}
