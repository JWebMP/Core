package za.co.mmagon.jwebswing.components.jqueryui.tabs;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.base.html.Link;
import za.co.mmagon.jwebswing.base.html.ListItem;
import za.co.mmagon.jwebswing.components.jqueryui.themes.JQUIThemeBlocks;

/**
 * A specific tab for the JWAccordion
 * <p>
 * @author MMagon
 * @since 29 Mar 2013
 * @version 1.0
 */
public class Tab
{

    /**
     * The header for a tab
     */
    private ListItem tabHeader;
    /**
     * The child component for a tab
     */
    private JQUITabsChildren tabDisplayComponent;

    /**
     * Any tab to be displayed
     *
     * @param tabHeader
     * @param tabDisplayComponent
     */
    public Tab(ListItem tabHeader, JQUITabsChildren tabDisplayComponent)
    {
        if (tabDisplayComponent != null)
        {
            Link tabLink = new Link("#" + Component.class.cast(tabDisplayComponent).getID(), null, tabHeader.getText(0).toString());
            tabHeader.add(tabLink);
        }
        this.tabHeader = tabHeader;
        this.tabDisplayComponent = tabDisplayComponent;
        Component.class.cast(tabDisplayComponent).addClass(JQUIThemeBlocks.UI_Widget_Content);
    }

    /**
     * Returns the tab header
     *
     * @return
     */
    public ListItem getTabHeader()
    {
        return tabHeader;
    }

    /**
     * Sets the tab header
     *
     * @param tabHeader
     */
    public void setTabHeader(ListItem tabHeader)
    {
        this.tabHeader = tabHeader;
    }

    /**
     * Returns the children of the tab
     *
     * @return
     */
    public JQUITabsChildren getTabDisplayComponent()
    {
        return tabDisplayComponent;
    }

    /**
     * Sets the children of the display
     *
     * @param tabDisplayComponent
     */
    public void setTabDisplayComponent(JQUITabsChildren tabDisplayComponent)
    {
        this.tabDisplayComponent = tabDisplayComponent;
    }
}
