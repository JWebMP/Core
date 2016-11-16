package za.co.mmagon.jwebswing.htmlbuilder.css;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import za.co.mmagon.jwebswing.htmlbuilder.css.annotations.CSSAnnotationType;
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
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Cursors;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Displays;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Overflows;
import za.co.mmagon.jwebswing.htmlbuilder.css.displays.Positions;
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

/**
 * This class holds CSS Enumerations that are global across all HTML elements
 * One day when they implement extends for Enums and @interfaces I suppose,
 * Then we can do proper generic, till then, just bare with it I guess
 * <p>
 * Based on w3 schools
 * <p>
 * @author Marc Magon
 */
@Target(
        {
            ElementType.FIELD, ElementType.TYPE, ElementType.LOCAL_VARIABLE
        })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@CSSAnnotationType
public @interface CSS
{

    public Background Background() default @Background;

    /**
     * Sets whether a background image is fixed or scrolls with the rest of the page
     * @return 
     */
    public BackgroundAttachments Background_Attachment() default BackgroundAttachments.Unset;

    /**
     * Sets the background color of an element
     * @return 
     */
    public ColourCSS Background_Color() default @ColourCSS;

    /**
     * Sets the background color to a colour name
     *
     * @return
     */
    public ColourNames Background_Color$() default ColourNames.Unset;

    /**
     * Specifies one or more background images for an element
     * @return 
     */
    public ImageCSS Background_Image() default @ImageCSS;

    /**
     * Specifies one or more background images for an element
     * @return 
     */
    public ImageCSS[] Background_Image$() default
    {
    };

    /**
     * Specifies the position of a background image
     * @return 
     */
    public BackgroundPositions Background_Position() default BackgroundPositions.Unset;

    /**
     * Sets how a background image will be repeated
     * @return 
     */
    public Repeats Background_Repeat() default Repeats.Unset;

    /**
     * Specifies the blending mode of each background layer (color/image)
     *
     * @return
     */
    public BackgroundBlendMode Background_BlendMode() default BackgroundBlendMode.Unset;

    /**
     * The background-clip property specifies the painting area of the background.
     *
     * @return
     */
    public BackgroundClip Background_Clip() default BackgroundClip.Unset;

    /**
     * The background-origin property specifies where the background image is positioned.
     *
     * @return
     */
    public BackgroundOrigins Background_Origin() default BackgroundOrigins.Unset;

    /**
     * The background-size property specifies the size of the background images.
     *
     * @return
     */
    public MeasurementCSS[] Background_Size() default
    {
    };

    /**
     * The background-size property specifies the size of the background images.
     *
     * @return
     */
    public BackgroundSizes Background_Size$() default BackgroundSizes.Unset;

    /**
     * The border shorthand property sets all the border properties in one declaration.
     *
     * @return
     */
    public Border Border() default @Border;

    /**
     * The border-top shorthand property sets all the top border properties in one declaration.
     *
     * @return
     */
    public BorderBottomCSS Border_Bottom() default @BorderBottomCSS;

    /**
     * The border-top shorthand property sets all the top border properties in one declaration.
     *
     * @return
     */
    public BorderBottomCSS Border_Left() default @BorderBottomCSS;

    /**
     * The border-top shorthand property sets all the top border properties in one declaration.
     *
     * @return
     */
    public BorderBottomCSS Border_Right() default @BorderBottomCSS;

    /**
     * The border-top shorthand property sets all the top border properties in one declaration.
     *
     * @return
     */
    public BorderBottomCSS Border_Top() default @BorderBottomCSS;

    /**
     * Sets the color of the bottom border
     *
     * @return
     */
    public ColourCSS Border_Bottom_Color() default @ColourCSS;

    /**
     * Sets the color of the bottom border
     *
     * @return
     */
    public ColourNames Border_Bottom_Color$() default ColourNames.Unset;

    /**
     * Sets the Style of the bottom border
     *
     * @return
     */
    public BorderStyles Border_Bottom_Style() default BorderStyles.Unset;

    /**
     * Sets the width of the bottom border
     *
     * @return
     */
    public MeasurementCSS Border_Bottom_Width() default @MeasurementCSS;

    /**
     * Sets the colour of the left border
     *
     * @return
     */
    public ColourCSS Border_Left_Color() default @ColourCSS;

    /**
     * Sets the colour of the left border
     *
     * @return
     */
    public ColourNames Border_Left_Color$() default ColourNames.Unset;

    /**
     * Sets the style of the left border
     *
     * @return
     */
    public BorderStyles Border_Left_Style() default BorderStyles.Unset;

    /**
     * Sets the width of the left border
     *
     * @return
     */
    public MeasurementCSS Border_Left_Width() default @MeasurementCSS;

    /**
     * Sets the color of the right border
     *
     * @return
     */
    public ColourCSS Border_Right_Color() default @ColourCSS;

    /**
     * Sets the color of the right border
     *
     * @return
     */
    public ColourNames Border_Right_Color$() default ColourNames.Unset;

    /**
     * Sets the style of the right border
     *
     * @return
     */
    public BorderStyles Border_Right_Style() default BorderStyles.Unset;

    /**
     * Sets the style of the right border
     *
     * @return
     */
    public MeasurementCSS Border_Right_Width() default @MeasurementCSS;

    /**
     * Sets the color of the top border
     *
     * @return
     */
    public ColourCSS Border_Top_Color() default @ColourCSS;

    /**
     * Sets the color of the top border
     *
     * @return
     */
    public ColourNames Border_Top_Color$() default ColourNames.Unset;

    /**
     * Sets the style of the top border
     *
     * @return
     */
    public BorderStyles Border_Top_Style() default BorderStyles.Unset;

    /**
     * Sets the width of the top border
     *
     * @return
     */
    public MeasurementCSS Border_Top_Width() default @MeasurementCSS;

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
    public Displays Display() default Displays.Unset;

    /**
     * The mouse cursor
     *
     * @return
     */
    public Cursors Cursor() default Cursors.Unset;

    /**
     * Sets the overflow
     *
     * @return
     */
    public Overflows Overflow() default Overflows.Unset;

    /**
     * Sets the Overflow for Horizontal
     *
     * @return
     */
    public Overflows Overflow_X() default Overflows.Unset;

    /**
     * Sets the Overflow for Vertical
     *
     * @return
     */
    public Overflows Overflow_Y() default Overflows.Unset;

    /**
     * Sets the Position to apply
     *
     * @return
     */
    public Positions Position() default Positions.Unset;

    /**
     * Sets how an object must float
     *
     * @return
     */
    public za.co.mmagon.jwebswing.htmlbuilder.css.displays.Float Float() default za.co.mmagon.jwebswing.htmlbuilder.css.displays.Float.Unset;

    /**
     * Sets the Z-Index of the component
     *
     * @return
     */
    public MeasurementCSS Z_Index() default @MeasurementCSS;

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @return
     */
    public MeasurementCSS Bottom() default @MeasurementCSS;

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @return
     */
    public MeasurementCSS Left() default @MeasurementCSS;

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @return
     */
    public MeasurementCSS Right() default @MeasurementCSS;

    /**
     * Sets the bottom margin edge for a positioned box
     *
     * @return
     */
    public MeasurementCSS Top() default @MeasurementCSS;

    /**
     * The font-family property specifies the font for an element.
     *
     * @return
     */
    public FontFamilies Font_Family() default FontFamilies.Unset;

    /**
     * Specifies the font size of text
     * @return 
     */
    public MeasurementCSS Font_Size() default @MeasurementCSS;

    /**
     * The font-style property specifies the font style for a text.
     * @return 
     */
    public FontStyles Font_Style() default FontStyles.Unset;

    /**
     * The font-variant property specifies whether or not a text should be displayed in a small-caps font.
     * @return 
     */
    public FontVariants Font_Variant() default FontVariants.Unset;

    /**
     * Specifies the weight of a font
     * @return 
     */
    public FontWeights Font_Weight() default FontWeights.Unset;

    /**
     * Specifies the weight of a font
     * @return 
     */
    public int Font_Weight$() default CSSPropertiesFactory.DefaultIntValue;

    /**
     * The height property sets the height of an element.
     * <p>
     * Note: The height property does not include padding, borders, or margins; it sets the height of the area inside the padding, border, and margin of the element!
     * <p>
     * Note: The min-height and max-height properties override height.
     * Default value: auto
     * Inherited: no
     * Animatable: yes. Read about animatable
     * Try it
     * Version: CSS1
     * JavaScript syntax: object.style.height="500px"
     *
     * @return
     */
    public MeasurementCSS Height() default @MeasurementCSS;

    /**
     * The height property sets the height of an element.
     * <p>
     * Note: The height property does not include padding, borders, or margins; it sets the height of the area inside the padding, border, and margin of the element!
     * <p>
     * Note: The min-height and max-height properties override height.
     * Default value: auto
     * Inherited: no
     * Animatable: yes. Read about animatable
     * Try it
     * Version: CSS1
     * JavaScript syntax: object.style.height="500px"
     *
     * @return
     */
    public HeightSetting Height$() default HeightSetting.Unset;

    /**
     * Definition and Usage
     * <p>
     * The width property sets the width of an element.
     * <p>
     * Note: The width property does not include padding, borders, or margins; it sets the width of the area inside the padding, border, and margin of the element!
     * <p>
     * Note: The min-width and max-width properties override width.
     * Default value: auto
     * Inherited: no
     * Animatable: yes. Read about animatable
     * Try it
     * Version: CSS1
     * JavaScript syntax: object.style.width="500px"
     *
     * @return
     */
    public MeasurementCSS Width() default @MeasurementCSS;

    /**
     * Definition and Usage
     * <p>
     * The width property sets the width of an element.
     * <p>
     * Note: The width property does not include padding, borders, or margins; it sets the width of the area inside the padding, border, and margin of the element!
     * <p>
     * Note: The min-width and max-width properties override width.
     * Default value: auto
     * Inherited: no
     * Animatable: yes. Read about animatable
     * Try it
     * Version: CSS1
     * JavaScript syntax: object.style.width="500px"
     *
     * @return
     */
    public WidthSetting Width$() default WidthSetting.Unset;

    /**
     * Definition and Usage
     * <p>
     * The min-height property is used to set the minimum height of an element.
     * <p>
     * This prevents the value of the height property from becoming smaller than min-height.
     * <p>
     * Note: The value of the min-height property overrides both max-height and height.
     * Default value: 0
     * Inherited: no
     * Animatable: yes, see individual properties. Read about animatable
     * Try it
     * Version: CSS2
     * JavaScript syntax: object.style.minHeight="400px"
     *
     * @return
     */
    public MeasurementCSS Min_Height() default @MeasurementCSS;

    /**
     * Definition and Usage
     * <p>
     * The max-height property is used to set the maximum height of an element.
     * <p>
     * This prevents the value of the height property from becoming larger than max-height.
     * <p>
     * Note: The value of the max-height property overrides height.
     * Default value: none
     * Inherited: no
     * Animatable: yes, see individual properties. Read about animatable
     * Try it
     * Version: CSS2
     * JavaScript syntax: object.style.maxHeight="100px"
     *
     * @return
     */
    public MeasurementCSS Max_Height() default @MeasurementCSS;

    /**
     * Definition and Usage
     * <p>
     * The min-width property is used to set the minimum width of an element.
     * <p>
     * This prevents the value of the width property from becoming smaller than min-width.
     * <p>
     * Note: The value of the min-width property overrides both max-width and width.
     * Default value: 0
     * Inherited: no
     * Animatable: yes, see individual properties. Read about animatable
     * Try it
     * Version: CSS2
     * JavaScript syntax: object.style.minWidth="400px"
     *
     * @return
     */
    public MeasurementCSS Min_Width() default @MeasurementCSS;

    /**
     * Definition and Usage
     * <p>
     * The max-width property is used to set the maximum width of an element.
     * <p>
     * This prevents the value of the width property from becoming larger than max-width.
     * <p>
     * Note: The value of the max-width property overrides width.
     * Default value: none
     * Inherited: no
     * Animatable: yes, see individual properties. Read about animatable
     * Try it
     * Version: CSS2
     * JavaScript syntax: object.style.maxWidth="600px"
     *
     * @return
     */
    public MeasurementCSS Max_Width() default @MeasurementCSS;

    /*
     * Specifies an image as the list-item marker
     * @return 
     */
    public ImageCSS List_Style_Image() default @ImageCSS;

    /**
     * Specifies if the list-item markers should appear inside or outside the content flow
     * @return 
     */
    public ListStylePosition List_Style_Position() default ListStylePosition.Unset;

    /**
     * Specifies the type of list-item marker
     * @return 
     */
    public ListStyleType List_Style_Type() default ListStyleType.Unset;

    /**
     * The shorthand for margin
     *
     * @return
     */
    public Margin Margin() default @Margin;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSS Margin_Right() default @MeasurementCSS;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MarginSetting Margin_Right$() default MarginSetting.Unset;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSS Margin_Left() default @MeasurementCSS;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MarginSetting Margin_Left$() default MarginSetting.Unset;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSS Margin_Top() default @MeasurementCSS;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MarginSetting Margin_Top$() default MarginSetting.Unset;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSS Margin_Bottom() default @MeasurementCSS;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MarginSetting Margin_Bottom$() default MarginSetting.Unset;

    /**
     * Sets the color of an outline
     *
     * @return
     */
    public ColourCSS Outline_Color() default @ColourCSS;

    /**
     * Sets the color of an outline
     *
     * @return
     */
    public ColourNames Outline_Color$() default ColourNames.Unset;

    /**
     * Sets the style of an outline
     *
     * @return
     */
    public BorderStyles Outline_Style() default BorderStyles.Unset;

    /**
     * Sets the width of an outline
     *
     * @return
     */
    public MeasurementCSS Outline_Width() default @MeasurementCSS;

    /**
     * Specifies the space between an outline and the edge or border of an element
     *
     * @return
     */
    public MeasurementCSS Outline_Offset() default @MeasurementCSS;

    /**
     * Shorthand format for padding
     *
     * @return
     */
    public Padding Padding() default @Padding;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSS Padding_Right() default @MeasurementCSS;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public PaddingSetting Padding_Right$() default PaddingSetting.Unset;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSS Padding_Left() default @MeasurementCSS;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public PaddingSetting Padding_Left$() default PaddingSetting.Unset;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSS Padding_Top() default @MeasurementCSS;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public PaddingSetting Padding_Top$() default PaddingSetting.Unset;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public MeasurementCSS Padding_Bottom() default @MeasurementCSS;

    /**
     * The CSS margin properties set the size of the white space OUTSIDE the border.
     *
     * @return
     */
    public PaddingSetting Padding_Bottom$() default PaddingSetting.Unset;

    /**
     * Specifies whether or not table borders should be collapsed
     * @return 
     */
    public TableBorderCollapse Border_Collapse() default TableBorderCollapse.Unset;

    /**
     * Sets where the caption will appear
     *
     * @return
     */
    public TableCaptionSides Table_Caption_Side() default TableCaptionSides.Unset;

    /**
     * Sets the border spacing for the table
     *
     * @return
     */
    public MeasurementCSS Border_Spacing() default @MeasurementCSS;

    /**
     * Definition and Usage
     * <p>
     * The color property specifies the color of text.
     * Default value: not specified
     * Inherited: yes
     * Version: CSS1
     * JavaScript syntax: object.style.color=white
     * <p>
     * @return
     */
    public ColourCSS Color() default @ColourCSS;

    /**
     * Definition and Usage
     * <p>
     * The color property specifies the color of text.
     * Default value: not specified
     * Inherited: yes
     * Version: CSS1
     * JavaScript syntax: object.style.color=white
     * <p>
     * @return
     */
    public ColourNames Color$() default ColourNames.Unset;

    /**
     * Definition and Usage
     * <p>
     * The direction property specifies the text direction/writing direction.
     * Default value: ltr
     * Inherited: yes
     * Version: CSS2
     * JavaScript syntax: object.style.direction="rtl"
     * <p>
     * @return
     */
    public TextDirections Direction() default TextDirections.Unset;

    /**
     * Definition and Usage
     * <p>
     * The letter-spacing property increases or decreases the space between characters in a text.
     * Default value: normal
     * Inherited: yes
     * Version: CSS1
     * JavaScript syntax: object.style.letterSpacing="3px"
     * <p>
     * @return
     */
    public MeasurementCSS Letter_Spacing() default @MeasurementCSS;

    /**
     * Definition and Usage
     * <p>
     * The line-height property specifies the line height.
     * <p>
     * Note: Negative values are not allowed.
     * Default value: normal
     * Inherited: yes
     * Version: CSS1
     * JavaScript syntax: object.style.lineHeight="2"
     * <p>
     * @return
     */
    public MeasurementCSS Line_Height() default @MeasurementCSS;

    /**
     * Definition and Usage
     * <p>
     * The text-align property specifies the horizontal alignment of text in an element.
     * Default value: left if direction is ltr, and right if direction is rtl
     * Inherited: yes
     * Version: CSS1
     * JavaScript syntax: object.style.textAlign="right"
     * <p>
     * @return
     */
    public TextAlignments Text_Align() default TextAlignments.Unset;

    /**
     * Definition and Usage
     * <p>
     * The text-decoration property specifies the decoration added to text.
     * <p>
     * Note: The color of the decoration should be set by the "color" property.
     * Default value: none
     * Inherited: no
     * Version: CSS1
     * JavaScript syntax: object.style.textDecoration="overline"
     * <p>
     * @return
     */
    public TextDecorations Text_Decoration() default TextDecorations.Unset;

    /**
     * Definition and Usage
     * <p>
     * The text-indent property specifies the indentation of the first line in a text-block.
     * <p>
     * Note: Negative values are allowed. The first line will be indented to the left if the value is negative.
     * Default value: 0
     * Inherited: yes
     * Version: CSS1
     * JavaScript syntax: object.style.textIndent="50px"
     * <p>
     * @return
     */
    public MeasurementCSS Text_Indent() default @MeasurementCSS;

    /**
     * Definition and Usage
     * <p>
     * The text-transform property controls the capitalization of text.
     * Default value: none
     * Inherited: yes
     * Version: CSS1
     * JavaScript syntax: object.style.textTransform="uppercase"
     * <p>
     * @return
     */
    public TextTransforms Text_Transform() default TextTransforms.Unset;

    /**
     * Used together with the direction property to set or return whether the text should be overridden to support multiple languages in the same document
     *
     * @return
     */
    public UnicodeBidis Unicode_Bidi() default UnicodeBidis.Unset;

    /**
     * Definition and Usage
     * <p>
     * The vertical-align property sets the vertical alignment of an element.
     * Default value: baseline
     * Inherited: no
     * Version: CSS1
     * JavaScript syntax: object.style.verticalAlign="bottom"
     * <p>
     * @return
     */
    public VerticalAlignments Vertical_Align() default VerticalAlignments.Unset;

    /**
     * Definition and Usage
     * <p>
     * The white-space property specifies how white-space inside an element is handled.
     * Default value: normal
     * Inherited: yes
     * Version: CSS1
     * JavaScript syntax: object.style.whiteSpace="pre"
     * <p>
     * @return
     */
    public WhiteSpacing White_Space() default WhiteSpacing.Unset;

    /**
     * Definition and Usage
     * <p>
     * The word-spacing property increases or decreases the white space between words.
     * <p>
     * Note: Negative values are allowed.
     * Default value: normal
     * Inherited: yes
     * Version: CSS1
     * JavaScript syntax: object.style.wordSpacing="10px"
     * <p>
     * @return
     */
    public MeasurementCSS Word_Spacing() default @MeasurementCSS;
}
