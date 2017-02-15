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
package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.client.HTMLVersions;
import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * Definition and Usage
 * <p>
 * The &gt;a&lt; tag defines a hyperlink, which is used to link from one page to another.
 * <p>
 * The most important attribute of the &gt;a&lt; element is the HREF attribute, which indicates the links destination.
 * <p>
 * By default, links will appear as follows in all browsers:
 * <p>
 * An unvisited link is underlined and blue A visited link is underlined and purple An active link is underlined and red
 * <p>
 * Browser Support Element &gt;a&lt; Yes Yes Yes Yes Yes
 * <p>
 * Tips and Notes
 * <p>
 * Tip: The following attributes: download, hreflang, media, rel, target, and type cannot be present if the href attribute is not present.
 * <p>
 * Tip: A linked page is normally displayed in the current browser window, unless you specify another target.
 * <p>
 * Tip: Use CSS to style links. Differences Between HTML 4.01 and HTML5
 * <p>
 * In HTML 4.01, the &gt;a&lt; tag could be either a hyperlink or an anchor. In HTML5, the &gt;a&lt; tag is always a hyperlink, but if it has no href attribute, it is only a placeholder for a
 * hyperlink.
 * <p>
 * HTML5 has some new attributes, and some HTML 4.01 attributes are no longer supported.
 *
 * @author MMagon
 * @since 23 Sep 2013
 * @version 1.1
 *
 * Updated attributes to full suite
 */
public enum LinkAttributes implements AttributeDefinitions
{
    /**
     * Not supported in HTML5.
     * Specifies the character-set of a linked document
     *
     * @deprecated
     */
    Charset(HTMLVersions.HTML401Transitional),
    /**
     * Specifies the coordinates of a link
     *
     * @deprecated
     */
    Coords(HTMLVersions.HTML401Transitional),
    /**
     * Specifies that the target will be downloaded when a user clicks
     */
    Download(HTMLVersions.HTML5, true),
    /**
     * Specifies the URL of the page the link goes to
     */
    HRef,
    /**
     * Specifies the language of the linked document
     */
    HRefLang,
    /**
     * Specifies what media/device the linked document is optimized for
     */
    Media,
    /**
     * Specifies the name of an anchor
     * Not Supported in HTML5 use global attribute ID instead
     *
     * @deprecated
     */
    Name(HTMLVersions.HTML401Transitional),
    /**
     * Specifies the relationship between the current document and the linked document
     */
    Rel,
    /**
     * Not supported in HTML5.
     *
     * @deprecated
     */
    Rev(HTMLVersions.HTML401Transitional, true),
    /**
     * Specifies the shape of a link
     *
     * @deprecated
     */
    Shape(HTMLVersions.HTML401Transitional),
    /**
     * Specifies where to open the linked document
     */
    Target,
    /**
     * Specifies the media type of the linked document
     */
    Type,
    /**
     * Sets the toggle
     */
    Data_Toggle,
    /**
     * Sets the target
     */
    Data_Target,;

    private HTMLVersions maxsupportedVersion = HTMLVersions.HTML5;
    private HTMLVersions minsupportedVersion = HTMLVersions.HTML401Frameset;
    private Class returnType = String.class;

    /**
     * Construct a new "a" tag with all the predefined supported HTML versions
     */
    private LinkAttributes()
    {
    }

    private LinkAttributes(HTMLVersions maxsupportedVersion)
    {
        this.maxsupportedVersion = maxsupportedVersion;
    }

    private LinkAttributes(HTMLVersions minsupportedVersion, boolean trues)
    {
        this.minsupportedVersion = minsupportedVersion;
    }

    private LinkAttributes(HTMLVersions maxsupportedVersion, HTMLVersions minsupportedVersion)
    {
        this.maxsupportedVersion = maxsupportedVersion;
        this.minsupportedVersion = minsupportedVersion;
    }

    private LinkAttributes(Class returnType)
    {
        this.returnType = returnType;
    }

    private LinkAttributes(HTMLVersions maxsupportedVersion, HTMLVersions minsupportedVersion, Class returnType)
    {
        this.maxsupportedVersion = maxsupportedVersion;
        this.minsupportedVersion = minsupportedVersion;
        this.returnType = returnType;
    }

    private LinkAttributes(HTMLVersions maxsupportedVersion, Class returnType)
    {
        this.maxsupportedVersion = maxsupportedVersion;
        this.returnType = returnType;
    }

    private LinkAttributes(HTMLVersions minsupportedVersion, boolean trues, Class returnType)
    {
        this.minsupportedVersion = maxsupportedVersion;
        this.returnType = returnType;
    }

   @Override
    public String toString()
    {
        return name().toLowerCase().replace('_', '-');
    }

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
