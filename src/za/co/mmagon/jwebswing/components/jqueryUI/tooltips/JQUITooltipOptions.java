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
package za.co.mmagon.jwebswing.components.jqueryUI.tooltips;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.components.jqueryUI.position.Position;
import za.co.mmagon.jwebswing.htmlbuilder.effects.JWAnimationEffectsPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQUITooltipOptions extends JavaScriptPart
{

    /**
     * Version 2.0
     */
    private static final long serialVersionUID = 2L;
    /**
     * The position of the tooltip
     */
    private Position position;
    /**
     * The content for the tooltip
     */ 
    private String content;
    /**
     * If the tooltip is disabled or not
     */
    private Boolean disabled;
    /**
     * The animation to apply on hide
     */
    private JWAnimationEffectsPart hide;
    /**
     * The component type that makes up a tooltip.
     * E.G. img[alt] or *[title]
     */
    private String items;
    /**
     * The animation to apply on show
     */
    private JWAnimationEffectsPart show;
    /**
     * A class to add to the widget, can be used to display various tooltip types, like warnings or errors.
     * <p>
     * This may get replaced by the classes option.
     */
    private String tooltipClass;
    /**
     * Whether the tooltip should track (follow) the mouse.
     */
    private Boolean track;

    public JQUITooltipOptions()
    {

    }

    /**
     * The position of the tooltip
     * <p>
     * @return
     */
    public Position getPosition()
    {
        return position;
    }

    /**
     * The position of the tooltip
     * <p>
     * @param position
     */
    public void setPosition(Position position)
    {
        this.position = position;
    }

    /**
     * The content for the tooltip
     * <p>
     * @return
     */
    public String getContent()
    {
        return content;
    }

    /**
     * The content for the tooltip
     * <p>
     * @param content
     */
    public void setContent(Div content)
    {
        content.setTiny(true);
        this.content = content.toString(true).toString();
    }

    /**
     * If the tooltip is disabled or not
     * <p>
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * *
     * If the tooltip is disabled or not
     * <p>
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * The animation to apply on hide
     * <p>
     * @return
     */
    public JWAnimationEffectsPart getHide()
    {
        return hide;
    }

    /**
     * The animation to apply on hide
     * <p>
     * @param hide
     */
    public void setHide(JWAnimationEffectsPart hide)
    {
        this.hide = hide;
    }

    /**
     * The component type that makes up a tooltip.
     * E.G. img[alt] or *[title]
     * <p>
     * @return
     */
    public String getItems()
    {
        return items;
    }

    /**
     * The component type that makes up a tooltip.
     * E.G. img[alt] or *[title]
     * <p>
     * @param items
     */
    public void setItems(String items)
    {
        this.items = items;
    }

    /**
     * The animation to apply on show
     * <p>
     * @return
     */
    public JWAnimationEffectsPart getShow()
    {
        return show;
    }

    /**
     * The animation to apply on show
     * <p>
     * @param show
     */
    public void setShow(JWAnimationEffectsPart show)
    {
        this.show = show;
    }

    /**
     * A class to add to the widget, can be used to display various tooltip types, like warnings or errors.
     * <p>
     * This may get replaced by the classes option.
     * <p>
     * @return
     */
    public String getTooltipClass()
    {
        return tooltipClass;
    }

    /**
     * A class to add to the widget, can be used to display various tooltip types, like warnings or errors.
     * <p>
     * This may get replaced by the classes option.
     * <p>
     * @param tooltipClass
     */
    public void setTooltipClass(String tooltipClass)
    {
        this.tooltipClass = tooltipClass;
    }

    /**
     * Whether the tooltip should track (follow) the mouse.
     * <p>
     * @return
     */
    public Boolean getTrack()
    {
        return track;
    }

    /**
     * Whether the tooltip should track (follow) the mouse.
     * <p>
     * @param track
     */
    public void setTrack(Boolean track)
    {
        this.track = track;
    }

    @Override
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.Javascript;
    }
}
