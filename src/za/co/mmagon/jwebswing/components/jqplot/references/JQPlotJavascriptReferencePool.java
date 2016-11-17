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
package za.co.mmagon.jwebswing.components.jqplot.references;

import za.co.mmagon.jwebswing.base.references.JavascriptReference;

/**
 * References for all the graphing Java Scripts
 * <p>
 * @author Marc Magon
 * @since 08 Aug 2015
 * @version 1.0
 */
public enum JQPlotJavascriptReferencePool
{

    /**
     * The basic core for the graphing system
     */
    GraphCore(new JavascriptReference("jqPlot", 1.09, "bower_components/jqplot-jwebswing/jquery.jqplot.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/jquery.jqplot.js", 15)),
    /**
     * If the ie is less than version 9 this is required
     */
    ExCanvas(new JavascriptReference("excanvas", 1.09, "bower_components/jqplot-jwebswing/excanvas.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/excanvas.js", 16)),
    /**
     * Builds a Bezier Curve Graph
     */
    BezierCurveRenderer(new JavascriptReference("jqplotBezeierCurve", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.BezierCurveRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.BezierCurveRenderer.js", 17)),
    /**
     * Renders the Bars
     */
    BarRenderer(new JavascriptReference("jqplotBar", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.barRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.barRenderer.js", 20)),
    AxisLabelRenderer(new JavascriptReference("jqplotAxisLabelRenderer", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.axisLabelRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.axisLabelRenderer.js", 17)),
    BlockRenderer(new JavascriptReference("jqplotBlock", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.blockRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.blockRenderer.js", 20)),
    BubbleRenderer(new JavascriptReference("jqplotBubble", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.bubbleRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.bubbleRenderer.js", 20)),
    CanvasAxisLabelRenderer(new JavascriptReference("jqplotAxisLabel", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.canvasAxisLabelRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.canvasAxisLabelRenderer.js", 17)),
    CanvasAxisTickRenderer(new JavascriptReference("jqplotAxisTickLabel", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.canvasAxisTickRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.canvasAxisTickRenderer.js", 17)),
    CanvasOverlayRenderer(new JavascriptReference("jqplotCanvasOverlay", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.canvasOverlay.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.canvasOverlay.js", 20)),
    CanvasTextRenderer(new JavascriptReference("jqplotTextRenderer", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.canvasTextRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.canvasTextRenderer.js", 16)),
    CategoryAxisRenderer(new JavascriptReference("jqplotCategoryAxisRenderer", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.categoryAxisRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.categoryAxisRenderer.js", 17)),
    CIParserRenderer(new JavascriptReference("jqplotCIParser", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.ciParser.min.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.ciParser.min.js", 17)),
    CursorRenderer(new JavascriptReference("jqplotCursor", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.cursor.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.cursor.js", 17)),
    DateAxisRenderer(new JavascriptReference("jqplotDateAxis", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.dateAxisRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.dateAxisRenderer.js", 17)),
    DoughnutRenderer(new JavascriptReference("jqplotDoughnut", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.donutRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.donutRenderer.js", 20)),
    DraggableRenderer(new JavascriptReference("jqplotDrag", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.dragable.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.dragable.js", 17)),
    EnhancedLegenedRenderer(new JavascriptReference("jqplotEnhancedLegend", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.enhancedLegendRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.enhancedLegendRenderer.js", 20)),
    EnhancedPieLegenedRenderer(new JavascriptReference("jqplotEnhancedLegend", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.enhancedPieLegendRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.enhancedPieLegendRenderer.js", 20)),
    FunnelRenderer(new JavascriptReference("jqplotFunnel", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.funnelRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.funnelRenderer.js", 20)),
    HighlightRenderer(new JavascriptReference("jqplotHighlight", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.highlighter.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.highlighter.js", 17)),
    JSON2Renderer(new JavascriptReference("jqplotJSON2", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.json2.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.json2.js", 16)),
    LogAxisRenderer(new JavascriptReference("jqplotLogAxis", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.logAxisRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.logAxisRenderer.js", 17)),
    MekkoAxisRenderer(new JavascriptReference("jqplotMekkoAxis", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.mekkoAxisRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.mekkoAxisRenderer.js", 20)),
    MekkoRenderer(new JavascriptReference("jqplotMekko", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.mekkoRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.mekkoRenderer.js", 20)),
    MeterGaugeRenderer(new JavascriptReference("jqplotMeter", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.meterGaugeRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.meterGaugeRenderer.js", 20)),
    Mobile(new JavascriptReference("jqplotMobile", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.mobile.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.mobile.js", 16)),
    OHLCRenderer(new JavascriptReference("jqplotOLHC", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.ohlcRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.ohlcRenderer.js", 20)),
    PieRenderer(new JavascriptReference("jqplotPie", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.pieRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.pieRenderer.js", 20)),
    PointLabelsRenderer(new JavascriptReference("jqplotPointLabels", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.pointLabels.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.pointLabels.js", 20)),
    PyramidAxisRenderer(new JavascriptReference("jqplotPyramidAxisRender", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.pyramidAxisRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.pyramidAxisRenderer.js", 20)),
    PyramidGridRenderer(new JavascriptReference("jqplotPyramidGridRender", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.pyramidGridRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.pyramidGridRenderer.js", 20)),
    PyramidRenderer(new JavascriptReference("jqplotPyramid", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.pyramidRenderer.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.pyramidRenderer.js", 20)),
    TrendlineRenderer(new JavascriptReference("jqplotTrendLine", 1.09, "bower_components/jqplot-jwebswing/plugins/jqplot.trendline.js", "https://cdnjs.cloudflare.com/ajax/libs/jqPlot/1.0.9/plugins/jqplot.trendline.js", 20)),;
    private final JavascriptReference reference;

    private JQPlotJavascriptReferencePool(JavascriptReference reference)
    {
        this.reference = reference;

    }

    public JavascriptReference getReference()
    {
        return reference;
    }

}
