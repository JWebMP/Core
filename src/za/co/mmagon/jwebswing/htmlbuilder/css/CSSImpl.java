package za.co.mmagon.jwebswing.htmlbuilder.css;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.annotation.Annotation;
import za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.Background;
import za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.BackgroundAttachments;
import za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.BackgroundBlendMode;
import za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.BackgroundClip;
import za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.BackgroundOrigins;
import za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.BackgroundPositions;
import za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.BackgroundSizes;
import za.co.mmagon.jwebswing.htmlbuilder.css.borders.Border;
import za.co.mmagon.jwebswing.htmlbuilder.css.borders.BorderBottomCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.colours.ColourNames;
import za.co.mmagon.jwebswing.htmlbuilder.css.composer.CSSBlockIdentifier;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Cursors;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Displays;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Overflows;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Positions;
import za.co.mmagon.jwebswing.htmlbuilder.css.enumarations.CSSTypes;
import za.co.mmagon.jwebswing.htmlbuilder.css.fonts.FontFamilies;
import za.co.mmagon.jwebswing.htmlbuilder.css.fonts.FontStyles;
import za.co.mmagon.jwebswing.htmlbuilder.css.fonts.FontVariants;
import za.co.mmagon.jwebswing.htmlbuilder.css.fonts.FontWeights;
import za.co.mmagon.jwebswing.htmlbuilder.css.heightwidth.HeightSetting;
import za.co.mmagon.jwebswing.htmlbuilder.css.heightwidth.WidthSetting;
import za.co.mmagon.jwebswing.htmlbuilder.css.lists.ListStylePosition;
import za.co.mmagon.jwebswing.htmlbuilder.css.lists.ListStyleType;
import za.co.mmagon.jwebswing.htmlbuilder.css.margins.Margin;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSS;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementCSSImpl;
import za.co.mmagon.jwebswing.htmlbuilder.css.measurement.MeasurementTypes;
import za.co.mmagon.jwebswing.htmlbuilder.css.padding.Padding;
import za.co.mmagon.jwebswing.htmlbuilder.css.padding.PaddingSetting;
import za.co.mmagon.jwebswing.htmlbuilder.css.tables.TableBorderCollapse;
import za.co.mmagon.jwebswing.htmlbuilder.css.tables.TableCaptionSides;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.TextAlignments;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.TextDecorations;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.TextDirections;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.TextTransforms;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.UnicodeBidis;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.VerticalAlignments;
import za.co.mmagon.jwebswing.htmlbuilder.css.text.WhiteSpacing;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavaScriptPart;
import za.co.mmagon.jwebswing.htmlbuilder.javascript.JavascriptPartType;

/**
 * This class is an object implementation of the CSS Annotations
 * <p>
 * @author Marc Magon
 * @since 2012/10/01
 */
public class CSSImpl extends JavaScriptPart implements CSS
{

    private static final long serialVersionUID = 1L;
    @JsonIgnore
    private CSSTypes cssObjectType;
    @JsonIgnore
    private CSSBlockIdentifier blockIdentifier;
    @JsonIgnore
    private String cssName;
    
    

    /**
     * Constructs a new CSS Implementation Object
     */
    protected CSSImpl()
    {
    }

    /**
     * The name of the block
     *
     * @param cssName
     */
    public CSSImpl(String cssName)
    {
        this(cssName, CSSTypes.None, CSSBlockIdentifier.Id);
    }

    /**
     * Constructs a new instance of the CSS Annotation with the given type
     *
     * @param cssName The name to use 
     * @param cssObjectType The type of CSS entry
     * @param blockIdentifier The Block Identifier type
     */
    public CSSImpl(String cssName, CSSTypes cssObjectType, CSSBlockIdentifier blockIdentifier)
    {
        this.cssName = cssName;
        this.cssObjectType = cssObjectType;
        this.blockIdentifier = blockIdentifier;
    }

    /**
     * Returns the CSS Object Type
     *
     * @return
     */
    @JsonIgnore
    public CSSTypes getCssObjectType()
    {
        if (cssObjectType == null)
        {
            setCssObjectType(CSSTypes.None);
        }
        return cssObjectType;
    }

    /**
     * Sets the CSS Object Type
     *
     * @param cssObjectType
     */
    @JsonIgnore
    public void setCssObjectType(CSSTypes cssObjectType)
    {
        this.cssObjectType = cssObjectType;
    }

    /**
     * Return this block identifier
     *
     * @return
     */
    @JsonIgnore
    public CSSBlockIdentifier getBlockIdentifier()
    {
        if (blockIdentifier == null)
        {
            blockIdentifier = CSSBlockIdentifier.Id;
        }
        return blockIdentifier;
    }

    /**
     * Sets this block identifier
     *
     * @param blockIdentifier
     */
    @JsonIgnore
    public void setBlockIdentifier(CSSBlockIdentifier blockIdentifier)
    {
        this.blockIdentifier = blockIdentifier;
    }

    /**
     * Gets the CSS Name
     *
     * @return
     */
    @JsonIgnore
    public String getCssName()
    {
        return cssName;
    }

    /**
     * Sets the CSS Name
     *
     * @param cssName
     */
    @JsonIgnore
    public void setCssName(String cssName)
    {
        this.cssName = cssName;
    }

    /**
     * Store and Return this object as JSON
     *
     * @return
     */
    @Override
    @JsonIgnore
    public JavascriptPartType getJavascriptType()
    {
        return JavascriptPartType.JSON;
    }

    public BackgroundAttachments Background_Attachment;
    public ColourCSS Background_Color;
    public ColourNames Background_Color$;
    public ImageCSS Background_Image;
    public ImageCSS[] Background_Image$;
    public BackgroundPositions Background_Position;
    public Repeats Background_Repeat;
    public BackgroundBlendMode Background_BlendMode;
    public BackgroundClip Background_Clip;
    public BackgroundOrigins Background_Origin;
    public BackgroundSizes Background_Size$;
    public MeasurementCSS[] Background_Size;
    public Background Background;

    /**
     * Specifies the background color of an element
     *
     * @return
     */
    @Override
    public ColourCSS Background_Color()
    {
        return Background_Color;
    }

    /**
     * Specifies the background color of an element
     *
     * @return
     */
    @Override
    public ColourNames Background_Color$()
    {
        return Background_Color$;
    }

    /**
     * Specifies one or more background images for an element
     *
     * @return
     */
    @Override
    public ImageCSS Background_Image()
    {
        return Background_Image;
    }

    /**
     * Specifies the position of a background image
     *
     * @return
     */
    @Override
    public BackgroundPositions Background_Position()
    {
        return Background_Position;
    }

    /**
     * Sets how a background image will be repeated
     *
     * @return
     */
    @Override
    public Repeats Background_Repeat()
    {
        return Background_Repeat;
    }

    /**
     * Specifies the blending mode of each background layer (color/image)
     *
     * @return
     */
    @Override
    public BackgroundBlendMode Background_BlendMode()
    {
        return Background_BlendMode;
    }

    /**
     * Specifies the painting area of the background
     *
     * @return
     */
    @Override
    public BackgroundClip Background_Clip()
    {
        return Background_Clip;
    }

    /**
     * Specifies where the background image(s) is/are positioned
     *
     * @return
     */
    @Override
    public BackgroundOrigins Background_Origin()
    {
        return Background_Origin;
    }

    /**
     * Specifies the size of the background image(s)
     *
     * @return
     */
    @Override
    public MeasurementCSS[] Background_Size()
    {
        return Background_Size;
    }

    /**
     * Specifies the size of the background image(s)
     *
     * @return
     */
    @Override
    public BackgroundSizes Background_Size$()
    {
        return Background_Size$;
    }

    /**
     * Specifies one or more background images for an element
     *
     * @return
     */
    @Override
    public ImageCSS[] Background_Image$()
    {
        return Background_Image$;
    }

    /**
     * Sets whether a background image is fixed or scrolls with the rest of the page
     * @return 
     */
    @Override
    public BackgroundAttachments Background_Attachment()
    {
        return Background_Attachment;
    }

    /**
     * Sets whether a background image is fixed or scrolls with the rest of the page
     * @param Background_Attachment
     */
    public void setBackgroundAttachment(BackgroundAttachments Background_Attachment)
    {
        this.Background_Attachment = Background_Attachment;
    }

    /**
     * Specifies the background color of an element
     *
     * @param Background_Color
     */
    public void setBackgroundColor(ColourCSS Background_Color)
    {
        this.Background_Color = Background_Color;
    }

    /**
     * Specifies the background color of an element
     *
     * @param Background_Color$
     */
    public void setBackgroundColor$(ColourNames Background_Color$)
    {
        this.Background_Color$ = Background_Color$;
    }

    /**
     * Specifies one or more background images for an element
     *
     * @param Background_Image
     */
    public void setBackgroundImage(ImageCSS Background_Image)
    {
        this.Background_Image = Background_Image;
    }

    /**
     * Specifies one or more background images for an element
     *
     * @param Background_Image$
     */
    public void setBackgroundImage$(ImageCSS[] Background_Image$)
    {
        this.Background_Image$ = Background_Image$;
    }

    /**
     * Specifies the position of a background image
     *
     * @param Background_Position
     */
    public void setBackgroundPosition(BackgroundPositions Background_Position)
    {
        this.Background_Position = Background_Position;
    }

    /**
     * Sets how a background image will be repeated
     *
     * @param Background_Repeat
     */
    public void setBackgroundRepeat(Repeats Background_Repeat)
    {
        this.Background_Repeat = Background_Repeat;
    }

    /**
     * Specifies the blending mode of each background layer (color/image)
     *
     * @param Background_BlendMode
     */
    public void setBackgroundBlendMode(BackgroundBlendMode Background_BlendMode)
    {
        this.Background_BlendMode = Background_BlendMode;
    }

    /**
     * Specifies the painting area of the background
     *
     * @param Background_Clip
     */
    public void setBackgroundClip(BackgroundClip Background_Clip)
    {
        this.Background_Clip = Background_Clip;
    }

    /**
     * Specifies where the background image(s) is/are positioned
     *
     * @param Background_Origin
     */
    public void setBackgroundOrigin(BackgroundOrigins Background_Origin)
    {
        this.Background_Origin = Background_Origin;
    }

    /**
     * Specifies the size of the background image(s)
     *
     * @param Background_Size$
     */
    public void setBackgroundSize$(BackgroundSizes Background_Size$)
    {
        this.Background_Size$ = Background_Size$;
    }

    /**
     * Specifies the size of the background image(s)
     *
     * @param Background_Size
     */
    public void setBackgroundSize(MeasurementCSS[] Background_Size)
    {
        this.Background_Size = Background_Size;
    }

    /**
     * Set different background properties in one declaration
     *
     * @return
     */
    @Override
    public za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.Background Background()
    {
        return Background;
    }

    /**
     * Set different background properties in one declaration
     *
     * @param Background
     */
    public void setBackground(za.co.mmagon.jwebswing.htmlbuilder.css.backgrounds.Background Background)
    {
        this.Background = Background;
    }

    public ColourCSS Border_Bottom_Color;
    public ColourNames Border_Bottom_Color$;
    public BorderStyles Border_Bottom_Style;
    public MeasurementCSS Border_Bottom_Width;
    public ColourCSS Border_Left_Color;
    public ColourNames Border_Left_Color$;
    public BorderStyles Border_Left_Style;
    public MeasurementCSS Border_Left_Width;
    public ColourCSS Border_Right_Color;
    public ColourNames Border_Right_Color$;
    public BorderStyles Border_Right_Style;
    public MeasurementCSS Border_Right_Width;
    public ColourCSS Border_Top_Color;
    public ColourNames Border_Top_Color$;
    public BorderStyles Border_Top_Style;
    public MeasurementCSS Border_Top_Width;

    public Border Border;
    public BorderBottomCSS Border_Bottom;
    public BorderBottomCSS Border_Left;
    public BorderBottomCSS Border_Right;
    public BorderBottomCSS Border_Top;

    /**
     * Sets the color of the bottom border
     *
     * @return
     */
    @Override
    public ColourCSS Border_Bottom_Color()
    {
        return Border_Bottom_Color;
    }

    /**
     * sets the colour of the bottom border
     *
     * @return
     */
    @Override
    public ColourNames Border_Bottom_Color$()
    {
        return Border_Bottom_Color$;
    }

    /**
     * Sets the style of the bottom border
     *
     * @return
     */
    @Override
    public BorderStyles Border_Bottom_Style()
    {
        return Border_Bottom_Style;
    }

    /**
     * Sets the width of the bottom border
     *
     * @return
     */
    @Override
    public MeasurementCSS Border_Bottom_Width()
    {
        return Border_Bottom_Width;
    }

    /**
     * Gets the colour of the bottom left border
     *
     * @return
     */
    @Override
    public ColourCSS Border_Left_Color()
    {
        return Border_Left_Color;
    }

    /**
     * Gets the colour of the left border
     *
     * @return
     */
    @Override
    public ColourNames Border_Left_Color$()
    {
        return Border_Left_Color$;
    }

    /**
     * Gets the style of the left border
     *
     * @return
     */
    @Override
    public BorderStyles Border_Left_Style()
    {
        return Border_Left_Style;
    }

    /**
     * Sets the style of the left border
     *
     * @return
     */
    @Override
    public MeasurementCSS Border_Left_Width()
    {
        return Border_Left_Width;
    }

    /**
     * Gets the colour of the right border
     *
     * @return
     */
    @Override
    public ColourCSS Border_Right_Color()
    {
        return Border_Right_Color;
    }

    /**
     * Sets the colour of the right border
     *
     * @return
     */
    @Override
    public ColourNames Border_Right_Color$()
    {
        return Border_Right_Color$;
    }

    /**
     * Gets the style of the right border
     *
     * @return
     */
    @Override
    public BorderStyles Border_Right_Style()
    {
        return Border_Right_Style;
    }

    /**
     * Gets the width of the right border
     *
     * @return
     */
    @Override
    public MeasurementCSS Border_Right_Width()
    {
        return Border_Right_Width;
    }

    /**
     * Sets the width of the right border
     *
     * @return
     */
    @Override
    public ColourCSS Border_Top_Color()
    {
        return Border_Top_Color;
    }

    /**
     * Sets the width of the top border
     *
     * @return
     */
    @Override
    public ColourNames Border_Top_Color$()
    {
        return Border_Top_Color$;
    }

    /**
     * Gets the style of the top border
     *
     * @return
     */
    @Override
    public BorderStyles Border_Top_Style()
    {
        return Border_Top_Style;
    }

    /**
     * Sets the style of the top border
     *
     * @return
     */
    @Override
    public MeasurementCSS Border_Top_Width()
    {
        return Border_Top_Width;
    }

    /**
     * Sets the border bottom color
     *
     * @param Border_Bottom_Color
     */
    public void setBorderBottomColor(ColourCSS Border_Bottom_Color)
    {
        this.Border_Bottom_Color = Border_Bottom_Color;
    }

    /**
     * Sets the border bottom color
     *
     * @param Border_Bottom_Color$
     */
    public void setBorderBottomColor$(ColourNames Border_Bottom_Color$)
    {
        this.Border_Bottom_Color$ = Border_Bottom_Color$;
    }

    /**
     * Sets the style of the bottom border
     *
     * @param Border_Bottom_Style
     */
    public void setBorderBottomStyle(BorderStyles Border_Bottom_Style)
    {
        this.Border_Bottom_Style = Border_Bottom_Style;
    }

    /**
     * Sets the width of the bottom border
     *
     * @param Border_Bottom_Width
     */
    public void setBorderBottomWidth(MeasurementCSS Border_Bottom_Width)
    {
        this.Border_Bottom_Width = Border_Bottom_Width;
    }

    /**
     * Sets the colour of the left border
     *
     * @param Border_Left_Color
     */
    public void setBorderLeftColor(ColourCSS Border_Left_Color)
    {
        this.Border_Left_Color = Border_Left_Color;
    }

    /**
     * Sets the colour of the left border
     *
     * @param Border_Left_Color$
     */
    public void setBorderLeftColor$(ColourNames Border_Left_Color$)
    {
        this.Border_Left_Color$ = Border_Left_Color$;
    }

    /**
     * Sets the style of the left border
     *
     * @param Border_Left_Style
     */
    public void setBorderLeftStyle(BorderStyles Border_Left_Style)
    {
        this.Border_Left_Style = Border_Left_Style;
    }

    /**
     * Sets the width of the left border
     *
     * @param Border_Left_Width
     */
    public void setBorderLeftWidth(MeasurementCSS Border_Left_Width)
    {
        this.Border_Left_Width = Border_Left_Width;
    }

    /**
     * Sets the colour of the right border
     *
     * @param Border_Right_Color
     */
    public void setBorderRightColor(ColourCSS Border_Right_Color)
    {
        this.Border_Right_Color = Border_Right_Color;
    }

    /**
     * Sets the colour of the right border
     *
     * @param Border_Right_Color$
     */
    public void setBorderRightColor$(ColourNames Border_Right_Color$)
    {
        this.Border_Right_Color$ = Border_Right_Color$;
    }

    /**
     * Sets the style of the right border
     *
     * @param Border_Right_Style
     */
    public void setBorderRightStyle(BorderStyles Border_Right_Style)
    {
        this.Border_Right_Style = Border_Right_Style;
    }

    /**
     * Sets the width of the right border
     *
     * @param Border_Right_Width
     */
    public void setBorderRightWidth(MeasurementCSS Border_Right_Width)
    {
        this.Border_Right_Width = Border_Right_Width;
    }

    /**
     * Sets the top colour for the border
     *
     * @param Border_Top_Color
     */
    public void setBorderTopColor(ColourCSS Border_Top_Color)
    {
        this.Border_Top_Color = Border_Top_Color;
    }

    /**
     * Sets the top colour for the border
     *
     * @param Border_Top_Color$
     */
    public void setBorderTopColor$(ColourNames Border_Top_Color$)
    {
        this.Border_Top_Color$ = Border_Top_Color$;
    }

    /**
     * Sets the top style for the border
     * <p>
     * @param Border_Top_Style
     */
    public void setBorderTopStyle(BorderStyles Border_Top_Style)
    {
        this.Border_Top_Style = Border_Top_Style;
    }

    /**
     * Sets the top width for the border
     * <p>
     * @param Border_Top_Width
     */
    public void setBorderTopWidth(MeasurementCSS Border_Top_Width)
    {
        this.Border_Top_Width = Border_Top_Width;
    }

    /**
     * Provides a short hand for setting all border at once
     *
     * @return
     */
    @Override
    public za.co.mmagon.jwebswing.htmlbuilder.css.borders.Border Border()
    {
        return Border;
    }

    /**
     * Provides a short hand for setting bottom border
     *
     * @return
     */
    @Override
    public BorderBottomCSS Border_Bottom()
    {
        return Border_Bottom;
    }

    /**
     * Provides a short hand for setting bottom border
     *
     * @return
     */
    @Override
    public BorderBottomCSS Border_Left()
    {
        return Border_Left;
    }

    /**
     * Provides a short hand for setting bottom border
     *
     * @return
     */
    @Override
    public BorderBottomCSS Border_Right()
    {
        return Border_Right;
    }

    /**
     * Provides a short hand for setting bottom border
     *
     * @return
     */
    @Override
    public BorderBottomCSS Border_Top()
    {
        return Border_Top;
    }

    public Displays Display;
    public Cursors Cursor;
    public Overflows Overflow;
    public Overflows Overflow_X;
    public Overflows Overflow_Y;
    public Positions Position;
    public za.co.mmagon.jwebswing.htmlbuilder.css.displays.Float Float;
    public MeasurementCSS Z_Index;
    public MeasurementCSS Bottom;
    public MeasurementCSS Left;
    public MeasurementCSS Right;
    public MeasurementCSS Top;

    /**
     * Sets the Display Format
     * The display Property
     * <p>
     * The display property specifies if/how an element is displayed.
     * <p>
     * Every HTML element has a default display value depending on what type of element it is. The default display value for most elements is block or inline.
     * Block-level Elements
     * <p>
     * A block-level element always starts on a new line and takes up the full width available (stretches out to the left and right as far as it can).
     * The &lt;div&gt; element is a block-level element.
     * <p>
     * Examples of block-level elements:
     * <p>
     * &lt;div&gt;
     * &lt;h1&gt; - &lt;h6&gt;
     * <p>
     * &lt;form&gt;
     * &lt;header&gt;
     * &lt;footer&gt;
     * &lt;section&gt;
     * <p>
     * Inline Elements
     * <p>
     * An inline element does not start on a new line and only takes up as much width as necessary.
     * <p>
     * This is an inline &lt;span&gt; element inside a paragraph.
     * <p>
     * Examples of inline elements:
     * <p>
     * &lt;span&gt;
     * &lt;a&gt;
     * &lt;img&gt;
     *
     * @return
     */
    @Override
    public Displays Display()
    {
        return Display;
    }

    /**
     * Sets the mouse cursor
     *
     * @return
     */
    @Override
    public Cursors Cursor()
    {
        return Cursor;
    }

    /**
     * Sets the overflow
     *
     * @return
     */
    @Override
    public Overflows Overflow()
    {
        return Overflow;
    }

    /**
     * Sets the Horizontal Overflow
     *
     * @return
     */
    @Override
    public Overflows Overflow_X()
    {
        return Overflow_X;
    }

    /**
     * Sets the vertical overflow
     *
     * @return
     */
    @Override
    public Overflows Overflow_Y()
    {
        return Overflow_Y;
    }

    /**
     * Sets the display position
     *
     * @return
     */
    @Override
    public Positions Position()
    {
        return Position;
    }

    /**
     * Sets the component floating
     *
     * @return
     */
    @Override
    public za.co.mmagon.jwebswing.htmlbuilder.css.displays.Float Float()
    {
        return Float;
    }

    /**
     * Sets the Z-Index
     *
     * @return
     */
    @Override
    public MeasurementCSS Z_Index()
    {
        return Z_Index;
    }

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @return
     */
    @Override
    public MeasurementCSS Bottom()
    {
        return Bottom;
    }

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @return
     */
    @Override
    public MeasurementCSS Left()
    {
        return Left;
    }

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @return
     */
    @Override
    public MeasurementCSS Right()
    {
        return Right;
    }

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @return
     */
    @Override
    public MeasurementCSS Top()
    {
        return Top;
    }

    /**
     * Sets the Display Format
     * The display Property
     * <p>
     * The display property specifies if/how an element is displayed.
     * <p>
     * Every HTML element has a default display value depending on what type of element it is. The default display value for most elements is block or inline.
     * Block-level Elements
     * <p>
     * A block-level element always starts on a new line and takes up the full width available (stretches out to the left and right as far as it can).
     * The &lt;div&gt; element is a block-level element.
     * <p>
     * Examples of block-level elements:
     * <p>
     * &lt;div&gt;
     * &lt;h1&gt; - &lt;h6&gt;
     * <p>
     * &lt;form&gt;
     * &lt;header&gt;
     * &lt;footer&gt;
     * &lt;section&gt;
     * <p>
     * Inline Elements
     * <p>
     * An inline element does not start on a new line and only takes up as much width as necessary.
     * <p>
     * This is an inline &lt;span&gt; element inside a paragraph.
     * <p>
     * Examples of inline elements:
     * <p>
     * &lt;span&gt;
     * &lt;a&gt;
     * &lt;img&gt;
     *
     * @param Display
     */
    public void setDisplay(Displays Display)
    {
        this.Display = Display;
    }

    /**
     * Sets the mouse cursor
     *
     * @param Cursor
     */
    public void setCursor(Cursors Cursor)
    {
        this.Cursor = Cursor;
    }

    /**
     * Sets the overflow
     *
     * @param Overflow
     */
    public void setOverflow(Overflows Overflow)
    {
        this.Overflow = Overflow;
    }

    /**
     * Sets the horizontal overflow
     *
     * @param Overflow_X
     */
    public void setOverflowX(Overflows Overflow_X)
    {
        this.Overflow_X = Overflow_X;
    }

    /**
     * Sets the vertical overflow
     *
     * @param OverflowY
     */
    public void setOverflowY(Overflows OverflowY)
    {
        this.Overflow_Y = OverflowY;
    }

    /**
     * Sets the display position
     *
     * @param Position
     */
    public void setPosition(Positions Position)
    {
        this.Position = Position;
    }

    /**
     * Sets the flow to be applied
     *
     * @param Float
     */
    public void setFloat(za.co.mmagon.jwebswing.htmlbuilder.css.displays.Float Float)
    {
        this.Float = Float;
    }

    /**
     * Sets the Z-Index
     *
     * @param Z_Index
     */
    public void setZIndex(MeasurementCSS Z_Index)
    {
        this.Z_Index = Z_Index;
    }

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @param Bottom
     */
    public void setBottom(MeasurementCSS Bottom)
    {
        this.Bottom = Bottom;
    }

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @param Left
     */
    public void setLeft(MeasurementCSS Left)
    {
        this.Left = Left;
    }

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @param Right
     */
    public void setRight(MeasurementCSS Right)
    {
        this.Right = Right;
    }

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @param Top
     */
    public void setTop(MeasurementCSS Top)
    {
        this.Top = Top;
    }

    public FontFamilies Font_Family;
    public MeasurementCSSImpl Font_Size;
    public FontStyles Font_Style;
    public FontVariants Font_Variant;
    public FontWeights Font_Weight;
    public Integer Font_Weight$;

    ;

    /**
     * Returns the font family assigned
     *
     * @return
     */
    @Override
    public FontFamilies Font_Family()
    {
        return Font_Family;
    }

    /**
     * Sets the font family assigned
     *
     * @param Font_Family
     */
    public void setFont_Family(FontFamilies Font_Family)
    {
        this.Font_Family = Font_Family;
    }

    /**
     * Sets the font size
     *
     * @return
     */
    @Override
    public MeasurementCSSImpl Font_Size()
    {
        return Font_Size;
    }

    /**
     * sets the font size
     *
     * @param Font_Size
     */
    public void setFontSize(MeasurementCSSImpl Font_Size)
    {
        this.Font_Size = Font_Size;
    }

    /**
     * Set the font style
     *
     * @return
     */
    @Override
    public FontStyles Font_Style()
    {
        return Font_Style;
    }

    /**
     * Set the font style
     *
     * @param Font_Style
     */
    public void setFontStyle(FontStyles Font_Style)
    {
        this.Font_Style = Font_Style;
    }

    /**
     * Sets the applicable font variant
     *
     * @return
     */
    @Override
    public FontVariants Font_Variant()
    {
        return Font_Variant;
    }

    /**
     * Sets the applicable font variant
     *
     * @param Font_Variant
     */
    public void setFontVariant(FontVariants Font_Variant)
    {
        this.Font_Variant = Font_Variant;
    }

    /**
     * Sets the font weight
     *
     * @return
     */
    @Override
    public FontWeights Font_Weight()
    {
        return Font_Weight;
    }

    /**
     * Sets the font weight
     *
     * @param Font_Weight
     */
    public void setFontWeight(FontWeights Font_Weight)
    {
        this.Font_Weight = Font_Weight;
    }

    /**
     * Sets the font weight
     *
     * @return
     */
    @Override
    public int Font_Weight$()
    {
        return Font_Weight$;
    }

    /**
     * Sets the font weight
     *
     * @param Font_Weight$
     */
    public void setFontWeight$(int Font_Weight$)
    {
        this.Font_Weight$ = Font_Weight$;
    }

    public MeasurementCSS Height;
    public HeightSetting Height$;
    public MeasurementCSS Width;
    public WidthSetting Width$;
    public MeasurementCSS Min_Height;
    public MeasurementCSS Max_Height;
    public MeasurementCSS Min_Width;
    public MeasurementCSS Max_Width;

    /**
     * Sets the height of an element
     *
     * @return
     */
    @Override
    public MeasurementCSS Height()
    {
        return Height;
    }

    /**
     * Sets the height of an element
     *
     * @return
     */
    @Override
    public HeightSetting Height$()
    {
        return Height$;
    }

    /**
     * Sets the width of an element
     *
     * @return
     */
    @Override
    public MeasurementCSS Width()
    {
        return Width;
    }

    /**
     * Sets the width of an element
     *
     * @return
     */
    @Override
    public WidthSetting Width$()
    {
        return Width$;
    }

    /**
     * Sets the min height of an element
     *
     * @return
     */
    @Override
    public MeasurementCSS Min_Height()
    {
        return Min_Height;
    }

    /**
     * Sets the max height of an element
     *
     * @return
     */
    @Override
    public MeasurementCSS Max_Height()
    {
        return Max_Height;
    }

    /**
     * Sets the min width of an element
     *
     * @return
     */
    @Override
    public MeasurementCSS Min_Width()
    {
        return Min_Width;
    }

    /**
     * Sets the max height of an element
     *
     * @return
     */
    @Override
    public MeasurementCSS Max_Width()
    {
        return Max_Width;
    }

    /**
     * Sets the height of an element
     *
     * @param Height
     */
    public void setHeight(MeasurementCSS Height)
    {
        this.Height = Height;
    }

    /**
     * Sets the height of an element
     *
     * @param Height$
     */
    public void setHeight$(HeightSetting Height$)
    {
        this.Height$ = Height$;
    }

    /**
     * Sets the width of an element
     *
     * @param Width
     */
    public void setWidth(MeasurementCSS Width)
    {
        this.Width = Width;
    }

    /**
     * Sets the width of an element
     *
     * @param Width$
     */
    public void setWidth$(WidthSetting Width$)
    {
        this.Width$ = Width$;
    }

    /**
     * Sets the width of an element
     *
     * @param Min_Height
     */
    public void setMinHeight(MeasurementCSS Min_Height)
    {
        this.Min_Height = Min_Height;
    }

    /**
     * Sets the width of an element
     *
     * @param Max_Height
     */
    public void setMaxHeight(MeasurementCSS Max_Height)
    {
        this.Max_Height = Max_Height;
    }

    /**
     * Sets the width of an element
     *
     * @param Min_Width
     */
    public void setMinWidth(MeasurementCSS Min_Width)
    {
        this.Min_Width = Min_Width;
    }

    /**
     * Sets the width of an element
     *
     * @param Max_Width
     */
    public void setMaxWidth(MeasurementCSS Max_Width)
    {
        this.Max_Width = Max_Width;
    }

    /**
     * Convenience method setting the Width
     * <p>
     * @param Width           The width to set
     * @param measurementType The measurement type
     */
    public void setWidth(int Width, MeasurementTypes measurementType)
    {
        setWidth(new MeasurementCSSImpl(Width, measurementType));
    }

    /**
     * Convenience method setting the inner HTML value - Default of Pixels
     * <p>
     * @param Width Width
     */
    public void setWidth(int Width)
    {
        setWidth(Width, MeasurementTypes.Pixels);
    }

    /**
     * Convenience method setting the Width
     * <p>
     * @param Width           The width to set
     * @param measurementType The measurement type
     */
    public void setHeight(int Width, MeasurementTypes measurementType)
    {
        setHeight(new MeasurementCSSImpl(Width, measurementType));
    }

    /**
     * Convenience method setting the inner HTML value - Default of Pixels
     * <p>
     * @param Width Width
     */
    public void setHeight(int Width)
    {
        setHeight(Width, MeasurementTypes.Pixels);
    }

    /**
     * Convenience method setting the Width
     * <p>
     * @param Width           The width to set
     * @param measurementType The measurement type
     */
    public void setMinWidth(int Width, MeasurementTypes measurementType)
    {
        setMinWidth(new MeasurementCSSImpl(Width, measurementType));
    }

    /**
     * Convenience method setting the inner HTML value - Default of Pixels
     * <p>
     * @param Width Width
     */
    public void setMinWidth(int Width)
    {
        setMinWidth(Width, MeasurementTypes.Pixels);
    }

    /**
     * Convenience method setting the Width
     * <p>
     * @param Width           The width to set
     * @param measurementType The measurement type
     */
    public void setMaxWidth(int Width, MeasurementTypes measurementType)
    {
        setMaxWidth(new MeasurementCSSImpl(Width, measurementType));
    }

    /**
     * Convenience method setting the inner HTML value - Default of Pixels
     * <p>
     * @param Width Width
     */
    public void setMaxWidth(int Width)
    {
        setMaxWidth(Width, MeasurementTypes.Pixels);
    }

    /**
     * Convenience method setting the Width
     * <p>
     * @param Width           The width to set
     * @param measurementType The measurement type
     */
    public void setMinHeight(int Width, MeasurementTypes measurementType)
    {
        setMinHeight(new MeasurementCSSImpl(Width, measurementType));
    }

    /**
     * Convenience method setting the inner HTML value - Default of Pixels
     * <p>
     * @param Width Width
     */
    public void setMinHeight(int Width)
    {
        setMinHeight(Width, MeasurementTypes.Pixels);
    }

    /**
     * Convenience method setting the Width
     * <p>
     * @param Width           The width to set
     * @param measurementType The measurement type
     */
    public void setMaxHeight(int Width, MeasurementTypes measurementType)
    {
        setMaxHeight(new MeasurementCSSImpl(Width, measurementType));
    }

    /**
     * Convenience method setting the inner HTML value - Default of Pixels
     * <p>
     * @param Width Width
     */
    public void setMaxHeight(int Width)
    {
        setMaxHeight(Width, MeasurementTypes.Pixels);
    }

    public ImageCSS List_Style_Image;
    public ListStylePosition List_Style_Position;
    public ListStyleType List_Style_Type;

    /**
     * Returns the Image associated with the list style item
     *
     * @return
     */
    @Override
    public ImageCSS List_Style_Image()
    {
        return List_Style_Image;
    }

    /**
     * Returns the position for the list bullet
     *
     * @return
     */
    @Override
    public ListStylePosition List_Style_Position()
    {
        return List_Style_Position;
    }

    /**
     * Defines the bullet type for a list
     *
     * @return
     */
    @Override
    public ListStyleType List_Style_Type()
    {
        return List_Style_Type;
    }

    /**
     * Sets the list style image
     * @param List_Style_Image 
     */
    public void setListStyleImage(ImageCSS List_Style_Image)
    {
        this.List_Style_Image = List_Style_Image;
    }

    /**
     * Sets the list style position
     * @param List_Style_Position 
     */
    public void setListStylePosition(ListStylePosition List_Style_Position)
    {
        this.List_Style_Position = List_Style_Position;
    }

    /**
     * Sets the list style type
     * @param List_Style_Type 
     */
    public void setListStyleType(ListStyleType List_Style_Type)
    {
        this.List_Style_Type = List_Style_Type;
    }
    
    

    public Margin Margin;
    public MeasurementCSS Margin_Right;
    public MarginSetting Margin_Right$;
    public MeasurementCSS Margin_Left;
    public MarginSetting Margin_Left$;
    public MeasurementCSS Margin_Top;
    public MarginSetting Margin_Top$;
    public MeasurementCSS Margin_Bottom;
    public MarginSetting Margin_Bottom$;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MeasurementCSS Margin_Right()
    {
        return Margin_Right;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MarginSetting Margin_Right$()
    {
        return Margin_Right$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MeasurementCSS Margin_Left()
    {
        return Margin_Left;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MarginSetting Margin_Left$()
    {
        return Margin_Left$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MeasurementCSS Margin_Top()
    {
        return Margin_Top;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * @param Margin_Right
     */
    public void setMarginRight(MeasurementCSS Margin_Right)
    {
        this.Margin_Right = Margin_Right;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * @param Margin_Right$
     */
    public void setMarginRight$(MarginSetting Margin_Right$)
    {
        this.Margin_Right$ = Margin_Right$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     * @param Margin_Left
     */
    public void setMarginLeft(MeasurementCSS Margin_Left)
    {
        this.Margin_Left = Margin_Left;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     * @param Margin_Left$
     */
    public void setMarginLeft$(MarginSetting Margin_Left$)
    {
        this.Margin_Left$ = Margin_Left$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     * @param Margin_Top
     */
    public void setMarginTop(MeasurementCSS Margin_Top)
    {
        this.Margin_Top = Margin_Top;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MarginSetting Margin_Top$()
    {
        return Margin_Top$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     */
    @Override
    public MeasurementCSS Margin_Bottom()
    {
        return Margin_Bottom;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     */
    @Override
    public MarginSetting Margin_Bottom$()
    {
        return Margin_Bottom$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @param Margin_Top$
     */
    public void setMargin_Top$(MarginSetting Margin_Top$)
    {
        this.Margin_Top$ = Margin_Top$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @param Margin_Bottom
     */
    public void setMargin_Bottom(MeasurementCSS Margin_Bottom)
    {
        this.Margin_Bottom = Margin_Bottom;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @param Margin_Bottom$
     */
    public void setMargin_Bottom$(MarginSetting Margin_Bottom$)
    {
        this.Margin_Bottom$ = Margin_Bottom$;
    }

    /**
     * Shorthand for Margin
     *
     * @return
     */
    @Override
    public za.co.mmagon.jwebswing.htmlbuilder.css.margins.Margin Margin()
    {
        return Margin;
    }

    /**
     * Set the shorthand for the margin.
     * <p>
     * If the margin property has four values:
     * <p>
     * <p>
     * margin: 25px 50px 75px 100px;
     * <p>
     * top margin is 25px
     * <p>
     * right margin is 50px
     * <p>
     * bottom margin is 75px
     * <p>
     * left margin is 100px
     * <p>
     * <p>
     * If the margin property has three values:
     * <p>
     * <p>
     * margin: 25px 50px 75px;
     * <p>
     * top margin is 25px
     * <p>
     * right and left margins are 50px
     * <p>
     * bottom margin is 75px
     * <p>
     * <p>
     * If the margin property has two values:
     * <p>
     * <p>
     * margin: 25px 50px;
     * <p>
     * top and bottom margins are 25px
     * <p>
     * right and left margins are 50px
     * <p>
     * <p>
     * If the margin property has one value:
     * <p>
     * <p>
     * margin: 25px;
     * <p>
     * all four margins are 25px
     *
     *
     * @param Margin
     */
    public void setMargin(za.co.mmagon.jwebswing.htmlbuilder.css.margins.Margin Margin)
    {
        this.Margin = Margin;
    }

    public ColourCSS Outline_Color;
    public ColourNames Outline_Color$;
    public BorderStyles Outline_Style;
    public MeasurementCSS Outline_Width;
    public MeasurementCSS Outline_Offset;

    /**
     * Sets the color of an outline
     *
     * @return
     */
    @Override
    public ColourCSS Outline_Color()
    {
        return Outline_Color;
    }

    /**
     * Sets the color of an outline
     *
     * @return
     */
    @Override
    public ColourNames Outline_Color$()
    {
        return Outline_Color$;
    }

    /**
     * Sets the Outline Style
     *
     * @return
     */
    @Override
    public BorderStyles Outline_Style()
    {
        return Outline_Style;
    }

    /**
     * Sets the outline Width
     *
     * @return
     */
    @Override
    public MeasurementCSS Outline_Width()
    {
        return Outline_Width;
    }

    /**
     * Sets the outline Offset
     *
     * @return
     */
    @Override
    public MeasurementCSS Outline_Offset()
    {
        return Outline_Offset;
    }

    /**
     * Sets the outline Color
     * @param Outline_Color
     */
    public void setOutlineColor(ColourCSS Outline_Color)
    {
        this.Outline_Color = Outline_Color;
    }

    /**
     * Sets the outline Color
     * @param Outline_Color$
     */
    public void setOutlineColor$(ColourNames Outline_Color$)
    {
        this.Outline_Color$ = Outline_Color$;
    }

    /**
     * Sets the Outline Style
     *
     * @param Outline_Style
     */
    public void setOutline_Style(BorderStyles Outline_Style)
    {
        this.Outline_Style = Outline_Style;
    }

    /**
     * Sets the outline width
     * @param Outline_Width
     */
    public void setOutlineWidth(MeasurementCSS Outline_Width)
    {
        this.Outline_Width = Outline_Width;
    }

    /**
     * Sets the outline offset
     * @param Outline_Offset
     */
    public void setOutline_Offset(MeasurementCSS Outline_Offset)
    {
        this.Outline_Offset = Outline_Offset;
    }

    public Padding Padding;
    public MeasurementCSS Padding_Right;
    public PaddingSetting Padding_Right$;
    public MeasurementCSS Padding_Left;
    public PaddingSetting Padding_Left$;
    public MeasurementCSS Padding_Top;
    public PaddingSetting Padding_Top$;
    public MeasurementCSS Padding_Bottom;
    public PaddingSetting Padding_Bottom$;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MeasurementCSS Padding_Right()
    {
        return Padding_Right;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public PaddingSetting Padding_Right$()
    {
        return Padding_Right$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MeasurementCSS Padding_Left()
    {
        return Padding_Left;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public PaddingSetting Padding_Left$()
    {
        return Padding_Left$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MeasurementCSS Padding_Top()
    {
        return Padding_Top;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     * @param Padding_Right
     */
    public void setPaddingRight(MeasurementCSS Padding_Right)
    {
        this.Padding_Right = Padding_Right;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     * @param Padding_Right$
     */
    public void setPaddingRight$(PaddingSetting Padding_Right$)
    {
        this.Padding_Right$ = Padding_Right$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     * @param Padding_Left
     */
    public void setPaddingLeft(MeasurementCSS Padding_Left)
    {
        this.Padding_Left = Padding_Left;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     * @param Padding_Left$
     */
    public void setPaddingLeft$(PaddingSetting Padding_Left$)
    {
        this.Padding_Left$ = Padding_Left$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     * @param Padding_Top
     */
    public void setPaddingTop(MeasurementCSS Padding_Top)
    {
        this.Padding_Top = Padding_Top;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     * <p>
     * <p>
     */
    @Override
    public PaddingSetting Padding_Top$()
    {
        return Padding_Top$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public MeasurementCSS Padding_Bottom()
    {
        return Padding_Bottom;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    @Override
    public PaddingSetting Padding_Bottom$()
    {
        return Padding_Bottom$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @param Padding_Top$
     */
    public void setPaddingTop$(PaddingSetting Padding_Top$)
    {
        this.Padding_Top$ = Padding_Top$;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @param Padding_Bottom
     */
    public void setPaddingBottom(MeasurementCSS Padding_Bottom)
    {
        this.Padding_Bottom = Padding_Bottom;
    }

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @param Padding_Bottom$
     */
    public void setPaddingBottom$(PaddingSetting Padding_Bottom$)
    {
        this.Padding_Bottom$ = Padding_Bottom$;
    }

    /**
     * Shorthand for Padding
     *
     * @return
     */
    @Override
    public za.co.mmagon.jwebswing.htmlbuilder.css.padding.Padding Padding()
    {
        return Padding;
    }

    /**
     * Set the shorthand for the margin.
     * <p>
     * If the margin property has four values:
     * <p>
     * <p>
     * margin: 25px 50px 75px 100px;
     * <p>
     * top margin is 25px
     * <p>
     * right margin is 50px
     * <p>
     * bottom margin is 75px
     * <p>
     * left margin is 100px
     * <p>
     * <p>
     * If the margin property has three values:
     * <p>
     * <p>
     * margin: 25px 50px 75px;
     * <p>
     * top margin is 25px
     * <p>
     * right and left margins are 50px
     * <p>
     * bottom margin is 75px
     * <p>
     * <p>
     * If the margin property has two values:
     * <p>
     * <p>
     * margin: 25px 50px;
     * <p>
     * top and bottom margins are 25px
     * <p>
     * right and left margins are 50px
     * <p>
     * <p>
     * If the margin property has one value:
     * <p>
     * <p>
     * margin: 25px;
     * <p>
     * all four margins are 25px
     *
     *
     * @param Padding
     */
    public void setPadding(za.co.mmagon.jwebswing.htmlbuilder.css.padding.Padding Padding)
    {
        this.Padding = Padding;
    }

    public TableBorderCollapse Border_Collapse;
    public TableCaptionSides Table_Caption_Side;
    public MeasurementCSS Border_Spacing;

    /**
     * Specifies whether or not table borders should be collapsed
     *
     * @return
     */
    @Override
    public TableBorderCollapse Border_Collapse()
    {
        return Border_Collapse;
    }

    /**
     * Where to place the caption
     *
     * @return
     */
    @Override
    public TableCaptionSides Table_Caption_Side()
    {
        return Table_Caption_Side;
    }

    /**
     * What the border spacing should be
     *
     * @return
     */
    @Override
    public MeasurementCSS Border_Spacing()
    {
        return Border_Spacing;
    }

    /**
     * Specifies whether or not table borders should be collapsed
     *
     * @param Border_Collapse
     */
    public void setBorderCollapse(TableBorderCollapse Border_Collapse)
    {
        this.Border_Collapse = Border_Collapse;
    }

    /**
     * Sets which side the caption must be on
     *
     * @param Table_Caption_Side
     */
    public void setTableCaptionSide(TableCaptionSides Table_Caption_Side)
    {
        this.Table_Caption_Side = Table_Caption_Side;
    }

    /**
     * Specifies whether or not table borders should be collapsed
     *
     * @param Border_Spacing
     */
    public void setBorderSpacing(MeasurementCSS Border_Spacing)
    {
        this.Border_Spacing = Border_Spacing;
    }

    public ColourCSS Color;
    public ColourNames Color$;
    public TextDirections Direction;
    public MeasurementCSS Letter_Spacing;
    public MeasurementCSS Line_Height;
    public TextAlignments Text_Align;
    public TextDecorations Text_Decoration;
    public MeasurementCSS Text_Indent;
    public TextTransforms Text_Transform;
    public UnicodeBidis Unicode_Bidi;
    public VerticalAlignments Vertical_Align;
    public WhiteSpacing White_Space;
    public MeasurementCSS Word_Spacing;

    /**
     * Sets the colour
     *
     * @return
     */
    @Override
    public ColourCSS Color()
    {
        return Color;
    }

    /**
     * Sets the color
     *
     * @return
     */
    @Override
    public ColourNames Color$()
    {
        return Color$;
    }

    /**
     * Sets the Text Direction
     *
     * @return
     */
    @Override
    public TextDirections Direction()
    {
        return Direction;
    }

    /**
     * Sets the letter spacing
     *
     * @return
     */
    @Override
    public MeasurementCSS Letter_Spacing()
    {
        return Letter_Spacing;
    }

    /**
     * Sets the Line Height
     *
     * @return
     */
    @Override
    public MeasurementCSS Line_Height()
    {
        return Line_Height;
    }

    /**
     * Sets the Text Alignment
     *
     * @return
     */
    @Override
    public TextAlignments Text_Align()
    {
        return Text_Align;
    }

    /**
     * Sets the Text Direction
     *
     * @return
     */
    @Override
    public TextDecorations Text_Decoration()
    {
        return Text_Decoration;
    }

    /**
     * Sets the Text Indentation
     *
     * @return
     */
    @Override
    public MeasurementCSS Text_Indent()
    {
        return Text_Indent;
    }

    /**
     * Sets any text transformations
     *
     * @return
     */
    @Override
    public TextTransforms Text_Transform()
    {
        return Text_Transform;
    }

    /**
     * Used together with the direction property to set or return whether the text should be overridden to
     * <p>
     * support multiple languages in the same document
     *
     * @return
     */
    @Override
    public UnicodeBidis Unicode_Bidi()
    {
        return Unicode_Bidi;
    }

    /**
     * Sets the Vertical Alignment
     *
     * @return
     */
    @Override
    public VerticalAlignments Vertical_Align()
    {
        return Vertical_Align;
    }

    /**
     * Sets the white spacing to be used
     *
     * @return
     */
    @Override
    public WhiteSpacing White_Space()
    {
        return White_Space;
    }

    /**
     * Sets the word spacing to be used
     *
     * @return
     */
    @Override
    public MeasurementCSS Word_Spacing()
    {
        return Word_Spacing;
    }

    /**
     * Sets the Colour
     *
     * @param Color
     */
    public void setColor(ColourCSS Color)
    {
        this.Color = Color;
    }

    /**
     * Sets the colour
     *
     * @param Color$
     */
    public void setColor$(ColourNames Color$)
    {
        this.Color$ = Color$;
    }

    /**
     * Sets the direction
     *
     * @param Direction
     */
    public void setDirection(TextDirections Direction)
    {
        this.Direction = Direction;
    }

    /**
     * Set the letter spacing
     *
     * @param Letter_Spacing
     */
    public void setLetterSpacing(MeasurementCSS Letter_Spacing)
    {
        this.Letter_Spacing = Letter_Spacing;
    }

    /**
     * Line Height
     *
     * @param Line_Height
     */
    public void setLineHeight(MeasurementCSS Line_Height)
    {
        this.Line_Height = Line_Height;
    }

    /**
     * Text Alignment
     *
     * @param Text_Align
     */
    public void setTextAlign(TextAlignments Text_Align)
    {
        this.Text_Align = Text_Align;
    }

    /**
     * Sets the Text Decoration
     *
     * @param Text_Decoration
     */
    public void setTextDecoration(TextDecorations Text_Decoration)
    {
        this.Text_Decoration = Text_Decoration;
    }

    /**
     * Sets the text indentation
     *
     * @param Text_Indent
     */
    public void setTextIndent(MeasurementCSS Text_Indent)
    {
        this.Text_Indent = Text_Indent;
    }

    /**
     * Sets the Text Transforms
     *
     * @param Text_Transform
     */
    public void setTextTransform(TextTransforms Text_Transform)
    {
        this.Text_Transform = Text_Transform;
    }

    /**
     * Used together with the direction property to set or return whether the text should be overridden to support multiple languages in the same document
     *
     * @param Unicode_Bidi
     */
    public void setUnicodeBidi(UnicodeBidis Unicode_Bidi)
    {
        this.Unicode_Bidi = Unicode_Bidi;
    }

    /**
     * Sets the vertical alignment
     *
     * @param Vertical_Align
     */
    public void setVerticalAlign(VerticalAlignments Vertical_Align)
    {
        this.Vertical_Align = Vertical_Align;
    }

    /**
     * Sets the white space
     *
     * @param White_Space
     */
    public void setWhiteSpace(WhiteSpacing White_Space)
    {
        this.White_Space = White_Space;
    }

    /**
     * Sets the word spacing
     *
     * @param Word_Spacing
     */
    public void setWordSpacing(MeasurementCSS Word_Spacing)
    {
        this.Word_Spacing = Word_Spacing;
    }

    @Override
    public Class<? extends Annotation> annotationType()
    {
        return CSS.class;
    }
    
}
