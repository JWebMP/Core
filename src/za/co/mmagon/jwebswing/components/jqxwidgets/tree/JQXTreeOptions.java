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
package za.co.mmagon.jwebswing.components.jqxwidgets.tree;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import za.co.mmagon.jwebswing.components.jqxwidgets.JQXDefaultJavaScriptPart;
import za.co.mmagon.jwebswing.components.jqxwidgets.dataadapter.JQXDataAdapter;
import za.co.mmagon.jwebswing.htmlbuilder.effects.EasingEffects;

/**
 * All the options for the tooltip library
 * <p>
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 * <p>
 * <p>
 */
public class JQXTreeOptions extends JQXDefaultJavaScriptPart
{

    private static final long serialVersionUID = 1L;

    private Integer animationShowDuration;// 	Number 	350
    private Integer animationHideDuration;// 	Number 	fast
    private Boolean allowDrag;// 	Boolean 	false
    private Boolean allowDrop;// 	Boolean 	false
    private Boolean checkboxes;// 	Boolean 	false
    private String dragStart;// 	Function 	null
    private String dragEnd;// 	Function 	null
    private Boolean disabled;// 	Boolean 	false
    private EasingEffects easing;// 	String 	'easeInOutCirc'
    private Boolean enableHover;// 	Boolean 	true
    private Boolean hasThreeStates;// 	Boolean 	false
    private Boolean incrementalSearch;// 	Boolean 	true
    private Boolean keyboardNavigation;// 	Boolean 	true
    private Boolean rtl;// 	Boolean 	false
    private ArrayList<JQXTreeItem> source;// 	Object 	null
    private JQXDataAdapter<JQXTreeItem> sourceAdapter;
    private Integer toggleIndicatorSize;// 	Number 	16
    private JQXTreeToggleModes toggleMode;// 	String 	dblclick

    /**
     * Runs the expand all method
     */
    @JsonIgnore
    private boolean expandAll;

    public JQXTreeOptions()
    {

    }

    /**
     * Gets the show animation duration
     *
     * @return
     */
    public Integer getAnimationShowDuration()
    {
        return animationShowDuration;
    }

    /**
     * Sets the show animation duration
     *
     * @param animationShowDuration
     */
    public void setAnimationShowDuration(Integer animationShowDuration)
    {
        this.animationShowDuration = animationShowDuration;
    }

    /**
     * Gets the animation hide duration
     *
     * @return
     */
    public Integer getAnimationHideDuration()
    {
        return animationHideDuration;
    }

    /**
     * Sets the animation Hide Duration
     *
     * @param animationHideDuration
     */
    public void setAnimationHideDuration(Integer animationHideDuration)
    {
        this.animationHideDuration = animationHideDuration;
    }

    /**
     * Gets if the tree can be dragged and dropped
     *
     * @return
     */
    public Boolean getAllowDrag()
    {
        return allowDrag;
    }

    /**
     * Sets if to allow drag
     *
     * @param allowDrag
     */
    public void setAllowDrag(Boolean allowDrag)
    {
        this.allowDrag = allowDrag;
    }

    /**
     * Gets allow drop
     *
     * @return
     */
    public Boolean getAllowDrop()
    {
        return allowDrop;
    }

    /**
     * Sets allow drop
     *
     * @param allowDrop
     */
    public void setAllowDrop(Boolean allowDrop)
    {
        this.allowDrop = allowDrop;
    }

    /**
     * Gets check-boxes
     *
     * @return
     */
    public Boolean getCheckboxes()
    {
        return checkboxes;
    }

    /**
     * Sets if must allow check-boxes
     *
     * @param checkboxes
     */
    public void setCheckboxes(Boolean checkboxes)
    {
        this.checkboxes = checkboxes;
    }

    /**
     * Sets the drag start?
     *
     * @return
     */
    public String getDragStart()
    {
        return dragStart;
    }

    /**
     * Sets the drag start?
     *
     * @param dragStart
     */
    public void setDragStart(String dragStart)
    {
        this.dragStart = dragStart;
    }

    /**
     * Sets the drag end
     *
     * @return
     */
    public String getDragEnd()
    {
        return dragEnd;
    }

    /**
     * Sets the drag end
     *
     * @param dragEnd
     */
    public void setDragEnd(String dragEnd)
    {
        this.dragEnd = dragEnd;
    }

    /**
     * Sets if disabled
     *
     * @return
     */
    public Boolean getDisabled()
    {
        return disabled;
    }

    /**
     * Gets if disabled
     *
     * @param disabled
     */
    public void setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
    }

    /**
     * Sets easing
     *
     * @return
     */
    public EasingEffects getEasing()
    {
        return easing;
    }

    /**
     * Gets easing
     *
     * @param easing
     */
    public void setEasing(EasingEffects easing)
    {
        this.easing = easing;
    }

    /**
     * Whether to enable hover selected
     *
     * @return
     */
    public Boolean getEnableHover()
    {
        return enableHover;
    }

    /**
     * Sets to enable hover selected
     *
     * @param enableHover
     */
    public void setEnableHover(Boolean enableHover)
    {
        this.enableHover = enableHover;
    }

    /**
     * Whether or not the tree has three states
     *
     * @return
     */
    public Boolean getHasThreeStates()
    {
        return hasThreeStates;
    }

    /**
     * If the tree has 3 states
     *
     * @param hasThreeStates
     */
    public void setHasThreeStates(Boolean hasThreeStates)
    {
        this.hasThreeStates = hasThreeStates;
    }

    /**
     * Sets if there must be an incremental search
     *
     * @return
     */
    public Boolean getIncrementalSearch()
    {
        return incrementalSearch;
    }

    /**
     * Sets if there must be an incremental search
     *
     * @param incrementalSearch
     */
    public void setIncrementalSearch(Boolean incrementalSearch)
    {
        this.incrementalSearch = incrementalSearch;
    }

    /**
     * Gets the keyboard navigation
     *
     * @return
     */
    public Boolean getKeyboardNavigation()
    {
        return keyboardNavigation;
    }

    /**
     * Sets the keyboard navigation
     *
     * @param keyboardNavigation
     */
    public void setKeyboardNavigation(Boolean keyboardNavigation)
    {
        this.keyboardNavigation = keyboardNavigation;
    }

    /**
     * Gets the RTL
     *
     * @return
     */
    public Boolean getRtl()
    {
        return rtl;
    }

    /**
     * Sets the Right to left
     *
     * @param rtl
     */
    public void setRtl(Boolean rtl)
    {
        this.rtl = rtl;
    }

    /**
     * Gets in-line source
     *
     * @return
     */
    public ArrayList<JQXTreeItem> getSource()
    {
        if (source == null)
        {
            source = new ArrayList<>();
        }
        return source;
    }

    /**
     * Sets the source to a tree item list
     *
     * @param source
     */
    public void setSource(ArrayList<JQXTreeItem> source)
    {
        this.source = source;
    }

    /**
     * Gets an ajax adapter for the source
     *
     * @return
     */
    public JQXDataAdapter<JQXTreeItem> getSourceAdapter()
    {
        return sourceAdapter;
    }

    /**
     * Sets the ajax adapter for the source
     *
     * @param sourceAdapter
     */
    public void setSourceAdapter(JQXDataAdapter<JQXTreeItem> sourceAdapter)
    {
        this.sourceAdapter = sourceAdapter;
    }

    /**
     * Gets the toggle indicator size
     *
     * @return
     */
    public Integer getToggleIndicatorSize()
    {
        return toggleIndicatorSize;
    }

    /**
     * Sets the toggle indicator size
     *
     * @param toggleIndicatorSize
     */
    public void setToggleIndicatorSize(Integer toggleIndicatorSize)
    {
        this.toggleIndicatorSize = toggleIndicatorSize;
    }

    /**
     * Gets the toggle mode
     *
     * @return
     */
    public JQXTreeToggleModes getToggleMode()
    {
        return toggleMode;
    }

    /**
     * Sets the toggle mode
     *
     * @param toggleMode
     */
    public void setToggleMode(JQXTreeToggleModes toggleMode)
    {
        this.toggleMode = toggleMode;
    }

    /**
     * Runs the expand all method
     *
     * @return
     */
    public boolean isExpandAll()
    {
        return expandAll;
    }

    /**
     * Runs the expand all method
     *
     * @param expandAll
     */
    public void setExpandAll(boolean expandAll)
    {
        this.expandAll = expandAll;
    }

}
