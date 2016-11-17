package za.co.mmagon.jwebswing.components.jqueryui.tabs;

import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.List;
import za.co.mmagon.jwebswing.base.html.ListItem;
import za.co.mmagon.jwebswing.base.html.attributes.NoAttributes;

/**
 * This class implements the JQuery UI implementation of a normal button
 *
 * @author MMagon
 * @since 09 Mar 2013
 * @version 1.0
 */
public class JQUITab extends Div<JQUITabsChildren, NoAttributes, JQUITabsFeatures, JQUITabsEvents, JQUITab>
{

    private static final long serialVersionUID = 1L;
    /**
     * the feature list
     */
    private JQUITabsFeature feature;

    /**
     * The Unordered List
     */
    private List unorderedList;

    public JQUITab()
    {
        super();
        addFeature(getFeature());
        add(getUnorderedList());
    }

    /**
     * Returns the feature for the JQUITab object
     * <p>
     * @return
     */
    public final JQUITabsFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQUITabsFeature(this);
        }
        return feature;
    }

    /**
     * Adds a tab to the collection
     * <p>
     * @param tab
     */
    public Tab addTab(Tab tab)
    {
        getUnorderedList().add(tab.getTabHeader());
        add(JQUITabsChildren.class.cast(tab.getTabDisplayComponent()));
        return tab;
    }

    public Tab addTab(String title, JQUITabsChildren displayComponent)
    {
        return addTab(new Tab(new ListItem(title), (JQUITabsChildren) displayComponent));
    }

    /**
     * Retrieves this unordered list
     *
     * @return
     */
    public List getUnorderedList()
    {
        if (unorderedList == null)
        {
            unorderedList = new List();
        }
        return unorderedList;
    }

    /**
     * Sets the unordered list
     *
     * @param unorderedList
     */
    public void setUnorderedList(List unorderedList)
    {
        this.unorderedList = unorderedList;
    }

    /**
     * Returns the options fields for the tab
     * <p>
     * @return
     */
    @Override
    public JQUITabOptions getOptions()
    {
        return feature.getOptions();
    }
}
