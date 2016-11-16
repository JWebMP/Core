package za.co.mmagon.jwebswing.components.jqImageMap.imagemap;

import java.util.HashMap;
import java.util.Map;
import za.co.mmagon.jwebswing.Feature;
import za.co.mmagon.jwebswing.base.html.interfaces.children.ImageMapFeatures;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;

/**
 * @since @version @author MMagon
 *
 *
 */
public class JQMapInteractiveFeature extends Feature<JavaScriptPart, JQMapInteractiveFeature> implements ImageMapFeatures
{

    private JQImageMap map;
    private boolean defaultProperties;
    private HashMap<InteractiveFeatureProperties, Object> appliedProperties = new HashMap();

    /**
     * Constructs a new Interactive feature for a map, or its area
     *
     * @param map
     */
    public JQMapInteractiveFeature(JQImageMap map)
    {
        super("JWMapInteractiveFeature");
        this.map = map;
        getJavascriptReferences().add(new JQHilightReference());
    }

    public HashMap<InteractiveFeatureProperties, Object> getAppliedProperties()
    {
        return appliedProperties;
    }

    public void setAppliedProperties(HashMap<InteractiveFeatureProperties, Object> appliedProperties)
    {
        this.appliedProperties = appliedProperties;
    }

    @Override
    public void assignFunctionsToComponent()
    {
        if (this.map != null)
        {
            //arr.add("$(function() {$('#" + map.getImage().getID() + "').mapPrep()});;");
            addQuery("$(function() {$('#" + map.getImage().getID() + "').maphilight({" + getProperties(false) + "});"
                    + "});");
        }

    }

    /**
     * Sets whether this is a default properties render inside the constructor
     *
     * @return Whether or not this is the default properties
     */
    public boolean isDefaultProperties()
    {
        return defaultProperties;
    }

    /**
     * Sets if this is to be rendered as the default image map properties
     *
     * @param defaultProperties Whether or not this is the default properties
     */
    public void setDefaultProperties(boolean defaultProperties)
    {
        this.defaultProperties = defaultProperties;
    }

    /**
     * Returns all the map highlight properties associated with this interactive feature
     *
     * @param inline Set to true for attribute format
     * @return The required property line
     */
    public String getProperties(boolean inline)
    {
        String propertySB = "";
        int current = 0;
        for (Map.Entry<InteractiveFeatureProperties, Object> entry : appliedProperties.entrySet())
        {
            InteractiveFeatureProperties interactiveFeatureProperties = entry.getKey();
            Object object = entry.getValue();
            current++;

            if (object.toString().equalsIgnoreCase(interactiveFeatureProperties.defaultValue.toString()))
            {
                continue;
            }
            //System.out.println("in [" + interactiveFeatureProperties.getClassType().getSimpleName() + "]");

            propertySB += (inline ? "\"" : "") + interactiveFeatureProperties.name() + (inline ? "\"" : "") + ":";
            String bleh = interactiveFeatureProperties.getClassType().getSimpleName();
            if (bleh.equals("Double") || bleh.equals("Boolean"))
            {
                propertySB += (inline ? "\"" : "") + object + (inline ? "\"" : "");
            }
            else
            {
                propertySB += "\"" + object + "\"";
            }
            /*
             * switch (interactiveFeatureProperties.getClassType().getSimpleName())
             * {
             * case "Double":
             * case "Boolean":
             * {
             * propertySB += (inline ? "\"" : "") + object + (inline ? "\"" : "");
             * break;
             * }
             * case "String":
             * {
             * propertySB += "\""+ object + "\"";
             * break;
             * }
             * default:
             * {
             *
             * }
             * }
             */
            if (current != appliedProperties.size())
            {
                propertySB += ",";
            }
        }
        return propertySB;
    }

    public String getProperty(InteractiveFeatureProperties property)
    {
        return appliedProperties.get(property).toString();
    }

    /**
     * Adds a property to this part of the image map
     *
     * @param property The property to add
     * @param value    The value to assign
     */
    public void addProperty(InteractiveFeatureProperties property, String value)
    {
        appliedProperties.put(property, value);
    }

    public static void main(String... args)
    {
        JQMapInteractiveFeature in = new JQMapInteractiveFeature(null);
        in.addProperty(InteractiveFeatureProperties.fill, "true");
        in.addProperty(InteractiveFeatureProperties.overlayColorPermanent, "004d36");
        in.addProperty(InteractiveFeatureProperties.overlayColorOpacity, "0.4");
        System.out.println(in.getProperties(true));
        System.out.println(in.getProperties(false));
    }

    public enum InteractiveFeatureProperties
    {
        /**
         * Whether to fill the shape
         */
        fill(Boolean.class, Boolean.TRUE),
        /**
         * The color to fill the shape with
         */
        fillColor(String.class, "000000"),
        /**
         * The opacity of the fill (0 = fully transparent, 1 = fully opaque)
         */
        fillOpacity(Double.class, 0.2),
        /**
         * Whether to outline the shape
         */
        stroke(Boolean.class, Boolean.TRUE),
        /**
         * The color of the outline
         */
        strokeColor(String.class, "ff0000"),
        /**
         * The opacity of the outline (0 = fully transparent, 1 = fully opaque)
         */
        strokeOpacity(Double.class, 0.2),
        /**
         * The thickness of the outline
         */
        strokeWidth(Double.class, 0.4),
        /**
         * Whether to fade in the shapes on mouseover
         */
        fade(Boolean.class, Boolean.TRUE),
        /**
         * Whether to always show the hilighted areas
         */
        alwaysOn(Boolean.class, Boolean.FALSE),
        /**
         * Whether to never show the hilighted areas (This only makes sense to use as per-area metadata, of course.)
         */
        neverOn(Boolean.class, Boolean.FALSE),
        /**
         * The name of an attribute to group areas by If this is present then all areas in the map which have the same attribute value as the hovered area will hilight as well
         */
        groupBy(String.class, ""),
        /**
         * If true, applies the class on the img to the wrapper div maphilight created. If a string, that string is used as a class on the wrapper div.
         */
        wrapClass(Boolean.class, Boolean.FALSE),
        /**
         * Whether to apply a shadow to the shape. (Only works with canvas-supporting browsers. So, everything but IE below version 9.)
         */
        shadow(Boolean.class, Boolean.FALSE),
        /**
         * Where to position the shadow. Can be 'outside', 'inside', or 'both'.
         */
        shadowPosition(Double.class, 0.4),
        /**
         * What to use to cast the shadow. Can be 'stroke' or 'fill'. If false, choose a value based on the shadow position. (Generally it looks better if it's being cast from a fill when it's outside
         * the shape, and from a stroke when it's inside the shape.)
         */
        shadowFrom(String.class, "fill"),
        /**
         * Horizontal offset of the shadow from the shape.
         */
        shadowX(Double.class, 0.4),
        /**
         * Vertical offset of the shadow from the shape.
         */
        shadowY(Double.class, 0.4),
        /**
         * Size of the shadow.
         */
        shadowRadius(Double.class, 0.4),
        /**
         * Color of the shadow.
         */
        shadowColor(String.class, "000000"),
        /**
         * Opacity of the shadow.
         */
        shadowOpacity(Double.class, 0.1),
        /**
         * The default colour to overlay with - Heat map uses this
         */
        overlayColorPermanent(String.class, "transparent"),
        /**
         * The opacity for the permanent colour
         */
        overlayColorOpacity(Double.class, 1),
        /**
         * A valid reference ID
         */
        boneId(String.class, "No Bone ID"),
        /**
         * Available attribute association ID
         */
        attName(String.class, "Holder 1"),
        /**
         * Available attribute association ID
         */
        attName2(String.class, "Holder 2");

        private Class classType;
        private Object defaultValue;

        InteractiveFeatureProperties(Class classType, Object defaultValue)
        {
            this.classType = classType;
            this.defaultValue = defaultValue;
        }

        public Class getClassType()
        {
            return classType;
        }

        public void setClassType(Class classType)
        {
            this.classType = classType;
        }

        public Object getDefaultValue()
        {
            return defaultValue;
        }

        public void setDefaultValue(Object defaultValue)
        {
            this.defaultValue = defaultValue;
        }
    }
}
