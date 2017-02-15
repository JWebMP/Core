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
package za.co.mmagon.jwebswing.base.interfaces;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.co.mmagon.jwebswing.base.ComponentEventBase;
import za.co.mmagon.jwebswing.base.html.Comment;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.utilities.TextUtilities;
import za.co.mmagon.logger.LogFactory;

/**
 * Denotes a component that has a tag. By default these can add events, features, variables etc
 *
 * @param <F> The allowed feature JavaScripts
 * @param <E> The allowed associated Events
 * @param <J> Component output for cloning. Returned on CloneComponent
 *
 * @author GedMarc
 * @since 23 Apr 2016
 */
public abstract class ComponentHTMLBase<F extends GlobalFeatures, E extends GlobalEvents, J extends ComponentHTMLBase>
        extends ComponentEventBase<F, E, J> implements IComponentHTMLBase<J>
{

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
     * Logger for the Component
     */
    @JsonIgnore
    private static final java.util.logging.Logger LOG = LogFactory.getInstance().getLogger("ComponentTag");
    /**
     * Serial Version for all Components and their compatibility
     *
     * @version 2 Version 2 - Updated CSS Library and References
     */
    @JsonIgnore
    private static final long serialVersionUID = 1l;
    /**
     * The actual tag string of this component
     */
    private String tag;
    /**
     * Specifies to render a closing tag or not
     */
    private boolean inlineClosingTag = false;
    /**
     * Specifies if this component should render a closing tag
     */
    private boolean closingTag = true;
    /**
     * Specifies if there must be a new line before the raw text entry
     */
    private boolean newLineForRawText;
    /**
     * Specifies if there should be a new line for the closing tag
     */
    private boolean newLineForClosingTag = true;

    /**
     * This components current tab indents as a string
     */
    @JsonIgnore
    private StringBuilder currentTabIndentString;
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
     * Returns a HTML Base interface of this component
     *
     * @return
     */
    public IComponentHTMLBase asTagBase()
    {
        return (ComponentHTMLBase) this;
    }

    /**
     * Builds up the HTML for this component and all it's children - Does not perform Pre Configure or Pre Render Use GetHTML() to perform a pre configure and render
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
     * @param tabCount Indentation depth
     * <p>
     * @return The HTML
     */
    protected StringBuilder renderHTML(int tabCount)
    {
        if (this instanceof Comment && isTiny())
        {
            return null;
        }

        setCurrentTabIndents(tabCount);

        StringBuilder tempStringBuilder = new StringBuilder();
        StringBuilder beforeTag = renderBeforeTag();
        if (beforeTag != null && beforeTag.length() > 0)
        {
            tempStringBuilder.append(beforeTag);
        }

        StringBuilder openingTag = renderOpeningTag();
        tempStringBuilder.append(openingTag);

        if (isInlineClosingTag())
        {
            return new StringBuilder(tempStringBuilder);
        }

        StringBuilder rawText = getText(0);

        if (isRenderTextBeforeChildren())
        {
            if (rawText != null && rawText.length() > 0)
            {
                tempStringBuilder.append(rawText);
            }
        }

        StringBuilder beforeChildren = renderBeforeChildren();
        if (beforeChildren != null && beforeChildren.length() > 0)
        {
            tempStringBuilder.append(beforeChildren);
        }

        StringBuilder childrenRender = renderChildren();
        if (childrenRender != null && childrenRender.length() > 0)
        {
            tempStringBuilder.append(childrenRender);
        }
        if (!isRenderTextBeforeChildren())
        {
            if (rawText != null && rawText.length() > 0)
            {
                tempStringBuilder.append(getNewLine()).append(getCurrentTabIndentString()).append("\t").append(rawText);
            }
        }

        StringBuilder afterChildren = renderAfterChildren();
        if (afterChildren != null && afterChildren.length() > 0)
        {
            tempStringBuilder.append(afterChildren);
        }

        StringBuilder closingTagString = renderClosingTag();
        tempStringBuilder.append(closingTagString);

        StringBuilder afterTag = renderAfterTag();
        if (afterTag != null && afterTag.length() > 0)
        {
            tempStringBuilder.append(afterTag);
        }

        return tempStringBuilder;
    }

    /**
     * Placeholder for children rendering. The component tag base object will never render any children, it only renders this tag
     *
     * @return
     */
    protected StringBuilder renderChildren()
    {
        return null;
    }

    /**
     * Returns this tag
     * <p>
     * @return The tag this component will render
     */
    @Override
    public final String getTag()
    {
        return tag;
    }

    /**
     * Overrides this tag name
     * <p>
     * @param tag The tag to use instead of the default
     */
    @Override
    public J setTag(String tag)
    {
        this.tag = tag;
        return (J) this;
    }

    /**
     * Generates the opening tag with indentation.
     * <p>
     * DO NOT append this StringBuilder, it builds dynamically
     * <p>
     * <p>
     * @return The String Builder coming in
     */
    private StringBuilder renderOpeningTag()
    {
        StringBuilder sb = new StringBuilder();
        if (!isTiny())
        {
            sb.append(getCurrentTabIndentString());
        }
        sb.append("<");
        sb.append(getTag());
        renderAttributes(sb);
        if (isInlineClosingTag())
        {
            sb.append("/");
        }
        sb.append(">");
        return sb;
    }

    /**
     * Method for the attribute handling, Empty in the HTML base
     *
     * @param sb The string builder to append attributes to
     *
     * @return
     */
    protected StringBuilder renderAttributes(StringBuilder sb)
    {
        return sb;
    }

    /**
     * Generates the opening tag with indentation
     * <p>
     * <p>
     * @return The original String Builder
     */
    private StringBuilder renderClosingTag()
    {
        StringBuilder sb = new StringBuilder();
        if (isInlineClosingTag() || !isClosingTag())
        {
            return sb;
        }
        if (!isTiny())
        {
            if (isNewLineForClosingTag())
            {
                sb.append(getNewLine());
                sb.append(getCurrentTabIndentString());
            }
        }
        sb.append("</");
        sb.append(getTag());
        sb.append(">");
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
     * @return True if must close on the same line
     */
    protected boolean isInlineClosingTag()
    {
        return inlineClosingTag;
    }

    /**
     * Sets Whether or not to close this tag as /
     * <p>
     * @param inlineClosingTag Sets whether to close this tag and disable the usage of children for this tag
     *
     * @return
     */
    protected J setInlineClosingTag(boolean inlineClosingTag)
    {
        this.inlineClosingTag = inlineClosingTag;
        return (J) this;
    }

    /**
     * Whether or not this component should render a closing tag
     * <p>
     * @return
     */
    @Override
    public boolean isClosingTag()
    {
        if (this instanceof NoClosingTag)
        {
            return false;
        }

        return this.closingTag;
    }

    /**
     * Whether or not this component should render a closing tag
     * <p>
     * @param noCloseTag Whether or not to render the closing tag
     */
    @Override
    public J setClosingTag(boolean noCloseTag)
    {
        this.closingTag = noCloseTag;
        return (J) this;
    }

    /**
     * Sets if there must be a new line before the raw text starts
     *
     * @return
     */
    @Override
    public boolean isNewLineForRawText()
    {
        if ((this instanceof NoNewLineForRawText))
        {
            return true;
        }

        return newLineForRawText;
    }

    /**
     * Sets if this component must place a new line before the raw text
     *
     * @param newLineForRawText
     */
    @Override
    public J setNewLineForRawText(boolean newLineForRawText)
    {
        this.newLineForRawText = newLineForRawText;
        return (J) this;
    }

    /**
     * Returns the current tab indentation for this object
     * <p>
     * @return The current tab indentation
     */
    protected StringBuilder getCurrentTabIndentString()
    {
        currentTabIndentString = TextUtilities.getTabString(getCurrentTabIndents());
        return currentTabIndentString;
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
    public J setCurrentTabIndents(int currentTabIndents)
    {
        this.currentTabIndents = currentTabIndents;
        return (J) this;
    }

    /**
     * Renders String content before this tag is rendered
     * <p>
     * @return Custom HTML String to be inserted directly before this components tag
     */
    protected StringBuilder renderBeforeTag()
    {
        return null;
    }

    /**
     * Renders the string before the childre
     *
     * @return
     */
    protected StringBuilder renderBeforeChildren()
    {
        return null;
    }

    /**
     * Renders the given string after the children
     *
     * @return
     */
    protected StringBuilder renderAfterChildren()
    {
        return null;
    }

    /**
     * Renders String content after this tag is rendered
     * <p>
     * @return Custom HTML String to be inserted directly after this components tag
     */
    protected StringBuilder renderAfterTag()
    {
        return null;
    }

    /**
     * Returns the HTML for the given object
     * <p>
     * @param outputHtml Dummy holder for specifying HTML output
     * <p>
     * @return The class and the associated ID and children count
     */
    @Override
    public String toString(boolean outputHtml)
    {
        return toString(0);
    }

    /**
     * Returns this components HTML after configuration and pre-rendering
     *
     * @param tabCount The number of tabs to indent by
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
        StringBuilder html = new StringBuilder();
        html.append(renderHTML(tabCount));
        return html.toString();
    }

    /**
     * If a new line for the closing tag is required. Also sets new line for raw text to false
     *
     * @return
     */
    @Override
    public boolean isNewLineForClosingTag()
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
    public void setNewLineForClosingTag(boolean newLineForClosingTag)
    {
        this.newLineForClosingTag = newLineForClosingTag;
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
     * Renders the text of this component before children or after
     *
     * @param renderTextBeforeChildren
     *
     * @return
     */
    public J setRenderTextBeforeChildren(boolean renderTextBeforeChildren)
    {
        this.renderTextBeforeChildren = renderTextBeforeChildren;
        return (J) this;
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
