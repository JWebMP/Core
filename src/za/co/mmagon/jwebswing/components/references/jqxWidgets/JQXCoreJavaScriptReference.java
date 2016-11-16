package za.co.mmagon.jwebswing.components.references.jqxWidgets;

import za.co.mmagon.jwebswing.base.references.JavascriptReference;

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
public class JQXCoreJavaScriptReference extends JavascriptReference
{

    public JQXCoreJavaScriptReference()
    {
        super("JQXCore", 3.91, "bower_components/jqwidgets/jqwidgets/jqxcore.js", "https://jqwidgets.com/public/jqwidgets/jqxcore.js");
        setSortOrder(10);
    }

}
