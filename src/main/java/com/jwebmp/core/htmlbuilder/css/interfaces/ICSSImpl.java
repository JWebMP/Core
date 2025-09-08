package com.jwebmp.core.htmlbuilder.css.interfaces;

import com.jwebmp.core.htmlbuilder.css.animatable.AnimateCSSImpl;
import com.jwebmp.core.htmlbuilder.css.annotations.CSSImplementationClass;
import com.jwebmp.core.htmlbuilder.css.backgrounds.BackgroundCSSImpl;
import com.jwebmp.core.htmlbuilder.css.borders.BorderCSSImpl;
import com.jwebmp.core.htmlbuilder.css.displays.DisplayCSSImpl;
import com.jwebmp.core.htmlbuilder.css.fonts.FontsCSSImpl;
import com.jwebmp.core.htmlbuilder.css.heightwidth.HeightWidthCSSImpl;
import com.jwebmp.core.htmlbuilder.css.lists.ListCSSImpl;
import com.jwebmp.core.htmlbuilder.css.margins.MarginsCSSImpl;
import com.jwebmp.core.htmlbuilder.css.outline.OutlineCSSImpl;
import com.jwebmp.core.htmlbuilder.css.padding.PaddingCSSImpl;
import com.jwebmp.core.htmlbuilder.css.tables.TableCSSImpl;
import com.jwebmp.core.htmlbuilder.css.text.TextCSSImpl;
import jakarta.validation.constraints.NotNull;

import java.util.Map;

public interface ICSSImpl<A extends java.lang.annotation.Annotation, T extends CSSImplementationClass<A, T>>
        extends CSSImplementationClass<A, T>
{
    /**
     * Returns all the maps of the underlying objects
     *
     * @return
     */
    Map<StringBuilder, Object> getMap();

    /**
     * Gets the background css
     *
     * @return
     */
    @NotNull
    BackgroundCSSImpl getBackground();

    /**
     * Sets the background object
     *
     * @param background
     */
    void setBackground(BackgroundCSSImpl background);

    /**
     * Returns dimension settings for the object
     *
     * @return
     */
    @NotNull
    HeightWidthCSSImpl getDimensions();

    /**
     * Returns the margins
     *
     * @return
     */
    @NotNull
    MarginsCSSImpl getMargins();

    /**
     * Returns the display
     *
     * @return
     */
    @NotNull
    DisplayCSSImpl getDisplay();

    /**
     * Returns the padding
     *
     * @return
     */
    @NotNull
    PaddingCSSImpl getPadding();

    /**
     * Returns the text
     *
     * @return
     */
    @NotNull
    TextCSSImpl getText();

    /**
     * Gets the border
     *
     * @return
     */
    @NotNull
    BorderCSSImpl getBorder();

    /**
     * @return
     */
    @NotNull
    FontsCSSImpl getFont();

    /**
     * Returns the list
     *
     * @return
     */
    @NotNull
    ListCSSImpl getList();

    /**
     * Returns the outline
     *
     * @return
     */
    @NotNull
    OutlineCSSImpl getOutline();

    /**
     * Returns the table
     *
     * @return
     */
    @NotNull
    TableCSSImpl getTable();

    /**
     * Returns the animatable object
     *
     * @return
     */
    @NotNull
    AnimateCSSImpl getAnimatable();

    /**
     * Sets animatable object
     *
     * @param animatable
     */
    void setAnimatable(AnimateCSSImpl animatable);

    /**
     * Sets the table object
     *
     * @param table
     */
    void setTable(TableCSSImpl table);

    /**
     * Sets the outline object
     *
     * @param outline
     */
    void setOutline(OutlineCSSImpl outline);

    /**
     * Sets the list object
     *
     * @param list
     */
    void setList(ListCSSImpl list);

    /**
     * Sets the font object
     *
     * @param font
     */
    void setFont(FontsCSSImpl font);

    /**
     * Sets the border object
     *
     * @param border
     */
    void setBorder(BorderCSSImpl border);

    /**
     * Sets the text object
     *
     * @param text
     */
    void setText(TextCSSImpl text);

    /**
     * Sets the padding object
     *
     * @param padding
     */
    void setPadding(PaddingCSSImpl padding);

    /**
     * Sets the display object
     *
     * @param display
     */
    void setDisplay(DisplayCSSImpl display);

    /**
     * Sets the margins object
     *
     * @param margins
     */
    void setMargins(MarginsCSSImpl margins);

    /**
     * Sets the dimensions object
     *
     * @param dimensions
     */
    void setDimensions(HeightWidthCSSImpl dimensions);
}
