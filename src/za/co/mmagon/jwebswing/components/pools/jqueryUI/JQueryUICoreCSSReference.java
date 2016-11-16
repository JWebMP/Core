package za.co.mmagon.jwebswing.components.pools.jqueryUI;

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;

/**
 *
 * @since
 * @version
 * @author MMagon
 *
 *
 */
class JQueryUICoreCSSReference extends CSSReference
{

    public JQueryUICoreCSSReference()
    {
        super("JQueryUICore", 1.114, "bower_components/jquery-ui/themes/base/core.css", "https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.11.4/jquery-ui.css");
        setSortOrder(10);
        setPriority(RequirementsPriority.Third);
    }

}
