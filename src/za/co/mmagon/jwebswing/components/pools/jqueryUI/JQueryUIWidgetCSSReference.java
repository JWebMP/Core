package za.co.mmagon.jwebswing.components.pools.jqueryUI;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;

/**
 * The JQuery JavaScript Reference
 *
 * @since 2014/12/09
 * @version 1.0
 * @author MMagon
 *
 * I have moved these from the features to make it easier to specify remote or local references.
 *
 */
class JQueryUIWidgetCSSReference extends CSSReference
{

    public JQueryUIWidgetCSSReference()
    {
        super("JQueryUIWidgetCSS", 1.112, "bower_components/jquery-ui/themes/base/theme.css", "https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.css");
        setSortOrder(11);
        setPriority(RequirementsPriority.Third);
    }
}
