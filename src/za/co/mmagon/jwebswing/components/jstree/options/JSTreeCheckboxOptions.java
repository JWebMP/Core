/*
 * Copyright (C) 2016 GedMarc
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
package za.co.mmagon.jwebswing.components.jstree.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * This plugin renders checkbox icons in front of each node, making multiple selection much easier.
 * <p>
 * It also supports tri-state behavior, meaning that if a node has a few of its children checked it will be rendered as undetermined,
 * <p>
 * and state will be propagated up. You can also fine tune the cascading options with the cascade config option.
 * <p>
 * <p>
 * Keep in mind when cascading checkbox will check even disabled nodes.
 * <p>
 * <p>
 * Undetermined state is automatically calculated, but if you are using AJAX and loading on demand and want to render a node as underemined pass "undetermined" : true in its state.
 *
 * @author GedMarc
 * @since 23 Dec 2016
 * @version 1.0
 *
 */
public class JSTreeCheckboxOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;
    /**
     * a boolean indicating if checkboxes should be visible (can be changed at a later time using show_checkboxes() and hide_checkboxes). Defaults to true.
     */
    private Boolean visible;
    /**
     * a boolean indicating if checkboxes should cascade down and have an undetermined state. Defaults to true.
     */
    @JsonProperty("three_state")
    private Boolean threeState;
    /**
     * a boolean indicating if clicking anywhere on the node should act as clicking on the checkbox. Defaults to true.
     */
    @JsonProperty("whole_node")
    private Boolean wholeNode;
    /**
     * a boolean indicating if the selected style of a node should be kept, or removed. Defaults to true.
     */
    @JsonProperty("keep_selected_style")
    private Boolean keepSelectedStyle;
    /**
     * This setting controls how cascading and undetermined nodes are applied.
     * <p>
     * If 'up' is in the string - cascading up is enabled, if 'down' is in the string - cascading down is enabled, if 'undetermined' is in the string - undetermined nodes will be used.
     * <p>
     * If three_state is set to true this setting is automatically set to 'up+down+undetermined'. Defaults to ''.
     */
    private Boolean cascade;
    /**
     * This setting controls if checkbox are bound to the general tree selection or to an internal array maintained by the checkbox plugin.
     * <p>
     * Defaults to true, only set to false if you know exactly what you are doing.
     */
    @JsonProperty("tie_selection")
    private Boolean tieSelection;

    public JSTreeCheckboxOptions()
    {

    }

    /**
     * a boolean indicating if checkboxes should be visible (can be changed at a later time using show_checkboxes() and hide_checkboxes). Defaults to true.
     *
     * @return
     */
    public Boolean getVisible()
    {
        return visible;
    }

    /**
     * a boolean indicating if checkboxes should be visible (can be changed at a later time using show_checkboxes() and hide_checkboxes). Defaults to true.
     *
     * @param visible
     */
    public void setVisible(Boolean visible)
    {
        this.visible = visible;
    }

    /**
     * a boolean indicating if checkboxes should cascade down and have an undetermined state. Defaults to true.
     *
     * @return
     */
    public Boolean getThreeState()
    {
        return threeState;
    }

    /**
     * a boolean indicating if checkboxes should cascade down and have an undetermined state. Defaults to true.
     *
     * @param threeState
     */
    public void setThreeState(Boolean threeState)
    {
        this.threeState = threeState;
    }

    /**
     * a boolean indicating if clicking anywhere on the node should act as clicking on the checkbox. Defaults to true.
     *
     * @return
     */
    public Boolean getWholeNode()
    {
        return wholeNode;
    }

    /**
     * a boolean indicating if clicking anywhere on the node should act as clicking on the checkbox. Defaults to true.
     *
     * @param wholeNode
     */
    public void setWholeNode(Boolean wholeNode)
    {
        this.wholeNode = wholeNode;
    }

    /**
     * a boolean indicating if the selected style of a node should be kept, or removed. Defaults to true.
     *
     * @return
     */
    public Boolean getKeepSelectedStyle()
    {
        return keepSelectedStyle;
    }

    /**
     * a boolean indicating if the selected style of a node should be kept, or removed. Defaults to true.
     *
     * @param keepSelectedStyle
     */
    public void setKeepSelectedStyle(Boolean keepSelectedStyle)
    {
        this.keepSelectedStyle = keepSelectedStyle;
    }

    /**
     * This setting controls how cascading and undetermined nodes are applied.
     * <p>
     * If 'up' is in the string - cascading up is enabled, if 'down' is in the string - cascading down is enabled, if 'undetermined' is in the string - undetermined nodes will be used.
     * <p>
     * If three_state is set to true this setting is automatically set to 'up+down+undetermined'. Defaults to ''.
     *
     * @return
     */
    public Boolean getCascade()
    {
        return cascade;
    }

    /**
     * This setting controls how cascading and undetermined nodes are applied.
     * <p>
     * If 'up' is in the string - cascading up is enabled, if 'down' is in the string - cascading down is enabled, if 'undetermined' is in the string - undetermined nodes will be used.
     * <p>
     * If three_state is set to true this setting is automatically set to 'up+down+undetermined'. Defaults to ''.
     *
     * @param cascade
     */
    public void setCascade(Boolean cascade)
    {
        this.cascade = cascade;
    }

    /**
     * This setting controls if checkbox are bound to the general tree selection or to an internal array maintained by the checkbox plugin.
     * <p>
     * Defaults to true, only set to false if you know exactly what you are doing.
     *
     * @return
     */
    public Boolean getTieSelection()
    {
        return tieSelection;
    }

    /**
     * This setting controls if checkbox are bound to the general tree selection or to an internal array maintained by the checkbox plugin.
     * <p>
     * Defaults to true, only set to false if you know exactly what you are doing.
     *
     * @param tieSelection
     */
    public void setTieSelection(Boolean tieSelection)
    {
        this.tieSelection = tieSelection;
    }

}
