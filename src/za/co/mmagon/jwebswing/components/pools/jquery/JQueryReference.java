package za.co.mmagon.jwebswing.components.pools.jquery;

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
public class JQueryReference extends JavascriptReference
{

    private static final long serialVersionUID = 1L;

    public JQueryReference()
    {
        super("JQuery", 3.0, "bower_components/jquery/dist/jquery.js", "https://code.jquery.com/jquery-3.0.0.js");
        setSortOrder(0);
        setPriority(RequirementsPriority.Second);
    }
}
