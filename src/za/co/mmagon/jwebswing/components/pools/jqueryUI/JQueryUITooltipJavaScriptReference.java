package za.co.mmagon.jwebswing.components.pools.jqueryUI;

import za.co.mmagon.jwebswing.base.references.JavascriptReference;

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
class JQueryUITooltipJavaScriptReference extends JavascriptReference
{

    public JQueryUITooltipJavaScriptReference()
    {
        super("JQueryUITooltip", 1.113, "bower_components/jquery-ui/jquery-ui.js", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.0/jquery-ui.js");
        setSortOrder(15);
    }

}
