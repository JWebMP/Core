module com.jwebmp.core {

	exports com.jwebmp;
	exports com.jwebmp.base;
	exports com.jwebmp.base.ajax;
	exports com.jwebmp.base.angular;
	exports com.jwebmp.base.angular.directives;
	exports com.jwebmp.base.angular.controllers;
	exports com.jwebmp.base.angular.factories;
	exports com.jwebmp.base.angular.forms;
	exports com.jwebmp.base.angular.modules;
	exports com.jwebmp.base.angular.configurations;
	exports com.jwebmp.base.client;

	exports com.jwebmp.base.html;
	exports com.jwebmp.base.html.attributes;
	exports com.jwebmp.base.html.inputs;

	opens com.jwebmp.base.html.interfaces;
	opens com.jwebmp.base.html.interfaces.children;
	opens com.jwebmp.base.html.interfaces.children.generics;
	opens com.jwebmp.base.html.interfaces.events;

	exports com.jwebmp.base.html.interfaces;
	exports com.jwebmp.base.html.interfaces.children;
	exports com.jwebmp.base.html.interfaces.children.generics;
	exports com.jwebmp.base.html.interfaces.events;

	exports com.jwebmp.base.interfaces;

	exports com.jwebmp.base.page to com.jwebmp.guicedinjection;

	exports com.jwebmp.base.servlets;
	exports com.jwebmp.base.servlets.enumarations;
	exports com.jwebmp.base.servlets.intercepters;
	exports com.jwebmp.base.servlets.interfaces;
	opens com.jwebmp.base.servlets.interfaces;


	exports com.jwebmp.base.servlets.options;

	exports com.jwebmp.events.activate;
	exports com.jwebmp.events.beforeactivate;
	exports com.jwebmp.events.beforeclose;
	exports com.jwebmp.events.beforeload;
	exports com.jwebmp.events.beforestop;
	exports com.jwebmp.events.blur;
	exports com.jwebmp.events.buttonclick;
	exports com.jwebmp.events.cancel;
	exports com.jwebmp.events.change;
	exports com.jwebmp.events.checked;
	exports com.jwebmp.events.click;
	exports com.jwebmp.events.close;
	exports com.jwebmp.events.complete;
	exports com.jwebmp.events.create;
	exports com.jwebmp.events.deactivate;
	exports com.jwebmp.events.drag;
	exports com.jwebmp.events.dragstart;
	exports com.jwebmp.events.dragstop;
	exports com.jwebmp.events.drop;
	exports com.jwebmp.events.dropout;
	exports com.jwebmp.events.dropover;
	exports com.jwebmp.events.focus;
	exports com.jwebmp.events.keydown;
	exports com.jwebmp.events.keypressed;
	exports com.jwebmp.events.keyup;
	exports com.jwebmp.events.load;
	exports com.jwebmp.events.mousedown;
	exports com.jwebmp.events.mouseenter;
	exports com.jwebmp.events.mousemove;
	exports com.jwebmp.events.mouseout;
	exports com.jwebmp.events.mouseover;
	exports com.jwebmp.events.mouseup;
	exports com.jwebmp.events.open;
	exports com.jwebmp.events.receive;
	exports com.jwebmp.events.remove;
	exports com.jwebmp.events.resize;
	exports com.jwebmp.events.resizestart;
	exports com.jwebmp.events.resizestop;
	exports com.jwebmp.events.response;
	exports com.jwebmp.events.rightclick;
	exports com.jwebmp.events.search;
	exports com.jwebmp.events.select;
	exports com.jwebmp.events.selected;
	exports com.jwebmp.events.selecting;
	exports com.jwebmp.events.slide;
	exports com.jwebmp.events.sort;
	exports com.jwebmp.events.spin;
	exports com.jwebmp.events.start;
	exports com.jwebmp.events.stop;
	exports com.jwebmp.events.submit;
	exports com.jwebmp.events.unselected;
	exports com.jwebmp.events.update;

	exports com.jwebmp.exceptions;

	exports com.jwebmp.generics;

	exports com.jwebmp.annotations;
	exports com.jwebmp.htmlbuilder.css;
	exports com.jwebmp.htmlbuilder.css.animatable;
	exports com.jwebmp.htmlbuilder.css.annotations;
	exports com.jwebmp.htmlbuilder.css.backgrounds;
	exports com.jwebmp.htmlbuilder.css.borders;
	exports com.jwebmp.htmlbuilder.css.colours;
	exports com.jwebmp.htmlbuilder.css.composer;
	exports com.jwebmp.htmlbuilder.css.displays;
	exports com.jwebmp.htmlbuilder.css.enumarations;
	exports com.jwebmp.htmlbuilder.css.fonts;
	exports com.jwebmp.htmlbuilder.css.heightwidth;
	exports com.jwebmp.htmlbuilder.css.image;
	exports com.jwebmp.htmlbuilder.css.interfaces;
	exports com.jwebmp.htmlbuilder.css.lists;
	exports com.jwebmp.htmlbuilder.css.margins;
	exports com.jwebmp.htmlbuilder.css.measurement;
	exports com.jwebmp.htmlbuilder.css.outline;
	exports com.jwebmp.htmlbuilder.css.padding;
	exports com.jwebmp.htmlbuilder.css.tables;
	exports com.jwebmp.htmlbuilder.css.text;
	exports com.jwebmp.htmlbuilder.css.themes;

	exports com.jwebmp.htmlbuilder.javascript;
	exports com.jwebmp.htmlbuilder.javascript.events.commandevent;
	exports com.jwebmp.htmlbuilder.javascript.events.enumerations;
	exports com.jwebmp.htmlbuilder.javascript.events.interfaces;

	exports com.jwebmp.plugins;
	exports com.jwebmp.plugins.ajaxenabler;
	exports com.jwebmp.plugins.jquery;

	exports com.jwebmp.utilities;
	exports com.jwebmp.utilities.dualquickpivot;
	exports com.jwebmp.utilities.regex;

	exports com.jwebmp.base.references;
	exports com.jwebmp.base.angular.forms.enumerations;
	exports com.jwebmp.components;

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
	requires commons.io;
	requires commons.lang3;
	requires java.sql;
	requires com.google.common;

	uses com.jwebmp.utilities.regex.IRegularExpressions;
	uses com.jwebmp.base.angular.directives.IAngularDirective;

	provides com.jwebmp.base.angular.directives.IAngularDirective with com.jwebmp.events.activate.ActivateDirective,
			                                                              com.jwebmp.events.beforeactivate.BeforeActivateDirective,
			                                                              com.jwebmp.events.beforeclose.BeforeCloseDirective,
			                                                              com.jwebmp.events.beforeload.BeforeLoadDirective,
			                                                              com.jwebmp.events.beforestop.BeforeStopDirective,
			                                                              com.jwebmp.events.buttonclick.ButtonClickDirective,
			                                                              com.jwebmp.events.cancel.CancelDirective,
			                                                              com.jwebmp.events.close.CloseDirective,
			                                                              com.jwebmp.events.complete.CompleteDirective,
			                                                              com.jwebmp.events.create.CreateDirective,
			                                                              com.jwebmp.events.deactivate.DeactivateDirective,
			                                                              com.jwebmp.events.drag.DragDirective,
			                                                              com.jwebmp.events.dragstart.DragStartDirective,
			                                                              com.jwebmp.events.dragstop.DragStopDirective,
			                                                              com.jwebmp.events.drop.DropDirective,
			                                                              com.jwebmp.events.dropout.DropOutDirective,
			                                                              com.jwebmp.events.dropover.DropOverDirective,
			                                                              com.jwebmp.events.focus.FocusDirective,
			                                                              com.jwebmp.events.load.LoadDirective,
			                                                              com.jwebmp.events.receive.ReceiveDirective,
			                                                              com.jwebmp.events.remove.RemoveDirective,
			                                                              com.jwebmp.events.resize.ResizeDirective,
			                                                              com.jwebmp.events.resizestart.ResizeStartDirective,
			                                                              com.jwebmp.events.resizestop.ResizeStopDirective,
			                                                              com.jwebmp.events.response.ResponseDirective,
			                                                              com.jwebmp.events.rightclick.RightClickDirective,
			                                                              com.jwebmp.events.search.SearchDirective,
			                                                              com.jwebmp.events.select.SelectDirective,
			                                                              com.jwebmp.events.selecting.SelectingDirective,
			                                                              com.jwebmp.events.slide.SlideDirective,
			                                                              com.jwebmp.events.sort.SortDirective,
			                                                              com.jwebmp.events.spin.SpinDirective,
			                                                              com.jwebmp.events.start.StartDirective,
			                                                              com.jwebmp.events.stop.StopDirective,
			                                                              com.jwebmp.events.unselected.UnselectedDirective,
			                                                              com.jwebmp.events.update.UpdateDirective;

	provides com.jwebmp.guicedinjection.scanners.PackageContentsScanner with com.jwebmp.JWebSwingPackageScanner;

	provides com.jwebmp.utilities.regex.IRegularExpressions with com.jwebmp.utilities.regex.TextRegExPatterns,
			                                                        com.jwebmp.utilities.regex.EmailAddressRegExPatterns,
			                                                        com.jwebmp.utilities.regex.DateFormatRegExPatterns;

	opens com.jwebmp.base.servlets to com.google.guice;
	opens com.jwebmp.base.page to com.google.guice;
}
