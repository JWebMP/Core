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
package za.co.mmagon.jwebswing.components.jqxwidgets.loader;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.VerticalAlignments;
import za.co.mmagon.jwebswing.htmlbuilder.css.themes.Theme;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 * All the options for the Loader
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXLoaderOptions extends JavaScriptPart
{

    private Boolean autoOpen;
    private Integer height;
    private Integer width;
    private String html;
    private Boolean isModal;
    private VerticalAlignments imagePosition;
    private Boolean rtl;
    private String text;
    private VerticalAlignments textPosition;
    private String theme;

    public JQXLoaderOptions()
    {

    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }

    public Boolean getAutoOpen()
    {
        return autoOpen;
    }

    public void setAutoOpen(Boolean autoOpen)
    {
        this.autoOpen = autoOpen;
    }

    public Integer getHeight()
    {
        return height;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public Integer getWidth()
    {
        return width;
    }

    public void setWidth(Integer width)
    {
        this.width = width;
    }

    public String getHtml()
    {
        return html;
    }

    public void setHtml(Component html)
    {
        html.setTiny(true);
        this.html = html.toString(true);
    }

    public Boolean getIsModal()
    {
        return isModal;
    }

    public void setIsModal(Boolean isModal)
    {
        this.isModal = isModal;
    }

    public VerticalAlignments getImagePosition()
    {
        return imagePosition;
    }

    public void setImagePosition(VerticalAlignments imagePosition)
    {
        this.imagePosition = imagePosition;
    }

    public Boolean getRtl()
    {
        return rtl;
    }

    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public VerticalAlignments getTextPosition()
    {
        return textPosition;
    }

    public void setTextPosition(VerticalAlignments textPosition)
    {
        this.textPosition = textPosition;
    }

    public String getTheme()
    {
        return theme;
    }

    public void setTheme(Theme theme)
    {
        this.theme = theme.getClassName();
    }

}
