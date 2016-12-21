package za.co.mmagon.jwebswing.components.jquerylayout.layout;

import java.util.logging.*;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.components.pools.jquerylayout.JQLayoutReferencePool;
import za.co.mmagon.jwebswing.components.pools.jqueryui.JQUIReferencePool;
import za.co.mmagon.logger.LogFactory;

/**
 * This class is essentially the Border Layout. Each child div controls it's own settings, access via getRegionLayoutDiv()
 *
 * @author MMagon
 * @since 16 Jul 2013
 * @version 1.0
 */
public class JQLayout extends Feature<JQLayoutOptions, JQLayout> implements IJQLayout
{

    private static final Logger log = LogFactory.getInstance().getLogger("JWLayout");
    private static final long serialVersionUID = 1L;

    /**
     * The variable associated with this layout
     */
    private String variableID;
    /**
     * The set of options
     */
    private JQLayoutOptions options;

    private JQLayoutDiv center;
    private JQLayoutDiv north;
    private JQLayoutDiv east;
    private JQLayoutDiv west;
    private JQLayoutDiv south;

    /**
     * Returns a clean version of this components options
     *
     * @return
     */
    public IJQLayout asMe()
    {
        return this;
    }

    /**
     * Constructs a new JWLayout Layout Handler with the given parameters
     * <p>
     * @param component The component to apply the Layout Handler To
     */
    public JQLayout(ComponentHierarchyBase component)
    {
        super("JQLayout");
        setComponent(component);
        getComponent().addFeature(this);
        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQLayoutReferencePool.JQueryLayout.getJavaScriptReference());
        getJavascriptReferences().add(JQLayoutReferencePool.JQueryLayoutResizer.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQLayoutReferencePool.JQueryLayout.getCssReference());
        setVariableID(component.getID());
        getComponent().addAttribute(GlobalAttributes.JWType, "layout");
        getCenter();
    }

    /**
     * Configures the feature
     */
    @Override
    public void preConfigure()
    {
        if (!isInitialized())
        {
            init();
        }
        if (!isConfigured())
        {
            getComponent().getPage().getOptions().setjQueryEnabled(true);
            getComponent().getPage().getOptions().setjQueryUIEnabled(true);
        }
        super.preConfigure();
    }

    /**
     * Write the layout options
     */
    @Override
    public void assignFunctionsToComponent()
    {
        StringBuilder sb = new StringBuilder("var lay_"
                + getComponent().getID()
                + " = "
                + getComponent().getJQueryID()
                + "layout(" + getNewLine());
        sb.append(getOptions());
        sb.append(");");
        addQuery(sb.toString());
    }

    /**
     * Sets the variable ID. Adds 'lay_' in front and takes all hyphens (-) into underscores (_)
     *
     * @param variableID
     */
    @Override
    public final void setVariableID(String variableID)
    {
        this.variableID = "lay_" + variableID.replace('-', '_');
        getComponent().addVariable(this.variableID);
    }

    /**
     * Returns the variable ID
     *
     * @return
     */
    @Override
    public String getVariableID()
    {
        return variableID;
    }

    /**
     * Returns the layout options
     * <p>
     * @return
     */
    @Override
    public JQLayoutOptions getOptions()
    {
        if (options == null)
        {
            options = new JQLayoutOptions();
        }

        return options;
    }

    /**
     * Returns the center pane
     *
     * @return A Layout pane on the center div
     */
    @Override
    public JQLayoutDiv getCenter()
    {
        if (this.center == null)
        {
            setCenter(new JQLayoutDiv(this, JQLayoutArea.Center, new Div()));
        }
        return this.center;
    }

    /**
     * Sets the center pane
     *
     * @param centerDiv The new center panel
     */
    @Override
    public void setCenter(JQLayoutDiv centerDiv)
    {
        getComponent().remove(this.center);
        this.center = centerDiv;
        if (this.center != null)
        {
            getComponent().add(this.center);
        }
    }

    /**
     * Returns the center pane
     *
     * @return A Layout pane on the center div
     */
    @Override
    public JQLayoutDiv getNorth()
    {
        if (this.north == null)
        {
            setNorth(new JQLayoutDiv(this, JQLayoutArea.North, new Div()));
        }
        return this.north;
    }

    /**
     * Sets the north pane
     *
     * @param centerDiv The new center panel
     */
    @Override
    public void setNorth(JQLayoutDiv centerDiv)
    {
        getComponent().remove(this.north);
        this.north = centerDiv;
        if (this.north != null)
        {
            getComponent().add(this.north);
        }
    }

    /**
     * Returns the south pane
     *
     * @return A Layout pane on the center div
     */
    @Override
    public JQLayoutDiv getSouth()
    {
        if (this.south == null)
        {
            setSouth(new JQLayoutDiv(this, JQLayoutArea.South, new Div()));
        }
        return this.south;
    }

    /**
     * Sets the south pane
     *
     * @param southDiv The new center panel
     */
    @Override
    public void setSouth(JQLayoutDiv southDiv)
    {
        getComponent().remove(this.south);
        this.south = southDiv;
        if (this.south != null)
        {
            getComponent().add(this.south);
        }
    }

    /**
     * Returns the center pane
     *
     * @return A Layout pane on the center div
     */
    @Override
    public JQLayoutDiv getWest()
    {
        if (this.west == null)
        {
            setWest(new JQLayoutDiv(this, JQLayoutArea.West, new Div()));
        }
        return this.west;
    }

    /**
     * Sets the center pane
     *
     * @param westDiv The new center panel
     */
    @Override
    public void setWest(JQLayoutDiv westDiv)
    {
        getComponent().remove(this.west);
        this.west = westDiv;
        if (this.west != null)
        {
            getComponent().add(this.west);
        }
    }

    /**
     * Returns the center pane
     *
     * @return A Layout pane on the center div
     */
    @Override
    public JQLayoutDiv getEast()
    {
        if (this.east == null)
        {
            setEast(new JQLayoutDiv(this, JQLayoutArea.East, new Div()));
        }
        return this.east;
    }

    /**
     * Sets the center pane
     *
     * @param eastDiv The new center panel
     */
    @Override
    public void setEast(JQLayoutDiv eastDiv)
    {
        getComponent().remove(this.east);
        this.east = eastDiv;
        if (this.east != null)
        {
            getComponent().add(this.east);
        }
    }
}
