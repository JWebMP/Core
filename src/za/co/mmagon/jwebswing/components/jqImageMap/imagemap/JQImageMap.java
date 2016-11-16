package za.co.mmagon.jwebswing.components.jqImageMap.imagemap;

import java.util.ArrayList;
import java.util.Iterator;
import za.co.mmagon.jwebswing.Component;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.Area;
import za.co.mmagon.jwebswing.base.html.Div;
import za.co.mmagon.jwebswing.base.html.Image;
import za.co.mmagon.jwebswing.base.html.Map;
import za.co.mmagon.jwebswing.base.html.Span;
import za.co.mmagon.jwebswing.base.html.attributes.AreaAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.ImageAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.ImageMapAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.children.BodyChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ImageMapChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ImageMapFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.components.jqueryUI.position.JQUIPositionFeature;
import za.co.mmagon.jwebswing.components.jqueryUI.position.Position;
import za.co.mmagon.jwebswing.components.jqueryUI.position.PositionLocationHorizontal;
import za.co.mmagon.jwebswing.components.jqueryUI.position.PositionLocationVertical;
import za.co.mmagon.jwebswing.features.gradients.JWGradientsFeature;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Positions;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * The image map component
 *
 * @author mmagon
 * @since 2013/01/14
 * @version 0.1
 */
@CSS(Position = Positions.Relative)
public class JQImageMap extends Component<ImageMapChildren, ImageMapAttributes, ImageMapFeatures, GlobalEvents, Component> implements BodyChildren
{

    private Div labelsDiv;
    private Div legendDiv;
    private Map map;
    private Image image;
    private int imageXSize;
    private int imageYSize;
    private int displayXSize;
    private int displayYSize;
    private Div labelHeadDiv;

    /**
     * The default interactive feature
     */
    private JQMapInteractiveFeature defaultProperties = new JQMapInteractiveFeature(this);
    /**
     * The default interactive feature
     */
    private final JQImageHeatMapFeature heatMap = new JQImageHeatMapFeature(this, 1, 1000000);

    private final JWGradientsFeature gradientFeature = new JWGradientsFeature(this, this.heatMap.getColourMin(), this.heatMap.getColourMax(), "vertical");

    private final JQMapLegendFeature legendFeature = new JQMapLegendFeature(this, gradientFeature);

    /**
     * The map URL
     */
    private String mapImageUrl;
    /**
     * Sets whether the image map should apply a heat map This attaches a heat map feature
     */
    private boolean heatmap;
    /**
     * Shows whether the map is interactive Allows for highlighting
     */
    private boolean interactive;
    /**
     * Shows whether the map is labeled This puts a div at the center of each polygon
     */
    private boolean labeled;
    /**
     * Sets whether to display a legend or not
     */
    private boolean legend;

    private boolean valueDisplayed;
    
    private boolean ratioConfigured = false;

    /**
     * Constructs a new Image Map
     *
     * @param mapImageUrl
     */
    public JQImageMap(String mapImageUrl)
    {
        this(mapImageUrl, false, false, false);
        this.labelHeadDiv = new Div();
    }

    /**
     * Constructs an ImageMap from the given parameters with the testing sizes
     *
     * @param mapImageUrl
     * @param heatmap
     * @param interactive
     * @param labeled
     */
    public JQImageMap(String mapImageUrl, boolean heatmap, boolean interactive, boolean labeled)
    {
        this(mapImageUrl, heatmap, interactive, labeled, 0, 0, 0, 0);
        this.labelHeadDiv = new Div();
    }

    /**
     *
     * @param mapImageUrl
     * @param heatmap
     * @param interactive
     * @param labeled
     * @param imageXSize The original Image size
     * @param imageYSize The original Image size
     * @param displayXSize The new image x size
     * @param displayYSize the new image y size
     */
    public JQImageMap(String mapImageUrl, boolean heatmap, boolean interactive, boolean labeled, int imageXSize, int imageYSize, int displayXSize, int displayYSize)
    {
        super("div", ComponentTypes.Div, false);
        this.labelHeadDiv = new Div();
        this.imageXSize = imageXSize;
        getCss().setWidth(imageXSize);
        getCss().setHeight(imageYSize);
        this.imageYSize = imageYSize;
        this.displayYSize = displayYSize;
        this.displayXSize = displayXSize;
        this.mapImageUrl = mapImageUrl;
        this.heatmap = heatmap;
        this.interactive = interactive;
        this.labeled = labeled;

        this.map = new Map();
        this.image = new Image(this.mapImageUrl);
        defaultProperties.setDefaultProperties(true);
        image.addAttribute(ImageAttributes.UseMap, "#" + this.map.getID());
        add(image);
        add(map);
    }

    /**
     * Adds a specified area to the image map
     *
     * @param areaName The name of the area
     * @param polygonCoordinates The co-ordinates for the area
     * @return True or false if added public Area addAreaToMap(String areaName, String polygonCoordinates) { Area a = new Area(ImageMapAreaShapes.Poly, polygonCoordinates);
     * a.addAttribute(GlobalAttributes.Name, areaName); this.map.add(a); return a; }
     */
    public Area addAreaToMap(String areaName, String polygonCoordinates)
    {
        Area a = new Area(ImageMapAreaShapes.Poly, polygonCoordinates);
        a.addAttribute(GlobalAttributes.Name, areaName);
        this.map.add(a);
        return a;
    }

    /**
     * Adds a specified area to the image map
     *
     * @param area The area to add
     * @return Always True
     */
    public boolean addAreaToMap(Area area)
    {
        this.map.add(area);
        return true;
    }

    public Area add(Area area)
    {
        addAreaToMap(area);
        return area;
    }
    
    private void renderResize()
    {
        if (displayXSize != 0)
        {
            image.addAttribute(ImageAttributes.Width, displayXSize + "px");
            image.addAttribute(ImageAttributes.Height, displayYSize + "px");

            int ratioXDifference = (int) (new Double(displayXSize) / new Double(imageXSize));
            int ratioYDifference = (int) (new Double(displayYSize) / new Double(imageYSize));

            int[] xArray;
            int[] yArray;
            if (!(ratioXDifference == 1 && ratioYDifference == 1) && !ratioConfigured)
            {
                ratioConfigured = true;
                for (Iterator<ComponentHierarchyBase> it = this.map.getChildren().iterator(); it.hasNext();)
                {
                    Area area = (Area) it.next();
                    int[][] allPoints = area.getCoordinatesArray();
                    xArray = new int[allPoints.length];
                    yArray = new int[allPoints.length];
                    int xTotal = 0;
                    int yTotal = 0;
                    for (int i = 0; i < allPoints.length; i++)
                    {
                        int[] is = allPoints[i];
                        xArray[i] = (int) (is[0] * ratioXDifference);
                        xTotal += xArray[i];
                        yArray[i] = (int) (is[1] * ratioYDifference);
                        yTotal += yArray[i];
                    }

                    String coords = "";
                    for (int i = 0; i < xArray.length; i++)
                    {
                        int j = xArray[i];
                        int k = yArray[i];
                        coords += j + "," + k + ",";
                    }
                    coords = coords.substring(0, (coords.length() - 1));
                    area.setCoordinates(coords);
                }
            }
        }
    }

    @Override
    public void preConfigure()
    {
        if (isInteractive())
        {
            addFeature(defaultProperties);
        }

        if (isHeatmap())
        {
            addFeature(defaultProperties);
            addFeature(heatMap);
            if (isLegend())
            {
                gradientFeature.setFromColour(this.heatMap.getColourMin());
                gradientFeature.setToColour(this.heatMap.getColourMax());
                gradientFeature.setDirection("vertical");
                addFeature(legendFeature);
                addFeature(gradientFeature);
                if (!getChildren().contains(legendFeature.getLayoutDiv()))
                {
                    getChildren().add(getChildren().size(), legendFeature.getLayoutDiv());
                }
            }

            double totalValue = 0.0;
            ArrayList<Double> values = new ArrayList();
            for (Iterator<ComponentHierarchyBase> it = this.map.getChildren().iterator(); it.hasNext();)
            {
                Area area = (Area) it.next();
                totalValue += area.getValue();
                values.add(area.getValue());
            }
            heatMap.setValues(values);
            for (Iterator<ComponentHierarchyBase> it = this.map.getChildren().iterator(); it.hasNext();)
            {
                Area area = (Area) it.next();
                area.getInteractiveProperties().addProperty(JQMapInteractiveFeature.InteractiveFeatureProperties.overlayColorPermanent, heatMap.getColourForValue(area.getValue()));
            }
        }

        if (isLabeled() || isValueDisplayed())
        {
            if (!(getChildren().contains(labelHeadDiv)))
            {
                ArrayList<ComponentHierarchyBase> alreadyAdded = new ArrayList();
                for (Iterator<ComponentHierarchyBase> it = this.map.getChildren().iterator(); it.hasNext();)
                {
                    Area area = (Area) it.next();
                    if (alreadyAdded.contains(area))
                    {
                        continue;
                    }
                    alreadyAdded.add(area);
                    Span areaLableDiv = new Span();
                    areaLableDiv.getCss().setPosition(Positions.Absolute);
                    areaLableDiv.setText("");
                    areaLableDiv.addAttribute(GlobalAttributes.Style, "color:#000000 !important");
                    if (isLabeled())
                    {
                        areaLableDiv.setText(area.getAttribute(GlobalAttributes.Name));
                    }
                    if (isValueDisplayed())
                    {
                        areaLableDiv.setText(areaLableDiv.getText(0) + "<br>" + area.getPrettyValue());
                    }

                    class Binder extends Feature<JavaScriptPart, Binder>
                    {

                        Span label;
                        Area area;

                        public Binder(Span label, Area area)
                        {
                            super("Image Map Label Binder");
                            this.label = label;
                            this.area = area;
                        }

                        @Override
                        public void assignFunctionsToComponent()
                        {

                            addQuery("$('#" + label.getID() + "').bind('click', function(event) {$('#" + area.getID() + "').click();});");
                            addQuery("$('#" + label.getID() + "').bind('hover', function(event) {$('#" + area.getID() + "').hover();});");
                            addQuery("$('#" + label.getID() + "').bind('mouseover', function(event) {$('#" + area.getID() + "').mouseover();});");
                            addQuery("$('#" + label.getID() + "').bind('mouseout', function(event) {$('#" + area.getID() + "').mouseout();});");
                        }
                    }

                    areaLableDiv.addAttribute(GlobalAttributes.Style, "position:absolute");
                    areaLableDiv.addFeature(new Binder(areaLableDiv, area));
                    //int[] center = PolygonUtils.getCenterPointOfPolygon(area.getCoordinates());
                    //areaLableDiv.addAttribute(GlobalAttributes.Style, "position:absolute;top:" + center[0] + ";left:"+ center[1]);
                    areaLableDiv.addFeature(new JQUIPositionFeature(areaLableDiv, new Position(PositionLocationHorizontal.center, PositionLocationVertical.center, PositionLocationHorizontal.center, PositionLocationVertical.center, area)));
                    area.add(areaLableDiv);
                    //add(areaLableDiv);
                }
                //add(labelHeadDiv);
            }
        }

        for (Iterator<ComponentHierarchyBase> it = this.map.getChildren().iterator(); it.hasNext();)
        {
            Area area = (Area) it.next();
            area.addAttribute(AreaAttributes.Data_MapHilight, "{" + area.getInteractiveProperties().getProperties(true) + "}");
        }
        //setPosition(Positions.Absolute);
        super.preConfigure();
    }

    /**
     * Returns the default properties
     *
     * @return
     */
    public JQMapInteractiveFeature getDefaultProperties()
    {
        return defaultProperties;
    }

    /**
     * Sets the default properties
     *
     * @param defaultProperties
     */
    public void setDefaultProperties(JQMapInteractiveFeature defaultProperties)
    {
        this.defaultProperties = defaultProperties;
    }

    /**
     * Return the current map object
     *
     * @return
     */
    public Map getMap()
    {
        return map;
    }

    /**
     * Sets the current map object
     *
     * @param map
     */
    public void setMap(Map map)
    {
        this.map = map;
    }

    /**
     * Returns the associated image
     *
     * @return
     */
    public Image getImage()
    {
        return image;
    }

    /**
     * Sets the associated image
     *
     * @param image
     */
    public void setImage(Image image)
    {
        this.image = image;
    }

    /**
     * Returns the Map Image URL
     *
     * @return
     */
    public String getMapImageUrl()
    {
        return mapImageUrl;
    }

    /**
     * Sets the map image url
     *
     * @param mapImageUrl
     */
    public void setMapImageUrl(String mapImageUrl)
    {
        this.mapImageUrl = mapImageUrl;
    }

    /**
     * If this map is a heat map
     *
     * @return
     */
    public boolean isHeatmap()
    {
        return heatmap;
    }

    /**
     * If this map is a heatmap
     *
     * @param heatmap
     */
    public void setHeatmap(boolean heatmap)
    {
        this.heatmap = heatmap;
    }

    /**
     * If this map is interactive
     *
     * @return
     */
    public boolean isInteractive()
    {
        return interactive;
    }

    /**
     * If this map has a legend
     *
     * @return
     */
    public boolean isLegend()
    {
        return legend;
    }

    /**
     * If this map has a legend
     *
     * @param legend
     */
    public void setLegend(boolean legend)
    {
        this.legend = legend;
    }

    /**
     * If this map is interactive
     *
     * @param interactive
     */
    public void setInteractive(boolean interactive)
    {
        this.interactive = interactive;
        if (isInteractive())
        {
            addFeature(defaultProperties);
        }
        else
        {
            removeFeature(defaultProperties);
        }
    }

    /**
     * Image x size
     *
     * @return
     */
    public int getImageXSize()
    {
        return imageXSize;
    }

    /**
     * Image x size
     *
     * @param imageXSize
     */
    public void setImageXSize(int imageXSize)
    {
        this.imageXSize = imageXSize;
    }

    /**
     * Image Y size
     *
     * @return
     */
    public int getImageYSize()
    {
        return imageYSize;
    }

    /**
     * Is value displayed
     *
     * @return
     */
    public boolean isValueDisplayed()
    {
        return valueDisplayed;
    }

    /**
     * Is value displayed
     *
     * @param valueDisplayed
     */
    public void setValueDisplayed(boolean valueDisplayed)
    {
        this.valueDisplayed = valueDisplayed;
    }

    /**
     * Set image y size
     *
     * @param imageYSize
     */
    public void setImageYSize(int imageYSize)
    {
        this.imageYSize = imageYSize;
    }

    /**
     * Display X Size
     *
     * @return
     */
    public int getDisplayXSize()
    {
        return displayXSize;
    }

    /**
     * Display X size
     *
     * @param displayXSize
     */
    public void setDisplayXSize(int displayXSize)
    {
        this.displayXSize = displayXSize;
    }

    /**
     * Display Y size
     *
     * @return
     */
    public int getDisplayYSize()
    {
        return displayYSize;
    }

    /**
     * Display Y size
     *
     * @param displayYSize
     */
    public void setDisplayYSize(int displayYSize)
    {
        this.displayYSize = displayYSize;
    }

    /**
     * Set is labeled
     *
     * @return
     */
    public boolean isLabeled()
    {
        return labeled;
    }

    /**
     * Set is labeled
     *
     * @param labeled
     */
    public void setLabeled(boolean labeled)
    {
        this.labeled = labeled;
    }

    /**
     * Return the heat map options
     *
     * @return
     */
    public JQImageHeatMapFeature getHeatMap()
    {
        return heatMap;
    }

    /**
     * Available image area shapes
     */
    public enum ImageMapAreaShapes
    {
        Default,
        Rect,
        Circle,
        Poly;
    }
}
