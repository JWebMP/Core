package za.co.mmagon.jwebswing.components.pools.jqueryUI;

import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;

/**
 * The JQuery JavaScript Reference
 * <p>
 * @since 2014/12/09
 * @version 1.0
 * @author MMagon
 *
 * I have moved these from the features to make it easier to specify remote or local references.
 * <p>
 */
class JQueryUIMouseJavaScriptReference extends JavascriptReference
{

    private static final long serialVersionUID = 1L;

    public JQueryUIMouseJavaScriptReference()
    {
        super("JQueryUIMouse", 1.113, "bower_components/jquery-ui/jquery-ui.js", "https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.0/jquery-ui.js");//mouse.js");
        setSortOrder(12);
        setPriority(RequirementsPriority.Fourth);
    }

}
