import com.guicedee.guicedinjection.interfaces.IGuiceModule;
import com.jwebmp.core.events.services.*;
import com.jwebmp.core.implementations.JWebMPServicesBindings;
import com.jwebmp.core.implementations.JWebMPSiteBinder;
import com.jwebmp.interception.JWebMPInterceptionBinder;

module com.jwebmp.core {

    requires static lombok;

    requires transitive com.guicedee.client;
    requires transitive com.guicedee.guicedservlets;
    requires transitive jakarta.validation;
    requires transitive jakarta.servlet;
    requires transitive com.google.guice.extensions.servlet;

    requires net.sf.uadetector.core;
    requires net.sf.uadetector.resources;

    requires aopalliance;

    requires com.google.guice;

    requires com.guicedee.jsonrepresentation;

    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;

    requires jakarta.websocket;
    requires jakarta.websocket.client;

    requires com.google.common;
    requires org.apache.commons.io;
    requires org.apache.commons.lang3;
    requires org.apache.commons.text;
    requires com.jwebmp.client;

    exports com.jwebmp.core;
    exports com.jwebmp.core.base;
    //exports com.jwebmp.core.base.ajax;

    // exports com.jwebmp.core.base.client;
    // exports com.jwebmp.core.services;

    exports com.jwebmp.core.base.html;
    // exports com.jwebmp.core.base.html.attributes;
    exports com.jwebmp.core.base.html.inputs;

    //  exports com.jwebmp.core.base.html.interfaces;
    //  exports com.jwebmp.core.base.html.interfaces.children;
    //  exports com.jwebmp.core.base.html.interfaces.children.generics;
    //  exports com.jwebmp.core.base.html.interfaces.events;

    //  exports com.jwebmp.core.base.interfaces;

    exports com.jwebmp.core.base.page;

    exports com.jwebmp.core.base.servlets;
    //   exports com.jwebmp.core.base.servlets.enumarations;
    //  exports com.jwebmp.core.base.servlets.interfaces;

    exports com.jwebmp.core.base.servlets.options;
    //exports com.jwebmp.core.databind;

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

    //   exports com.jwebmp.core.generics;

    exports com.jwebmp.core.annotations;

    exports com.jwebmp.core.htmlbuilder.css;
    exports com.jwebmp.core.htmlbuilder.css.animatable;
    exports com.jwebmp.core.htmlbuilder.css.annotations;
    exports com.jwebmp.core.htmlbuilder.css.backgrounds;
    exports com.jwebmp.core.htmlbuilder.css.borders;
    exports com.jwebmp.core.htmlbuilder.css.colours;
    exports com.jwebmp.core.htmlbuilder.css.composer;
    exports com.jwebmp.core.htmlbuilder.css.displays;
    //   exports com.jwebmp.core.htmlbuilder.css.enumarations;
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
    //  exports com.jwebmp.core.htmlbuilder.css.themes;

    exports com.jwebmp.interception.services;
    exports com.jwebmp.interception;

    //  exports com.jwebmp.core.htmlbuilder.javascript;
    exports com.jwebmp.core.htmlbuilder.javascript.events.commandevent;
    exports com.jwebmp.core.htmlbuilder.javascript.events.enumerations;
    //   exports com.jwebmp.core.htmlbuilder.javascript.events.interfaces;

//    exports com.jwebmp.core.plugins;

    exports com.jwebmp.core.utilities;
    exports com.jwebmp.core.utilities.dualquickpivot;
    exports com.jwebmp.core.utilities.regex;

//	exports com.jwebmp.core.services.scopes;

    //  exports com.jwebmp.core.base.references;

    uses com.jwebmp.interception.services.AjaxCallIntercepter;
    uses com.jwebmp.interception.services.DataCallIntercepter;
    uses com.jwebmp.interception.services.SiteCallIntercepter;

    uses com.jwebmp.core.services.IRegularExpressions;

    uses com.jwebmp.core.services.IPageConfigurator;
    uses com.jwebmp.core.services.IPage;

    uses com.jwebmp.core.services.IErrorPage;
    uses com.jwebmp.core.services.RenderBeforeLinks;
    uses com.jwebmp.core.services.RenderAfterLinks;
    uses com.jwebmp.core.services.RenderBeforeDynamicScripts;
    uses com.jwebmp.core.services.RenderAfterScripts;
    uses com.jwebmp.core.services.RenderAfterDynamicScripts;
    uses com.jwebmp.core.services.RenderBeforeScripts;

    uses IOnActivateService;
    uses IOnBeforeActivateService;
    uses IOnBeforeCloseService;
    uses IOnBeforeLoadService;
    uses IOnBlurService;
    uses IOnBeforeStopService;
    uses IOnButtonClickService;
    uses IOnCancelService;
    uses IOnChangeService;
    uses IOnCheckedService;
    uses IOnCloseService;
    uses IOnClickService;
    uses IOnCompleteService;
    uses IOnCreateService;
    uses IOnDeActivateService;
    uses IOnDragService;
    uses IOnDragStartService;
    uses IOnDragStopService;
    uses IOnDropService;
    uses IOnDropOverService;
    uses IOnFocusService;
    uses IOnKeyDownService;
    uses IOnKeyPressedService;
    uses IOnKeyUpService;
    uses IOnLoadService;
    uses IOnMouseEnterService;
    uses IOnMouseMoveService;
    uses IOnMouseOutService;
    uses IOnMouseOverService;
    uses IOnMouseUpService;
    uses IOnOpenService;
    uses IOnReceiveService;
    uses IOnRemoveService;
    uses IOnResizeService;
    uses IOnResizeStopService;
    uses IOnResponseService;
    uses IOnRightClickService;
    uses IOnSelectService;
    uses IOnSearchService;
    uses IOnSelectedService;
    uses IOnSelectingService;
    uses IOnSlideService;
    uses IOnSortService;
    uses IOnSpinService;
    uses IOnStartService;
    uses IOnStopService;
    uses IOnSubmitService;
    uses IOnUnSelectedService;
    uses IOnUpdateService;
    uses com.jwebmp.core.databind.IOnDataBind;
    uses com.jwebmp.core.databind.IOnDataBindCloak;

    uses com.jwebmp.core.services.IDynamicRenderingServlet;
    uses IOnDropOutService;
    uses IOnMouseDownService;
    uses IOnResizeStartService;
    uses com.jwebmp.core.events.IEventConfigurator;
    uses com.jwebmp.core.databind.IOnComponentHtmlRender;
    uses com.jwebmp.core.databind.IOnComponentAdded;


    provides IGuiceModule with JWebMPServicesBindings, JWebMPInterceptionBinder, JWebMPSiteBinder;

    provides com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions with com.jwebmp.core.implementations.JWebMPModuleInclusions;

    provides com.jwebmp.core.services.IDynamicRenderingServlet with com.jwebmp.core.implementations.JWebMPDynamicScriptRenderer, com.jwebmp.core.implementations.JWebMPJavaScriptDynamicScriptRenderer;

    provides com.jwebmp.core.services.IRegularExpressions with com.jwebmp.core.utilities.regex.TextRegExPatterns, com.jwebmp.core.utilities.regex.EmailAddressRegExPatterns, com.jwebmp.core.utilities.regex.DateFormatRegExPatterns;

    provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.core.base.page.ScriptsDynamicPageConfigurator, com.jwebmp.core.base.page.CSSLinksInsertPageConfigurator, com.jwebmp.core.base.page.ScriptsInsertPageConfigurator, com.jwebmp.core.base.page.TopShelfScriptsInsertPageConfigurator;

    opens com.jwebmp.core.base.servlets to com.google.guice, com.fasterxml.jackson.databind;

    opens com.jwebmp.core.base.page to com.google.guice;
    //  opens com.jwebmp.core.base.ajax to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.base.html to com.fasterxml.jackson.databind;
    //  opens com.jwebmp.core.htmlbuilder.javascript to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.base to com.fasterxml.jackson.databind;

    opens com.jwebmp.core to com.google.guice, com.fasterxml.jackson.databind;
    opens com.jwebmp.core.implementations to com.google.guice, com.fasterxml.jackson.databind;
//	opens com.jwebmp.core.services.scopes to com.google.guice, com.fasterxml.jackson.databind;

    opens com.jwebmp.core.htmlbuilder.css to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.htmlbuilder.css.annotations to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.htmlbuilder.css.interfaces to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.htmlbuilder.css.animatable to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.htmlbuilder.css.backgrounds to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.htmlbuilder.css.borders to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.htmlbuilder.css.colours to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.htmlbuilder.css.composer to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.htmlbuilder.css.displays to com.fasterxml.jackson.databind;
    // opens com.jwebmp.core.htmlbuilder.css.enumarations to com.fasterxml.jackson.databind;
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
    //  opens com.jwebmp.core.htmlbuilder.css.themes to com.fasterxml.jackson.databind;

    //  opens com.jwebmp.core.base.client to com.fasterxml.jackson.databind;

    //  opens com.jwebmp.core.base.servlets.interfaces to com.fasterxml.jackson.databind;
    opens com.jwebmp.core.base.servlets.options to com.fasterxml.jackson.databind;

    opens com.jwebmp.core.utilities.regex to com.fasterxml.jackson.databind;

    exports com.jwebmp.core.components;
    exports com.jwebmp.core.events;
    exports com.jwebmp.core.enumerations;
    exports com.jwebmp.core.implementations;

}
