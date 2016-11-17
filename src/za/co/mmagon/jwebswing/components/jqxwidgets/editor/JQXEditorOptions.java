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
package za.co.mmagon.jwebswing.components.jqxwidgets.editor;

import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptFunction;

/**
 * All the options for the JQXEditor library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXEditorOptions extends JQXDefaultJavaScriptPart
{

    private JavascriptFunction createCommand;// 	Function 	null
    private Boolean disabled;// 	Boolean 	false
    private Boolean editable;// 	Boolean 	true
    private String lineBreak;// 	String 	"default"
//private localization 	Object 	{ "bold": "Bold", "italic": "Italic", "underline": "Underline", "format": "Format Block", "font": "Font Name", "size": "Font Size", "color": "Text Color", "background": "Fill Color", "left": "Align Left", "center": "Align Center", "right": "Align Right", "outdent": "Indent Less", "indent": "Indent More", "ul": "Insert unordered list", "ol": "Insert ordered list", "image": "Insert image", "link": "Insert link", "html": "View source", "clean": "Remove Formatting" }
    private String pasteMode;// 	String 	"html"
    private Boolean rtl;// 	Boolean 	false
//stylesheets 	Array 	[]
    private String toolbarPosition;// 	String 	"top"
    private String tools;// 	String 	"bold italic underline | format font size | color background | left center right | outdent indent | ul ol | image | link | clean | html"

    public JQXEditorOptions()
    {

    }

    public JavascriptFunction getCreateCommand()
    {
        return createCommand;
    }

    public void setCreateCommand(JavascriptFunction createCommand)
    {
        this.createCommand = createCommand;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Boolean getEditable()
    {
        return editable;
    }

    public void setEditable(Boolean editable)
    {
        this.editable = editable;
    }

    public String getLineBreak()
    {
        return lineBreak;
    }

    public void setLineBreak(String lineBreak)
    {
        this.lineBreak = lineBreak;
    }

    public String getPasteMode()
    {
        return pasteMode;
    }

    public void setPasteMode(String pasteMode)
    {
        this.pasteMode = pasteMode;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public String getToolbarPosition()
    {
        return toolbarPosition;
    }

    public void setToolbarPosition(String toolbarPosition)
    {
        this.toolbarPosition = toolbarPosition;
    }

    public String getTools()
    {
        return tools;
    }

    public void setTools(String tools)
    {
        this.tools = tools;
    }

}
