/*
 * Copyright (C) 2017 GedMarc
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

import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * You can set the state on a node using the state property.
 * <p>
 * Use any combination of the following: opened, selected, disabled.
 *
 * @author GedMarc
 * @since 02 Jan 2017
 * @version 1.0
 *
 */
public class JSTreeNodeStateOptions extends JavaScriptPart
{

    private static final long serialVersionUID = 1L;

    /**
     * is the node open
     */
    private Boolean opened;
    /**
     * is the node disabled
     */
    private Boolean disabled;
    /**
     * is the node selected
     */
    private Boolean selected;

    public JSTreeNodeStateOptions()
    {

    }

    /**
     * is the node open
     *
     * @return
     */
    public Boolean isOpened()
    {
        return opened;
    }

    /**
     * is the node open
     *
     * @param opened
     *
     * @return
     */
    public JSTreeNodeStateOptions setOpened(Boolean opened)
    {
        this.opened = opened;
        return this;
    }

    /**
     * is the node disabled
     *
     * @return
     */
    public Boolean isDisabled()
    {
        return disabled;
    }

    /**
     * is the node disabled
     *
     * @param disabled
     *
     * @return
     */
    public JSTreeNodeStateOptions setDisabled(Boolean disabled)
    {
        this.disabled = disabled;
        return this;
    }

    /**
     * is the node selected
     *
     * @return
     */
    public Boolean isSelected()
    {
        return selected;
    }

    /**
     * is the node selected
     *
     * @param selected
     *
     * @return
     */
    public JSTreeNodeStateOptions setSelected(Boolean selected)
    {
        this.selected = selected;
        return this;
    }

}
