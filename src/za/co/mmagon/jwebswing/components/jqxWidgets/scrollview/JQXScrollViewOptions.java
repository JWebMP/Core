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
package za.co.mmagon.jwebswing.components.jqxWidgets.scrollview;

import za.co.mmagon.jwebswing.components.jqxWidgets.JQXDefaultJavaScriptPart;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Dec 24, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXScrollViewOptions extends JQXDefaultJavaScriptPart
{

    private Integer animationDuration;// 	Number 	30
    private Boolean bounceEnabled;// 	Boolean 	true
    private Integer[] buttonsOffset;// 	Array 	[0, 0]
    private Integer currentPage;// 	Number 	0
    private Boolean disabled;// 	Boolean 	false
    private Double moveThreshold;// 	Number 	0.5
    private Boolean showButtons;// 	Boolean 	true
    private Boolean slideShow;// 	Boolean 	true
    private Integer slideDuration;// 	Number 	3000

    public JQXScrollViewOptions()
    {

    }

    public Integer getAnimationDuration()
    {
        return animationDuration;
    }

    public void setAnimationDuration(Integer animationDuration)
    {
        this.animationDuration = animationDuration;
    }

    public Boolean getBounceEnabled()
    {
        return bounceEnabled;
    }

    public void setBounceEnabled(Boolean bounceEnabled)
    {
        this.bounceEnabled = bounceEnabled;
    }

    public Integer[] getButtonsOffset()
    {
        return buttonsOffset;
    }

    public void setButtonsOffset(Integer[] buttonsOffset)
    {
        this.buttonsOffset = buttonsOffset;
    }

    public Integer getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage)
    {
        this.currentPage = currentPage;
    }

    public Boolean getDisabled()
    {
        return disabled;
    }

    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    public Double getMoveThreshold()
    {
        return moveThreshold;
    }

    public void setMoveThreshold(Double moveThreshold)
    {
        this.moveThreshold = moveThreshold;
    }

    public Boolean getShowButtons()
    {
        return showButtons;
    }

    public void setShowButtons(Boolean showButtons)
    {
        this.showButtons = showButtons;
    }

    public Boolean getSlideShow()
    {
        return slideShow;
    }

    public void setSlideShow(Boolean slideShow)
    {
        this.slideShow = slideShow;
    }

    public Integer getSlideDuration()
    {
        return slideDuration;
    }

    public void setSlideDuration(Integer slideDuration)
    {
        this.slideDuration = slideDuration;
    }

}
