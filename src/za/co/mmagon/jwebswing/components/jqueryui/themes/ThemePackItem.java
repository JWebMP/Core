package za.co.mmagon.jwebswing.components.jqueryui.themes;

import za.co.mmagon.jwebswing.base.html.Image;
import za.co.mmagon.jwebswing.base.html.Link;
import za.co.mmagon.jwebswing.base.html.ListItem;
import za.co.mmagon.jwebswing.base.html.Span;
import za.co.mmagon.jwebswing.htmlbuilder.css.CSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;

/**
 *
 * @author mmagon
 * @since 24 Sep 2013
 */
@CSS(Width = @MeasurementCSS(250))
public class ThemePackItem extends ListItem
{

    private String name;
    private String cssClass;
    private String iconImageLocation;

    private Link link;
    @CSS(Width = @MeasurementCSS(16),
            Height = @MeasurementCSS(16))
    private Image image;
    private Span span;

    /*
     * public ThemePackItem()
     * {
     *
     * }
     *
     * public ThemePackItem(String cssClass)
     * {
     * this.cssClass = cssClass;
     * }
     */
    public ThemePackItem(String name, String cssClass)
    {
        this(name, cssClass, null);
    }

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

    public String getCssClass()
    {
        return cssClass;
    }

    public void setCssClass(String cssClass)
    {
        this.cssClass = cssClass;
    }

    public String getIconImageLocation()
    {
        return iconImageLocation;
    }

    public void setIconImageLocation(String iconImageLocation)
    {
        this.iconImageLocation = iconImageLocation;
    }
}
