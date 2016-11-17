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

    private ListItem tabHeader;
    private JQUITabsChildren tabDisplayComponent;

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

    public ListItem getTabHeader()
    {
        return tabHeader;
    }

    public void setTabHeader(ListItem tabHeader)
    {
        this.tabHeader = tabHeader;
    }

    public JQUITabsChildren getTabDisplayComponent()
    {
        return tabDisplayComponent;
    }

    public void setTabDisplayComponent(JQUITabsChildren tabDisplayComponent)
    {
        this.tabDisplayComponent = tabDisplayComponent;
    }
}
