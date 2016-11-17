/*
 * Copyright (C) 2014 mmagon
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
package za.co.mmagon.jwebswing.components.jqplot.options.title;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.co.mmagon.jwebswing.components.jqplot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqplot.parts.interfaces.JQPlotTitleRenderer;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourHex;
import za.co.mmagon.jwebswing.htmlbuilder.css.fonts.FontFamilies;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.TextAlignments;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Handles the text attribute of the JWGraph
 * <p>
 * @author mmagon
 * @since 2014/07/09
 */
public class JQPlotTitleOptions<O extends JavaScriptPart & JQPlotTitleRenderer> extends JavaScriptPart
{

    @JsonIgnore
    private JQPlotGraph linkedGraph;

    /**
     * text of the text
     */
    private String text;
    /**
     * Whether or not to show the text
     */
    private Boolean show;

    /**
     * CSS font-family spec for the text.
     */
    private FontFamilies fontFamily;
    /**
     * CSS font-size spec for the text.
     */
    private Integer fontSize;
    /**
     * CSS text-align spec for the text.
     */
    private TextAlignments textAlign;
    /**
     * CSS color spec for the text.
     */
    private String textColor;
    /**
     * for creating a DOM element for the text, see $.jqplot.DivTitleRenderer.
     */
    private String renderer;

    private O rendererOptions;

    /**
     * Constructs a Title Part for the JWGraph
     * <p>
     * @param title The text to add to the graph
     * @param graph The linked graph
     */
    public JQPlotTitleOptions(String title, JQPlotGraph graph)
    {
        this.text = title;
        this.linkedGraph = graph;
    }

    /**
     * Whether or not to show the text
     * <p>
     * @return
     */
    public Boolean getShow()
    {
        return show;
    }

    /**
     * Whether or not to show the text
     * <p>
     * @param show
     */
    public void setShow(Boolean show)
    {
        this.show = show;
    }

    /**
     * Returns the actual text
     * <p>
     * @return
     */
    public String getText()
    {
        return text;
    }

    /**
     * Sets the actual text
     * <p>
     * @param text
     */
    public void setText(String text)
    {
        this.text = text;
    }

    /**
     * Returns the font family
     * <p>
     * @return
     */
    public FontFamilies getFontFamily()
    {
        return fontFamily;
    }

    /**
     * Sets the font family
     * <p>
     * @param fontFamily
     */
    public void setFontFamily(FontFamilies fontFamily)
    {
        this.fontFamily = fontFamily;
    }

    /**
     * Sets the font size
     * <p>
     * @return
     */
    public Integer getFontSize()
    {
        return fontSize;
    }

    /**
     * Sets the font size
     * <p>
     * @param fontSize
     */
    public void setFontSize(Integer fontSize)
    {
        this.fontSize = fontSize;
    }

    /**
     * Returns the text alignment
     * <p>
     * @return
     */
    public TextAlignments getTextAlign()
    {
        return textAlign;
    }

    /**
     * sets the text alignment
     * <p>
     * @param textAlign
     */
    public void setTextAlign(TextAlignments textAlign)
    {
        this.textAlign = textAlign;
    }

    /**
     * Sets the colour of the text
     * <p>
     * @return
     */
    public String getTextColor()
    {
        return textColor;
    }

    /**
     * Sets the text colour
     * <p>
     * @param textColor
     */
    public void setTextColor(ColourHex textColor)
    {
        this.textColor = textColor.getValue();
    }

    /**
     * Returns the text renderer
     * <p>
     * @return
     */
    public String getRenderer()
    {
        return renderer;
    }

    /**
     * Returns the current renderer options or the default
     *
     * @return
     */
    public O getRendererOptions()
    {
        if (rendererOptions == null)
        {
            setRendererOptions((O) new JQPlotTitleOptionsDivTitle(linkedGraph));
        }
        return rendererOptions;
    }

    /**
     * Sets the renderer options
     *
     * @param rendererOptions
     */
    public void setRendererOptions(O rendererOptions)
    {
        this.rendererOptions = rendererOptions;
        this.renderer = rendererOptions.getRenderer();
    }

}
