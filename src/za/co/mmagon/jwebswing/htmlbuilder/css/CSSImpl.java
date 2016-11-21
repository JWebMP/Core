package za.co.mmagon.jwebswing.htmlbuilder.css;

import za.co.mmagon.jwebswing.htmlbuilder.css.animatable.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.borders.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.fonts.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.heightwidth.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.lists.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.margins.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.outline.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.padding.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.tables.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.*;

/**
 * This class is an object implementation of the CSS Annotations
 * <p>
 * @author Marc Magon
 * @since 2012/10/01
 */
public class CSSImpl extends CSSImplementationAdapter<CSS, CSSImpl> implements CSSImplementationClass<CSS, CSSImpl>
{

    private static final long serialVersionUID = 1L;
    /**
     * The animation CSS
     */
    private AnimateCSS animatable;
    /**
     * The getBackground css
     */
    private BackgroundCSSImpl background;
    /**
     * The getBorder CSS
     */
    private BorderCSSImpl border;
    /**
     * The getDisplay CSS
     */
    private DisplayCSSImpl display;
    /**
     * The font CSS
     */
    private FontsCSSImpl font;
    /**
     * The getDimensions CSS
     */
    private HeightWidthCSSImpl dimensions;
    /**
     * getList Style CSS
     */
    private ListCSSImpl list;
    /**
     * getMargin CSS
     */
    private MarginsCSSImpl margins;
    /**
     * getOutline CSS
     */
    private OutlineCSSImpl outline;
    /**
     * getPadding CSS
     */
    private PaddingCSSImpl padding;
    /**
     * getTable CSS
     */
    private TableCSSImpl table;
    /**
     * Text CSS
     */
    private TextCSSImpl text;

    /**
     * Construct a new instance
     */
    public CSSImpl()
    {
        //No need to configure anything on startup
    }

    /**
     * Returns the animatable object
     *
     * @return
     */
    public AnimateCSS getAnimatable()
    {
        return animatable;
    }

    /**
     * Gets the background css
     *
     * @return
     */
    public BackgroundCSSImpl getBackground()
    {
        if (background == null)
        {
            background = new BackgroundCSSImpl();
        }
        return background;
    }

    /**
     * Gets the border
     *
     * @return
     */
    public BorderCSSImpl getBorder()
    {
        if (border == null)
        {
            border = new BorderCSSImpl();
        }
        return border;
    }

    /**
     * Returns the display
     *
     * @return
     */
    public DisplayCSSImpl getDisplay()
    {
        if (display == null)
        {
            display = new DisplayCSSImpl();
        }
        return display;
    }

    /**
     *
     * @return
     */
    public FontsCSSImpl getFont()
    {
        if (font == null)
        {
            font = new FontsCSSImpl();
        }
        return font;
    }

    public HeightWidthCSSImpl getDimensions()
    {
        if (dimensions == null)
        {
            dimensions = new HeightWidthCSSImpl();
        }
        return dimensions;
    }

    /**
     * Returns the list
     *
     * @return
     */
    public ListCSSImpl getList()
    {
        if (list == null)
        {
            list = new ListCSSImpl();
        }
        return list;
    }

    /**
     * Returns the margins
     *
     * @return
     */
    public MarginsCSSImpl getMargins()
    {
        if (margins == null)
        {
            margins = new MarginsCSSImpl();
        }
        return margins;
    }

    /**
     * Returns the outline
     *
     * @return
     */
    public OutlineCSSImpl getOutline()
    {
        if (outline == null)
        {
            outline = new OutlineCSSImpl();
        }
        return outline;
    }

    /**
     * Returns the padding
     *
     * @return
     */
    public PaddingCSSImpl getPadding()
    {
        if (padding == null)
        {
            padding = new PaddingCSSImpl();
        }
        return padding;
    }

    /**
     * Returns the table
     *
     * @return
     */
    public TableCSSImpl getTable()
    {
        if (table == null)
        {
            table = new TableCSSImpl();
        }
        return table;
    }

    /**
     * Returns the text
     *
     * @return
     */
    public TextCSSImpl getText()
    {
        if (text == null)
        {
            text = new TextCSSImpl();
        }
        return text;
    }

    /**
     * Sets animatable object
     *
     * @param animatable
     */
    public void setAnimatable(AnimateCSS animatable)
    {
        this.animatable = animatable;
    }

    /**
     * Sets the background object
     *
     * @param background
     */
    public void setBackground(BackgroundCSSImpl background)
    {
        this.background = background;
    }

    /**
     * Sets the border object
     *
     * @param border
     */
    public void setBorder(BorderCSSImpl border)
    {
        this.border = border;
    }

    /**
     * Sets the display object
     *
     * @param display
     */
    public void setDisplay(DisplayCSSImpl display)
    {
        this.display = display;
    }

    /**
     * Sets the font object
     *
     * @param font
     */
    public void setFont(FontsCSSImpl font)
    {
        this.font = font;
    }

    /**
     * Sets the dimensions object
     *
     * @param dimensions
     */
    public void setDimensions(HeightWidthCSSImpl dimensions)
    {
        this.dimensions = dimensions;
    }

    /**
     * Sets the list object
     *
     * @param list
     */
    public void setList(ListCSSImpl list)
    {
        this.list = list;
    }

    /**
     * Sets the margins object
     *
     * @param margins
     */
    public void setMargins(MarginsCSSImpl margins)
    {
        this.margins = margins;
    }

    /**
     * Sets the outline object
     *
     * @param outline
     */
    public void setOutline(OutlineCSSImpl outline)
    {
        this.outline = outline;
    }

    /**
     * Sets the padding object
     *
     * @param padding
     */
    public void setPadding(PaddingCSSImpl padding)
    {
        this.padding = padding;
    }

    /**
     * Sets the table object
     *
     * @param table
     */
    public void setTable(TableCSSImpl table)
    {
        this.table = table;
    }

    /**
     * Sets the text object
     *
     * @param text
     */
    public void setText(TextCSSImpl text)
    {
        this.text = text;
    }

}
