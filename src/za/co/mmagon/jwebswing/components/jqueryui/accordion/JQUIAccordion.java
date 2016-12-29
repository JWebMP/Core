package za.co.mmagon.jwebswing.components.jqueryui.accordion;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.HeaderText;
import za.co.mmagon.jwebswing.base.html.attributes.*;

/**
 * Displays collapsible content panels for presenting information in a limited amount of space.
 * https://jqueryui.com/accordion/
 * <p>
 * <p>
 * <p>
 * Click headers to expand/collapse content that is broken into logical sections, much like tabs. Optionally, toggle sections open/closed on mouseover.
 * <p>
 * The underlying HTML markup is a series of headers (H3 tags) and content divs so the content is usable without JavaScript.
 *
 *
 * @author Marc Magon
 * @since 2013/01/15
 */
public class JQUIAccordion extends Div<JQUIAccordionChildren, NoAttributes, JQUIAccordionFeatures, JQUIAccordionEvents, JQUIAccordion> 
        implements JQUIAccordionChildren
{

    private static final long serialVersionUID = 1L;

    private ArrayList<JQUIAccordionTab> accordionTabs;

    private JQUIAccordionFeature feature;

    /**
     * Constructs a new accordion object
     */
    public JQUIAccordion()
    {
        this(null);
        this.accordionTabs = new ArrayList();
    }

    /**
     * Constructs a new accordion with the given height style as a default set option
     * <p>
     * @param heightStyle
     */
    public JQUIAccordion(JQUIAccordionHeightStyle heightStyle)
    {
        this.accordionTabs = new ArrayList();
        addFeature(feature = new JQUIAccordionFeature(this));
        getOptions().setHeightStyle(heightStyle);
        addAttribute(GlobalAttributes.JWType, "accordion");
    }

    /**
     * Never null
     * <p>
     * @return
     */
    @Override
    public final JQUIAccordionOptions getOptions()
    {
        return getFeature().getOptions();
    }

    /**
     * Returns the feature associated with this accordion
     *
     * @return
     */
    public JQUIAccordionFeature getFeature()
    {
        if (feature == null)
        {
            feature = new JQUIAccordionFeature(this);
        }
        return feature;
    }

    /**
     * Sets the feature for this accordion
     *
     * @param feature
     */
    public void setFeature(JQUIAccordionFeature feature)
    {

        this.feature = feature;
    }

    /**
     * Returns this collection of accordion tabs
     *
     * @return
     */
    public ArrayList<JQUIAccordionTab> getAccordionTabs()
    {
        if (accordionTabs == null)
        {
            accordionTabs = new ArrayList<>();
        }
        return accordionTabs;
    }

    /**
     * Sets the collection of accordion tabs
     * <p>
     * @param accordianTabs
     */
    public void setAccordionTabs(ArrayList<JQUIAccordionTab> accordianTabs)
    {
        this.accordionTabs = accordianTabs;
    }

    /**
     * Adds a new accordion tab
     * <p>
     * @param tabName     The name of the accordion
     * @param tabContents The content of the accordion
     * @return The accordion tab
     */
    public JQUIAccordionTab addAccordianTab(HeaderText tabName, Div tabContents)
    {
        JQUIAccordionTab accTab = new JQUIAccordionTab(tabName, tabContents);
        addAccordianTab(accTab);
        return accTab;
    }

    /**
     * Adds a new accordion tab
     * <p>
     * @param tabName     The name of the accordion
     * @param tabContents The content of the accordion
     * @return The accordion tab
     */
    public JQUIAccordionTab addAccordianTab(String tabName, Div tabContents)
    {
        HeaderText header;
        if (getOptions().getHeader() == null)
        {
            header = new HeaderText(HeaderTypes.H3, tabName);
        }
        else
        {
            header = new HeaderText(getOptions().getHeader(), tabName);
        }

        return addAccordianTab(header, tabContents);
    }

    /**
     * Adds a physical accordion tab
     * <p>
     * @param accordianTab The accordion tab to add to this accordion
     * @return
     */
    public JQUIAccordionTab addAccordianTab(JQUIAccordionTab accordianTab)
    {
        accordionTabs.add(accordianTab);
        add(accordianTab.getHeader());
        add(accordianTab.getComponent());
        return accordianTab;
    }
}
