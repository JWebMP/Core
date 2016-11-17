package za.co.mmagon.jwebswing.base.html;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import org.apache.log4j.Logger;
import za.co.mmagon.LoggerFactory;
import za.co.mmagon.jwebswing.base.ComponentHierarchyBase;
import za.co.mmagon.jwebswing.base.html.attributes.AreaAttributes;
import za.co.mmagon.jwebswing.base.html.attributes.GlobalAttributes;
import za.co.mmagon.jwebswing.base.html.interfaces.GlobalFeatures;
import za.co.mmagon.jwebswing.base.html.interfaces.children.AreaChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.children.MapChildren;
import za.co.mmagon.jwebswing.base.html.interfaces.events.GlobalEvents;
import za.co.mmagon.jwebswing.base.servlets.enumarations.ComponentTypes;
import za.co.mmagon.jwebswing.components.jqimagemap.imagemap.JQImageMap;
import za.co.mmagon.jwebswing.components.jqimagemap.imagemap.JQMapInteractiveFeature;

/**
 * Browser Support<p>
 * <p>
 * Internet Explorer Firefox Opera Google Chrome Safari<p>
 * <p>
 * The area tag is supported in all major browsers. Definition and Usage<p>
 * <p>
 * The area tag defines an area inside an image-map (an image-map is an image with clickable areas)
 * .<p>
 * <p>
 * The area element is always nested inside a map tag.<p>
 * <p>
 * Note: The usemap attribute in the img tag is associated with the map element's name attribute, and creates a relationship between the image and the map. Differences Between HTML 4.01 and HTML5<p>
 * <p>
 * HTML5 has some new attributes, and some HTML 4.01 attributes are no longer supported. Differences Between HTML and XHTML<p>
 * <p>
 * In HTML the area tag has no end tag.<p>
 * <p>
 * In XHTML the area tag must be properly closed.<p>
 *
 * @since 2013/11/22
 * @version 1.0
 * @author MMagon
 *
 *
 */
public class Area extends ComponentHierarchyBase<AreaChildren, AreaAttributes, GlobalFeatures, GlobalEvents, Area>
        implements MapChildren, Serializable
{

    private static final Logger LOG = LoggerFactory.getInstance().makeNewLoggerInstance("Area");
    /**
     * Serial Version for all Components and their compatibility
     */
    private static final long serialVersionUID = 1l;

    private JQImageMap.ImageMapAreaShapes areaShape;
    private int[][] coordinatesArray;
    private String coordinates;
    private String prettyValue = "0.0";
    private double value = 0.0;
    private JQMapInteractiveFeature interactiveProperties;
    private JQImageMap drillMap;
    private DecimalFormat decimalFormat;

    public Area()
    {
        super(ComponentTypes.Area);
    }

    /**
     * Construct a new area tag with the given co-ordinates and area shape. A name is required
     *
     * @param areaShape   The area shape
     * @param coordinates The co-ordinates of this area
     * @param name        The name of this area
     */
    public Area(JQImageMap.ImageMapAreaShapes areaShape, String coordinates, String name)
    {
        super(ComponentTypes.Area);
        this.areaShape = areaShape;
        this.coordinatesArray = getArrayFromStringCoordinates(coordinates);
        this.coordinates = coordinates;
        addAttribute(GlobalAttributes.Name, name);
        addAttribute(AreaAttributes.Coords, this.coordinates);
        addAttribute(AreaAttributes.Shape, areaShape.name().toLowerCase());
        setInlineClosingTag(true);
    }

    /**
     * Construct a new area tag with the given co-ordinates and area shape. The name "MapArea" is assigned as a default for image maps
     *
     * @param areaShape   The area shape
     * @param coordinates The co-ordinates of this area
     */
    public Area(JQImageMap.ImageMapAreaShapes areaShape, String coordinates)
    {
        this(areaShape, coordinates, "MapArea");
    }

    /**
     * If a drill through map is specified, returns this map
     *
     * @return
     */
    public JQImageMap getDrillMap()
    {
        return drillMap;
    }

    /**
     * Sets the drill map drill through
     *
     * @param drillMap
     */
    public void setDrillMap(JQImageMap drillMap)
    {
        this.drillMap = drillMap;
    }

    /**
     * Pre-configures this component with all the required attributes and features
     */
    @Override
    public void preConfigure()
    {
        if (coordinates != null)
        {
            addAttribute(AreaAttributes.Coords, this.coordinates);
        }
        if (areaShape != null)
        {
            addAttribute(AreaAttributes.Shape, areaShape.name().toLowerCase());
        }
        super.preConfigure();
    }

    /**
     * Returns the interactive properties of this feature
     *
     * @return
     */
    public JQMapInteractiveFeature getInteractiveProperties()
    {
        if (interactiveProperties == null)
        {
            interactiveProperties = new JQMapInteractiveFeature(null);
        }
        return interactiveProperties;
    }

    /**
     * Splits the co-ordinates into an array
     *
     * @param coordinates The Co-ordinate string
     * @return The integer array of all the points
     */
    public static synchronized int[][] getArrayFromStringCoordinates(String coordinates)
    {
        StringTokenizer st = new StringTokenizer(coordinates, ",");
        int coordinateCount = st.countTokens() / 2;
        int[][] coords = new int[coordinateCount][2];
        int currentCoord = 0;
        while (st.hasMoreElements())
        {
            try
            {
                String coord1 = (String) st.nextElement();
                String coord2 = (String) st.nextElement();
                coords[currentCoord][0] = Integer.parseInt(coord1);
                coords[currentCoord][1] = Integer.parseInt(coord2);
                currentCoord++;
            }
            catch (NullPointerException npe)
            {
                LOG.warn("Area format incorrect",npe);
            }
        }
        return coords;
    }

    /**
     * Retrieves the Co-Ordinates array
     *
     * @return int[2]
     */
    public int[][] getCoordinatesArray()
    {
        return getArrayFromStringCoordinates(this.coordinates);
    }

    /**
     * Return the string form of the co-ordinates
     *
     * @return
     */
    public String getCoordinates()
    {
        return coordinates;
    }

    /**
     * Set the Co-ordinates
     *
     * @param coordinates
     */
    public void setCoordinates(String coordinates)
    {
        this.coordinates = coordinates;
    }

    /**
     * Return the given area shape
     *
     * @return
     */
    public JQImageMap.ImageMapAreaShapes getAreaShape()
    {
        return areaShape;
    }

    /**
     * sets the given area shape
     *
     * @param areaShape
     */
    public void setAreaShape(JQImageMap.ImageMapAreaShapes areaShape)
    {
        this.areaShape = areaShape;
    }

    /**
     * Returns a value for this value
     *
     * @return
     */
    public double getValue()
    {
        return value;
    }

    /**
     * Sets the value associated with this area
     *
     * @param value
     */
    public void setValue(double value)
    {
        this.value = value;
    }

    /**
     * Sets the value assigned to this area
     *
     * @param value
     */
    public void setValue(String value)
    {
        this.prettyValue = value;
    }

    /**
     * Returns a pretty print version of the given are
     *
     * @return
     */
    public String getPrettyValue()
    {
        return prettyValue;
    }

    /**
     * Set the pretty value of the figure
     *
     * @param prettyValue
     */
    public void setPrettyValue(String prettyValue)
    {
        this.prettyValue = prettyValue;
    }

    /**
     * Sets the Decimal Format of this area for pretty print
     *
     * @return
     */
    public DecimalFormat getDecimalFormat()
    {
        return decimalFormat;
    }

    /**
     * Sets the Decimal Format of this area for pretty print
     *
     * @param decimalFormat
     */
    public void setDecimalFormat(DecimalFormat decimalFormat)
    {
        this.decimalFormat = decimalFormat;
    }

}
