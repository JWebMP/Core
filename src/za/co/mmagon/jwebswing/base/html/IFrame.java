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
import za.co.mmagon.jwebswing.base.html.attributes.IFrameAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.NoChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;

/**
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The iframe tag is supported in all major browsers.<p>
 * <p>
 * Definition and Usage<p>
 * <p>
 * The iframe tag specifies an inline frame.<p>
 * <p>
 * An inline frame is used to embed another document within the current HTML document.<p>
 * <p>
 * Tips and Notes<p>
 * <p>
 * Tip: To deal with browsers that do not support iframe, add a text between the opening iframe tag and the closing /iframe tag.<p>
 * <p>
 * Tip: Use CSS to style the iframe (even to include scrollbars)
 * .<p>
 * <p>
 * Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * HTML5 has added some new attributes, and several HTML 4.01 attributes are removed from HTML5.<p>
 * <p>
 * Differences Between HTML and XHTML<p>
 * <p>
 * In XHTML, the name attribute is deprecated, and will be removed. Use the id attribute instead.<p>
 * <p>
 * @author Marc Magon
 * @param <J>
 */
public class IFrame<J extends IFrame>
        extends Component<NoChildren, IFrameAttributes, GlobalFeatures, GlobalEvents, J>
{

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new IFrame
     * <p>
     * @param URL            The source URL to utilize
     * @param name           The name of the IFrame. Used for Targets
     * @param widthInPixels  The width in Pixels of the IFrame
     * @param heightInPixels The height in Pixels of the IFrame
     */
    public IFrame(String URL, String name, int widthInPixels, int heightInPixels)
    {
        super(ComponentTypes.IFrame);
        addAttribute(IFrameAttributes.Name, name);
        addAttribute(IFrameAttributes.Src, URL);
        addAttribute(IFrameAttributes.Width, widthInPixels);
        addAttribute(IFrameAttributes.Height, heightInPixels);
        setTiny(true);
    }

    /**
     * Returns this IFrames URL
     * <p>
     * @return String that is this frame URL
     */
    public String getURL()
    {
        return getAttribute(IFrameAttributes.Src);
    }

    /**
     * Sets this Frames URL
     * <p>
     * @param URL The URL to use for this frame
     */
    public void setURL(String URL)
    {
        addAttribute(IFrameAttributes.Src, URL);
    }

    /**
     * Get this frames name
     * <p>
     * @return The name of this frame
     */
    public String getFrameName()
    {
        return getAttribute(IFrameAttributes.Name);
    }

    /**
     * Sets this frames name
     * <p>
     * @param frameName The new name of the IFrame
     */
    public void setFrameName(String frameName)
    {
        addAttribute(IFrameAttributes.Name, frameName);
    }

    /**
     * Returns the Width in Pixels
     * <p>
     * @return
     */
    public int getWidthInPixels()
    {
        return new Integer(getAttribute(IFrameAttributes.Width));
    }

    /**
     * Sets the width in pixels
     * <p>
     * @param widthInPixels
     */
    public void setWidthInPixels(int widthInPixels)
    {
        addAttribute(IFrameAttributes.Width, widthInPixels);
    }

    /**
     * Returns the Height in Pixels
     * <p>
     * @return The height in Pixels
     */
    public int getHeightInPixles()
    {
        return new Integer(getAttribute(IFrameAttributes.Height));
    }

    /**
     * Sets this IFrames Height
     * <p>
     * @param heightInPixles The height of the frame
     */
    public void setHeightInPixles(int heightInPixles)
    {
        addAttribute(IFrameAttributes.Height, heightInPixles);
    }

    /**
     * Sets the raw text to display when the browser doesn't support iframe's
     *
     * @param text
     */
    public void setUnsupportedText(String text)
    {
        setText(text);
    }

}
