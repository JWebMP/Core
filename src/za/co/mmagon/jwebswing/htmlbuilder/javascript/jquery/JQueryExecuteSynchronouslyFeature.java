package za.co.mmagon.jwebswing.htmlbuilder.javascript.jquery;

import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.ComponentFeatureBase;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implements an ordered hierarchy of JQueries. This is useful is
 * doing calls asynchronously. Especially for components with dependencies.
 *
 * @author MMagon
 */
public class JQueryExecuteSynchronouslyFeature extends Feature<JavaScriptPart, JQueryExecuteSynchronouslyFeature>
{

	private List<ComponentFeatureBase> orderedWhenList = new ArrayList();
	private List<ComponentFeatureBase> orderedThenList = new ArrayList();

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

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof JQueryExecuteSynchronouslyFeature))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		JQueryExecuteSynchronouslyFeature that = (JQueryExecuteSynchronouslyFeature) o;

		if (!orderedWhenList.equals(that.orderedWhenList))
		{
			return false;
		}
		return orderedThenList.equals(that.orderedThenList);
	}

	@Override
	public int hashCode()
	{
		int result = super.hashCode();
		result = 31 * result + orderedWhenList.hashCode();
		result = 31 * result + orderedThenList.hashCode();
		return result;
	}
}
