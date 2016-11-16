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
public class JQueryReferenceV2 extends JavascriptReference
{

    private static final long serialVersionUID = 1L;

    public JQueryReferenceV2()
    {
        super("JQuery", 2.24, "bower_components/jquery/dist/jquery.js", "https://code.jquery.com/jquery-2.2.4.js");
        setSortOrder(0);
        setPriority(RequirementsPriority.Second);
    }
}
