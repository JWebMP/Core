/*
 * Copyright (C) 2016 GedMarc
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
package za.co.mmagon.jwebswing.components.jqplot.graphs.display;

/**
 * Represents a single bar
 */
public class JQPlotBar implements JQPlotSeriesItem
{

    private String xAxisValue;
    private String categoryValue;
    private Double yValue;
    private Double startingValue;

    private boolean waterfall;
    private boolean clustered;

    /**
     * Constructs a new Bar with the given X Axis category and actual yAxis value
     * <p>
     * @param xAxisValue
     * @param yValue
     */
    public JQPlotBar(String xAxisValue, Double yValue)
    {
        this.xAxisValue = xAxisValue;
        this.yValue = yValue;
    }

    /**
     * For cluster graphs, to give each series a separate name
     *
     * @param xAxisValue
     * @param categoryValue
     * @param yValue
     */
    public JQPlotBar(String xAxisValue, String categoryValue, Double yValue)
    {
        this.xAxisValue = xAxisValue;
        this.categoryValue = categoryValue;
        this.yValue = yValue;

        setClustered(true);
    }

    /**
     * For Waterfall Bars, Specified with a Starting Point clustered
     *
     * @param xAxisValue
     * @param categoryValue
     * @param yValue
     * @param startingValue
     */
    public JQPlotBar(String xAxisValue, String categoryValue, Double startingValue, Double yValue)
    {
        this.xAxisValue = xAxisValue;
        this.categoryValue = categoryValue;
        this.yValue = yValue;
        this.startingValue = startingValue;

        setWaterfall(true);
        setClustered(true);
    }

    /**
     * For Waterfall Bars, Specified with a Starting Point
     *
     * @param categoryValue
     * @param yValue
     * @param startingValue
     */
    public JQPlotBar(String categoryValue, Double startingValue, Double yValue)
    {
        this.categoryValue = categoryValue;
        this.yValue = yValue;
        this.startingValue = startingValue;

        setWaterfall(true);
    }

    /**
     * Gets the category value for a specific bar
     * <p>
     * @return
     */
    public String getCategoryValue()
    {
        return categoryValue;
    }

    /**
     * Sets the current category value for a specific bar
     * <p>
     * @param categoryValue
     */
    public void setCategoryValue(String categoryValue)
    {
        this.categoryValue = categoryValue;
    }

    /**
     * Gets the yAxis Value
     * <p>
     * @return
     */
    public Double getyValue()
    {
        return yValue;
    }

    /**
     * Sets the yAxis Value
     * <p>
     * @param yValue
     */
    public void setyValue(Double yValue)
    {
        this.yValue = yValue;
    }

    /**
     * Only for Waterfall, Gets the starting value
     *
     * @return
     */
    public Double getStartingValue()
    {
        return startingValue;
    }

    /**
     * Only for waterfall, gets the starting value
     *
     * @param startingValue
     */
    public void setStartingValue(Double startingValue)
    {
        this.startingValue = startingValue;
    }

    /**
     * Gets the X Axis Name
     *
     * @return
     */
    public String getxAxisValue()
    {
        return xAxisValue;
    }

    /**
     * Sets the X Axis Name
     *
     * @param xAxisValue
     */
    public void setxAxisValue(String xAxisValue)
    {
        this.xAxisValue = xAxisValue;
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

    @Override
    public String toString()
    {
        if (isClustered() && !isWaterfall())
        {
            return "[\"" + getCategoryValue() + "\"," + getyValue() + "],";
        }
        if (isWaterfall())
        {
            /*
             * if (isClustered())
             * {
             * return "[\"" + getCategoryValue() + "\"," + getStartingValue() + "," + getyValue() + "],";
             * }
             */

            //return getStartingValue() + "," + getyValue() + ",";
            return getyValue() + ",";
        }

        return getyValue().toString() + ",";
    }
}
