package za.co.mmagon.jwebswing.htmlbuilder.css;

import java.lang.annotation.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.Annotations.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.animatable.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.borders.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.fonts.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.heightwidth.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.interfaces.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.lists.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.margins.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.outline.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.padding.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.tables.*;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.*;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.*;

/**
 * This class is an object implementation of the CSS Annotations
 * <p>
 * @author Marc Magon
 * @since 2012/10/01
 */
public class CSSImpl extends JavaScriptPart implements CSS
{
    private static final long serialVersionUID = 1L;
    
    public CSSAnimatable animatable;
    public BackgroundCSS background;
    public BorderCSS border;
    public CustomCSS custom;
    public ColourCSS colour;
    public DisplayCSS display;
    public FontsCSS fonts;
    public HeightWidthCSS dimensions;
    public ListCSS list;
    public MarginsCSS margins;
    public OutlineCSS outline;
    public PaddingCSS padding;
    public TableCSS tables;
    public TextCSS text;
    
    /**
     * Construct a new instance
     */
    public CSSImpl()
    {
        //No need to configure anything on startup
    }

    @Override
    public CSSAnimatable animatable()
    {
        return animatable;
    }

    @Override
    public CustomCSS custom()
    {
        if(custom == null)
            custom = new CustomCSSImpl();
        return custom;
    }

    @Override
    public BackgroundCSS background()
    {
        if(background == null)
            background = new BackgroundCSSImpl();
        return background;
    }

    @Override
    public BorderCSS border()
    {
        if(border == null)
            border = new BorderCSSImpl();
        return border;
    }

    @Override
    public ColourCSS colour()
    {
        if(colour == null)
            colour = new ColourCSSImpl();
        return colour;
    }

    @Override
    public DisplayCSS display()
    {
        if(display == null)
        {
            display = new DisplayCSSImpl();
        }
        return display;
    }

    @Override
    public FontsCSS font()
    {
        if(fonts == null)
            fonts = new FontsCSSImpl();
        return fonts;
    }

    @Override
    public HeightWidthCSS dimensions()
    {
        if(dimensions == null)
            dimensions = new HeightWidthCSSImpl();
        return dimensions;
    }

    /**
     * @return 
     */
    @Override
    public ListCSS list()
    {
        if(list == null)
            list = new ListCSSImpl();
        return list;
    }

    @Override
    public MarginsCSS margins()
    {
        if(margins == null)
        {
            margins = new MarginsCSSImpl();
        }
        return margins;
    }

    @Override
    public OutlineCSS outline()
    {
        if(outline == null)
            outline = new OutlineCSSImpl();
        return outline;
    }

    /**
     * 
     * @return 
     */
    @Override
    public PaddingCSS padding()
    {
        if(padding == null)
            padding = new PaddingCSSImpl();
        return padding;
    }

    
    @Override
    public TableCSS table()
    {
        if(tables == null)
            tables = new TableCSSImpl();
        return tables;
    }

    
    @Override
    public TextCSS text()
    {
        if(text == null)
            text = new TextCSSImpl();
        return text;
    }

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return CSS.class;
    }

    
    
}
