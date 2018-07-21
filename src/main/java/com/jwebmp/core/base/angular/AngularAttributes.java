/*
 * Copyright (C) 2017 Marc Magon
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
package com.jwebmp.core.base.angular;

import com.jwebmp.core.base.html.interfaces.AttributeDefinitions;

/**
 * A list of the attributes for angular
 *
 * @author GedMarc
 * @since 26 Apr 2016
 */
public enum AngularAttributes
		implements AttributeDefinitions
{
	ngApp("ng-app"),
	ngBind("ng-bind"),
	ngBindHtml("ng-bind-html"),
	ngBindTemplate("ng-bind-template"),
	ngBlur("ng-blur"),
	ngChange("ng-change"),
	ngChecked("ng-checked"),
	ngClass("ng-class"),
	ngClassEven("ng-class-even"),
	ngClassOdd("ng-class-odd"),
	ngClick("ng-click"),
	ngCloak("ng-cloak", true),
	ngController("ng-controller"),
	ngCopy("ng-copy"),
	ngCsp("ng-csp"),
	ngCut("ng-cut"),
	ngDblclick("ng-dblclick"),
	ngDisabled("ng-disabled"),
	ngFocus("ng-focus"),
	ngForm("ng-form"),
	ngHide("ng-hide"),
	ngHref("ng-href"),
	ngIf("ng-if"),
	ngInclude("ng-include"),
	ngInit("ng-init"),
	ngJq("ng-jq"),
	ngKeydown("ng-keydown"),
	ngKeypress("ng-keypress"),
	ngKeyup("ng-keyup"),
	ngList("ng-list"),
	ngMaxlength("ng-maxlength"),
	ngMinlength("ng-minlength"),
	ngModel("ng-model"),
	ngModelOptions("ng-model-options"),
	ngMousedown("ng-mousedown"),
	ngMouseenter("ng-mouseenter"),
	ngMouseleave("ng-mouseleave"),
	ngMousemove("ng-mousemove"),
	ngMouseover("ng-mouseover"),
	ngMouseup("ng-mouseup"),
	ngNonBindable("ng-non-bindable"),
	ngOpen("ng-open"),
	ngOptions("ng-options"),
	ngPaste("ng-paste"),
	ngPattern("ng-pattern"),
	ngPluralize("ng-pluralize"),
	ngReadonly("ng-readonly"),
	ngRepeat("ng-repeat"),
	ngRequired("ng-required"),
	ngRightClick("ng-right-click"),
	ngSelected("ng-selected"),
	ngShow("ng-show"),
	ngSrc("ng-src"),
	ngSrcset("ng-srcset"),
	ngStyle("ng-style"),
	ngSubmit("ng-submit"),
	ngSwitch("ng-switch"),
	ngTransclude("ng-transclude"),
	ngValue("ng-value"),

	//The custom ones

	ngButtonClick("ng-button-click"),
	ngActivate("ng-activate"),
	ngBeforeActivate("ng-before-activate"),
	ngBeforeClose("ng-before-close"),
	ngBeforeLoad("ng-before-load"),
	ngBeforeStop("ng-before-stop"),
	ngCancel("ng-cancel"),
	ngClose("ng-close"),
	ngComplete("ng-complete"),
	ngCreate("ng-create"),
	ngDeActivate("ng-de-activate"),
	ngDrag("ng-drag"),
	ngDragStart("ng-drag-start"),
	ngDragStop("ng-drag-stop"),
	ngDrop("ng-drop"),
	ngDropOut("ng-drop-out"),
	ngDropOver("ng-drop-over"),
	ngLoad("ng-load"),
	ngReceive("ng-receive"),
	ngRemove("ng-remove"),
	ngResize("ng-resize"),
	ngResizeStart("ng-resize-start"),
	ngResizeStop("ng-resize-stop"),
	ngResponse("ng-response"),
	ngSearch("ng-search"),
	ngSelect("ng-select"),
	ngSelecting("ng-selecting"),
	ngSlide("ng-slide"),
	ngSort("ng-sort"),
	ngSpin("ng-spin"),
	ngStart("ng-start"),
	ngStop("ng-stop"),
	ngUnselected("ng-un-selected"),
	ngUpdate("ng-update"),

	//Event more customs

	ngJSTreeOnChanged("ng-jstree-onchanged");

	private String attributeName;

	private boolean isKeyword;

	AngularAttributes(String attributeName)
	{
		this.attributeName = attributeName;
	}

	AngularAttributes(String attributeName, boolean isKeyword)
	{
		this.attributeName = attributeName;
		this.isKeyword = isKeyword;
	}

	@Override
	public String toString()
	{
		return getAttributeName();
	}

	/**
	 * Returns the attribute name to display
	 *
	 * @return
	 */
	public String getAttributeName()
	{
		return attributeName;
	}

	/**
	 * Sets the attribute name
	 *
	 * @param attributeName
	 */
	public void setAttributeName(String attributeName)
	{
		this.attributeName = attributeName;
	}

	@Override
	public boolean isKeyword()
	{
		return isKeyword;
	}
}
