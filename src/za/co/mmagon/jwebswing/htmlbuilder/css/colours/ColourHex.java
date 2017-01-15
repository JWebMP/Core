package za.co.mmagon.jwebswing.htmlbuilder.css.colours;

import com.fasterxml.jackson.annotation.JsonValue;
import java.io.Serializable;
import za.co.mmagon.jwebswing.base.client.CSSVersions;

/**
 *
 * @author Marc Magon
 */
public class ColourHex implements CssColour<ColourHex>, Serializable
{

    private static final long serialVersionUID = 1L;
    private String thisHex;

    public ColourHex(String thisHex)
    {
        if (thisHex.startsWith("#"))
        {
            this.thisHex = thisHex;
        }
        else
        {
            this.thisHex = "#" + thisHex;
        }
    }

    public ColourHex(ColourNames colourName)
    {
        this.thisHex = colourName.toString();
    }

    @Override
    public CSSVersions getCSSVersion()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getJavascriptSyntax()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setThisHex(String thisHex)
    {
        this.thisHex = thisHex;
    }

    @Override
    public String getValue()
    {
        return thisHex;
    }

    @Override
    public ColourHex getDefault()
    {
        return new ColourHex("#ffffff");
    }

    @JsonValue(true)
    @Override
    public String toString()
    {
        return thisHex;
    }
}
