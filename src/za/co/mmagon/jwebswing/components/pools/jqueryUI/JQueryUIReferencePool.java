/*
 * Copyright (C) 2015 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package za.co.mmagon.jwebswing.components.pools.jqueryUI;

import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.servlets.interfaces.ReferencePool;

/**
 *
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 */
public enum JQueryUIReferencePool implements ReferencePool
{
    
    /**
     * The core of JQuery UI
     */
    Core(new JQueryUICoreJavaScriptReference(), new JQueryUICoreCSSReference()),
    /**
     * The widget library of JQuery UI
     */
    Widget(new JQueryUIWidgetJavaScriptReference(), new JQueryUIWidgetCSSReference()),
    /**
     * The Mouse Library of JQuery UI
     */
    Mouse(new JQueryUIMouseJavaScriptReference(), null),
    /**
     * The accordion setup of JQueryUI
     */
    Accordion(new JQUIAccordionJavaScriptReference(), new JQUIAccordionCSSReference()),
    /**
     * The auto complete setup of JQueryUI
     */
    AutoComplete(new JQUIAutoCompleteJavaScriptReference(), new JQUIAutoCompleteCSSReference()),
    /**
     * Provides the auto complete with categorization support
     */
    AutoComplete_Categorization(new JQUIAutoCompleteCategorizeJavaScriptReference(), new JQUIAutoCompleteCategorizeCSSReference()),
    /**
     * Provides the auto complete with categorization support
     */
    AutoComplete_ComboBox(new JQUIAutoCompleteComboBoxJavaScriptReference(), new JQUIAutoCompleteComboBoxCSSReference()),
    /**
     * The button setup of JQuery UI
     */
    Button(new JQUIButtonJavaScriptReference(), new JQUIButtonCSSReference()),
    /**
     * The date picker element of JQuery UI
     */
    DatePicker(new JQUIDatePickerJavaScriptReference(), new JQUIDatePickerCSSReference()),
    /**
     * The dialog element of JQuery UI
     */
    Dialog(new JQUIDialogJavaScriptReference(), new JQUIDialogCSSReference()),
    /**
     * The menu element of JQuery UI
     */
    Menu(new JQUIMenuJavaScriptReference(), new JQUIMenuCSSReference()),
    /**
     * The position element of JQuery UI
     */
    Position(new JQUIPositionJavaScriptReference(), null),
    /**
     * Progress Bar
     */
    ProgressBar(new JQUIProgressBarJavaScriptReference(), new JQUIProgressBarCSSReference()),
    /**
     * Select Menu
     */
    SelectMenu(new JQUISelectMenuJavaScriptReference(), new JQUISelectMenuCSSReference()),
    /**
     * The select menu add-ons script from JQuery UI .com
     */
    SelectMenuIcons(new JQUISelectMenuIconsJavaScriptReference(), null),
    /**
     * The Slider add-ons
     */
    Slider(new JQUISliderJavaScriptReference(), new JQUISliderCSSReference()),
    /**
     * The spinner class
     */
    Spinner(new JQUISpinnerJavaScriptReference(), new JQUISpinnerCSSReference()),
    /**
     * The tabs scripts for JQuery UI
     */
    Tabs(new JQUITabsJavaScriptReference(), new JQUITabsCSSReference()),
    /**
     * The JQuery UI Tooltip Functionality
     */
    Tooltip(new JQueryUITooltipJavaScriptReference(), new JQueryUITooltipCSSReference()),
    /**
     * The JQuery UI draggable feature
     */
    Draggable(new JQUIDraggableJavaScriptReference(), new JQUIDraggableCSSReference()),
    /**
     * The JQuery UI droppable
     */
    Droppable(new JQUIDroppableJavaScriptReference(), null),
    /**
     * The JQuery UI Resizable
     */
    Resizable(new JQUIResizableJavaScriptReference(), new JQUIResizableCSSReference()),
    /**
     * The selectable widget implementation
     */
    Selectable(new JQUISelectableJavaScriptReference(), new JQUISelectableCSSReference()),
    /**
     * The sortable implementation
     */
    Sortable(new JQUISortableJavaScriptReference(), new JQUISortableCSSReference()),;

    private JavascriptReference javaScriptReference;
    private CSSReference cssReference;

    private JQueryUIReferencePool(JavascriptReference javaScriptReference, CSSReference cssReference)
    {
        this.javaScriptReference = javaScriptReference;
        this.cssReference = cssReference;
    }

    @Override
    public JavascriptReference getJavaScriptReference()
    {
        return javaScriptReference;
    }

    @Override
    public void setJavaScriptReference(JavascriptReference javaScriptReference)
    {
        this.javaScriptReference = javaScriptReference;
    }

    @Override
    public CSSReference getCssReference()
    {
        return cssReference;
    }

    @Override
    public void setCssReference(CSSReference cssReference)
    {
        this.cssReference = cssReference;
    }

}
