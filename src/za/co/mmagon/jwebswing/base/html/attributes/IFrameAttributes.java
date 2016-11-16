package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 * Valid IFrame attribute entries
 * <p>
 * @author MMagon
 * @since 23 Sep 2013
 * @version 1.0
 */
public enum IFrameAttributes implements AttributeDefinitions
{

    /**
     * Not supported in HTML5. Specifies the alignment of an iframe according to surrounding elements
     * <p>
     * @deprecated
     */
    Align,
    /**
     * Not supported in HTML5. Specifies whether or not to display a border around an &lt;iframe&gt;
     * <p>
     * @deprecated
     */
    FrameBorder,
    /**
     * Specifies the height of an &lt;iframe&gt;
     * <p>
     */
    Height,
    /**
     * Specifies a page that contains a long description of the content of an &lt;iframe&gt;
     * <p>
     */
    LongDesc,
    /**
     * Not supported in HTML5. Specifies the top and bottom margins of the content of an &lt;iframe&gt;
     * <p>
     * @deprecated
     */
    MarginHeight,
    /**
     * Not supported in HTML5. Specifies the left and right margins of the content of an &lt;iframe&gt;
     * <p>
     * @deprecated
     */
    MarginWidth,
    /**
     * Specifies the name of an &lt;iframe&gt;
     * <p>
     */
    Name,
    /**
     * Enables an extra set of restrictions for the content in an &lt;iframe&gt; allow-forms
     * <p>
     * allow-pointer-lock
     * <p>
     * allow-popups
     * <p>
     * allow-same-origin
     * <p>
     * allow-scripts
     * <p>
     * allow-top-navigation
     * <p>
     */
    Sandbox,
    /**
     * Not supported in HTML5. Specifies whether or not to display scrollbars in an &lt;iframe&gt;
     * <p>
     * @deprecated
     */
    Scrolling,
    /**
     * Specifies that the &lt;iframe&gt; should look like it is a part of the containing document
     * <p>
     */
    Seamless,
    /**
     * Specifies the address of the document to embed in the &lt;iframe&gt;
     * <p>
     */
    Src,
    /**
     * Specifies the HTML content of the page to show in the &lt;iframe&gt;
     * <p>
     */
    SrcDoc,
    /**
     * Specifies the width of an &lt;iframe&gt;
     * <p>
     */
    Width;

    /**
     * Returns the name in lowercase form
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
