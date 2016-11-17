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
package za.co.mmagon.jwebswing.components.jqmetro.metro;

import za.co.mmagon.jwebswing.components.jqmetro.metro.enumerations.JQMetroModes;
import za.co.mmagon.jwebswing.components.jqmetro.metro.enumerations.JQMetroSwapOptions;
import za.co.mmagon.jwebswing.components.jqmetro.metro.enumerations.JQMetroBounceDirections;
import java.util.ArrayList;
import za.co.mmagon.jwebswing.base.servlets.enumarations.Orientation;
import za.co.mmagon.jwebswing.htmlbuilder.effects.EasingEffects;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.events.mouseevents.MouseEventType;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQMetroOptions extends JavaScriptPart
{

    private JQMetroModes mode;
    private Integer speed;
    private Integer initDelay;
    private Integer delay;
    private Boolean startNow;
    private ArrayList<String> stops;
    private Boolean stack;
    private Orientation direction;
    private Boolean bounce;
    private ArrayList<JQMetroBounceDirections> bounceDirections;
    private Boolean bounceFollowsMove;
    private String link;
    private Boolean newWindow;
    private String animationDirection;
    private Boolean autoAniDirection;
    private Boolean ignoreDataAttributes;
    private Boolean pauseOnHover;
    private Boolean playOnHover;
    private Integer onHoverDelay;
    private Integer onHoverOutDelay;
    private Integer repeatCount;
    private Boolean appendBack;
    private Boolean alwaysTrigger;
    private Boolean flipListOnHover;
    private MouseEventType flipListOnHoverEvent;
    private Double noHAflipOpacity;
    private EasingEffects haTransFunc;
    private EasingEffects noHaTransFunc;
    private Integer currentIndex;
    private Boolean useModernizr;
    private Boolean useHardwareAccel;
    private JQMetroSwapOptions swap;
    private Boolean useTranslate;
    private JQMetroSwapOptions swapFront;
    private JQMetroSwapOptions swapBack;

    public JQMetroOptions()
    {

    }

    public JQMetroModes getMode()
    {
        return mode;
    }

    public void setMode(JQMetroModes mode)
    {
        this.mode = mode;
    }

    public Integer getSpeed()
    {
        return speed;
    }

    public void setSpeed(Integer speed)
    {
        this.speed = speed;
    }

    public Integer getInitDelay()
    {
        return initDelay;
    }

    public void setInitDelay(Integer initDelay)
    {
        this.initDelay = initDelay;
    }

    public Integer getDelay()
    {
        return delay;
    }

    public void setDelay(Integer delay)
    {
        this.delay = delay;
    }

    public Boolean getStartNow()
    {
        return startNow;
    }

    public void setStartNow(Boolean startNow)
    {
        this.startNow = startNow;
    }

    public ArrayList<String> getStops()
    {
        return stops;
    }

    public void setStops(ArrayList<String> stops)
    {
        this.stops = stops;
    }

    public Boolean getStack()
    {
        return stack;
    }

    public void setStack(Boolean stack)
    {
        this.stack = stack;
    }

    public Orientation getDirection()
    {
        return direction;
    }

    public void setDirection(Orientation direction)
    {
        this.direction = direction;
    }

    public Boolean getBounce()
    {
        return bounce;
    }

    public void setBounce(Boolean bounce)
    {
        this.bounce = bounce;
    }

    public ArrayList<JQMetroBounceDirections> getBounceDirections()
    {
        return bounceDirections;
    }

    public void setBounceDirections(ArrayList<JQMetroBounceDirections> bounceDirections)
    {
        this.bounceDirections = bounceDirections;
    }

    public Boolean getBounceFollowsMove()
    {
        return bounceFollowsMove;
    }

    public void setBounceFollowsMove(Boolean bounceFollowsMove)
    {
        this.bounceFollowsMove = bounceFollowsMove;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public Boolean getNewWindow()
    {
        return newWindow;
    }

    public void setNewWindow(Boolean newWindow)
    {
        this.newWindow = newWindow;
    }

    public String getAnimationDirection()
    {
        return animationDirection;
    }

    public void setAnimationDirection(String animationDirection)
    {
        this.animationDirection = animationDirection;
    }

    public Boolean getAutoAniDirection()
    {
        return autoAniDirection;
    }

    public void setAutoAniDirection(Boolean autoAniDirection)
    {
        this.autoAniDirection = autoAniDirection;
    }

    public Boolean getIgnoreDataAttributes()
    {
        return ignoreDataAttributes;
    }

    public void setIgnoreDataAttributes(Boolean ignoreDataAttributes)
    {
        this.ignoreDataAttributes = ignoreDataAttributes;
    }

    public Boolean getPauseOnHover()
    {
        return pauseOnHover;
    }

    public void setPauseOnHover(Boolean pauseOnHover)
    {
        this.pauseOnHover = pauseOnHover;
    }

    public Boolean getPlayOnHover()
    {
        return playOnHover;
    }

    public void setPlayOnHover(Boolean playOnHover)
    {
        this.playOnHover = playOnHover;
    }

    public Integer getOnHoverDelay()
    {
        return onHoverDelay;
    }

    public void setOnHoverDelay(Integer onHoverDelay)
    {
        this.onHoverDelay = onHoverDelay;
    }

    public Integer getOnHoverOutDelay()
    {
        return onHoverOutDelay;
    }

    public void setOnHoverOutDelay(Integer onHoverOutDelay)
    {
        this.onHoverOutDelay = onHoverOutDelay;
    }

    public Integer getRepeatCount()
    {
        return repeatCount;
    }

    public void setRepeatCount(Integer repeatCount)
    {
        this.repeatCount = repeatCount;
    }

    public Boolean getAppendBack()
    {
        return appendBack;
    }

    public void setAppendBack(Boolean appendBack)
    {
        this.appendBack = appendBack;
    }

    public Boolean getAlwaysTrigger()
    {
        return alwaysTrigger;
    }

    public void setAlwaysTrigger(Boolean alwaysTrigger)
    {
        this.alwaysTrigger = alwaysTrigger;
    }

    public Boolean getFlipListOnHover()
    {
        return flipListOnHover;
    }

    public void setFlipListOnHover(Boolean flipListOnHover)
    {
        this.flipListOnHover = flipListOnHover;
    }

    public MouseEventType getFlipListOnHoverEvent()
    {
        return flipListOnHoverEvent;
    }

    public void setFlipListOnHoverEvent(MouseEventType flipListOnHoverEvent)
    {
        this.flipListOnHoverEvent = flipListOnHoverEvent;
    }

    public Double getNoHAflipOpacity()
    {
        return noHAflipOpacity;
    }

    public void setNoHAflipOpacity(Double noHAflipOpacity)
    {
        this.noHAflipOpacity = noHAflipOpacity;
    }

    public EasingEffects getHaTransFunc()
    {
        return haTransFunc;
    }

    public void setHaTransFunc(EasingEffects haTransFunc)
    {
        this.haTransFunc = haTransFunc;
    }

    public EasingEffects getNoHaTransFunc()
    {
        return noHaTransFunc;
    }

    public void setNoHaTransFunc(EasingEffects noHaTransFunc)
    {
        this.noHaTransFunc = noHaTransFunc;
    }

    public Integer getCurrentIndex()
    {
        return currentIndex;
    }

    public void setCurrentIndex(Integer currentIndex)
    {
        this.currentIndex = currentIndex;
    }

    public Boolean getUseModernizr()
    {
        return useModernizr;
    }

    public void setUseModernizr(Boolean useModernizr)
    {
        this.useModernizr = useModernizr;
    }

    public Boolean getUseHardwareAccel()
    {
        return useHardwareAccel;
    }

    public void setUseHardwareAccel(Boolean useHardwareAccel)
    {
        this.useHardwareAccel = useHardwareAccel;
    }

    public JQMetroSwapOptions getSwap()
    {
        return swap;
    }

    public void setSwap(JQMetroSwapOptions swap)
    {
        this.swap = swap;
    }

    public Boolean getUseTranslate()
    {
        return useTranslate;
    }

    public void setUseTranslate(Boolean useTranslate)
    {
        this.useTranslate = useTranslate;
    }

    public JQMetroSwapOptions getSwapFront()
    {
        return swapFront;
    }

    public void setSwapFront(JQMetroSwapOptions swapFront)
    {
        this.swapFront = swapFront;
    }

    public JQMetroSwapOptions getSwapBack()
    {
        return swapBack;
    }

    public void setSwapBack(JQMetroSwapOptions swapBack)
    {
        this.swapBack = swapBack;
    }

}
