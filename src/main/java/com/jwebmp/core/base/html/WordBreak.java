/*
 * Copyright (C) 2017 GedMarc
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
package com.jwebmp.core.base.html;

import com.jwebmp.core.Component;
import com.jwebmp.core.base.html.attributes.NoAttributes;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.NoIDTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineBeforeClosingTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.core.base.html.interfaces.children.generics.ParagraphChildren;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;

/**
 * Definition and Usage<p>
 * <p>
 * The &lt;wbr&gt; (Word Break Opportunity) tag specifies where in a text it would be ok to add a line-break.<p>
 * <p>
 * Tip: When a word is too long, or you are afraid that the browser will break your lines at the wrong place, you can use the &lt;wbr&gt; element to add word break
 * opportunities.<p>
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
 *
 * @param <J>
 *
 * @author GedMarc
 * @version 1.0
 * 		<p>
 * @since Mar 1, 2015
 */
public class WordBreak<J extends WordBreak<J>>
		extends Component<ParagraphChildren, NoAttributes, GlobalFeatures, GlobalEvents, J>
		implements NoIDTag, NoNewLineBeforeClosingTag, NoNewLineForRawText
{

	/**
	 * Static instance of Word Break
	 */
	public static final WordBreak wordBreak = new WordBreak();


	/**
	 * Singleton instance of word breaks
	 */
	private WordBreak()
	{
		super(ComponentTypes.WordBreak);
	}
}
