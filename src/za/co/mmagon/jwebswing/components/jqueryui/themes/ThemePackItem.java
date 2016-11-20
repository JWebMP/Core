package za.co.mmagon.jwebswing.components.jqueryui.themes;

import za.co.mmagon.jwebswing.base.html.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.heightwidth.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.*;

/**
 * A default theme pack item
 * @author mmagon
 * @since 24 Sep 2013
 */
@HeightWidthCSS(Width = @MeasurementCSS(250))
public class ThemePackItem extends ListItem
{

    private static final long serialVersionUID = 1L;

    private String name;
    private String cssClass;
    private String iconImageLocation;

    private Link link;
    @HeightWidthCSS(Width = @MeasurementCSS(16),
            Height = @MeasurementCSS(16))
    private Image image;
    private Span span;

    /*
     * public ThemePackItem() {
     *
     * }
     *
     * public ThemePackItem(String cssClass) { this.cssClass = cssClass; }
     */
    public ThemePackItem(String name, String cssClass)
    {
        this(name, cssClass, null);
    }

    /**
     * Creates a new theme pack item with the given values
     * @param name
     * @param cssClass
     * @param iconImageLocation 
     */
    public ThemePackItem(String name, String cssClass, String iconImageLocation)
    {
        this.name = name;
        this.cssClass = cssClass;
        this.iconImageLocation = iconImageLocation;

        link = new Link(cssClass);
        add(link);
        if (iconImageLocation != null && !iconImageLocation.isEmpty())
        {
            image = new Image(iconImageLocation);
            add(image);
        }

        span = new Span();
        span.addClass("themeName");
        span.setText(this.name);
        //span.setWidth(250);

        addClass(JQUIThemeBlocks.UI_Widget);
        addClass(JQUIThemeBlocks.UI_Widget_Input);
        addClass(JQUIThemeBlocks.UI_State_Active);
        //addClass(CSSThemeBlockNames.UI_Priority_Primary);

        link.add(span);
    }

    /**
     * Gets the class
     * @return 
     */
    public String getCssClass()
    {
        return cssClass;
    }

    /**
     * Sets the css class name
     * @param cssClass 
     */
    public void setCssClass(String cssClass)
    {
        this.cssClass = cssClass;
    }

    /**
     * Gets the icon image location
     * @return 
     */
    public String getIconImageLocation()
    {
        return iconImageLocation;
    }

    /**
     * Sets the icon image location
     * @param iconImageLocation 
     */
    public void setIconImageLocation(String iconImageLocation)
    {
        this.iconImageLocation = iconImageLocation;
    }
}
