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
package za.co.mmagon.jwebswing.components.pools.jqxwidgets;

import za.co.mmagon.jwebswing.components.references.jqxwidgets.JQXCoreJavaScriptReference;
import za.co.mmagon.jwebswing.base.references.CSSReference;
import za.co.mmagon.jwebswing.base.references.JavascriptReference;
import za.co.mmagon.jwebswing.base.servlets.interfaces.ReferencePool;

/**
 *
 * @author GedMarc
 * @since Mar 4, 2015
 * @version 1.0
 */
public enum JQXReferencePool implements ReferencePool
{
    Globalization(new JavascriptReference("JQXGlobalizationJS", 3.91, "bower_components/jqwidgets/jqwidgets/globalization/globalize.js", "https://jqwidgets.com/public/jqwidgets/"), 12),
    FormattedInputFeature(new JavascriptReference("JQXFormattedInputJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxformattedinput.js", "https://jqwidgets.com/public/jqwidgets/jqxformattedinput.js")),
    Date(new JavascriptReference("JQXDateJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxdate.js", "https://jqwidgets.com/public/jqwidgets/jqxdate.js"), 12),
    Touch(new JavascriptReference("JQXTouchJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxtouch.js", "https://jqwidgets.com/public/jqwidgets/jqxtouch.js"), 12),
    //GridEdit(new JavascriptReference("JQXFormattedInputJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxgrid.edit.js","https://jqwidgets.com/public/jqwidgets/")),
    /**
     * The core of JQuery UI
     */
    Core(new JQXCoreJavaScriptReference(), 10),
    /**
     * integration plug-in
     */
    AngularJS(new JavascriptReference("JQXAngularJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxangular.js", "https://jqwidgets.com/public/jqwidgets/jqxangular.js",11)),
    /**
     * RepeatButton, SubmitButton and ToggleButton widgets
     */
    Button(new JavascriptReference("JQXButtonJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxbuttons.js", "https://jqwidgets.com/public/jqwidgets/jqxbuttons.js")),
    BulletChart(new JavascriptReference("JQXBulletChartJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxbulletchart.js", "https://jqwidgets.com/public/jqwidgets/jqxbulletchart.js")),
    Data(new JavascriptReference("JQXBulletChartJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxdata.js", "https://jqwidgets.com/public/jqwidgets/jqxdata.js"), 11),
    ButtonGroup(new JavascriptReference("JQXButtonGroupJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxbuttongroup.js", "https://jqwidgets.com/public/jqwidgets/jqxbuttongroup.js")),
    Calendar(new JavascriptReference("JQXCalendarJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxcalendar.js", "https://jqwidgets.com/public/jqwidgets/jqxcalendar.js")),
    ComboBox(new JavascriptReference("JQXComboBoxJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxcombobox.js", "https://jqwidgets.com/public/jqwidgets/jqxcombobox.js")),
    ComplexInputNumber(new JavascriptReference("JQXComplexInputNumberJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxcomplexinput.js", "https://jqwidgets.com/public/jqwidgets/jqxcomplexinput.js")),
    Chart(new JavascriptReference("JQXChartJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxchart.core.js", "https://jqwidgets.com/public/jqwidgets/jqxchart.core.js")),
    ChartRangeSelector(new JavascriptReference("JQXChartRangeSelectorJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxchart.rangeselector.js", "https://jqwidgets.com/public/jqwidgets/jqxchart.rangeselector.js")),
    ChartAPI(new JavascriptReference("JQXChartAPIJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxchart.api.js", "https://jqwidgets.com/public/jqwidgets/jqxchart.api.js")),
    ChartAnnotations(new JavascriptReference("JQXChartAnnotationsvJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxchart.annotations.js", "https://jqwidgets.com/public/jqwidgets/jqxchart.annotations.js")),
    WaterfallChart(new JavascriptReference("JQXWaterfallChartJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxchart.waterfall.js", "https://jqwidgets.com/public/jqwidgets/jqxchart.waterfall.js")),
    CheckBox(new JavascriptReference("JQXCheckBoxJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxcheckbox.js", "https://jqwidgets.com/public/jqwidgets/jqxcheckbox.js")),
    DataSource(new JavascriptReference("JQXDataSourceJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxdata.js", "https://jqwidgets.com/public/jqwidgets/jqxdata.js")),
    DataExport(new JavascriptReference("JQXDataExportJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxdata.export.js", "https://jqwidgets.com/public/jqwidgets/jqxdata.export.js")),
    DateTimePlugin(new JavascriptReference("JQXDateTimePluginJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxdate.js", "https://jqwidgets.com/public/jqwidgets/jqxdate.js")),
    DateTimeInput(new JavascriptReference("JQXDateTimeInputJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxdatetimeinput.js", "https://jqwidgets.com/public/jqwidgets/jqxdatetimeinput.js")),
    ColorPicker(new JavascriptReference("JQXColorPickerJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxcolorpicker.js", "https://jqwidgets.com/public/jqwidgets/jqxcolorpicker.js")),
    DataTable(new JavascriptReference("JQXDataTableJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxdatatable.js", "https://jqwidgets.com/public/jqwidgets/jqxdatatable.js")),
    Docking(new JavascriptReference("JQXDockingJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxdocking.js", "https://jqwidgets.com/public/jqwidgets/jqxdocking.js")),
    DockingLayout(new JavascriptReference("JQXDockingLayoutJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxdockinglayout.js", "https://jqwidgets.com/public/jqwidgets/jqxdockinglayout.js")),
    DropDownButton(new JavascriptReference("JQXDropDownButtonJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxdropdownbutton.js", "https://jqwidgets.com/public/jqwidgets/jqxdropdownbutton.js")),
    DragDrop(new JavascriptReference("JQXDragDropJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxdragdrop.js", "https://jqwidgets.com/public/jqwidgets/jqxdragdrop.js")),
    Draw(new JavascriptReference("JQXDrawJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxdraw.js", "https://jqwidgets.com/public/jqwidgets/jqxdraw.js")),
    DockPanel(new JavascriptReference("JQXDockPanelJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxdockpanel.js", "https://jqwidgets.com/public/jqwidgets/jqxdockpanel.js")),
    DropDownList(new JavascriptReference("JQXDropDownListJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxdropdownlist.js", "https://jqwidgets.com/public/jqwidgets/jqxdropdownlist.js")),
    Editor(new JavascriptReference("JQXEditorJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxeditor.js", "https://jqwidgets.com/public/jqwidgets/jqxeditor.js")),
    Expander(new JavascriptReference("JQXExpanderJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxexpander.js", "https://jqwidgets.com/public/jqwidgets/jqxexpander.js")),
    FileUpload(new JavascriptReference("JQXFileUploadJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxfileupload.js", "https://jqwidgets.com/public/jqwidgets/jqxfileupload.js")),
    /**
     * Binary, Octal, Hex TextBox widget
     */
    SystemDecimalTextBox(new JavascriptReference("JQXSystemDecimalTextBoxJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxformattedinput.js", "https://jqwidgets.com/public/jqwidgets/jqxformattedinput.js")),
    Grid(new JavascriptReference("JQXGridJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxgrid.js", "https://jqwidgets.com/public/jqwidgets/jqxgrid.js")),
    GridSort(new JavascriptReference("JQXGridSortJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxgrid.sort.js", "https://jqwidgets.com/public/jqwidgets/jqxgrid.sort.js")),
    GridFilter(new JavascriptReference("JQXGridFilterJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxgrid.filter.js", "https://jqwidgets.com/public/jqwidgets/jqxgrid.filter.js")),
    GridGrouping(new JavascriptReference("JQXGridGroupingJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxgrid.grouping.js", "https://jqwidgets.com/public/jqwidgets/jqxgrid.grouping.js")),
    GridSelection(new JavascriptReference("JQXGridSelectionJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxgrid.selection.js", "https://jqwidgets.com/public/jqwidgets/jqxgrid.selection.js")),
    GridColumnsResize(new JavascriptReference("JQXGridColumnsJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxgrid.columnsresize.js", "https://jqwidgets.com/public/jqwidgets/jqxgrid.columnsresize.js")),
    GridColumnsReOrder(new JavascriptReference("JQXGridColumnsReOrderJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxgrid.columnsreorder.js", "https://jqwidgets.com/public/jqwidgets/jqxgrid.columnsreorder.js")),
    GridPager(new JavascriptReference("JQXGridPagerJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxgrid.pager.js", "https://jqwidgets.com/public/jqwidgets/jqxgrid.pager.js")),
    GridEditing(new JavascriptReference("JQXGridEditingJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxgrid.edit.js", "https://jqwidgets.com/public/jqwidgets/jqxgrid.edit.js")),
    GridStateSave(new JavascriptReference("JQXGridStateSaveJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxgrid.storage.js", "https://jqwidgets.com/public/jqwidgets/jqxgrid.storage.js")),
    GridAggregatesPlugIn(new JavascriptReference("JQXGridAggregatesPlugInJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxgrid.aggregates.js", "https://jqwidgets.com/public/jqwidgets/jqxgrid.aggregates.js")),
    /**
     * Radial and Linear Gauge widget
     */
    Gauge(new JavascriptReference("JQXGaugeJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxgauge.js", "https://jqwidgets.com/public/jqwidgets/jqxgauge.js")),
    /**
     * Text Box Input
     */
    Input(new JavascriptReference("JQXInputJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxinput.js", "https://jqwidgets.com/public/jqwidgets/jqxinput.js")),
    Layout(new JavascriptReference("JQXLayoutJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxlayout.js", "https://jqwidgets.com/public/jqwidgets/jqxlayout.js")),
    Loader(new JavascriptReference("JQXLoaderJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxloader.js", "https://jqwidgets.com/public/jqwidgets/jqxloader.js")),
    Knockout(new JavascriptReference("JQXKnockoutJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxknockout.js", "https://jqwidgets.com/public/jqwidgets/jqxknockout.js")),
    ListBox(new JavascriptReference("JQXListBoxJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxlistbox.js", "https://jqwidgets.com/public/jqwidgets/jqxlistbox.js")),
    ListMenu(new JavascriptReference("JQXListMenuJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxlistmenu.js", "https://jqwidgets.com/public/jqwidgets/jqxlistmenu.js")),
    MaskedInput(new JavascriptReference("JQXMaskedInputJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxmaskedinput.js", "https://jqwidgets.com/public/jqwidgets/jqxmaskedinput.js")),
    Menu(new JavascriptReference("JQXMenuJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxmenu.js", "https://jqwidgets.com/public/jqwidgets/jqxmenu.js")),
    NavigationBar(new JavascriptReference("JQXNavigationBarJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxnavigationbar.js", "https://jqwidgets.com/public/jqwidgets/jqxnavigationbar.js")),
    NavBar(new JavascriptReference("JQXNavBarJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxnavbar.js", "https://jqwidgets.com/public/jqwidgets/jqxnavbar.js")),
    Notification(new JavascriptReference("JQXNotificationJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxnotification.js", "https://jqwidgets.com/public/jqwidgets/jqxnotification.js")),
    NumberInput(new JavascriptReference("JQXNumberInputJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxnumberinput.js", "https://jqwidgets.com/public/jqwidgets/jqxnumberinput.js")),
    RangeSelector(new JavascriptReference("JQXRangeSelectorJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxrangeselector.js", "https://jqwidgets.com/public/jqwidgets/jqxrangeselector.js")),
    Panel(new JavascriptReference("JQXPanelJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxpanel.js", "https://jqwidgets.com/public/jqwidgets/jqxpanel.js")),
    Popup(new JavascriptReference("JQXPopupJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxpopup.js", "https://jqwidgets.com/public/jqwidgets/jqxpopup.js")),
    ProgressBar(new JavascriptReference("JQXProgressBarJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxprogressbar.js", "https://jqwidgets.com/public/jqwidgets/jqxprogressbar.js")),
    PasswordInput(new JavascriptReference("JQXPasswordInputJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxpasswordinput.js", "https://jqwidgets.com/public/jqwidgets/jqxpasswordinput.js")),
    Popover(new JavascriptReference("JQXPopoverJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxpopover.js", "https://jqwidgets.com/public/jqwidgets/jqxpopover.js")),
    Rating(new JavascriptReference("JQXRatingJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxrating.js", "https://jqwidgets.com/public/jqwidgets/jqxrating.js")),
    Ribbon(new JavascriptReference("JQXRibbonJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxribbon.js", "https://jqwidgets.com/public/jqwidgets/jqxribbon.js")),
    RadioButton(new JavascriptReference("JQXRadioButtonJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxradiobutton.js", "https://jqwidgets.com/public/jqwidgets/jqxradiobutton.js")),
    Response(new JavascriptReference("JQXResponseJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxresponse.js", "https://jqwidgets.com/public/jqwidgets/jqxresponse.js")),
    ResponsivePanel(new JavascriptReference("JQXResponsivePanelssssssJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxresponsivepanel.js", "https://jqwidgets.com/public/jqwidgets/jqxresponsivepanel.js")),
    SwitchButton(new JavascriptReference("JQXSwitchButtonJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxswitchbutton.js", "https://jqwidgets.com/public/jqwidgets/jqxswitchbutton.js")),
    ScrollBar(new JavascriptReference("JQXScrollBarJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxscrollbar.js", "https://jqwidgets.com/public/jqwidgets/jqxscrollbar.js")),
    ScrollView(new JavascriptReference("JQXScrollViewJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxscrollview.js", "https://jqwidgets.com/public/jqwidgets/jqxscrollview.js")),
    Splitter(new JavascriptReference("JQXSplitterJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxsplitter.js", "https://jqwidgets.com/public/jqwidgets/jqxsplitter.js")),
    Slider(new JavascriptReference("JQXSliderJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxslider.js", "https://jqwidgets.com/public/jqwidgets/jqxslider.js")),
    Scheduler(new JavascriptReference("JQXSchedulerJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxscheduler.js", "https://jqwidgets.com/public/jqwidgets/jqxscheduler.js")),
    SchedulerAPI(new JavascriptReference("JQXSchedulerAPIJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxscheduler.api.js", "https://jqwidgets.com/public/jqwidgets/jqxscheduler.api.js")),
    Tabs(new JavascriptReference("JQXTabsJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxtabs.js", "https://jqwidgets.com/public/jqwidgets/jqxtabs.js")),
    TagCloud(new JavascriptReference("JQXTagCloudJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxtagcloud.js", "https://jqwidgets.com/public/jqwidgets/jqxtagcloud.js")),
    Tree(new JavascriptReference("JQXTreeJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxtree.js", "https://jqwidgets.com/public/jqwidgets/jqxtree.js")),
    TreeMap(new JavascriptReference("JQXTreeMapJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxtreemap.js", "https://jqwidgets.com/public/jqwidgets/jqxtreemap.js")),
    TreeGrid(new JavascriptReference("JQXTreeGridJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxtreegrid.js", "https://jqwidgets.com/public/jqwidgets/jqxtreegrid.js")),
    TextArea(new JavascriptReference("JQXTextAreaJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxtextarea.js", "https://jqwidgets.com/public/jqwidgets/jqxtextarea.js")),
    Toolbar(new JavascriptReference("JQXToolbarJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxtoolbar.js", "https://jqwidgets.com/public/jqwidgets/jqxtoolbar.js")),
    ToolTip(new JavascriptReference("JQXToolTipJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxtooltip.js", "https://jqwidgets.com/public/jqwidgets/jqxtooltip.js")),
    Validator(new JavascriptReference("JQXValidatorJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxvalidator.js", "https://jqwidgets.com/public/jqwidgets/jqxvalidator.js")),
    Window(new JavascriptReference("JQXWindowJS", 3.91, "bower_components/jqwidgets/jqwidgets/jqxwindow.js", "https://jqwidgets.com/public/jqwidgets/jqxwindow.js"));

    private JavascriptReference javaScriptReference;
    private CSSReference cssReference;

    private JQXReferencePool(JavascriptReference javaScriptReference, CSSReference cssReference)
    {
        this(javaScriptReference, cssReference, 500000);
    }

    private JQXReferencePool(JavascriptReference javaScriptReference, CSSReference cssReference, int sortOrder)
    {
        this.javaScriptReference = javaScriptReference;
        this.cssReference = cssReference;
        if (javaScriptReference != null)
        {
            this.javaScriptReference.setSortOrder(sortOrder);
        }
        if (cssReference != null)
        {
            this.cssReference.setSortOrder(sortOrder);
        }
    }

    private JQXReferencePool(JavascriptReference javaScriptReference)
    {
        this(javaScriptReference, 500000);
    }

    private JQXReferencePool(JavascriptReference javaScriptReference, int sortOrder)
    {
        this.javaScriptReference = javaScriptReference;
        if (javaScriptReference != null)
        {
            this.javaScriptReference.setSortOrder(sortOrder);
        }
        if (cssReference != null)
        {
            this.cssReference.setSortOrder(sortOrder);
        }
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
