package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 *
 * @since @version @author MMagon
 *
 *
 */
public enum AppletAttributes implements AttributeDefinitions
{
    /**
     * Alignment Type
     */
    Align,
    /**
     * Specifies the file name of a Java applet
     */
    Code,
    /**
     * Specifies a reference to a serialized representation of an applet
     */
    Object,
    /**
     * Specifies an alternate text for an applet
     */
    Alt,
    /**
     * Specifies the location of an archive file
     */
    Archive,
    /**
     * Specifies a relative base URL for applets specified in the code attribute
     */
    CodeBase,
    /**
     * Specifies the height of an applet
     */
    Height,
    /**
     * Defines the horizontal spacing around an applet
     */
    Hspace,
    /**
     * Defines the vertical spacing around an applet
     */
    Vspace,
    /**
     * Specifies the width of an applet
     */
    Width;

    @Override
    public boolean isKeyword()
    {
        return false;
    }

    @Override
    public String toString()
    {
        return super.toString().toLowerCase();
    }

}
