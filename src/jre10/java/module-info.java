import com.jwebmp.core.annotations.JWebMPSiteBinder;
import com.jwebmp.core.base.angular.controllers.JWAngularController;
import com.jwebmp.core.base.angular.modules.AngularMessagesModule;
import com.jwebmp.core.base.angular.services.*;
import com.jwebmp.core.services.*;
import com.jwebmp.guicedinjection.interfaces.IGuiceDefaultBinder;
import com.jwebmp.guicedservlets.services.IGuiceSiteBinder;

module com.jwebmp.core {

	exports com.jwebmp.core;
	exports com.jwebmp.core.base;
	exports com.jwebmp.core.base.ajax;
	exports com.jwebmp.core.base.angular;
	exports com.jwebmp.core.base.angular.directives;
	exports com.jwebmp.core.base.angular.controllers;
	exports com.jwebmp.core.base.angular.factories;
	exports com.jwebmp.core.base.angular.forms;
	exports com.jwebmp.core.base.angular.modules;
	exports com.jwebmp.core.base.angular.configurations;
	exports com.jwebmp.core.base.client;

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

	exports com.jwebmp.core.events.activate;
	exports com.jwebmp.core.events.beforeactivate;
	exports com.jwebmp.core.events.beforeclose;
	exports com.jwebmp.core.events.beforeload;
	exports com.jwebmp.core.events.beforestop;
	exports com.jwebmp.core.events.blur;
	exports com.jwebmp.core.events.buttonclick;
	exports com.jwebmp.core.events.cancel;
	exports com.jwebmp.core.events.change;
	exports com.jwebmp.core.events.checked;
	exports com.jwebmp.core.events.click;
	exports com.jwebmp.core.events.close;
	exports com.jwebmp.core.events.complete;
	exports com.jwebmp.core.events.create;
	exports com.jwebmp.core.events.deactivate;
	exports com.jwebmp.core.events.drag;
	exports com.jwebmp.core.events.dragstart;
	exports com.jwebmp.core.events.dragstop;
	exports com.jwebmp.core.events.drop;
	exports com.jwebmp.core.events.dropout;
	exports com.jwebmp.core.events.dropover;
	exports com.jwebmp.core.events.focus;
	exports com.jwebmp.core.events.keydown;
	exports com.jwebmp.core.events.keypressed;
	exports com.jwebmp.core.events.keyup;
	exports com.jwebmp.core.events.load;
	exports com.jwebmp.core.events.mousedown;
	exports com.jwebmp.core.events.mouseenter;
	exports com.jwebmp.core.events.mousemove;
	exports com.jwebmp.core.events.mouseout;
	exports com.jwebmp.core.events.mouseover;
	exports com.jwebmp.core.events.mouseup;
	exports com.jwebmp.core.events.open;
	exports com.jwebmp.core.events.receive;
	exports com.jwebmp.core.events.remove;
	exports com.jwebmp.core.events.resize;
	exports com.jwebmp.core.events.resizestart;
	exports com.jwebmp.core.events.resizestop;
	exports com.jwebmp.core.events.response;
	exports com.jwebmp.core.events.rightclick;
	exports com.jwebmp.core.events.search;
	exports com.jwebmp.core.events.select;
	exports com.jwebmp.core.events.selected;
	exports com.jwebmp.core.events.selecting;
	exports com.jwebmp.core.events.slide;
	exports com.jwebmp.core.events.sort;
	exports com.jwebmp.core.events.spin;
	exports com.jwebmp.core.events.start;
	exports com.jwebmp.core.events.stop;
	exports com.jwebmp.core.events.submit;
	exports com.jwebmp.core.events.unselected;
	exports com.jwebmp.core.events.update;

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
	exports com.jwebmp.core.base.angular.forms.enumerations;
	exports com.jwebmp.core.components;

	requires java.logging;
	requires com.jwebmp.logmaster;
	requires com.fasterxml.jackson.annotation;
	requires java.validation;
	requires com.jwebmp.guicedinjection;
	requires aopalliance;
	requires com.jwebmp.interception;
	requires javax.servlet.api;
	requires uadetector.core;

	requires com.google.guice.extensions.servlet;
	requires com.google.guice;
	requires com.jwebmp.guicedservlets;
	requires uadetector.resources;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.module.paramnames;
	requires com.fasterxml.jackson.datatype.jdk8;
	requires com.fasterxml.jackson.datatype.jsr310;
	requires com.fasterxml.jackson.core;

	requires java.sql;
	requires com.google.common;
	requires org.apache.commons.io;
	requires org.apache.commons.lang3;
	requires org.apache.commons.text;

	uses com.jwebmp.core.utilities.regex.IRegularExpressions;
	uses IAngularDirective;
	uses com.jwebmp.core.services.IPageConfigurator;
	uses com.jwebmp.core.services.IPage;
	uses IAngularControllerScopeStatement;
	uses com.jwebmp.core.base.angular.services.IAngularModule;
	uses IAngularConfigurationScopeStatement;
	uses IAngularConfiguration;
	uses IAngularController;
	uses IAngularFactory;
	uses IErrorPage;
	uses RenderBeforeLinks;
	uses RenderAfterLinks;
	uses RenderBeforeDynamicScripts;
	uses RenderAfterScripts;
	uses RenderAfterDynamicScripts;
	uses RenderBeforeScripts;

	provides IGuiceSiteBinder with JWebMPSiteBinder;
	provides IGuiceDefaultBinder with JWebMPServicesBindings;

	provides IAngularModule with AngularMessagesModule;
	provides IAngularController with JWAngularController;

	provides IAngularDirective with com.jwebmp.core.events.activate.ActivateDirective,
			                           com.jwebmp.core.events.beforeactivate.BeforeActivateDirective,
			                           com.jwebmp.core.events.beforeclose.BeforeCloseDirective,
			                           com.jwebmp.core.events.beforeload.BeforeLoadDirective,
			                           com.jwebmp.core.events.beforestop.BeforeStopDirective,
			                           com.jwebmp.core.events.buttonclick.ButtonClickDirective,
			                           com.jwebmp.core.events.cancel.CancelDirective,
			                           com.jwebmp.core.events.close.CloseDirective,
			                           com.jwebmp.core.events.complete.CompleteDirective,
			                           com.jwebmp.core.events.create.CreateDirective,
			                           com.jwebmp.core.events.deactivate.DeactivateDirective,
			                           com.jwebmp.core.events.drag.DragDirective,
			                           com.jwebmp.core.events.dragstart.DragStartDirective,
			                           com.jwebmp.core.events.dragstop.DragStopDirective,
			                           com.jwebmp.core.events.drop.DropDirective,
			                           com.jwebmp.core.events.dropout.DropOutDirective,
			                           com.jwebmp.core.events.dropover.DropOverDirective,
			                           com.jwebmp.core.events.focus.FocusDirective,
			                           com.jwebmp.core.events.load.LoadDirective,
			                           com.jwebmp.core.events.receive.ReceiveDirective,
			                           com.jwebmp.core.events.remove.RemoveDirective,
			                           com.jwebmp.core.events.resize.ResizeDirective,
			                           com.jwebmp.core.events.resizestart.ResizeStartDirective,
			                           com.jwebmp.core.events.resizestop.ResizeStopDirective,
			                           com.jwebmp.core.events.response.ResponseDirective,
			                           com.jwebmp.core.events.rightclick.RightClickDirective,
			                           com.jwebmp.core.events.search.SearchDirective,
			                           com.jwebmp.core.events.select.SelectDirective,
			                           com.jwebmp.core.events.selecting.SelectingDirective,
			                           com.jwebmp.core.events.slide.SlideDirective,
			                           com.jwebmp.core.events.sort.SortDirective,
			                           com.jwebmp.core.events.spin.SpinDirective,
			                           com.jwebmp.core.events.start.StartDirective,
			                           com.jwebmp.core.events.stop.StopDirective,
			                           com.jwebmp.core.events.unselected.UnselectedDirective,
			                           com.jwebmp.core.events.update.UpdateDirective;

	provides com.jwebmp.core.utilities.regex.IRegularExpressions with com.jwebmp.core.utilities.regex.TextRegExPatterns,
			                                                             com.jwebmp.core.utilities.regex.EmailAddressRegExPatterns,
			                                                             com.jwebmp.core.utilities.regex.DateFormatRegExPatterns;

	provides IPageConfigurator with com.jwebmp.core.base.angular.AngularPageConfigurator,
			                           com.jwebmp.core.base.page.ScriptsDynamicPageConfigurator,
			                           com.jwebmp.core.base.page.CSSLinksInsertPageConfigurator,
			                           com.jwebmp.core.base.page.ScriptsInsertPageConfigurator,
			                           com.jwebmp.core.base.page.TopShelfScriptsInsertPageConfigurator,
			                           com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;

	opens com.jwebmp.core.base.servlets to com.google.guice;
	opens com.jwebmp.core.base.page to com.google.guice;
	opens com.jwebmp.core.base.ajax to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.base.html to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.base.angular to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.htmlbuilder.javascript to com.fasterxml.jackson.databind;
	opens com.jwebmp.core.base to com.fasterxml.jackson.databind;
	opens com.jwebmp.core to com.fasterxml.jackson.databind;

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

	exports com.jwebmp.core.services;
	exports com.jwebmp.core.base.angular.services;

}
