package za.co.mmagon.jwebswing.components.jquerylayout.layout;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.log4j.Logger;
import za.co.mmagon.LoggerFactory;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.components.pools.jqueryui.JQUIReferencePool;
import za.co.mmagon.jwebswing.components.pools.jquerylayout.JQLayoutReferencePool;

/**
 * This class builds the JQuery needed for the Layout component
 *
 * @author MMagon
 * @since 2013/07/16
 */
public class JQLayoutFeature extends Feature<JQLayoutOptions, JQLayoutFeature>
{

    private static final Logger log = LoggerFactory.getInstance().makeNewLoggerInstance("JWLayout Feature");
    private static final long serialVersionUID = 1L;
    private String layoutID;
    private String variableID;
    @JsonIgnore
    private final JQLayout myComponent;
    private final JQLayoutOptions options = new JQLayoutOptions();

    public JQLayoutFeature(JQLayout onComponent)
    {
        super("BorderLayoutFeature");
        myComponent = onComponent;
        setComponent(myComponent.getComponent());
        setVariableID(myComponent.getComponent());
        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Widget.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Mouse.getJavaScriptReference());
        getJavascriptReferences().add(JQUIReferencePool.Resizable.getJavaScriptReference());
        getJavascriptReferences().add(JQLayoutReferencePool.JQueryLayout.getJavaScriptReference());
        getJavascriptReferences().add(JQLayoutReferencePool.JQueryLayoutResizer.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQUIReferencePool.Widget.getCssReference());
        getCssReferences().add(JQLayoutReferencePool.JQueryLayout.getCssReference());
    }

    @Override
    public void assignFunctionsToComponent()
    {
        //Config for the layout options from the divs
        StringBuilder sb = new StringBuilder(variableID + " = $('#" + this.layoutID + "').layout(" + getNewLine());
        sb.append(getOptions());
        sb.append(");");
        addQuery(sb.toString());
        //addQuery("resizeLayouts();" + getNewLine());
    }

    /**
     * Returns the JavaScript variable ID associated with the layout
     *
     * @return The JavaScript variable ID
     */
    public String getVariableID()
    {
        return variableID;
    }

    /**
     * Component to apply the layout to
     *
     * @param layoutID
     */
    public void setLayoutID(ComponentHierarchyBase layoutID)
    {
        setComponent(layoutID);
        this.layoutID = layoutID.getID() == null ? "null" : layoutID.getID();
    }

    /**
     * Component to apply for. Sets the layout ID as well
     *
     * @param layoutComponent
     */
    public final void setVariableID(ComponentHierarchyBase layoutComponent)
    {
        layoutComponent.removeVariable(variableID);
        setLayoutID(layoutComponent);
        setComponent(layoutComponent);
        variableID = "lay_" + getLayoutID().replace('-', '_');
        layoutComponent.addVariable(variableID);
    }

    public void setVariableID(String componentID)
    {
        variableID = "lay_" + componentID.replace('-', '_');
        this.layoutID = componentID;

        setVariableID(getComponent());
    }

    public String getLayoutID()
    {
        return layoutID;
    }

    /**
     * Returns the layout options
     * <p>
     * @return
     */
    @Override
    public JQLayoutOptions getOptions()
    {
        return this.options;
    }
}
