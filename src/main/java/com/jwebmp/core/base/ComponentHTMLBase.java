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
package com.jwebmp.core.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jwebmp.core.base.html.Comment;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.base.html.interfaces.NoClosingTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineBeforeClosingTag;
import com.jwebmp.core.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.core.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.core.base.interfaces.IComponentHTMLBase;
import com.jwebmp.core.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.core.utilities.StaticStrings;
import com.jwebmp.core.utilities.TextUtilities;

import javax.validation.constraints.NotNull;

/**
 * Denotes a component that has a tag. By default these can add events, features, variables etc
 *
 * @param <F>
 * 		The allowed feature JavaScripts
 * @param <E>
 * 		The allowed associated Events
 * @param <J>
 * 		Component output for cloning. Returned on CloneComponent
 *
 * @author GedMarc
 * @since 23 Apr 2016
 */
@SuppressWarnings({"MissingClassJavaDoc", "WeakerAccess", "UnusedReturnValue"})
public abstract class ComponentHTMLBase<F extends GlobalFeatures, E extends GlobalEvents, J extends ComponentHTMLBase<F, E, J>>
		extends ComponentEventBase<F, E, J>
		implements IComponentHTMLBase<J>
{

	/**
	 * The actual tag string of this component
	 */
	private String tag;
	/**
	 * Specifies to render a closing tag or not
	 */
	private Boolean inlineClosingTag;
	/**
	 * Specifies if this component should render a closing tag
	 */
	private Boolean closingTag = true;
	/**
	 * Specifies if there must be a new line before the raw text entry
	 */
	private boolean newLineForRawText;
	/**
	 * Specifies if there should be a new line for the closing tag
	 */
	private boolean newLineForClosingTag = true;
	/**
	 * The number of indents currently at
	 */
	@JsonIgnore
	private int currentTabIndents;
	/**
	 * Renders the text of this component before children
	 */
	private boolean renderTextBeforeChildren = true;

	/**
	 * Construct a new component that will render a tag
	 *
	 * @param componentType
	 * 		The type of component
	 */
	public ComponentHTMLBase(ComponentTypes componentType)
	{
		super(componentType);
		setTag(componentType.getComponentTag());
	}

	/**
	 * Returns a HTML Base interface of this component
	 *
	 * @return A HTML Base view of this component, managing only the tags
	 */
	@SuppressWarnings("unused")
	@NotNull
	public IComponentHTMLBase asTagBase()
	{
		return this;
	}

	/**
	 * Method for the attribute handling, Empty in the HTML base
	 *
	 * @param sb
	 * 		The string builder to append attributes to
	 *
	 * @return A complete string for the attribute
	 */
	@NotNull
	@SuppressWarnings({"unused", "UnusedReturnValue"})
	protected abstract StringBuilder renderAttributes(StringBuilder sb);

	/**
	 * Gets the physical inline closing tag value
	 *
	 * @return If the tag must close inline
	 */
	@NotNull
	public Boolean getInlineClosingTag()
	{
		return inlineClosingTag;
	}

	/**
	 * Sets Whether or not to close this tag as /
	 * <p>
	 *
	 * @param inlineClosingTag
	 * 		Sets whether to close this tag and disable the usage of children for this tag
	 *
	 * @return Always this object
	 */
	@NotNull
	@SuppressWarnings("unchecked")
	protected J setInlineClosingTag(boolean inlineClosingTag)
	{
		this.inlineClosingTag = inlineClosingTag;
		return (J) this;
	}

	/**
	 * The actual logic of the before tag rendering
	 *
	 * @param tempStringBuilder
	 * 		The StringBuilder to be manipulated
	 *
	 * @return The render before with the given tag
	 */
	@SuppressWarnings({"unused", "UnusedReturnValue"})
	@NotNull
	private StringBuilder renderBeforeTag(StringBuilder tempStringBuilder)
	{
		StringBuilder beforeTag = renderBeforeTag();
		if (beforeTag != null && beforeTag.length() > 0)
		{
			tempStringBuilder.append(beforeTag);
		}
		return tempStringBuilder;
	}

	/**
	 * The actual logic of the render text before children
	 *
	 * @param tempStringBuilder
	 * 		The current string builder
	 *
	 * @return The modified StringBuilder with the text rendered before the children
	 */
	@SuppressWarnings("UnusedReturnValue")
	@NotNull
	private StringBuilder renderTextBeforeChildren(StringBuilder tempStringBuilder)
	{
		StringBuilder rawText = getText(0);
		if (isRenderTextBeforeChildren() && (rawText.length() > 0))
		{
			tempStringBuilder.append(rawText);
		}
		return tempStringBuilder;
	}

	/**
	 * Renders the text of this component before children
	 *
	 * @return If the text should render before children
	 */
	public boolean isRenderTextBeforeChildren()
	{
		return renderTextBeforeChildren;
	}

	/**
	 * Renders the text of this component before children or after. Default true
	 *
	 * @param renderTextBeforeChildren
	 * 		If text should render before or after children are drawn
	 *
	 * @return Always this object
	 */
	@SuppressWarnings("unchecked")
	public J setRenderTextBeforeChildren(boolean renderTextBeforeChildren)
	{
		this.renderTextBeforeChildren = renderTextBeforeChildren;
		return (J) this;
	}

	/**
	 * The actual logic of the render text after children
	 *
	 * @param tempStringBuilder
	 * 		The current StringBuilder
	 *
	 * @return The StringBuilder with the raw text appended
	 */
	@SuppressWarnings("UnusedReturnValue")
	@NotNull
	private StringBuilder renderTextAfterChildren(StringBuilder tempStringBuilder)
	{
		StringBuilder rawText = getText(0);
		if (!isRenderTextBeforeChildren() && (rawText.length() > 0))
		{
			tempStringBuilder.append(rawText);
		}
		return tempStringBuilder;
	}

	/**
	 * The actual logic of the render before children
	 *
	 * @param tempStringBuilder
	 * 		The current string builder
	 *
	 * @return The modified string builder with everything rendered before the children
	 */
	@NotNull
	private StringBuilder renderBeforeChildren(StringBuilder tempStringBuilder)
	{
		StringBuilder beforeChildren = renderBeforeChildren();
		if (beforeChildren != null && beforeChildren.length() > 0)
		{
			tempStringBuilder.append(beforeChildren);
		}
		return tempStringBuilder;
	}

	/**
	 * Renders the string before the children
	 *
	 * @return Custom HTML String to be inserted directly before this components tag
	 */

	protected StringBuilder renderBeforeChildren()
	{
		return null;
	}

	/**
	 * Builds up the HTML for this component and all it's children - Does not perform Pre Configure or Pre Render Use GetHTML() to
	 * perform a
	 * pre configure and render
	 * <p>
	 * Executes the following methods in order
	 * <p>
	 * (1)preRenderHTML - removed. Placed into toString()
	 * <p>
	 * (2)renderBeforeTag
	 * <p>
	 * (3)renderAdditionalInnerHTMLBeforeChildren
	 * <p>
	 * (4)renderAttributeHTML
	 * <p>
	 * (5)renderAdditionalInnerHTMLAfterChildren.
	 * <p>
	 * (5)postRenderHTML
	 * <p>
	 *
	 * @param tabCount
	 * 		Indentation depth
	 * 		<p>
	 *
	 * @return The HTML
	 */
	@NotNull
	protected StringBuilder renderHTML(int tabCount)
	{
		if (this instanceof Comment && isTiny())
		{
			return new StringBuilder();
		}

		setCurrentTabIndents(tabCount);
		StringBuilder tempStringBuilder = new StringBuilder();
		renderBeforeTag(tempStringBuilder);
		tempStringBuilder.append(renderOpeningTag());
		if (isInlineClosingTag())
		{
			return new StringBuilder(tempStringBuilder);
		}

		renderTextBeforeChildren(tempStringBuilder);
		renderBeforeChildren(tempStringBuilder);
		renderChildren(tempStringBuilder);
		renderTextAfterChildren(tempStringBuilder);
		renderAfterChildren(tempStringBuilder);
		tempStringBuilder.append(renderClosingTag());
		renderAfterTag(tempStringBuilder);
		return tempStringBuilder;
	}

	/**
	 * The actual logic of the children rendering
	 *
	 * @param tempStringBuilder
	 * 		The current string builder
	 *
	 * @return The newly modified string builder
	 */
	@NotNull
	private StringBuilder renderChildren(StringBuilder tempStringBuilder)
	{
		StringBuilder childrenRender = renderChildren();
		if (childrenRender != null && childrenRender.length() > 0)
		{
			tempStringBuilder.append(childrenRender);
		}
		return tempStringBuilder;
	}

	/**
	 * Returns this tag
	 * <p>
	 *
	 * @return The tag this component will render
	 */
	@Override
	@NotNull
	public final String getTag()
	{
		return tag;
	}

	/**
	 * Whether or not this component should render a closing tag
	 *
	 * @return if this tag has a closing tag
	 */
	@Override
	@NotNull
	public Boolean isClosingTag()
	{
		if (this instanceof NoClosingTag)
		{
			return false;
		}
		return closingTag;
	}

	/**
	 * If a new line for the closing tag is required.
	 *
	 * @return If a new line is required
	 */
	@Override
	@NotNull
	public Boolean isNewLineForClosingTag()
	{
		if (!newLineForClosingTag)
		{
			return false;
		}

		return !(this instanceof NoNewLineBeforeClosingTag);
	}

	/**
	 * If a new line for the closing tag is required.
	 *
	 * @param newLineForClosingTag
	 * 		A new line is required for this objects closing tag
	 *
	 * @return Always this object
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setNewLineForClosingTag(boolean newLineForClosingTag)
	{
		this.newLineForClosingTag = newLineForClosingTag;
		return (J) this;
	}

	/**
	 * Sets if there must be a new line before the raw text starts
	 *
	 * @return If newline for raw text must be generated
	 */
	@Override
	@NotNull
	public Boolean isNewLineForRawText()
	{
		return (this instanceof NoNewLineForRawText) || newLineForRawText;

	}

	/**
	 * Whether or not this component should render a closing tag
	 *
	 * @param noCloseTag
	 * 		Whether or not to render the closing tag
	 *
	 * @return Always this object
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setClosingTag(boolean noCloseTag)
	{
		closingTag = noCloseTag;
		return (J) this;
	}

	/**
	 * Renders as an inline tiny html tag
	 *
	 * @return A string of the html tag
	 */
	@Override
	@NotNull
	public String toTinyString()
	{
		return setTiny(true).toString(0);
	}

	/**
	 * Overrides this tag name
	 * <p>
	 *
	 * @param tag
	 * 		The tag to use instead of the default
	 *
	 * @return This Class
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setTag(String tag)
	{
		this.tag = tag;
		return (J) this;
	}

	/**
	 * Overrides this tag name
	 * <p>
	 *
	 * @param tag
	 * 		The tag to use instead of the default
	 *
	 * @return This Class
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setTag(ComponentTypes tag)
	{
		this.tag = tag.getComponentTag();
		return (J) this;
	}


	/**
	 * Returns the HTML for the given object
	 * <p>
	 *
	 * @param outputHtml
	 * 		Dummy holder for specifying HTML output
	 *
	 * @return The class and the associated ID and children count
	 */
	@Override
	@NotNull
	public String toString(boolean outputHtml)
	{
		return toString(0);
	}

	/**
	 * Returns this components HTML after configuration and pre-rendering
	 *
	 * @param tabCount
	 * 		The number of tabs to indent by
	 *
	 * @return The sting with the given tab counts
	 */
	@Override
	@NotNull
	public String toString(Integer tabCount)
	{
		if (!isConfigured())
		{
			preConfigure();
		}
		return String.valueOf(renderHTML(tabCount));
	}

	/**
	 * Placeholder for children rendering.
	 * The component tag base object will never render any children, it only renders this tag
	 *
	 * @return Something new to render at this phase in the generation
	 */

	protected StringBuilder renderChildren()
	{
		return null;
	}

	/**
	 * The actual logic and the rendering after children
	 *
	 * @param tempStringBuilder
	 * 		The current temp String Builder
	 *
	 * @return The modified or final temp string builder
	 */
	@NotNull
	private StringBuilder renderAfterChildren(StringBuilder tempStringBuilder)
	{
		StringBuilder afterChildren = renderAfterChildren();
		if (afterChildren != null && afterChildren.length() > 0)
		{
			tempStringBuilder.append(afterChildren);
		}
		return tempStringBuilder;
	}

	/**
	 * Gets the number of tabs to apply for this component currently
	 *
	 * @return The current number of tab indents
	 */
	protected int getCurrentTabIndents()
	{
		return currentTabIndents;
	}

	/**
	 * Sets the number of tab indents for this component
	 *
	 * @param currentTabIndents
	 * 		the tab indentation count
	 *
	 * @return Always this object
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setCurrentTabIndents(int currentTabIndents)
	{
		this.currentTabIndents = currentTabIndents;
		return (J) this;
	}

	/**
	 * Sets if this component must place a new line before the raw text
	 *
	 * @param newLineForRawText
	 * 		If there should be a new line for raw text
	 *
	 * @return Always this object
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setNewLineForRawText(boolean newLineForRawText)
	{
		this.newLineForRawText = newLineForRawText;
		return (J) this;
	}

	/**
	 * Renders the given string after the children
	 *
	 * @return Custom HTML String to be inserted directly before this components tag
	 */

	protected StringBuilder renderAfterChildren()
	{
		return null;
	}

	/**
	 * The actual rendering of the after tag
	 *
	 * @param tempStringBuilder
	 * 		The current temp string builder
	 *
	 * @return The modified string for the tag
	 */
	@NotNull
	private StringBuilder renderAfterTag(StringBuilder tempStringBuilder)
	{
		StringBuilder afterTag = renderAfterTag();
		if (afterTag != null && afterTag.length() > 0)
		{
			tempStringBuilder.append(afterTag);
		}
		return tempStringBuilder;
	}

	/**
	 * Generates the opening tag with indentation.
	 * <p>
	 * DO NOT append this StringBuilder, it builds dynamically
	 * <p>
	 * <p>
	 *
	 * @return The String Builder coming in
	 */
	@NotNull
	private StringBuilder renderOpeningTag()
	{
		StringBuilder sb = new StringBuilder();
		if (!isTiny())
		{
			sb.append(getCurrentTabIndentString());
		}
		sb.append(StaticStrings.STRING_SHARP_BRACE_OPEN);
		sb.append(getTag());
		renderAttributes(sb);
		if (isInlineClosingTag())
		{
			sb.append(StaticStrings.STRING_FORWARD_SLASH);
		}
		sb.append(StaticStrings.STRING_SHARP_BRACE_CLOSED);
		return sb;
	}

	/**
	 * Generates the opening tag with indentation
	 * <p>
	 * <p>
	 *
	 * @return The original String Builder
	 */
	@NotNull
	private StringBuilder renderClosingTag()
	{
		StringBuilder sb = new StringBuilder();
		if (isInlineClosingTag() || !isClosingTag())
		{
			return sb;
		}

		if (!isTiny() && isNewLineForClosingTag())
		{
			sb.append(getNewLine());
			sb.append(getCurrentTabIndentString());
		}

		sb.append(StaticStrings.STRING_SHARP_BRACE_SLASH_OPEN);
		sb.append(getTag());
		sb.append(StaticStrings.STRING_SHARP_BRACE_CLOSED);
		return sb;
	}

	/**
	 * Returns the current tab indentation for this object
	 * <p>
	 *
	 * @return The current tab indentation
	 */
	@NotNull
	protected StringBuilder getCurrentTabIndentString()
	{
		return TextUtilities.getTabString(getCurrentTabIndents());
	}

	/**
	 * Renders String content before this tag is rendered
	 * <p>
	 *
	 * @return Custom HTML String to be inserted directly before this components tag
	 */

	protected StringBuilder renderBeforeTag()
	{
		return null;
	}

	/**
	 * Renders String content after this tag is rendered
	 * <p>
	 *
	 * @return Custom HTML String to be inserted directly after this components tag
	 */

	protected StringBuilder renderAfterTag()
	{
		return null;
	}

	/**
	 * Only returns in-line text if the tag is not closed in line
	 *
	 * @param sb
	 * 		The current string builder
	 *
	 * @return The input text if the tag is closing in line, or the actual inline text if the tag does stuff
	 *
	 * @see ComponentBase#getText(StringBuilder)
	 */
	@Override
	@NotNull
	protected StringBuilder getText(StringBuilder sb)
	{
		if (isInlineClosingTag())
		{
			return sb;
		}
		return super.getText(sb);
	}

	/**
	 * Whether or not to close this tag as /. Also sets whether to display the closing tag as separate
	 * <p>
	 *
	 * @return True if must close on the same line
	 */
	@NotNull
	protected Boolean isInlineClosingTag()
	{
		if (inlineClosingTag == null)
		{
			inlineClosingTag = false;
		}
		return inlineClosingTag;
	}

	/**
	 * Run all Assign Function To Components and Pre Configures for all Events
	 */
	@Override
	public void preConfigure()
	{
		if (!isInitialized())
		{
			init();
		}
		super.preConfigure();
	}

	/**
	 * @see ComponentEventBase#hashCode()
	 */
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	/**
	 * @see ComponentEventBase#equals(Object)
	 */
	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}
}
