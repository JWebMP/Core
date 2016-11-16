package za.co.mmagon.jwebswing.components.google.sourceprettify;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * Implements the Google Prettify-It JQuery class
 *
 * @since 2014/06/06
 * @author mmagon
 */
public class JQSourceCodePrettifyFeature extends Feature<JavaScriptPart, JQSourceCodePrettifyFeature> implements GlobalFeatures
{

    /**
     * Constructs a source code displayer with the given PRE tag.
     * <p>
     * @param comp
     */
    public JQSourceCodePrettifyFeature(JQSourceCodePrettify comp)
    {
        super("JWSourceCodePrettify");
        setComponent(comp);
        getJavascriptReferences().add(new JavascriptReference("JQueryPrettify", 1.0, "bower_components/google-code-prettify/src/prettify.js"));//, "https://google-code-prettify.googlecode.com/svn/loader/prettify.js"));
        getCssReferences().add(new CSSReference("JQueryPrettify", 1.0, "bower_components/google-code-prettify/src/prettify.css"));//, "https://google-code-prettify.googlecode.com/svn/loader/prettify.js"));
    }

    @Override
    public void assignFunctionsToComponent()
    {
        addQuery("prettyPrint();" + getNewLine());
    }
}
