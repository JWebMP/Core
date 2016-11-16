package za.co.mmagon.jwebswing.base.html.attributes;

import za.co.mmagon.jwebswing.base.html.interfaces.AttributeDefinitions;

/**
 *
 * @since
 * @version
 * @author MMagon
 *
 *
 */
public enum AudioAttributes implements AttributeDefinitions
{
    /**
     * Specifies that the audio will start playing as soon as it is ready
     */
    Autoplay,
    /**
     * Specifies that audio controls should be displayed (such as a play/pause button etc)
     */
    Controls,
    /**
     * Specifies that the audio will start over again, every time it is finished
     */
    Loop,
    /**
     * Specifies that the audio output should be muted
     */
    Muted,
    /**
     * Specifies if and how the author thinks the audio should be loaded when the page loads
     */
    Preload,
    /**
     * Specifies the URL of the audio file
     */
    Src;

    @Override
    public String toString()
    {
        return super.toString().toLowerCase();
    }

    @Override
    public boolean isKeyword()
    {
        return false;
    }

    public enum AudioPreloadTypes
    {
        Auto,
        Metadata,
        None
    }
}
