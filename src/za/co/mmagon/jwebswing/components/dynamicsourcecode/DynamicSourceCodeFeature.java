package za.co.mmagon.jwebswing.components.dynamicsourcecode;

import za.co.mmagon.jwebswing.*;
import za.co.mmagon.jwebswing.base.html.interfaces.*;
import za.co.mmagon.jwebswing.components.google.sourceprettify.*;

/**
 * Adds the dynamic source code JavaScript through
 *
 * @author MMagon
 * @since 2013/01/16
 * @version 1.0
 */
public class DynamicSourceCodeFeature extends Feature<DynamicSourceCodeOptions, DynamicSourceCodeFeature>
        implements GlobalFeatures
{

    private static final long serialVersionUID = 1L;

    private DynamicSourceCodeOptions options;

    /**
     * Constructs a new Feature for the Dynamic Source Code Component.
     * <p>
     * @param forComponent
     */
    public DynamicSourceCodeFeature(Component forComponent)
    {
        super("JWDynamicSourceCode");
        setComponent(forComponent);
        getJavascriptReferences().add(DynamicSourceCodeReferencePool.DynamicSourceCodeJavascript.getJavaScriptReference());
    }

    /**
     * Returns all the source code options options
     * <p>
     * @return
     */
    @Override
    public DynamicSourceCodeOptions getOptions()
    {
        if (options == null)
        {
            options = new DynamicSourceCodeOptions();
        }
        return options;
    }

    @Override
    public void preConfigure()
    {
        if (!isConfigured())
        {
            getComponent().getPage().getOptions().setjQueryEnabled(true);
        }
        super.preConfigure();
    }

    @Override
    public void assignFunctionsToComponent()
    {
        DynamicSourceCode source = (DynamicSourceCode) getComponent();
        //System.out.println("Feature Assign - " + isInitialized() + " - " + source.isInitialized());
        addQuery("$('" + source.getID(true) + "').dynamicSourceCode(" + getOptions().toString() + ");" + getNewLine());

        source.getSourceChanges().entrySet().stream().map((entry) ->
        {
            Component key = entry.getKey();
            Class value = entry.getValue();

            return key;
        }).forEachOrdered((key) ->
        {
            addQuery("$('" + source.getID(true) + "').dynamicSourceCodeAddChanger('" + key.getID() + "','click');" + getNewLine());
        });

        source.getThemeChanges().entrySet().stream().map((entry) ->
        {
            Component key = entry.getKey();
            SourceCodePrettifyThemes value = entry.getValue();

            return key;
        }).forEachOrdered((key) ->
        {
            addQuery("$('" + source.getID(true) + "').dynamicSourceCodeAddThemeChanger('" + key.getID() + "');" + getNewLine());
        });
    }
}
