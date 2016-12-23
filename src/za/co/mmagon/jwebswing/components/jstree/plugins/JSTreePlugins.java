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
package za.co.mmagon.jwebswing.components.jstree.plugins;

/**
 * jsTree has some functionality moved out of the core so you can only use it when you need it.
 * <p>
 * To enable a plugin use the plugins config option and add that plugin's name to the array.
 * <p>
 * For example enabling all the plugins can be done this way: (enable only plugins you need)
 *
 * @author GedMarc
 * @since 22 Dec 2016
 * @version 1.0
 *
 */
public enum JSTreePlugins
{
    /**
     * This plugin renders checkbox icons in front of each node, making multiple selection much easier.
     * <p>
     * It also supports tri-state behavior, meaning that if a node has a few of its children checked it will be rendered as undetermined,
     * <p>
     * and state will be propagated up. You can also fine tune the cascading options with the cascade config option.
     * <p>
     * Keep in mind when cascading checkbox will check even disabled nodes.
     * <p>
     * <p>
     * Undetermined state is automatically calculated, but if you are using AJAX and loading on demand and want to render a node as underemined pass "undetermined" : true in its state.
     */
    Checkbox,
    /**
     * This plugin makes it possible to right click nodes and shows a list of configurable actions in a menu.
     * <p>
     * You can find all the contextmenu plugin config options in the API.
     */
    ContextMenu,
    /**
     * Drag & drop plugin
     * <p>
     * This plugin makes it possible to drag and drop tree nodes and rearrange the tree.
     * <p>
     * You can find all the dnd plugin config options in the API.
     */
    DnD,
    /**
     * This plugin makes it possible to load nodes in a single request (used with lazy loading).
     * <p>
     * You can find all the massload plugin config options in the API.
     */
    Massload,
    /**
     * This plugin adds the possibility to search for items in the tree and even to show only matching nodes.
     */
    Search,
    /**
     * This plugin automatically arranges all sibling nodes according to a comparison config option function, which defaults to alphabetical order.
     */
    Sort,
    /**
     * This plugin saves all opened and selected nodes in the user's browser, so when returning to the same tree the previous state will be restored.
     * <p>
     * You can find all the state plugin config options in the API. Make a selection and refresh this page to see the change persisted.
     */
    State,
    /**
     * This plugin makes it possible to add predefined types for groups of nodes, which means to easily control nesting rules and icon for each group.
     * <p>
     * To set a node's type you can use set_type or supply a type property with the node's data.
     * <p>
     * <p>
     */
    Types,
    /**
     * Enforces that no nodes with the same name can coexist as siblings. This plugin has no options, it just prevents renaming and moving nodes to a parent, which already contains a node with the
     * same name.
     */
    Unique,
    /**
     * Makes each node appear block level which makes selection easier. May cause slow down for large trees in old browsers.
     */
    WholeRow,
    /**
     * This plugin adds additional information about selection changes.
     * <p>
     * Once included in the plugins config option, each changed.jstree event data will contain a new property named changed,
     * <p>
     * which will give information about selected and deselected nodes since the last changed.jstree event
     */
    Changed,
    /**
     * This plugin overrides the activate_node function (the one that gets called when a user tries to select a node) and enables preventing the function invokation by using a callback.
     */
    ConditionalSelect;

    @Override
    public String toString()
    {
        return name().toLowerCase();
    }
}
