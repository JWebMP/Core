package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * Attributes valid for the header link tag
 *
 * @since 2013/11/13
 * @version 1.0
 * @author MMagon
 *
 *
 */
public enum CSSLinkAttributes implements AttributeDefinitions
{
    /**
     * THe charset for the link
     */
    Charset,
    /**
     * The link
     */
    HRef,
    /**
     * The language of the link
     */
    HRefLang,
    /**
     * The relationship to the document
     */
    Rel,
    /**
     * The media type
     */
    Media,
    /**
     * The link is reversed
     */
    Rev,
    /**
     * Specifies that the target resource should be cached
     */
    PreFetch,
    /**
     * The target frame
     */
    Target,
    /**
     * The type
     */
    Type;

    /**
     * Returns the lower case variant of the name;
     *
     * @return
     */
    @Override
    public String toString()
    {
        return name().toLowerCase();
    }

    @Override
    public boolean isKeyword()
    {
        return false;
    }
}
