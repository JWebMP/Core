package za.co.mmagon.jwebswing.htmlbuilder.css.themes;

import java.util.*;

/**
 * All the class names to work with JQuery UI Themes
 *
 * @author MMagon
 * @since 21 Jul 2013
 * @version 1.0
 */
public enum JQUI_ThemeBlockNames
{
    /**
     * Specifies the container must adopt the widget
     */
    UI_Widget,
    /**
     * Container
     */
    UI_Widget_Content,
    /**
     * Header
     */
    UI_Widget_Header,
    /**
     * Footer
     */
    UI_Widget_Footer,
    /**
     * Widget Shadow
     */
    UI_Widget_Shadow,
    /**
     * Footer
     */
    UI_Widget_Input,
    /**
     * Disabled State
     */
    UI_State_Disabled,
    /**
     * Enabled State
     */
    UI_State_Enabled,
    /**
     * Hover State
     */
    UI_State_Hover,
    /**
     * On Focus
     */
    UI_State_Focus,
    /**
     * On Blur
     */
    UI_State_Blur,
    /**
     * Active State
     */
    UI_State_Active,
    /**
     * Visited State
     */
    UI_State_Visited,
    /**
     * Link State
     */
    UI_State_Link,
    /**
     * State Default
     */
    UI_State_Default,
    /**
     * State Highlighted
     */
    UI_State_Highlight,
    /**
     * State Error
     */
    UI_State_Error,
    /**
     * Priorities
     */
    /**
     * Primary Priority
     */
    UI_Priority_Primary,
    /**
     * Secondary Priority
     */
    UI_Priority_Secondary,
    /**
     * The Layout Component Content
     */
    UI_Layout_Content,
    /**
     * The Layout Component Content
     */
    UI_Layout_North,
    /**
     * The Layout Component Content
     */
    UI_Layout_South,
    /**
     * The Layout Component Content
     */
    UI_Layout_East,
    /**
     * The Layout Component Content
     */
    UI_Layout_Center,
    /**
     * The Layout Component Content
     */
    UI_Layout_West,
    /**
     * Apply corners to all
     */
    UI_Corner_All,
    /**
     * Corners on the Top
     */
    UI_Corner_Top,
    /**
     * Corners on the left
     */
    UI_Corner_Left,
    /**
     * Corners on the right
     */
    UI_Corner_Right,
    /**
     * Corners on the bottom
     */
    UI_Corner_Bottom;

    /**
     * Enabled or Disabled States
     */
    protected static final EnumSet<JQUI_ThemeBlockNames> ThemeStates = EnumSet.of(UI_State_Enabled, UI_State_Disabled);

    /**
     * Priorities
     *
     */
    protected static final EnumSet<JQUI_ThemeBlockNames> ThemePriorities = EnumSet.of(UI_Priority_Primary, UI_Priority_Secondary);

    /**
     * Link Types
     */
    protected static final EnumSet<JQUI_ThemeBlockNames> ThemeLinks = EnumSet.of(UI_State_Active, UI_State_Hover, UI_State_Link, UI_State_Visited);

    /**
     * Theme Status (Error,Highlight,Default)
     */
    protected static final EnumSet<JQUI_ThemeBlockNames> ThemeStatus = EnumSet.of(UI_State_Error, UI_State_Highlight, UI_State_Default);

    /**
     * Layout Specific (North, East, West, South, Center, Content)
     */
    protected static final EnumSet<JQUI_ThemeBlockNames> ThemeLayout = EnumSet.of(UI_Layout_Center, UI_Layout_Content, UI_Layout_East, UI_Layout_North, UI_Layout_South, UI_Layout_West);

    /**
     * Radius Settings
     */
    protected static final EnumSet<JQUI_ThemeBlockNames> ThemeCorners = EnumSet.of(UI_Corner_All, UI_Corner_Top, UI_Corner_Left, UI_Corner_Right, UI_Corner_Bottom);

    @Override
    public String toString()
    {
        return name().toLowerCase().replace("_", "-");
    }
}
