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

import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.interfaces.ReferencePool;

/**
 *
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 */
public enum JQUIReferencePool implements ReferencePool
{
    /**
     * The core of JQuery UI
     */
    Core(new JQueryUICoreJavaScriptReference(), new JQueryUICoreCSSReference(), 5),
    /**
     * The widget library of JQuery UI
     */
    Widget(new JQueryUIWidgetJavaScriptReference(), new JQueryUIWidgetCSSReference(), 6),
    /**
     * The Mouse Library of JQuery UI
     */
    Mouse(new JQueryUIMouseJavaScriptReference(), null, 7),
    /**
     * The accordion setup of JQueryUI
     */
    Accordion(new JQUIAccordionJavaScriptReference(), new JQUIAccordionCSSReference(), 20),
    /**
     * The auto complete setup of JQueryUI
     */
    AutoComplete(new JQUIAutoCompleteJavaScriptReference(), new JQUIAutoCompleteCSSReference(), 20),
    /**
     * Provides the auto complete with categorization support
     */
    AutoComplete_Categorization(new JQUIAutoCompleteCategorizeJavaScriptReference(), new JQUIAutoCompleteCategorizeCSSReference(), 21),
    /**
     * Provides the auto complete with categorization support
     */
    AutoComplete_ComboBox(new JQUIAutoCompleteComboBoxJavaScriptReference(), new JQUIAutoCompleteComboBoxCSSReference(), 22),
    /**
     * The button setup of JQuery UI
     */
    Button(new JQUIButtonJavaScriptReference(), new JQUIButtonCSSReference(), 20),
    /**
     * The date picker element of JQuery UI
     */
    DatePicker(new JQUIDatePickerJavaScriptReference(), new JQUIDatePickerCSSReference(), 20),
    /**
     * The dialog element of JQuery UI
     */
    Dialog(new JQUIDialogJavaScriptReference(), new JQUIDialogCSSReference(), 25),
    /**
     * The menu element of JQuery UI
     */
    Menu(new JQUIMenuJavaScriptReference(), new JQUIMenuCSSReference(), 20),
    /**
     * The position element of JQuery UI
     */
    Position(new JQUIPositionJavaScriptReference(), null, 8),
    /**
     * Progress Bar
     */
    ProgressBar(new JQUIProgressBarJavaScriptReference(), new JQUIProgressBarCSSReference(), 20),
    /**
     * Select Menu
     */
    SelectMenu(new JQUISelectMenuJavaScriptReference(), new JQUISelectMenuCSSReference(), 20),
    /**
     * The select menu add-ons script from JQuery UI .com
     */
    SelectMenuIcons(new JQUISelectMenuIconsJavaScriptReference(), null, 21),
    /**
     * The Slider add-ons
     */
    Slider(new JQUISliderJavaScriptReference(), new JQUISliderCSSReference(), 20),
    /**
     * The spinner class
     */
    Spinner(new JQUISpinnerJavaScriptReference(), new JQUISpinnerCSSReference(), 20),
    /**
     * The spinner Time class
     */
    SpinnerTime(new JavascriptReference("JWSpinnerTimeJavaScriptReferenceJS", 1.114, "javascript/jquery.ui/timespinner.js", 21), new JQUISpinnerCSSReference(), 20),
    /**
     * The tabs scripts for JQuery UI
     */
    Tabs(new JQUITabsJavaScriptReference(), new JQUITabsCSSReference(), 20),
    /**
     * The JQuery UI Tooltip Functionality
     */
    Tooltip(new JQueryUITooltipJavaScriptReference(), new JQueryUITooltipCSSReference(), 15),
    /**
     * The JQuery UI draggable feature
     */
    Draggable(new JQUIDraggableJavaScriptReference(), new JQUIDraggableCSSReference(), 15),
    /**
     * The JQuery UI droppable
     */
    Droppable(new JQUIDroppableJavaScriptReference(), null, 15),
    /**
     * The JQuery UI Resizable
     */
    Resizable(new JQUIResizableJavaScriptReference(), new JQUIResizableCSSReference(), 15),
    /**
     * The selectable widget implementation
     */
    Selectable(new JQUISelectableJavaScriptReference(), new JQUISelectableCSSReference(), 15),
    /**
     * The sortable implementation
     */
    Sortable(new JQUISortableJavaScriptReference(), new JQUISortableCSSReference(), 15),;

    private JavascriptReference javaScriptReference;
    private CSSReference cssReference;

    private JQUIReferencePool(JavascriptReference javaScriptReference, CSSReference cssReference, int sortOrder)
    {
        this.javaScriptReference = javaScriptReference;
        if (javaScriptReference != null)
        {
            javaScriptReference.setSortOrder(sortOrder);
        }
        if (cssReference != null)
        {
            cssReference.setSortOrder(sortOrder);
        }
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
