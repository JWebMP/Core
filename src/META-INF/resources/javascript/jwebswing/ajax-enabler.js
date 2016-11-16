var ids;
var currentEventType;
var componentID;
var componentRenderingID;
var nextComponentID;

var myLayout;

//JQuery implementation of the events system
$.fn.jw = function (opts) {
    opts = $.extend({}, $.fn.jw.defaults, opts);
    var event = opts.eventType;
    $(this).on(event + '.' + opts.eventNameSpace, "*", function () {
        performAjax($(this).attr('id'), event, event, opts.valueFunction);
    });

    $.fn.jw.defaults = {
        eventType: 'EventType',
        eventNameSpace: 'jw',
        valueFunction: $(this).val()
    };
};

var currentReceived;
/**
 * Processes an ajax call received
 * @param {xml} xml The xml returned
 * @returns {undefined}
 */
function receiveUpdate(xml)
{
    $(xml).find("compUpdate").each(function () {
        currentReceived = $(this).text();
        componentID = $(this).find("ID").text();
        //alert('updating component [' + $('#' + componentID).attr("id"));
        var command = $(this).find("Commands").text();
        componentRenderingID = $(this).find('ComponentRendering').text();
        if (componentRenderingID === '')
        {
            if (processHTML($(this), false)) //process html synchronously
            {
                //alert('html done');
                processCSSLinks($(this));
                processCSS($(this));
                if (processScriptLinks($(this))) //synchronously process the js files then the scripts
                {
                    processScripts($(this));
                } else
                    alert('Couldnt Load JavaScript');
                resizeLayouts();
            } else
                alert('Couldnt Process HTML');
        } else
        {
            //alert('Processing Streamer');
            componentRenderingID = $(this).find('ComponentRendering').text();
            nextComponentID = $(this).find('NextComponentToRender').text();
            //alert('Current Component Busy Adding On [' + componentRenderingID + ']. It is being added onto [' + componentID + ']. Next Component is [' + nextComponentID + ']');
            processCommand($(this));
        }
    });
}

function processScripts(componentXml)
{
    var allScripts = componentXml.find("ScriptUpdate");
    var upTo = allScripts.length;
    var current = 0;
    for (var eachScript in allScripts)
    {
        if (current === upTo)
            break;

        if (typeof allScripts[eachScript] === 'object')
        {
            var jQObject = jQuery(allScripts[eachScript]);
            var check = jQObject.val();
            if (check === 0) {
                jQObject.addClass('js_warning');
                return false;
            }
            var script = jQObject.text();
            //alert('loading script \n' + script);
            jQuery.globalEval(script);
        }
        current++;
    }
   // alert('scripts done');
}

// Usage
//$.cachedScript( "ajax/test.js" ).done(function( script, textStatus ) {
//  console.log( textStatus );
//});

jQuery.cachedScript = function (url, options) {

    // Allow user to set any option except for dataType, cache, and url
    options = $.extend(options || {}, {
        dataType: "script",
        cache: true,
        url: url,
        async: false
    });

    // Use $.ajax() since it is more flexible than $.getScript
    // Return the jqXHR object so we can chain callbacks
    return jQuery.ajax(options);
};



var scriptsDynamicallyLoaded = [];

function processScriptLinks(componentXml)
{
    var allScripts = componentXml.find("ScriptLinkUpdate");
    var upTo = allScripts.length;
    var current = 0;
    for (var eachScript in allScripts)
    {
        if (current === upTo)
            break;

        if (typeof allScripts[eachScript] === 'object')
        {
            var jQObject = jQuery(allScripts[eachScript]);
            var check = jQObject.val();
            if (check === 0) {
                jQObject.addClass('js_warning');
                return false;
            }
            var script = jQObject.text();

            if (script.indexOf('http') === -1)
            {
                var documentLocation = document.location.href.substring(0, document.location.href.lastIndexOf('/'));
                var scriptLocation = documentLocation + '/' + script;
                script = scriptLocation;
            }
            if (script.lastIndexOf(".js") > 1)
            {
                //alert('loading script ' + script);
                var s = document.createElement("script");
                s.type = "application/javascript";
                s.src = script;
                $.cachedScript(script);
                //$("head").append(s);
            }
        }
        current++;
    }

    ;
    return true;
}



function processCSSLinks(componentXml)
{
    componentXml.find("CSSLinkUpdate").each(function () {
        var script = $(this).text();
        // alert(script);
        if (script.indexOf('http') === -1)
        {
            var documentLocation = document.location.href.substring(0, document.location.href.lastIndexOf('/'));
            var scriptLocation = documentLocation + '/' + script;
            script = scriptLocation;
        }
        //alert(script);
        var len = $('link[href="' + script + '"]').length;
        var len2 = $('link[href="' + $(this).text() + '"]').length;
        if (len === 0 && len2 === 0)
        {
            //alert(script);
            $('head').append('<link rel="stylesheet" type="text/css" href="' + script + '">');
        }
        ;
    });
}

function stringToDOM(html) {
    /* code taken from jQuery */
    var wrapMap = {
        option: [1, "<select multiple='multiple'>", "</select>"],
        legend: [1, "<fieldset>", "</fieldset>"],
        area: [1, "<map>", "</map>"],
        param: [1, "<object>", "</object>"],
        thead: [1, "<table>", "</table>"],
        tr: [2, "<table><tbody>", "</tbody></table>"],
        col: [2, "<table><tbody></tbody><colgroup>", "</colgroup></table>"],
        td: [3, "<table><tbody><tr>", "</tr></tbody></table>"],
        // IE6-8 can't serialize link, script, style, or any html5 (NoScope) tags,
        // unless wrapped in a div with non-breaking characters in front of it.
        _default: [1, "<div>", "</div>"]
    };
    wrapMap.optgroup = wrapMap.option;
    wrapMap.tbody = wrapMap.tfoot = wrapMap.colgroup = wrapMap.caption = wrapMap.thead;
    wrapMap.th = wrapMap.td;
    var element = document.createElement('div');
    var match = /<\s*\w.*?>/g.exec(html);
    if (match !== null) {
        var tag = match[0].replace(/</g, '').replace(/>/g, '');
        var map = wrapMap[tag] || wrapMap._default, element;
        html = map[1] + html + map[2];
        element.innerHTML = html;
        // Descend through wrappers to the right content
        var j = map[0] + 1;
        while (j--) {
            element = element.lastChild;
        }
    } else {
        // if only text is passed
        element.innerHTML = html;
        element = element.lastChild;
    }
    return element;
}



function processHTML(componentXml, inline)
{
    var updatedXmlString;
    if (!inline)
    {
        updatedXmlString = componentXml.find("HTMLUpdate").text();
        var dom = stringToDOM(updatedXmlString);
       // alert(dom);
        $('#' + componentID).replaceWith(dom);
        $('#' + componentID).parent().show();
    }
    return true;
}

function processCSS(componentXml)
{
    componentXml.find("CSSUpdate").each(function () {
        var cssText = $(this).text();
        $('html').append('<style>' + cssText + '</style>');
    });
}

function processEvents(componentXml)
{
    $("#" + componentID).unbind();
    componentXml.find("EventType").each(function () {
        var eventType = $(this).text();
        bindEvent(componentID, eventType);
    });
}

function processCommand(componentXml)
{
    componentXml.find("NextComponentToRender").each(function () {
        nextComponentID = $(this).text();
        processScriptLinks(componentXml);
        processCSSLinks(componentXml);
        processHTML(componentXml, true);
        processCSS(componentXml);
        processEvents(componentXml);
        renderOnLoad(componentRenderingID, nextComponentID);
    });
}

function renderOnLoad(componentId, nextComponentId)
{
    performCommand(componentId, 'RenderOnLoad', nextComponentId);
}

function clickFunction(id, clickType) {
    performAjax(id, clickType, clickType, $('#' + id).text());
}


function performCommand(id, commandName, commandValue)
{
    performAjax(id, 'performCommand', commandName, commandValue);
}



/**
 * This guy does the ajax. Some asynchronous some not
 * @param id {string} Element ID
 * @param eventType {string} Event Type
 * @param eventFrom {string} Event Component Called From
 * @param value {object} Value on the Component
 * @returns {string}
 */
function performAjax(id, eventType, eventFrom, value)
{
    var element = document.getElementById(id);
    var getdate = new Date();
    var article = new Object();
    article.componentId = id;
    article.eventType = eventType;
    article.eventTypeFrom = eventFrom;
    article.datetime = getdate;
    article.value = JSON.stringify(JSON.decycle(value));
    $.ajax({
        type: "POST",
        url: "JWebSwingAjaxReceiver",
        data: JSON.stringify(JSON.decycle(article)),
        //dataType: "json",
        /*contentType: 'application/json', 
         mimeType: 'application/json',*/
        asynch: false,
        converters: {
            'json xml': true
        },
        success: receiveUpdate,
        error: failedAjax
    });
}

function failedAjax(jqXHR, textStatus, errorThrown)
{
    alert('session looks lost. Reloading page');
    location.reload();
}

function getXml(node) {
    if (window.XMLSerializer) {
        oXMLSerializer = new XMLSerializer();
        var xml = oXMLSerializer.serializeToString(node);
        return xml;
    }

    if (node.outerXML) {

        return node.outerXML;
    }

    return '';
}

function returnObjectById(id)
{
    var returnVar;
    if (document.getElementById)
        returnVar = document.getElementById(id);
    else if (document.all)
        returnVar = document.all[id];
    else if (document.layers)
        returnVar = document.layers[id];
    return returnVar;
}
//JQX Navigation Bar Sizing Fix
$(document).ready(function () {
    $(".jqxNaviBar").bind('expandedItem', function (event) {
        var index = event.item + 1;
        $(window).resize();
    });
    $(window).resize();
});

function resizeLayouts()
{
    $('html').find("[jwtype='layout']").each(function (index) {
        var layoutResizeString = 'lay_' + $(this).prop('id');
        layoutResizeString = layoutResizeString.replace(/-/g, "_");
        var layoutString = "setTimeout('" + layoutResizeString + ".resizeAll();',10);";
        jQuery.globalEval(layoutString);
        //layoutString = "setTimeout('" + layoutResizeString + ".resizeAll();',1000);"; //just in case
        //jQuery.globalEval(layoutString);
    });
}

//theme switcher if need be
function initthemes(initialurl) {
    if ($('#themeComboBox').length === 0)
    {
        // alert('couldnt find the combobox');
        return;
    }
    if (!$('#themeComboBox').jqxDropDownList)
    {
        alert('Theme combo box is not drop down list');
        // return;
    }

    var loadedThemes = [0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1];
    var themes = [
        {label: 'Arctic', group: 'Themes', value: 'arctic'},
        {label: 'Web', group: 'Themes', value: 'web'},
        {label: 'Bootstrap', group: 'Themes', value: 'bootstrap'},
        {label: 'Metro', group: 'Themes', value: 'metro'},
        {label: 'Metro Dark', group: 'Themes', value: 'metrodark'},
        {label: 'Office', group: 'Themes', value: 'office'},
        {label: 'Orange', group: 'Themes', value: 'orange'},
        {label: 'Fresh', group: 'Themes', value: 'fresh'},
        {label: 'Energy Blue', group: 'Themes', value: 'energyblue'},
        {label: 'Dark Blue', group: 'Themes', value: 'darkblue'},
        {label: 'Black', group: 'Themes', value: 'black'},
        {label: 'Shiny Black', group: 'Themes', value: 'shinyblack'},
        {label: 'Classic', group: 'Themes', value: 'classic'},
        {label: 'Summer', group: 'Themes', value: 'summer'},
        {label: 'High Contrast', group: 'Themes', value: 'highcontrast'},
        {label: 'Lightness', group: 'UI Compatible', value: 'ui-lightness'},
        {label: 'Darkness', group: 'UI Compatible', value: 'ui-darkness'},
        {label: 'Smoothness', group: 'UI Compatible', value: 'ui-smoothness'},
        {label: 'Start', group: 'UI Compatible', value: 'ui-start'},
        {label: 'Redmond', group: 'UI Compatible', value: 'ui-redmond'},
        {label: 'Sunny', group: 'UI Compatible', value: 'ui-sunny'},
        {label: 'Overcast', group: 'UI Compatible', value: 'ui-overcast'},
        {label: 'Le Frog', group: 'UI Compatible', value: 'ui-le-frog'}
    ];
    var me = this;
    this.$head = $('head');
    $('#themeComboBox').jqxDropDownList({source: themes, theme: 'arctic', selectedIndex: 0, dropDownHeight: 200, width: '140px', height: '20px'});

    var hasParam = window.location.toString().indexOf('?');
    if (hasParam !== -1) {
        var themestart = window.location.toString().indexOf('(');
        var themeend = window.location.toString().indexOf(')');
        var theme = window.location.toString().substring(themestart + 1, themeend);
        $.data(document.body, 'theme', theme);
        selectedTheme = theme;
        var themeIndex = 0;
        $.each(themes, function (index) {
            if (this.value === theme) {
                themeIndex = index;
                return false;
            }
        });
        $('#themeComboBox').jqxDropDownList({selectedIndex: themeIndex});
        loadedThemes[0] = -1;
        loadedThemes[themeIndex] = 0;
    } else {
        $.data(document.body, 'theme', 'arctic');
    }

    $('#themeComboBox').on('select', function (event) {
        setTimeout(function () {
            var selectedIndex = event.args.index;
            var selectedTheme = '';
            var url = initialurl;

            var loaded = loadedThemes[selectedIndex] !== -1;
            loadedThemes[selectedIndex] = selectedIndex;

            var themes = [
                {label: 'Arctic', group: 'Themes', value: 'arctic'},
                {label: 'Web', group: 'Themes', value: 'web'},
                {label: 'Bootstrap', group: 'Themes', value: 'bootstrap'},
                {label: 'Metro', group: 'Themes', value: 'metro'},
                {label: 'Metro Dark', group: 'Themes', value: 'metrodark'},
                {label: 'Office', group: 'Themes', value: 'office'},
                {label: 'Orange', group: 'Themes', value: 'orange'},
                {label: 'Fresh', group: 'Themes', value: 'fresh'},
                {label: 'Energy Blue', group: 'Themes', value: 'energyblue'},
                {label: 'Dark Blue', group: 'Themes', value: 'darkblue'},
                {label: 'Black', group: 'Themes', value: 'black'},
                {label: 'Shiny Black', group: 'Themes', value: 'shinyblack'},
                {label: 'Classic', group: 'Themes', value: 'classic'},
                {label: 'Summer', group: 'Themes', value: 'summer'},
                {label: 'High Contrast', group: 'Themes', value: 'highcontrast'},
                {label: 'Lightness', group: 'UI Compatible', value: 'ui-lightness'},
                {label: 'Darkness', group: 'UI Compatible', value: 'ui-darkness'},
                {label: 'Smoothness', group: 'UI Compatible', value: 'ui-smoothness'},
                {label: 'Start', group: 'UI Compatible', value: 'ui-start'},
                {label: 'Redmond', group: 'UI Compatible', value: 'ui-redmond'},
                {label: 'Sunny', group: 'UI Compatible', value: 'ui-sunny'},
                {label: 'Overcast', group: 'UI Compatible', value: 'ui-overcast'},
                {label: 'Le Frog', group: 'UI Compatible', value: 'ui-le-frog'}
            ];
            selectedTheme = themes[selectedIndex].value;
            url += 'jqx.' + selectedTheme + '.css';

            if (!loaded) {
                if (document.createStyleSheet !== undefined) {
                    document.createStyleSheet(url);
                } else {
                    // alert(url);
                    me.$head.append('<link rel="stylesheet" href="' + url + '" media="screen" />');
                }
            }
            $.data(document.body, 'theme', selectedTheme);
            //var startedExample = $.data(document.body, 'example');
            /*if (startedExample !== null) {
             startDemo(startedExample);
             }*/
        }, 5);
    });
}
;


/**
 * JQX Colour Picker Element Display
 * @param color A $.jqx.color object
 */
function getTextElementByColor(color)
{
    if (color === 'transparent' || color.hex === "")
    {
        return $("<div style='text-shadow: none; position: relative; padding-bottom: 2px; margin-top: 2px;'>transparent</div>");
    }
    var element = $("<div style='text-shadow: none; position: relative; padding-bottom: 2px; margin-top: 2px;'>#" + color.hex + "</div>");
    var nThreshold = 105;
    var bgDelta = (color.r * 0.299) + (color.g * 0.587) + (color.b * 0.114);
    var foreColor = (255 - bgDelta < nThreshold) ? 'Black' : 'White';
    element.css('color', foreColor);
    element.css('background', "#" + color.hex);
    element.addClass('jqx-rc-all');
    return element;
}








































/*! jQuery JSON plugin v2.5.1 | github.com/Krinkle/jquery-json */
!function ($) {
    "use strict";
    var escape = /["\\\x00-\x1f\x7f-\x9f]/g, meta = {"\b": "\\b", "	": "\\t", "\n": "\\n", "\f": "\\f", "\r": "\\r", '"': '\\"', "\\": "\\\\"}, hasOwn = Object.prototype.hasOwnProperty;
    $.toJSON = "object" == typeof JSON && JSON.stringify ? JSON.stringify : function (a) {
        if (null === a)
            return"null";
        var b, c, d, e, f = $.type(a);
        if ("undefined" === f)
            return void 0;
        if ("number" === f || "boolean" === f)
            return String(a);
        if ("string" === f)
            return $.quoteString(a);
        if ("function" == typeof a.toJSON)
            return $.toJSON(a.toJSON());
        if ("date" === f) {
            var g = a.getUTCMonth() + 1, h = a.getUTCDate(), i = a.getUTCFullYear(), j = a.getUTCHours(), k = a.getUTCMinutes(), l = a.getUTCSeconds(), m = a.getUTCMilliseconds();
            return 10 > g && (g = "0" + g), 10 > h && (h = "0" + h), 10 > j && (j = "0" + j), 10 > k && (k = "0" + k), 10 > l && (l = "0" + l), 100 > m && (m = "0" + m), 10 > m && (m = "0" + m), '"' + i + "-" + g + "-" + h + "T" + j + ":" + k + ":" + l + "." + m + 'Z"'
        }
        if (b = [], $.isArray(a)) {
            for (c = 0; c < a.length; c++)
                b.push($.toJSON(a[c]) || "null");
            return"[" + b.join(",") + "]"
        }
        if ("object" == typeof a) {
            for (c in a)
                if (hasOwn.call(a, c)) {
                    if (f = typeof c, "number" === f)
                        d = '"' + c + '"';
                    else {
                        if ("string" !== f)
                            continue;
                        d = $.quoteString(c)
                    }
                    f = typeof a[c], "function" !== f && "undefined" !== f && (e = $.toJSON(a[c]), b.push(d + ":" + e))
                }
            return"{" + b.join(",") + "}"
        }
    }, $.evalJSON = "object" == typeof JSON && JSON.parse ? JSON.parse : function (str) {
        return eval("(" + str + ")")
    }, $.secureEvalJSON = "object" == typeof JSON && JSON.parse ? JSON.parse : function (str) {
        var filtered = str.replace(/\\["\\\/bfnrtu]/g, "@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g, "]").replace(/(?:^|:|,)(?:\s*\[)+/g, "");
        if (/^[\],:{}\s]*$/.test(filtered))
            return eval("(" + str + ")");
        throw new SyntaxError("Error parsing JSON, source is not valid.")
    }, $.quoteString = function (a) {
        return a.match(escape) ? '"' + a.replace(escape, function (a) {
            var b = meta[a];
            return"string" == typeof b ? b : (b = a.charCodeAt(), "\\u00" + Math.floor(b / 16).toString(16) + (b % 16).toString(16))
        }) + '"' : '"' + a + '"'
    }
}(jQuery);














/*
 cycle.js
 2015-02-25
 
 Public Domain.
 
 NO WARRANTY EXPRESSED OR IMPLIED. USE AT YOUR OWN RISK.
 
 This code should be minified before deployment.
 See http://javascript.crockford.com/jsmin.html
 
 USE YOUR OWN COPY. IT IS EXTREMELY UNWISE TO LOAD CODE FROM SERVERS YOU DO
 NOT CONTROL.
 */

/*jslint eval, for */

/*property 
 $ref, apply, call, decycle, hasOwnProperty, length, prototype, push,
 retrocycle, stringify, test, toString
 */

if (typeof JSON.decycle !== 'function') {
    JSON.decycle = function decycle(object) {
        'use strict';

// Make a deep copy of an object or array, assuring that there is at most
// one instance of each object or array in the resulting structure. The
// duplicate references (which might be forming cycles) are replaced with
// an object of the form
//      {$ref: PATH}
// where the PATH is a JSONPath string that locates the first occurance.
// So,
//      var a = [];
//      a[0] = a;
//      return JSON.stringify(JSON.decycle(a));
// produces the string '[{"$ref":"$"}]'.

// JSONPath is used to locate the unique object. $ indicates the top level of
// the object or array. [NUMBER] or [STRING] indicates a child member or
// property.

        var objects = [], // Keep a reference to each unique object or array
                paths = [];     // Keep the path to each unique object or array

        return (function derez(value, path) {

// The derez recurses through the object, producing the deep copy.

            var i, // The loop counter
                    name, // Property name
                    nu;         // The new object or array

// typeof null === 'object', so go on if this value is really an object but not
// one of the weird builtin objects.

            if (typeof value === 'object' && value !== null &&
                    !(value instanceof Boolean) &&
                    !(value instanceof Date) &&
                    !(value instanceof Number) &&
                    !(value instanceof RegExp) &&
                    !(value instanceof String)) {

// If the value is an object or array, look to see if we have already
// encountered it. If so, return a $ref/path object. This is a hard way,
// linear search that will get slower as the number of unique objects grows.

                for (i = 0; i < objects.length; i += 1) {
                    if (objects[i] === value) {
                        return {$ref: paths[i]};
                    }
                }

// Otherwise, accumulate the unique value and its path.

                objects.push(value);
                paths.push(path);

// If it is an array, replicate the array.

                if (Object.prototype.toString.apply(value) === '[object Array]') {
                    nu = [];
                    for (i = 0; i < value.length; i += 1) {
                        nu[i] = derez(value[i], path + '[' + i + ']');
                    }
                } else {

// If it is an object, replicate the object.

                    nu = {};
                    for (name in value) {
                        if (Object.prototype.hasOwnProperty.call(value, name)) {
                            nu[name] = derez(value[name],
                                    path + '[' + JSON.stringify(name) + ']');
                        }
                    }
                }
                return nu;
            }
            return value;
        }(object, '$'));
    };
}


if (typeof JSON.retrocycle !== 'function') {
    JSON.retrocycle = function retrocycle($) {
        'use strict';

// Restore an object that was reduced by decycle. Members whose values are
// objects of the form
//      {$ref: PATH}
// are replaced with references to the value found by the PATH. This will
// restore cycles. The object will be mutated.

// The eval function is used to locate the values described by a PATH. The
// root object is kept in a $ variable. A regular expression is used to
// assure that the PATH is extremely well formed. The regexp contains nested
// * quantifiers. That has been known to have extremely bad performance
// problems on some browsers for very long strings. A PATH is expected to be
// reasonably short. A PATH is allowed to belong to a very restricted subset of
// Goessner's JSONPath.

// So,
//      var s = '[{"$ref":"$"}]';
//      return JSON.retrocycle(JSON.parse(s));
// produces an array containing a single element which is the array itself.

        var px = /^\$(?:\[(?:\d+|\"(?:[^\\\"\u0000-\u001f]|\\([\\\"\/bfnrt]|u[0-9a-zA-Z]{4}))*\")\])*$/;

        (function rez(value) {

// The rez function walks recursively through the object looking for $ref
// properties. When it finds one that has a value that is a path, then it
// replaces the $ref object with a reference to the value that is found by
// the path.

            var i, item, name, path;

            if (value && typeof value === 'object') {
                if (Object.prototype.toString.apply(value) === '[object Array]') {
                    for (i = 0; i < value.length; i += 1) {
                        item = value[i];
                        if (item && typeof item === 'object') {
                            path = item.$ref;
                            if (typeof path === 'string' && px.test(path)) {
                                value[i] = eval(path);
                            } else {
                                rez(item);
                            }
                        }
                    }
                } else {
                    for (name in value) {
                        if (typeof value[name] === 'object') {
                            item = value[name];
                            if (item) {
                                path = item.$ref;
                                if (typeof path === 'string' && px.test(path)) {
                                    value[name] = eval(path);
                                } else {
                                    rez(item);
                                }
                            }
                        }
                    }
                }
            }
        }($));
        return $;
    };
}


function xmlToString(xmlData) {

    var xmlString;
    //IE
    if (window.ActiveXObject) {
        xmlString = xmlData.xml;
        alert(xmlString);
    }
    // code for Mozilla, Firefox, Opera, etc.
    else {
        xmlString = (new XMLSerializer()).serializeToString(xmlData);
        alert(xmlString);
    }
    return xmlString;
}
