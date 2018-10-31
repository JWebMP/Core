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

package com.jwebmp.core.htmlbuilder.css.composer;

import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.core.utilities.TextUtilities;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Denotes many lines of CSS. This belongs to a Block This can be not defined, or hover, a, visited, link... etc
 *
 * @author MMagon
 * @version 1.0
 * @since 07 Apr 2013
 */
public class CSSLines

{
	/**
	 * If this should be rendered as tiny
	 */
	private static boolean tinyHTML;
	/**
	 * A list of all the CSS lines
	 */
	private List<CSSLine> allLines;
	/**
	 * Whether or not to render in quotations
	 */
	private boolean renderInQuotations;
	/**
	 * If the surrounding braces should be rendered
	 */
	private boolean renderBraces;
	/**
	 * If the css should be pretty printed
	 */
	private boolean prettyPrint;
	/**
	 * If semicolon's shouldn't exists
	 */
	private boolean renderSemiColons;

	/**
	 * A New CSS Lines Holder, setting Braces on, Quotations off, pretty print as true
	 */
	public CSSLines()
	{
		this(new ArrayList<>());
	}

	/**
	 * A New CSS Lines Holder, setting Braces on, Quotations off, pretty print as true
	 *
	 * @param allLines
	 * 		The lines that should be rendered for CSS Lines
	 */
	public CSSLines(List<CSSLine> allLines)
	{
		this(allLines, false);
	}

	/**
	 * A New CSS Lines Holder, setting Braces on, Quotations Set, pretty print as true
	 *
	 * @param allLines
	 * 		The lines that should be rendered for CSS Lines
	 * @param renderInQuotations
	 * 		Sets to render the CSS for JQuery
	 */
	public CSSLines(List<CSSLine> allLines, boolean renderInQuotations)
	{
		this(allLines, renderInQuotations, false);
	}

	/**
	 * A New CSS Lines Holder, setting Braces Set, Quotations Set, pretty print as true
	 *
	 * @param allLines
	 * 		The lines that should be rendered for CSS Lines
	 * @param renderInQuotations
	 * 		Sets to render the CSS for JQuery
	 * @param renderBraces
	 * 		Sets to render braces for the CSS
	 */
	public CSSLines(List<CSSLine> allLines, boolean renderInQuotations, boolean renderBraces)
	{
		this(allLines, renderInQuotations, renderBraces, true, false);
	}

	/**
	 * A New CSS Lines Holder, setting Braces Set, Quotations Set, and pretty print Set
	 *
	 * @param allLines
	 * 		The lines that should be rendered for CSS Lines
	 * @param renderInQuotations
	 * 		Sets to render the CSS for JQuery
	 * @param renderBraces
	 * 		Sets to render braces for the CSS
	 * @param prettyPrint
	 * 		Sets to put on the pretty print
	 * @param tinyHtml
	 * 		Old field for tiny HTML - replaced with getNewLine();
	 */
	public CSSLines(List<CSSLine> allLines, boolean renderInQuotations, boolean renderBraces, boolean prettyPrint, boolean tinyHtml)
	{
		this.allLines = allLines;
		this.renderInQuotations = renderInQuotations;
		this.renderBraces = renderBraces;
		this.prettyPrint = prettyPrint;
		tinyHTML = tinyHtml;
	}

	/**
	 * A New CSS Lines Holder, setting Braces Set, Quotations Set, and pretty print Set
	 *
	 * @param renderInQuotations
	 * 		Sets to render the CSS for JQuery
	 * @param renderBraces
	 * 		Sets to render braces for the CSS
	 * @param prettyPrint
	 * 		Sets to put on the pretty print
	 */
	public CSSLines(boolean renderInQuotations, boolean renderBraces, boolean prettyPrint)
	{
		this(new ArrayList<>(), renderInQuotations, renderBraces, prettyPrint, false);
	}

	/**
	 * @return Whether or not to enclose property and value in quotations '
	 */
	public boolean isRenderInQuotations()
	{
		return renderInQuotations;
	}

	/**
	 * Sets Whether or not to enclose property and value in quotations '
	 *
	 * @param renderInQuotations
	 * 		Sets Whether or not to enclose property and value in quotations '
	 */
	public void setRenderInQuotations(boolean renderInQuotations)
	{
		this.renderInQuotations = renderInQuotations;
	}

	/**
	 * Returns whether or not should render in semi colons
	 *
	 * @return True or False
	 */
	public boolean isRenderSemiColons()
	{
		return renderSemiColons;
	}

	/**
	 * Sets whether or not to render in semi colons
	 *
	 * @param renderSemiColons
	 * 		True or False
	 */
	public void setRenderSemiColons(boolean renderSemiColons)
	{
		this.renderSemiColons = renderSemiColons;
	}

	/**
	 * A custom hash code
	 *
	 * @return
	 */
	@Override
	public int hashCode()
	{
		return 2;
	}

	/**
	 * Checks if this lines object is equal to another
	 *
	 * @param o
	 * 		Any object
	 */
	@Override
	public boolean equals(Object o)
	{
		if (o instanceof CSSLines)
		{
			CSSLines lines = (CSSLines) o;
			return !lines.toString()
			             .equals(toString());
		}
		else
		{
			return false;
		}
	}

	/**
	 * Returns this lines CSS object with 0 tabs
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		return toString(0);
	}

	/**
	 * Returns this lines object at the tab count indentation
	 *
	 * @param tabCount
	 * 		Number of tab indents to apply
	 *
	 * @return The CSS line block
	 */
	public String toString(int tabCount)
	{
		StringBuilder sb = new StringBuilder();
		StringBuilder tabs = TextUtilities.getTabString(tabCount);
		StringBuilder cssTabsLess = TextUtilities.getTabString(tabCount - 1);
		StringBuilder newline = new StringBuilder(StaticStrings.STRING_NEWLINE_TEXT);

		if (isRenderBraces())
		{
			if (isPrettyPrint())
			{
				sb.append(newline);
			}
			sb.append("{");
			if (isPrettyPrint())
			{
				sb.append(newline);
			}
		}

		for (CSSLine cSSLine : getAllLines())
		{
			if (!isPrettyPrint())
			{
				sb.append(cSSLine.toString(renderInQuotations));
				sb.append(";");
			}
			else
			{
				sb.append(!isPrettyPrint() ? "" : tabs)
				  .append(cSSLine.toString(renderInQuotations))
				  .append(";");
			}
			if (isPrettyPrint())
			{
				sb.append("\n");
			}
		}
		if (isRenderBraces())
		{
			sb.append(tinyHTML ? "" : cssTabsLess)
			  .append("}");
		}
		return sb.toString();
	}

	/**
	 * Whether or not it must render opening and or closing braces {}
	 *
	 * @return Whether or not it must render opening and or closing braces {}
	 */
	public boolean isRenderBraces()
	{
		return renderBraces;
	}

	/**
	 * Sets Whether or not it must render opening and or closing braces {}
	 *
	 * @param renderBraces
	 * 		Whether or not it must render opening and or closing braces {}
	 */
	public void setRenderBraces(boolean renderBraces)
	{
		this.renderBraces = renderBraces;
	}

	/**
	 * Whether or not it must render new lines
	 *
	 * @return Whether or not it must render new lines
	 */
	public boolean isPrettyPrint()
	{
		return prettyPrint;
	}

	/**
	 * Sets Whether or not it must render new lines
	 *
	 * @param prettyPrint
	 * 		Whether or not it must render new lines
	 */
	public void setPrettyPrint(boolean prettyPrint)
	{
		this.prettyPrint = prettyPrint;
	}

	/**
	 * Get all CSSLines
	 *
	 * @return a list of CSS Line
	 */
	@NotNull
	public List<CSSLine> getAllLines()
	{
		if (allLines == null)
		{
			allLines = new ArrayList();
		}
		return allLines;
	}

	/**
	 * Reset this lines object with a new CSSLine
	 *
	 * @param allLines
	 * 		The lines list to set
	 */
	public void setAllLines(List<CSSLine> allLines)
	{
		this.allLines = allLines;
	}
}
