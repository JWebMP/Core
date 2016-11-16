package za.co.mmagon.jwebswing.htmlbuilder.javascript.jquery;

import java.util.ArrayList;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.ComponentFeatureBase;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * This class implements an ordered hierarchy of JQueries. This is useful is
 * doing calls asynchronously. Especially for components with dependencies.
 *
 * @author MMagon
 */
public class JQueryExecuteSynchronouslyFeature extends Feature<JavaScriptPart, JQueryExecuteSynchronouslyFeature>
{

    private ArrayList<ComponentFeatureBase> orderedWhenList = new ArrayList();
    private ArrayList<ComponentFeatureBase> orderedThenList = new ArrayList();

    public JQueryExecuteSynchronouslyFeature()
    {
        super("JQueryWhenThen");
    }

    public boolean addFeatureToWhen(ComponentFeatureBase newWhen)
    {
        orderedWhenList.add(newWhen);
        return true;
    }

    public boolean addFeatureToThen(ComponentFeatureBase newWhen)
    {
        orderedThenList.add(newWhen);
        return true;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        ArrayList<String> queries = new ArrayList();
        StringBuilder query = new StringBuilder("$.when(");
        for (ComponentFeatureBase feature : orderedWhenList)
        {
            query.append(feature.renderJavascript());
        }
        query.append(").then(");
        for (ComponentFeatureBase feature : orderedThenList)
        {
            query.append(feature.renderJavascript());
        }
        query.append(");");

    }

}
