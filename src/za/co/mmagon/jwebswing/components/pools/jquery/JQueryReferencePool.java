package za.co.mmagon.jwebswing.components.pools.jquery;

import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.enumarations.RequirementsPriority;

/**
 *
 * @since @version @author MMagon
 *
 *
 */
public enum JQueryReferencePool
{

    JQuery(new JQueryReference()),
    JQueryV2(new JQueryReferenceV2()),
    JQueryV3(new JavascriptReference("Jquery3", 3.1, "bower_components/jquery-3/dist/jquery.js", "https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.js", 0,RequirementsPriority.First)),
    AjaxEnabler(new JQueryAjaxEnablerReference()),
    JQueryAtmospherePush(new AtmosphereReference()),
    JQueryMigrate(new JQueryMigrateReference()),
    JQXWidgetFixes(new JavascriptReference("JQXWidgetFix", 1.0, "javascript/jwebswing/jqxfixes.js", 8));

    /*
     * JQueryCrossDomain(new JQueryCrossDomainReference()),
     * JQueryMigrate(new JQueryMigrateReference()),
     * JQueryCookieHandler(new JQueryCookieHandlerReference()),
     *
     * JQueryRightClickHandler(new JQueryRightClickHandlerReference()),
     * JQueryScrollBars(new JWDataTablesJavaScriptReference()),
     *
     */
    ;

    private JQueryReferencePool(JavascriptReference reference)
    {
        this.reference = reference;
    }

    private final JavascriptReference reference;

    public JavascriptReference getJavaScriptReference()
    {
        return reference;
    }

}
