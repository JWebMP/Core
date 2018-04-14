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
package com.jwebmp.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jwebmp.base.html.Comment;
import com.jwebmp.base.html.interfaces.GlobalFeatures;
import com.jwebmp.base.html.interfaces.NoClosingTag;
import com.jwebmp.base.html.interfaces.NoNewLineBeforeClosingTag;
import com.jwebmp.base.html.interfaces.NoNewLineForRawText;
import com.jwebmp.base.html.interfaces.events.GlobalEvents;
import com.jwebmp.base.interfaces.IComponentHTMLBase;
import com.jwebmp.base.servlets.enumarations.ComponentTypes;
import com.jwebmp.utilities.TextUtilities;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;

import static com.jwebmp.utilities.StaticStrings.*;


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
public abstract class ComponentHTMLBase<F extends GlobalFeatures, E extends GlobalEvents, J extends ComponentHTMLBase<F, E, J>>
		extends ComponentEventBase<F, E, J>
		implements IComponentHTMLBase<J>
{
	/**
	 * Serial Version for all Components and their compatibility
	 *
	 * @version 2 Version 2 - Updated CSS Library and References
	 */
	@JsonIgnore
	private static final long serialVersionUID = 1L;
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
	 */
	@SuppressWarnings("")
	public ComponentHTMLBase(ComponentTypes componentType)
	{
		super(componentType);
		setTag(componentType.getComponentTag());
	}

	/**
	 * Returns a HTML Base interface of this component
	 *
	 * @return
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
	 * @return
	 */
	@NotNull
	@SuppressWarnings("unused")
	protected StringBuilder renderAttributes(StringBuilder sb)
	{
		return sb;
	}

	/**
	 * Gets the physical inline closing tag value
	 *
	 * @return
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
	 * @return
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
	 *
	 * @return
	 */
	@SuppressWarnings("unused")
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
	 *
	 * @return
	 */
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
	 * The actual logic of the render text after children
	 *
	 * @param tempStringBuilder
	 *
	 * @return
	 */
	@NotNull
	private StringBuilder renderTextAfterChildren(StringBuilder tempStringBuilder)
	{
		StringBuilder rawText = getText(0);
		if (!isRenderTextBeforeChildren() && (rawText != null && rawText.length() > 0))
		{
			tempStringBuilder.append(rawText);
		}
		return tempStringBuilder;
	}

	/**
	 * The actual logic of the render before children
	 *
	 * @param tempStringBuilder
	 *
	 * @return
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
	 * The actual logic of the children rendering
	 *
	 * @param tempStringBuilder
	 *
	 * @return
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
	 * The actual logic and the rendering after children
	 *
	 * @param tempStringBuilder
	 *
	 * @return
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
	 * The actual rendering of the after tag
	 *
	 * @param tempStringBuilder
	 *
	 * @return
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
	 * Placeholder for children rendering. The component tag base object will never render any children, it only renders this tag
	 *
	 * @return
	 */
	@Nullable
	protected StringBuilder renderChildren()
	{
		return null;
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
	 * Overrides this tag name
	 * <p>
	 *
	 * @param tag
	 * 		The tag to use instead of the default
	 */
	@Override
	@SuppressWarnings("unchecked")
	public J setTag(String tag)
	{
		this.tag = tag;
		return (J) this;
	}

	/**
	 * Returns the HTML for the given object
	 * <p>
	 *
	 * @param outputHtml
	 * 		Dummy holder for specifying HTML output
	 * 		<p>
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
	 * @return
	 */
	@Override
	public String toString(Integer tabCount)
	{
		if (!isConfigured())
		{
			preConfigure();
		}
		return String.valueOf(renderHTML(tabCount));
	}

	/**
	 * Whether or not this component should render a closing tag
	 * <p>
	 *
	 * @return
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
	 * If a new line for the closing tag is required. Also sets new line for raw text to false
	 *
	 * @return
	 */
	@Override
	@NotNull
	public Boolean isNewLineForClosingTag()
	{
		if (!newLineForClosingTag)
		{
			return newLineForClosingTag;
		}

		if (this instanceof NoNewLineBeforeClosingTag)
		{
			return false;
		}

		return newLineForClosingTag;
	}

	/**
	 * If a new line for the closing tag is required. Also sets new line for raw text to false
	 *
	 * @param newLineForClosingTag
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
	 * @return
	 */
	@Override
	@NotNull
	public Boolean isNewLineForRawText()
	{
		return (this instanceof NoNewLineForRawText) || newLineForRawText;

	}

	/**
	 * Whether or not this component should render a closing tag
	 * <p>
	 *
	 * @param noCloseTag
	 * 		Whether or not to render the closing tag
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
	 * Gets the number of tabs to apply for this component currently
	 *
	 * @return
	 */
	protected int getCurrentTabIndents()
	{
		return currentTabIndents;
	}

	/**
	 * Sets the number of tab indents for this component
	 *
	 * @param currentTabIndents
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
		sb.append(STRING_SHARP_BRACE_OPEN);
		sb.append(getTag());
		renderAttributes(sb);
		if (isInlineClosingTag())
		{
			sb.append(STRING_FORWARD_SLASH);
		}
		sb.append(STRING_SHARP_BRACE_CLOSED);
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

		sb.append(STRING_SHARP_BRACE_SLASH_OPEN);
		sb.append(getTag());
		sb.append(STRING_SHARP_BRACE_CLOSED);
		return sb;
	}

	/**
	 * Only returns in-line text if the tag is not closed in line
	 *
	 * @param sb
	 *
	 * @return
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
	@Nullable
	protected StringBuilder renderBeforeTag()
	{
		return null;
	}

	/**
	 * Renders the string before the childre
	 *
	 * @return
	 */
	@Nullable
	protected StringBuilder renderBeforeChildren()
	{
		return null;
	}

	/**
	 * Renders the given string after the children
	 *
	 * @return
	 */
	@Nullable
	protected StringBuilder renderAfterChildren()
	{
		return null;
	}

	/**
	 * Renders String content after this tag is rendered
	 * <p>
	 *
	 * @return Custom HTML String to be inserted directly after this components tag
	 */
	@Nullable
	protected StringBuilder renderAfterTag()
	{
		return null;
	}

	/**
	 * Renders the text of this component before children
	 *
	 * @return
	 */
	public boolean isRenderTextBeforeChildren()
	{
		return renderTextBeforeChildren;
	}

	/**
	 * Renders the text of this component before children or after. Default true
	 *
	 * @param renderTextBeforeChildren
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public J setRenderTextBeforeChildren(boolean renderTextBeforeChildren)
	{
		this.renderTextBeforeChildren = renderTextBeforeChildren;
		return (J) this;
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}

	@Override
	public void preConfigure()
	{
		if (!isInitialized())
		{
			init();
		}
		super.preConfigure();

	}
}
