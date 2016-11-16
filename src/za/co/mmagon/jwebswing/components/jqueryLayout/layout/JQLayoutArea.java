package za.co.mmagon.jwebswing.components.jqueryLayout.layout;

import za.co.mmagon.jwebswing.components.jqueryUI.themes.JQUIThemeBlocks;

/**
 * All the panes of a border layout
 *
 * @author MMagon
 * @since 16 Jul 2013
 * @version 1.0
 */
public enum JQLayoutArea
{
    /**
     * The bottom pane
     * Known issue with IOS 5 and a floating pane. Global issue, blame IOS
     */
    South(JQUIThemeBlocks.UI_Layout_South),
    /**
     * The north pane
     */
    North(JQUIThemeBlocks.UI_Layout_North),
    /**
     * The east pane
     */
    East(JQUIThemeBlocks.UI_Layout_East),
    /**
     * The west pane
     */
    West(JQUIThemeBlocks.UI_Layout_West),
    /**
     * The center pane
     */
    Center(JQUIThemeBlocks.UI_Layout_Center);

    /**
     * The area class
     */
    private JQUIThemeBlocks areaClass;

    /**
     * Constructs a new Layout Area
     *
     * @param areaClass
     */
    private JQLayoutArea(JQUIThemeBlocks areaClass)
    {
        this.areaClass = areaClass;
    }

    /**
     * Sets the class
     *
     * @param areaClass
     */
    public void setAreaClass(JQUIThemeBlocks areaClass)
    {
        this.areaClass = areaClass;
    }

    /**
     * Returns the actual class for the div
     *
     * @return
     */
    public JQUIThemeBlocks getAreaClass()
    {
        return areaClass;
    }

    /**
     * The north lowercase
     *
     * @return
     */
    @Override
    public String toString()
    {
        return name().toString().toLowerCase();
    }
}
