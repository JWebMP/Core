package za.co.mmagon.jwebswing.components.jquerylayout.layout;

import java.util.*;
import org.apache.log4j.*;
import za.co.mmagon.*;
import za.co.mmagon.jwebswing.*;
import za.co.mmagon.jwebswing.base.*;
import za.co.mmagon.jwebswing.base.exceptions.*;
import za.co.mmagon.jwebswing.base.html.attributes.*;
import za.co.mmagon.jwebswing.components.pools.jquerylayout.*;
import za.co.mmagon.jwebswing.components.pools.jqueryui.*;

/**
 * This class is essentially the Border Layout. Each child div controls it's own settings, access via getRegionLayoutDiv()
 *
 * @author MMagon
 * @since 16 Jul 2013
 * @version 1.0
 */
public class JQLayout extends Feature<JQLayoutOptions, JQLayout> implements IJQLayout
{

    private static final Logger log = LoggerFactory.getInstance().makeNewLoggerInstance("JWLayout");
    private static final long serialVersionUID = 1L;

    /**
     * All the currently loaded panes
     */
    private HashMap<JQLayoutArea, JQLayoutDiv> panes;
    /**
     * The variable associated with this layout
     */
    private String variableID;
    /**
     * The set of options
     */
    private JQLayoutOptions options;

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
        this.component = component;
        this.component.addFeature(this);
        if (component == null)
        {
            throw new NullComponentException("Cannot use a null object inside of a layout feature");
        }

        getJavascriptReferences().add(JQUIReferencePool.Core.getJavaScriptReference());
        getJavascriptReferences().add(JQLayoutReferencePool.JQueryLayout.getJavaScriptReference());
        getJavascriptReferences().add(JQLayoutReferencePool.JQueryLayoutResizer.getJavaScriptReference());
        getCssReferences().add(JQUIReferencePool.Core.getCssReference());
        getCssReferences().add(JQLayoutReferencePool.JQueryLayout.getCssReference());
        setVariableID(component.getID());
        getComponent().addAttribute(GlobalAttributes.JWType, "layout");
    }

    @Override
    public void init()
    {
        if (!isInitialized())
        {
            getPanes().entrySet().stream().map((entry) ->
            {
                JQLayoutArea key = entry.getKey();
                return entry;
            }).map((entry) -> entry.getValue()).map((value) ->
            {
                value.init();
                return value;
            }).forEachOrdered((value) ->
            {
                getComponent().add(value);
            });
        }

        super.init();
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
            getComponent().getPage().setjQueryEnabled(true);
            getComponent().getPage().setjQueryUIEnabled(true);
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
        if (getPane(JQLayoutArea.Center) == null)
        {
            getPanes().put(JQLayoutArea.Center, new JQLayoutDiv(this, JQLayoutArea.Center, null));
        }
        return getPanes().get(JQLayoutArea.Center);
    }

    /**
     * Sets the center pane
     *
     * @param centerDiv The new center panel
     */
    @Override
    public void setCenter(JQLayoutDiv centerDiv)
    {
        getPanes().put(JQLayoutArea.Center, centerDiv);
    }

    /**
     * Returns the center pane
     *
     * @return A Layout pane on the center div
     */
    @Override
    public JQLayoutDiv getNorth()
    {
        if (getPane(JQLayoutArea.North) == null)
        {
            getPanes().put(JQLayoutArea.North, new JQLayoutDiv(this, JQLayoutArea.North, null));
        }
        return getPanes().get(JQLayoutArea.North);
    }

    /**
     * Sets the north pane
     *
     * @param centerDiv The new center panel
     */
    @Override
    public void setNorth(JQLayoutDiv centerDiv)
    {
        getPanes().put(JQLayoutArea.North, centerDiv);
    }

    /**
     * Returns the south pane
     *
     * @return A Layout pane on the center div
     */
    @Override
    public JQLayoutDiv getSouth()
    {
        if (getPane(JQLayoutArea.South) == null)
        {
            getPanes().put(JQLayoutArea.South, new JQLayoutDiv(this, JQLayoutArea.South, null));
        }

        return getPanes().get(JQLayoutArea.South);
    }

    /**
     * Sets the south pane
     *
     * @param southDiv The new center panel
     */
    @Override
    public void setSouth(JQLayoutDiv southDiv)
    {
        getPanes().put(JQLayoutArea.Center, southDiv);
    }

    /**
     * Returns the center pane
     *
     * @return A Layout pane on the center div
     */
    @Override
    public JQLayoutDiv getWest()
    {
        if (getPane(JQLayoutArea.West) == null)
        {
            getPanes().put(JQLayoutArea.West, new JQLayoutDiv(this, JQLayoutArea.West, null));
        }

        return getPanes().get(JQLayoutArea.West);
    }

    /**
     * Sets the center pane
     *
     * @param westDiv The new center panel
     */
    @Override
    public void setWest(JQLayoutDiv westDiv)
    {
        getPanes().put(JQLayoutArea.West, westDiv);
    }

    /**
     * Returns the center pane
     *
     * @return A Layout pane on the center div
     */
    @Override
    public JQLayoutDiv getEast()
    {
        if (getPane(JQLayoutArea.East) == null)
        {
            getPanes().put(JQLayoutArea.East, new JQLayoutDiv(this, JQLayoutArea.East, null));
        }

        return getPanes().get(JQLayoutArea.East);
    }

    /**
     * Sets the center pane
     *
     * @param eastDiv The new center panel
     */
    @Override
    public void setEast(JQLayoutDiv eastDiv)
    {
        getPanes().put(JQLayoutArea.East, eastDiv);
    }

    /**
     * Returns all the layouts panes
     *
     * @return
     */
    public HashMap<JQLayoutArea, JQLayoutDiv> getPanes()
    {
        if (panes == null)
        {
            panes = new HashMap<>();
        }
        return panes;
    }

    /**
     * Sets all the layout panes
     *
     * @param panes
     */
    public void setPanes(HashMap<JQLayoutArea, JQLayoutDiv> panes)
    {
        this.panes = panes;
    }

    /**
     * Returns the Layout Div for the pane
     *
     * @param paneArea
     *
     * @return
     */
    public JQLayoutDiv getPane(JQLayoutArea paneArea)
    {
        return getPanes().get(paneArea);
    }
}
