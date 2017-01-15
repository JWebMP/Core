/*
 * Copyright (C) 2015 Marc Magon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package za.co.mmagon.jwebswing.components.jqplot.graphs;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.co.mmagon.jwebswing.base.servlets.enumarations.Orientation;
import za.co.mmagon.jwebswing.components.jqplot.JQPlotGraph;
import za.co.mmagon.jwebswing.components.jqplot.graphs.display.JQPlotBar;
import za.co.mmagon.jwebswing.components.jqplot.options.axis.JQPlotAxisLabelRendererOptionsCategoryLabels;
import za.co.mmagon.jwebswing.components.jqplot.options.axis.JQPlotAxisOptions;
import za.co.mmagon.jwebswing.components.jqplot.options.series.JQPlotSeriesBarOptions;
import za.co.mmagon.jwebswing.components.jqplot.references.JQPlotJavascriptReferencePool;
import za.co.mmagon.jwebswing.generics.CompassPoints;
import za.co.mmagon.logger.LogFactory;

/**
 * Constructs a new JQPlotBar Graph default series display
 * <p>
 * @author Marc Magon
 * @since 09 Aug 2015
 * @version 1.0
 */
public class JQPlotBarGraph extends JQPlotGraph<JQPlotSeriesBarOptions>
{

    /**
     * The logger for the swing Servlet
     */
    private static final Logger LOG = LogFactory.getInstance().getLogger("JQPlotBarGraph");
    /**
     * Version 1
     */
    private static final long serialVersionUID = 1L;
    /**
     * How many dimensions
     */
    private boolean TwoD = false;

    /**
     * The category or tick values
     */
    private ArrayList<String> categoryTickValues;

    /**
     * Each of the separate bar groups to be applied
     */
    private HashMap<String, List<JQPlotBar>> barGroups;

    /**
     * Vertical or Horizontal
     */
    private Orientation orientation;

    /**
     * The bar graph options
     */
    protected JQPlotSeriesBarOptions barGraphOptions = null;

    /**
     * If the graph is rendered as a cluster
     */
    private boolean clustered;
    /**
     * If the graph is rendering as a waterfall
     */
    private boolean waterfall;

    /**
     * Constructs a new JQPlotBar Graph default Graph
     * <p>
     * @param orientation Vertical or Horizontal. Configures where to apply the Tick Renderer. Don't ever make this null
     */
    public JQPlotBarGraph(Orientation orientation)
    {
        setOrientation(orientation);
        getJavascriptReferences().add(JQPlotJavascriptReferencePool.BarRenderer.getReference());
        getOptions().getSeriesDefaults().setRendererOptions(getBarGraphOptions());
    }

    /**
     * Adds a new bar for cluster graphs for each bar value to have a series name
     * <p>
     * @param xAxisName The tick or category value
     * @param BarName   The yAxis Value
     * @param barValue  The actual bar value
     *
     */
    public void addBar(String xAxisName, String BarName, Double barValue)
    {
        JQPlotBar bar = new JQPlotBar(xAxisName, BarName, barValue);
        setClustered(true);
        bar.setClustered(true);
        addBar(bar);
    }

    /**
     * Adds a new bar and category to the 0 bar group number for waterfall standard graphs
     * <p>
     * @param xAxisName     The tick or category value
     * @param startingPoint The starting point for a bar
     * @param barValue      The actual bar value
     *
     */
    public void addBar(String xAxisName, Double startingPoint, Double barValue)
    {
        JQPlotBar bar = new JQPlotBar(xAxisName, startingPoint, barValue);
        getBarGraphOptions().setWaterfall(true);
        setWaterfall(true);
        addBar(bar);
    }

    /**
     * Adds a new bar and category to the 0 bar group number for waterfall clustered graphs
     * <p>
     * @param xAxisName     The tick or category value
     * @param BarName       The yAxis Value
     * @param startingPoint The starting point for a bar
     * @param barValue      The actual bar value
     *
     */
    public void addBar(String xAxisName, String BarName, Double startingPoint, Double barValue)
    {
        JQPlotBar bar = new JQPlotBar(xAxisName, BarName, startingPoint, barValue);
        getBarGraphOptions().setWaterfall(true);
        setWaterfall(true);
        addBar(bar);
    }

    /**
     * Adds a new bar and category to the 0 bar group number
     * <p>
     * @param XAxisValue The tick or category value
     * @param dataValue  The yAxis Value
     */
    public void addBar(String XAxisValue, double dataValue)
    {
        JQPlotBar bar = new JQPlotBar(XAxisValue, dataValue);
        addBar(bar);
    }

    /**
     * Adds a new bar and x Axis to the 0 bar group
     * <p>
     * @param bar The bar to add to the bar group 0
     */
    public void addBar(JQPlotBar bar)
    {
        List<JQPlotBar> bars = getBarGroup(bar.getxAxisValue());
        bars.add(bar);
    }

    /**
     * Returns the bar group associated with the category. If no group is found a new one is created
     *
     * @param xAxisValue
     *
     * @return
     */
    protected List<JQPlotBar> getBarGroup(String xAxisValue)
    {
        if (!getBarGroups().containsKey(xAxisValue))
        {
            getBarGroups().put(xAxisValue, new ArrayList<>());
        }
        List<JQPlotBar> bars = getBarGroups().get(xAxisValue);

        return bars;
    }

    /**
     * Returns the largest number of clusters for each category (x)
     *
     * @return 0 if no bars found at all
     */
    public Integer getNumberOfClusterBars()
    {
        int clusterBars = 0;
        for (Map.Entry<String, List<JQPlotBar>> entry : getBarGroups().entrySet())
        {
            String key = entry.getKey();
            List<JQPlotBar> value = entry.getValue();
            if (value.size() > clusterBars)
            {
                clusterBars = value.size();
            }
        }
        return clusterBars;
    }

    /**
     * Returns the maximum integer from the bar grouping. Not a count of bar groups
     * <p>
     * @return the largest key
     */
    public Integer getNumberOfBarGroups()
    {
        return getBarGroups().size();
    }

    /**
     * Create the ticks and correct axis options and stuff
     */
    @Override
    public void preConfigure()
    {
        super.preConfigure();
        switch (orientation)
        {
            case HORIZONTAL:
            {
                JQPlotAxisOptions axis = getOptions().getAxes().getyAxis();
                axis.setRendererOptions(new JQPlotAxisLabelRendererOptionsCategoryLabels(this));
                axis.setTicks(getCategoryTickValues());
                break;
            }
            case VERTICAL:
            {
                JQPlotAxisOptions axis = getOptions().getAxes().getxAxis();
                axis.setRendererOptions(new JQPlotAxisLabelRendererOptionsCategoryLabels(this));
                axis.setTicks(getCategoryTickValues());
                break;
            }
            default:
            {
                JQPlotAxisOptions axis = getOptions().getAxes().getxAxis();
                axis.setRendererOptions(new JQPlotAxisLabelRendererOptionsCategoryLabels(this));
                axis.setTicks(getCategoryTickValues());
            }
        }

        getBarGroups().entrySet().stream().map(entry ->
        {
            String key = entry.getKey();
            return entry;
        }).map(entry -> entry.getValue()).forEachOrdered(value ->
        {
            value.stream().filter(next ->
            {
                return next.getyValue() != null;
            }).filter(next -> (next.getyValue() < 0)).map(_item -> (JQPlotSeriesBarOptions) getOptions().getSeriesDefaults().getRendererOptions()).forEachOrdered((barOptions) ->
            {
                barOptions.setFillToZero(true);
            });
        });
    }

    /**
     * Renders each bar in a list
     *
     * @param value
     *
     * @return
     */
    protected StringBuilder renderBarArrayList(List<JQPlotBar> value)
    {
        StringBuilder sb = new StringBuilder();
        value.forEach(sb::append);
        return sb;
    }

    /**
     * Gets the data points to be rendered
     * <p>
     * @return
     */
    @Override
    protected StringBuilder getDataPointRender()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        int clusterBarCount = getNumberOfClusterBars();
        int categoryCount = getNumberOfBarGroups();

        if (clusterBarCount > 1)
        {
            setTwoD(true);
        }

        if (!isTwoD())
        {
            sb.append("[");
            for (Map.Entry<String, List<JQPlotBar>> entrySet : getBarGroups().entrySet())
            {
                String key = entrySet.getKey();
                List<JQPlotBar> value = entrySet.getValue();
                sb.append(renderBarArrayList(value));
            }
            if (sb.indexOf(",") > -1)
            {
                sb = sb.deleteCharAt(sb.lastIndexOf(","));
            }
            sb.append("]");
        }
        else
        {
            Object[] rows = new Object[clusterBarCount];
            Object[] valuesPerRow;//

            //The expected number of bars per category, aka number of arrays to build
            for (int i = 0; i < clusterBarCount; i++)
            {
                rows[i] = valuesPerRow = new Object[categoryCount];

                //Get the int i number bar number per category;
                for (int j = 0; j < categoryCount; j++)
                {
                    int mapPosition = 0;
                    for (Map.Entry<String, List<JQPlotBar>> entry : getBarGroups().entrySet())
                    {
                        String key = entry.getKey();
                        List<JQPlotBar> value = entry.getValue();

                        if (i >= value.size())
                        {
                            break;
                        }

                        if (mapPosition == j)
                        {
                            try
                            {
                                JQPlotBar o = value.get(i);
                                if (o != null)
                                {
                                    if (o.getyValue() == null)
                                    {
                                        valuesPerRow[j] = 0;
                                    }
                                    else
                                    {
                                        valuesPerRow[j] = o.getyValue();
                                    }
                                }
                            }
                            catch (Exception e)
                            {
                                LOG.log(Level.WARNING, "Unable to generate data", e);
                                valuesPerRow[j] = "";
                            }
                            break;
                        }
                        mapPosition++;
                    }
                }

            }
            //Load values from Array
            for (Object row1 : rows)
            {
                Object[] row = (Object[]) row1;
                sb.append("[");
                for (Object value : row)
                {
                    if (value == null)
                    {
                        value = 0;
                    }
                    sb.append(value).append(",");
                }
                if (sb.indexOf(",") > -1)
                {
                    sb = sb.deleteCharAt(sb.lastIndexOf(","));
                }
                sb.append("],");
            }
            if (sb.indexOf("],") > -1)
            {
                sb = sb.deleteCharAt(sb.lastIndexOf(","));
            }
        }
        sb.append("]");
        return sb;
    }

    /**
     * Sets if this graph is clustered
     *
     * @return
     */
    public boolean isTwoD()
    {
        return TwoD;
    }

    /**
     * Sets if this bar graph is clustered or not
     *
     * @param TwoD
     */
    public void setTwoD(boolean TwoD)
    {
        this.TwoD = TwoD;
    }

    /**
     * Returns the current tick values array
     * <p>
     * @return
     */
    public List<String> getCategoryTickValues()
    {
        if (categoryTickValues == null)
        {
            categoryTickValues = new ArrayList<>();
        }

        getBarGroups().entrySet().forEach((entry) ->
        {
            String key = entry.getKey();
            List<JQPlotBar> value = entry.getValue();
            if (!categoryTickValues.contains(key))
            {
                categoryTickValues.add(key);
            }
        });
        return categoryTickValues;
    }

    /**
     * Return a linked hash map each of the bar groups in order of Integer.
     * <p>
     * <p>
     * @return
     */
    public Map<String, List<JQPlotBar>> getBarGroups()
    {
        if (barGroups == null)
        {
            barGroups = new LinkedHashMap<>();
        }
        return barGroups;
    }

    /**
     * Returns the orientation of this bar graph
     * <p>
     * @return
     */
    public Orientation getOrientation()
    {
        return orientation;
    }

    /**
     * Sets the orientation of the bar graph. final
     *
     * @param orientation
     */
    public final void setOrientation(Orientation orientation)
    {
        this.orientation = orientation;
        switch (orientation)
        {
            case HORIZONTAL:
            {
                JQPlotAxisOptions axis = getOptions().getAxes().getyAxis();
                axis.setRendererOptions(new JQPlotAxisLabelRendererOptionsCategoryLabels(this));
                axis.setTicks(getCategoryTickValues());

                getSeriesDefaultBarOptions().setBarDirection(Orientation.HORIZONTAL);
                if (!(getOptions().getSeriesDefaults().getPointLabels().getShow() != null))
                {
                    getOptions().getSeriesDefaults().getPointLabels().setLocation(CompassPoints.E);
                    getOptions().getSeriesDefaults().getPointLabels().setEdgeTolerance(-15);
                    getOptions().getSeriesDefaults().setShadowAngle(135);

                }

                getOptions().getAxes().setxAxis(null);

                break;
            }
            case VERTICAL:
            default:
            {
                JQPlotAxisOptions axis = getOptions().getAxes().getxAxis();
                axis.setRendererOptions(new JQPlotAxisLabelRendererOptionsCategoryLabels(this));
                axis.setTicks(getCategoryTickValues());

                getOptions().getAxes().setyAxis(null);
                break;
            }
        }
    }

    /**
     * Sets the default bar options if null for series default
     *
     * @return
     */
    public JQPlotSeriesBarOptions getSeriesDefaultBarOptions()
    {
        if (getOptions().getSeriesDefaults().getRendererOptions() == null)
        {
            getOptions().getSeriesDefaults().setRendererOptions(getBarGraphOptions());
        }

        return (JQPlotSeriesBarOptions) getOptions().getSeriesDefaults().getRendererOptions();
    }

    /**
     * Gets if this is a waterfall bar
     *
     * @return
     */
    public boolean isWaterfall()
    {
        return waterfall;
    }

    /**
     * sets if this is a waterfall bar
     *
     * @param waterfall
     */
    public void setWaterfall(boolean waterfall)
    {
        this.waterfall = waterfall;
    }

    /**
     * gets if this is a clustered bar
     *
     * @return
     */
    public boolean isClustered()
    {
        return clustered;
    }

    /**
     * sets if this is a clustered bar
     *
     * @param clustered
     */
    public void setClustered(boolean clustered)
    {
        this.clustered = clustered;
    }

    /**
     * Returns a new instance of the Bar Graph Options
     *
     * @return
     */
    public final JQPlotSeriesBarOptions getBarGraphOptions()
    {
        if (barGraphOptions == null)
        {
            barGraphOptions = new JQPlotSeriesBarOptions(this);
        }
        return barGraphOptions;
    }

}
