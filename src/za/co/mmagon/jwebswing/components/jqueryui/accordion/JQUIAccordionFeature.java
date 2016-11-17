package za.co.mmagon.jwebswing.components.jqueryui.accordion;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.components.pools.jqueryui.JQUIReferencePool;

/**
 *
 * @author MMagon
 */
public class JQUIAccordionFeature extends Feature<JQUIAccordionOptions, JQUIAccordionFeature> implements JQUIAccordionFeatures
{

    private static final long serialVersionUID = 1L;

    private final JQUIAccordion accordion;

    /**
     * The options for the accordion
     */
    private JQUIAccordionOptions options;

    public JQUIAccordionFeature(JQUIAccordion accordion)
    {
        super("JWAccordianFeature");
        this.accordion = accordion;
        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Widget.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQUIReferencePool.Widget.getCssReference());

        getJavascriptReferences().add(JQUIReferencePool.Accordion.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Accordion.getCssReference());
    }

    @Override
    public void assignFunctionsToComponent()
    {
        String additionalString = accordion.getJQueryID() + "accordion(" + getOptions() + ");" + getNewLine();
        addQuery(additionalString);
    }

    /**
     * Never null
     * <p>
     * @return
     */
    @Override
    public final JQUIAccordionOptions getOptions()
    {
        if (options == null)
        {
            options = new JQUIAccordionOptions();
        }
        return options;
    }
}
