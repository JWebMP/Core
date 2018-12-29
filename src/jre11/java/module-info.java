import com.jwebmp.core.annotations.JWebMPSiteBinder;
import com.jwebmp.core.annotations.ObjectMapperBinder;
import com.jwebmp.core.base.servlets.intercepters.LocalStorageIntercepter;
import com.jwebmp.core.implementations.JWebMPDynamicScriptRenderer;
import com.jwebmp.core.implementations.JWebMPJavaScriptDynamicScriptRenderer;
import com.jwebmp.core.implementations.JWebMPModuleExclusions;
import com.jwebmp.core.services.*;
import com.jwebmp.guicedinjection.interfaces.IGuiceDefaultBinder;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanJarExclusions;
import com.jwebmp.guicedinjection.interfaces.IGuiceScanModuleExclusions;
import com.jwebmp.guicedservlets.services.IGuiceSiteBinder;
import com.jwebmp.interception.services.AjaxCallIntercepter;
import com.jwebmp.interception.services.DataCallIntercepter;

module com.jwebmp.core {

	exports com.jwebmp.core;
	exports com.jwebmp.core.base;
	exports com.jwebmp.core.base.ajax;

	exports com.jwebmp.core.base.client;
	exports com.jwebmp.core.services;


	exports com.jwebmp.core.base.html;
	exports com.jwebmp.core.base.html.attributes;
	exports com.jwebmp.core.base.html.inputs;

	exports com.jwebmp.core.base.html.interfaces;
	exports com.jwebmp.core.base.html.interfaces.children;
	exports com.jwebmp.core.base.html.interfaces.children.generics;
	exports com.jwebmp.core.base.html.interfaces.events;

	exports com.jwebmp.core.base.interfaces;

	exports com.jwebmp.core.base.page to com.jwebmp.guicedinjection;

	exports com.jwebmp.core.base.servlets;
	exports com.jwebmp.core.base.servlets.enumarations;
	exports com.jwebmp.core.base.servlets.intercepters;
	exports com.jwebmp.core.base.servlets.interfaces;

	exports com.jwebmp.core.base.servlets.options;
	exports com.jwebmp.core.databind;

	exports com.jwebmp.core.events.activate to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.beforeactivate to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.beforeclose to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.beforeload to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.beforestop to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.blur to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.buttonclick to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.cancel to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.change to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.checked to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.click to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui, com.jwebmp.plugins.softhistorychange, com.jwebmp.plugins.bsquickforms4, com.jwebmp.plugins.quickforms;
	exports com.jwebmp.core.events.close to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.complete to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.create to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.deactivate to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.drag to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.dragstart to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.dragstop to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.drop to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.dropout to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.dropover to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.focus to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.keydown to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.keypressed to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.keyup to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.load to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.mousedown to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.mouseenter to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.mousemove to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.mouseout to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.mouseover to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.mouseup to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.open to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.receive to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.remove to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.resize to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.resizestart to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.resizestop to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.response to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.rightclick to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.search to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.select to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui, com.jwebmp.plugins.jqxwidgets;
	exports com.jwebmp.core.events.selected to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.selecting to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.slide to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.sort to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.spin to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.start to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.stop to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.submit to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.unselected to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;
	exports com.jwebmp.core.events.update to com.jwebmp.core.angularjs, com.jwebmp.plugins.jqueryui;

	exports com.jwebmp.core.exceptions;

	exports com.jwebmp.core.generics;

	exports com.jwebmp.core.annotations;
	exports com.jwebmp.core.htmlbuilder.css;
	exports com.jwebmp.core.htmlbuilder.css.animatable;
	exports com.jwebmp.core.htmlbuilder.css.annotations;
	exports com.jwebmp.core.htmlbuilder.css.backgrounds;
	exports com.jwebmp.core.htmlbuilder.css.borders;
	exports com.jwebmp.core.htmlbuilder.css.colours;
	exports com.jwebmp.core.htmlbuilder.css.composer;
	exports com.jwebmp.core.htmlbuilder.css.displays;
	exports com.jwebmp.core.htmlbuilder.css.enumarations;
	exports com.jwebmp.core.htmlbuilder.css.fonts;
	exports com.jwebmp.core.htmlbuilder.css.heightwidth;
	exports com.jwebmp.core.htmlbuilder.css.image;
	exports com.jwebmp.core.htmlbuilder.css.interfaces;
	exports com.jwebmp.core.htmlbuilder.css.lists;
	exports com.jwebmp.core.htmlbuilder.css.margins;
	exports com.jwebmp.core.htmlbuilder.css.measurement;
	exports com.jwebmp.core.htmlbuilder.css.outline;
	exports com.jwebmp.core.htmlbuilder.css.padding;
	exports com.jwebmp.core.htmlbuilder.css.tables;
	exports com.jwebmp.core.htmlbuilder.css.text;
	exports com.jwebmp.core.htmlbuilder.css.themes;

	exports com.jwebmp.core.htmlbuilder.javascript;
	exports com.jwebmp.core.htmlbuilder.javascript.events.commandevent;
	exports com.jwebmp.core.htmlbuilder.javascript.events.enumerations;
	exports com.jwebmp.core.htmlbuilder.javascript.events.interfaces;

	exports com.jwebmp.core.plugins;
	exports com.jwebmp.core.plugins.ajaxenabler;
	exports com.jwebmp.core.plugins.jquery;

	exports com.jwebmp.core.utilities;
	exports com.jwebmp.core.utilities.dualquickpivot;
	exports com.jwebmp.core.utilities.regex;

	exports com.jwebmp.core.base.references;

	requires java.logging;
	requires com.jwebmp.logmaster;
	requires com.jwebmp.guicedinjection;
	requires com.jwebmp.interception;
	requires com.jwebmp.guicedservlets;

	requires net.sf.uadetector.core;
	requires net.sf.uadetector.resources;

	requires java.validation;

	requires aopalliance;

	requires javax.servlet.api;

	requires com.google.guice.extensions.servlet;
	requires com.google.guice;

	requires com.fasterxml.jackson.annotation;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.core;

	requires com.google.common;
	requires org.apache.commons.io;
	requires org.apache.commons.lang3;
	requires org.apache.commons.text;

	requires com.fasterxml.jackson.module.guice;

	uses IRegularExpressions;

	uses com.jwebmp.core.services.IPageConfigurator;
	uses com.jwebmp.core.services.IPage;


	uses IErrorPage;
	uses RenderBeforeLinks;
	uses RenderAfterLinks;
	uses RenderBeforeDynamicScripts;
	uses RenderAfterScripts;
	uses RenderAfterDynamicScripts;
	uses RenderBeforeScripts;


	uses com.jwebmp.core.events.activate.IOnActivateService;
	uses com.jwebmp.core.events.beforeactivate.IOnBeforeActivateService;
	uses com.jwebmp.core.events.beforeclose.IOnBeforeCloseService;
	uses com.jwebmp.core.events.beforeload.IOnBeforeLoadService;
	uses com.jwebmp.core.events.blur.IOnBlurService;
	uses com.jwebmp.core.events.beforestop.IOnBeforeStopService;
	uses com.jwebmp.core.events.buttonclick.IOnButtonClickService;
	uses com.jwebmp.core.events.cancel.IOnCancelService;
	uses com.jwebmp.core.events.change.IOnChangeService;
	uses com.jwebmp.core.events.checked.IOnCheckedService;
	uses com.jwebmp.core.events.close.IOnCloseService;
	uses com.jwebmp.core.events.click.IOnClickService;
	uses com.jwebmp.core.events.complete.IOnCompleteService;
	uses com.jwebmp.core.events.create.IOnCreateService;
	uses com.jwebmp.core.events.deactivate.IOnDeActivateService;
	uses com.jwebmp.core.events.drag.IOnDragService;
	uses com.jwebmp.core.events.dragstart.IOnDragStartService;
	uses com.jwebmp.core.events.dragstop.IOnDragStopService;
	uses com.jwebmp.core.events.drop.IOnDropService;
	uses com.jwebmp.core.events.dropover.IOnDropOverService;
	uses com.jwebmp.core.events.focus.IOnFocusService;
	uses com.jwebmp.core.events.keydown.IOnKeyDownService;
	uses com.jwebmp.core.events.keypressed.IOnKeyPressedService;
	uses com.jwebmp.core.events.keyup.IOnKeyUpService;
	uses com.jwebmp.core.events.load.IOnLoadService;
	uses com.jwebmp.core.events.mouseenter.IOnMouseEnterService;
	uses com.jwebmp.core.events.mousemove.IOnMouseMoveService;
	uses com.jwebmp.core.events.mouseout.IOnMouseOutService;
	uses com.jwebmp.core.events.mouseover.IOnMouseOverService;
	uses com.jwebmp.core.events.mouseup.IOnMouseUpService;
	uses com.jwebmp.core.events.open.IOnOpenService;
	uses com.jwebmp.core.events.receive.IOnReceiveService;
	uses com.jwebmp.core.events.remove.IOnRemoveService;
	uses com.jwebmp.core.events.resize.IOnResizeService;
	uses com.jwebmp.core.events.resizestop.IOnResizeStopService;
	uses com.jwebmp.core.events.response.IOnResponseService;
	uses com.jwebmp.core.events.rightclick.IOnRightClickService;
	uses com.jwebmp.core.events.select.IOnSelectService;
	uses com.jwebmp.core.events.search.IOnSearchService;
	uses com.jwebmp.core.events.selected.IOnSelectedService;
	uses com.jwebmp.core.events.selecting.IOnSelectingService;
	uses com.jwebmp.core.events.slide.IOnSlideService;
	uses com.jwebmp.core.events.sort.IOnSortService;
	uses com.jwebmp.core.events.spin.IOnSpinService;
	uses com.jwebmp.core.events.start.IOnStartService;
	uses com.jwebmp.core.events.stop.IOnStopService;
	uses com.jwebmp.core.events.submit.IOnSubmitService;
	uses com.jwebmp.core.events.unselected.IOnUnSelectedService;
	uses com.jwebmp.core.events.update.IOnUpdateService;
	uses com.jwebmp.core.databind.IOnDataBind;
	uses com.jwebmp.core.databind.IOnDataBindCloak;


	uses IDynamicRenderingServlet;


	provides DataCallIntercepter with LocalStorageIntercepter;
	provides AjaxCallIntercepter with LocalStorageIntercepter;

	provides IGuiceSiteBinder with JWebMPSiteBinder;
	provides IGuiceDefaultBinder with JWebMPServicesBindings, ObjectMapperBinder;


	provides IGuiceScanJarExclusions with JWebMPModuleExclusions;
	provides IGuiceScanModuleExclusions with JWebMPModuleExclusions;

	provides IDynamicRenderingServlet with JWebMPDynamicScriptRenderer, JWebMPJavaScriptDynamicScriptRenderer;


	provides IRegularExpressions with com.jwebmp.core.utilities.regex.TextRegExPatterns,
			                             com.jwebmp.core.utilities.regex.EmailAddressRegExPatterns,
			                             com.jwebmp.core.utilities.regex.DateFormatRegExPatterns;

	provides IPageConfigurator with com.jwebmp.core.base.page.ScriptsDynamicPageConfigurator,
			                           com.jwebmp.core.base.page.CSSLinksInsertPageConfigurator,
			                           com.jwebmp.core.base.page.ScriptsInsertPageConfigurator,
			                           com.jwebmp.core.base.page.TopShelfScriptsInsertPageConfigurator,
			                           com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;

	opens com.jwebmp.core.base.servlets to com.google.guice, com.fasterxml.jackson.databind;

	opens com.jwebmp.core.base.page to com.google.guice;
	opens com.jwebmp.core.base.ajax to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.base.html to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.javascript to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.base to com.fasterxml.jackson.databind;
	opens com.jwebmp.core to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.implementations to com.google.guice, com.fasterxml.jackson.databind;

	opens com.jwebmp.core.htmlbuilder.css.annotations to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.interfaces to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.animatable to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.backgrounds to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.borders to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.colours to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.composer to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.displays to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.enumarations to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.fonts to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.heightwidth to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.image to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.lists to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.margins to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.measurement to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.outline to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.padding to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.tables to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.text to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.css.themes to com.fasterxml.jackson.databind;

	opens com.jwebmp.core.base.client to com.fasterxml.jackson.databind;

	opens com.jwebmp.core.base.servlets.interfaces to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.base.servlets.options to com.fasterxml.jackson.databind;

	opens com.jwebmp.core.utilities.regex to com.fasterxml.jackson.databind;
	exports com.jwebmp.core.components;


}
