/*
 * Copyright (C) 2015 GedMarc
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
package za.co.mmagon.jwebswing.components.jqxWidgets.maskedinput;

import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXMaskedInputOptions extends JQXDefaultJavaScriptPart
{

    private Boolean disabled;// 	Boolean 	false
    private String mask;// 	String 	'#####'
    private String promptChar;// 	String 	"_"
    private Boolean readOnly;// 	Boolean 	false
    private Boolean rtl;// 	Boolean 	false
    private String textAlign;// 	String 	left
    private String value;// 	String 	null

    public JQXMaskedInputOptions()
    {

    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public String getMask()
    {
        return mask;
    }

    public void setMask(String mask)
    {
        this.mask = mask;
    }

    public String getPromptChar()
    {
        return promptChar;
    }

    public void setPromptChar(String promptChar)
    {
        this.promptChar = promptChar;
    }

    public Boolean getReadOnly()
    {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly)
    {
        this.readOnly = readOnly;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public String getTextAlign()
    {
        return textAlign;
    }

    public void setTextAlign(String textAlign)
    {
        this.textAlign = textAlign;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

}
