package com.jwebmp.core.htmlbuilder.javascript.events.enumerations;

import com.fasterxml.jackson.annotation.JsonValue;
import com.jwebmp.core.events.activate.ActivateAdapter;
import com.jwebmp.core.events.beforeactivate.BeforeActivateAdapter;
import com.jwebmp.core.events.beforeclose.BeforeCloseAdapter;
import com.jwebmp.core.events.beforeload.BeforeLoadAdapter;
import com.jwebmp.core.events.beforestop.BeforeStopAdapter;
import com.jwebmp.core.events.blur.BlurAdapter;
import com.jwebmp.core.events.buttonclick.ButtonClickAdapter;
import com.jwebmp.core.events.cancel.CancelAdapter;
import com.jwebmp.core.events.change.ChangeAdapter;
import com.jwebmp.core.events.checked.CheckedAdapter;
import com.jwebmp.core.events.click.ClickAdapter;
import com.jwebmp.core.events.close.CloseAdapter;
import com.jwebmp.core.events.complete.CompleteAdapter;
import com.jwebmp.core.events.create.CreateAdapter;
import com.jwebmp.core.events.deactivate.DeactivateAdapter;
import com.jwebmp.core.events.drag.DragAdapter;
import com.jwebmp.core.events.dragstart.DragStartAdapter;
import com.jwebmp.core.events.dragstop.DragStopAdapter;
import com.jwebmp.core.events.drop.DropAdapter;
import com.jwebmp.core.events.focus.FocusAdapter;
import com.jwebmp.core.events.load.LoadAdapter;
import com.jwebmp.core.events.mousedown.MouseDownAdapter;
import com.jwebmp.core.events.mouseenter.MouseEnterAdapter;
import com.jwebmp.core.events.mousemove.MouseMoveAdapter;
import com.jwebmp.core.events.mouseout.MouseOutAdapter;
import com.jwebmp.core.events.mouseover.MouseOverAdapter;
import com.jwebmp.core.events.open.OpenAdapter;
import com.jwebmp.core.events.receive.ReceiveAdapter;
import com.jwebmp.core.events.remove.RemoveAdapter;
import com.jwebmp.core.events.resize.ResizeAdapter;
import com.jwebmp.core.events.resizestart.ResizeStartAdapter;
import com.jwebmp.core.events.resizestop.ResizeStopAdapter;
import com.jwebmp.core.events.response.ResponseAdapter;
import com.jwebmp.core.events.rightclick.RightClickAdapter;
import com.jwebmp.core.events.search.SearchAdapter;
import com.jwebmp.core.events.selected.SelectedAdapter;
import com.jwebmp.core.events.selecting.SelectingAdapter;
import com.jwebmp.core.events.slide.SlideAdapter;
import com.jwebmp.core.events.sort.SortAdapter;
import com.jwebmp.core.events.spin.SpinAdapter;
import com.jwebmp.core.events.start.StartAdapter;
import com.jwebmp.core.events.stop.StopAdapter;
import com.jwebmp.core.events.submit.SubmitAdapter;
import com.jwebmp.core.events.unselected.UnselectedAdapter;
import com.jwebmp.core.events.update.UpdateAdapter;
import com.jwebmp.core.htmlbuilder.javascript.events.commandevent.OnComponentLoadedEvent;

/**
 * Everything is a click so that makes it nice
 *
 * @author GedMarc
 */
public enum EventTypes
		implements Comparable<EventTypes>
{

	/**
	 * Sends an Ajax call to the server to perform any command on document render. Very flexible, Maybe overly so
	 */
	/**
	 * Sends an Ajax call to the server to perform any command on document render. Very flexible, Maybe overly so
	 */
	performCommand(OnComponentLoadedEvent.class, null),
	/**
	 * Registers a Mouse Over event
	 */
	mouseOver(MouseOverAdapter.class, null),
	/**
	 * Registers a Mouse Over event
	 */
	mouseOut(MouseOutAdapter.class, null),
	mouseDown(MouseDownAdapter.class, null),
	mouseUp(MouseDownAdapter.class, null),
	mouseEnter(MouseEnterAdapter.class, null),
	mouseMove(MouseMoveAdapter.class, null),
	keyDown(MouseMoveAdapter.class, null),
	keyPressed(MouseMoveAdapter.class, null),
	keyUp(MouseMoveAdapter.class, null),
	/**
	 * Registers a Right Click event
	 */
	contextmenu(RightClickAdapter.class, null),
	/*
	 * Registers a normal click event
	 */
	click(ClickAdapter.class, null),
	changed(null, null),
	/**
	 * Known as focus-lost in Swing Triggered when the menu loses focus.
	 */
	blur(BlurAdapter.class, null),
	/**
	 * Triggered when focus is moved to an item (not selecting). The default action is to replace the text field's value with the value of the focused item, though only if the
	 * event was triggered by a
	 * keyboard interaction.
	 * <p>
	 * Canceling this event prevents the value from being updated, but does not prevent the menu item from being focused.
	 */
	focus(FocusAdapter.class, null),
	/**
	 * Registers when a drag starts Triggered when the user starts dragging the dialog.
	 */
	dragStart(DragStartAdapter.class, null),
	/**
	 * Registers when a drag stops Triggered after the dialog has been dragged.
	 */
	dragStop(DragStopAdapter.class, null),
	/**
	 * Triggered when an accepted Draggable is dropped on the droppable (based on the tolerance option).
	 */
	drop(DropAdapter.class, null),
	/**
	 * Triggered when a dialog is about to close. If canceled, the dialog will not close.
	 */
	beforeClose(BeforeCloseAdapter.class, null),
	/**
	 * Triggered when the menu is hidden. Not every close event will be accompanied by a change event. Triggered when the dialog is closed. Triggered when the menu is hidden.
	 */
	close(CloseAdapter.class, null),
	/**
	 * Triggered when the accordion is created. If the accordion is collapsed, ui.header and ui.panel will be empty jQuery objects. Triggered when the dialog is created. Triggered
	 * when the progressbar
	 * is created. Triggered when the selectmenu is created.
	 */
	create(CreateAdapter.class, null),
	/**
	 * Prevents interactions from starting on specified elements.
	 */
	cancel(CancelAdapter.class, null),
	/**
	 * Triggered while the dialog is being dragged.
	 */
	drag(DragAdapter.class, null),
	/**
	 * Triggered when the suggestion menu is opened or updated. Triggered when the dialog is opened.
	 */
	open(OpenAdapter.class, null),
	/**
	 * Triggered while the dialog is being resized.
	 */
	resize(ResizeAdapter.class, null),
	/**
	 * Triggered when the user starts resizing the dialog.
	 */
	resizeStart(ResizeStartAdapter.class, null),
	/**
	 * This event is triggered at the end of a resize operation. Triggered after the dialog has been resized.
	 */
	resizeStop(ResizeStopAdapter.class, null),
	/**
	 * Triggered after a panel has been activated (after animation completes). If the accordion was previously collapsed, ui.oldHeader and ui.oldPanel will be empty jQuery objects.
	 * If the accordion is
	 * collapsing, ui.newHeader and ui.newPanel will be empty jQuery objects.
	 */
	activate(ActivateAdapter.class, null),
	/**
	 * Triggered directly before a panel is activated. Can be canceled to prevent the panel from activating. If the accordion is currently collapsed, ui.oldHeader and ui.oldPanel
	 * will be empty jQuery
	 * objects. If the accordion is collapsing, ui.newHeader and ui.newPanel will be empty jQuery objects.
	 * <p>
	 * Triggered immediately before a tab is activated. Can be canceled to prevent the tab from activating. If the tabs are currently collapsed, ui.oldTab and ui.oldPanel will be
	 * empty jQuery objects.
	 * If the tabs are collapsing, ui.newTab and ui.newPanel will be empty jQuery objects.
	 */
	beforeActivate(BeforeActivateAdapter.class, null),
	beforeStop(BeforeStopAdapter.class, null),
	buttonClickEvent(ButtonClickAdapter.class, null),
	/**
	 * Triggered when the field is blurred, if the value has changed. Triggered when the value of the progressbar changes. Triggered when the selected item has changed. Not every
	 * select event will
	 * fire a change event.
	 */
	change(ChangeAdapter.class, null),
	unselected(UnselectedAdapter.class, null),
	selected(SelectedAdapter.class, null),
	selecting(SelectingAdapter.class, null),
	deactivate(DeactivateAdapter.class, null),
	out(MouseOutAdapter.class, null),
	over(MouseOverAdapter.class, null),
	receive(ReceiveAdapter.class, null),
	remove(RemoveAdapter.class, null),
	sort(SortAdapter.class, null),
	/**
	 * Triggered when the user starts sliding.
	 */
	start(StartAdapter.class, null),
	/**
	 * Triggered after the user slides a handle.
	 */
	stop(StopAdapter.class, null),
	/**
	 * Triggered after a search completes, before the menu is shown.
	 * <p>
	 * Useful for local manipulation of suggestion data, where a custom source option callback is not required. This event is always triggered when a search completes, even if the
	 * menu will not be
	 * shown because there are no results or the Autocomplete is disabled.
	 */
	response(ResponseAdapter.class, null),
	/**
	 * Triggered before a search is performed, after minLength and delay are met. If canceled, then no request will be started and no items suggested.
	 */
	search(SearchAdapter.class, null),
	/**
	 * Triggered when an item is selected from the menu.
	 * <p>
	 * The default action is to replace the text field's value with the value of the selected item.
	 * <p>
	 * Canceling this event prevents the value from being updated, but does not prevent the menu from closing.
	 * <p>
	 * Triggered when a menu item is selected.
	 */
	select(SelectedAdapter.class, null),
	/**
	 * Triggered when the value of the progressbar reaches the maximum value.
	 */
	complete(CompleteAdapter.class, null),
	/**
	 * Triggered on every mouse move during slide. The value provided in the event as ui.value represents the value that the handle will have as a result of the current movement.
	 * Canceling the event
	 * will prevent the handle from moving and the handle will continue to have its previous value.
	 */
	slide(SlideAdapter.class, null),
	/**
	 * <p>
	 * Triggered when a remote tab is about to be loaded, after the beforeActivate event. Can be canceled to prevent the tab panel from loading content; though the panel will still
	 * be activated. This
	 * event is triggered just before the Ajax request is made, so modifications can be made to ui.jqXHR and ui.ajaxSettings.
	 * <p>
	 * Note: Although ui.ajaxSettings is provided and can be modified, some of these properties have already been processed by jQuery. For example, prefilters have been applied,
	 * data has been
	 * processed, and type has been determined. The beforeLoad event occurs at the same time, and therefore has the same restrictions, as the beforeSend callback from
	 * jQuery.ajax().
	 * <p>
	 */
	beforeLoad(BeforeLoadAdapter.class, null),
	/**
	 * Triggered after a remote tab has been loaded.
	 */
	load(LoadAdapter.class, null),
	update(UpdateAdapter.class, null),
	undefined(null, null),
	/**
	 * Triggered during increment/decrement (to determine direction of spin compare current value with ui.value).
	 * <p>
	 * Can be canceled, preventing the value from being updated.
	 */
	spin(SpinAdapter.class, null),
	/**
	 * Marks a data. Always null, Internal.
	 */
	data(null, null),
	checked(CheckedAdapter.class, null),
	submit(SubmitAdapter.class, null),

	async(null, null),
	custom(null, null);

	private final Class classType;
	private final Class ajaxOptionsReturn;

	/**
	 * Registers and Ajax Event Type
	 *
	 * @param classType
	 * @param groupedType
	 */
	EventTypes(Class classType, Class groupedType)
	{
		this.classType = classType;
		ajaxOptionsReturn = groupedType;
	}

	/**
	 * Get the class type that this AJAX event type is matched to
	 *
	 * @return Get the class type that this AJAX event type is matched to
	 */
	public Class getClassType()
	{
		return classType;
	}

	/**
	 * Gets the Ajax Event Types that this event is linked to
	 *
	 * @return Gets the Ajax Event Types that this event is linked to
	 */
	public Class getAjaxOptionsReturn()
	{
		return ajaxOptionsReturn;
	}

	@Override
	@JsonValue
	public String toString()
	{
		return name().toLowerCase();
	}

}
