package za.co.mmagon.jwebswing.components.jqdatatable;

import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.components.pools.jquerydatatables.JQDataTableReferencePool;

/**
 * Implements the jQuery DataTable plugin
 * <p>
 * @since 2014 09 30
 * @version 1.0
 * @author MMagon
 *
 * <p>
 */
public class JQDataTableFeature extends Feature<JQDataTableOptions, JQDataTableFeature> implements GlobalFeatures
{

    private static final long serialVersionUID = 1L;
    private Component comp;

    /**
     * Construct a new JW Data Table
     * <p>
     * @param component The Table to apply the Data Table features to.
     */
    public JQDataTableFeature(Component component)
    {
        super("JWDataFeature");
        addJavaScriptReference(JQDataTableReferencePool.JQueryDataTables.getJavaScriptReference());
        addJavaScriptReference(JQDataTableReferencePool.JQueryDataTablesUI.getJavaScriptReference());
        addCssReference(JQDataTableReferencePool.JQueryDataTables.getCssReference());
        addCssReference(JQDataTableReferencePool.JQueryDataTablesUI.getCssReference());
        component.addVariable(getDTID());
        this.comp = component;
    }

    public String getDTID()
    {
        return "dt_" + comp.getID();
    }

    @Override
    public void assignFunctionsToComponent()
    {
        //Set a new ID for every call to render. Cannot re-initialize a data table
        //String s = "if((" + getDTID() + " === null))" + getNewLine();
        String s = "if (typeof " + getDTID() + " === \"undefined\")" + getNewLine();
        s += "{" + getNewLine();
        s += getDTID() + " = " + comp.getJQueryID() + "DataTable(" + getOptions() + ");" + getNewLine();
        s += "}" + getNewLine();
        s += "else" + getNewLine();
        s += "{" + getNewLine();
        //s += "alert('dt variable ' + " + getDTID() + ");" + getNewLine();
        // s += getDTID() + ".dataTable('refresh');" + getNewLine();
        s += comp.getJQueryID() + "DataTable(" + getOptions() + ");" + getNewLine();
        s += getDTID() + " = " + comp.getJQueryID() + "DataTable(" + getOptions() + ");" + getNewLine();
        s += "}" + getNewLine();

        addQuery(s);
    }

    private JQDataTableOptions options;

    @Override
    public JQDataTableOptions getOptions()
    {
        if (options == null)
        {
            options = new JQDataTableOptions();
        }
        return options;
    }

}
