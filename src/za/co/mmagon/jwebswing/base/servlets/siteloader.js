/* global BootstrapDialog, eval */

var jw = {isLoading: false, pageLoading: true};
jw.siteAddress = 'SITEADDRESSINSERT';

jw.angularLoading = false;

jw.mobile = {};
jw.actions = {};

jw.localstorage = {};
if (localStorage)
{
    for (var i = 0; i < localStorage.length; i++) {
        jw.localstorage[localStorage.key(i)] = localStorage.getItem(localStorage.key(i));
    }
}
jw.sessionstorage = {};
if (sessionStorage)
{
    for (var i = 0; i < sessionStorage.length; i++) {
        jw.sessionstorage[sessionStorage.key(i)] = sessionStorage.getItem(sessionStorage.key(i));
    }
}

jw.env = {};
jw.env.loadescripts = [];
jw.env.loadedcss = [];

/**
 * Loads an angular JSON variables object from the server
 * @param {type} data
 * @returns {undefined}
 */
jw.actions.loadData = function (data, $scope, $parse, $timeout) {
    $.each(data.variables, function (i, item) {
        var the_string = item.variableName;
        if ($parse)
        {
            var model = $parse(the_string);
            model.assign($scope, item.variable);
        }
    });
    if ($timeout)
    {
        $timeout(function () {});
    }
};

/**
 * Creates a new variable object translatable by the server
 * @param {type} name The name of the object
 * @param {type} object The physical object
 * @returns {Object} The new data bound object
 */
jw.actions.dataVariable = function (name, object) {
    var newVariable = new Object();
    newVariable.variableName = name;
    newVariable.variableObject = object;
    return newVariable;
};

/**
 * Processes the response received from the ajax handler
 * @param {type} result
 *@param {type} status
 * @param {type} xhr
 * @returns {undefined}
 */
jw.actions.processResponse = function (result, $scope, $parse, $timeout, $compile) {
    jw.actions.processHtml(result, $scope, $compile);
    jw.actions.processCssReferences(result);
    jw.actions.processJSReferences(result);
    jw.actions.processCss(result);
    jw.actions.loadData(result, $scope, $parse, $timeout);
    jw.actions.processReactions(result);


    //jw.actions.processJsScripts(result)
};

/**
 * Adds the style tag to the html
 * @param {type} result
 * @returns {undefined}
 */
jw.actions.processCss = function (result)
{
    $('head').append('<style>' + result + '</style>');
};

/*
 * Loads the next reference or call the callback if on the final position
 * @param {type} array
 * @param {type} position
 * @param {type} completedCallback
 * @returns {undefined}
 */
jw.actions.loadNextJSReference = function (array, position, completedCallback) {
    position = position + 1;
    if (position === (array.length))
    {
        completedCallback();
    } else
    {
        jw.actions.synchronizedJSReferencesLoad(array, position, completedCallback);
    }
};
/**
 * Loads a list of java script references in synchronized order, fires the last callback when done
 * @param {type} array
 * @param {type} position
 * @param {type} completedCallback
 * @returns {undefined}
 */
jw.actions.synchronizedJSReferencesLoad = function (array, position, completedCallback)
{
    var ref = array[position];
    if (ref)
    {
        if (ref.endsWith('/jwas') || ref.endsWith('/jwjs') || ref.endsWith('/jwad') || ref.endsWith('/jwdata') || ref.endsWith('/jwajax'))
        {
            position = position + 1;
            $.notCachedScriptSync(ref).complete(jw.actions.loadNextJSReference(array, position, completedCallback));
        } else
        {
            position = position + 1;
            $.cachedScriptSync(ref).complete(jw.actions.loadNextJSReference(array, position, completedCallback));
        }
    }
};
/**
 * Adds the JS Reference
 * @param {type} result
 * @returns {undefined}
 */
jw.actions.processJSReferences = function (result)
{
    if (result.jsReferences)
    {
        jw.actions.synchronizedJSReferencesLoad(result.jsReferences, 0, function () {
            jw.actions.processJsScripts(result);
        });
    } else
    {
        jw.actions.processJsScripts(result);
    }
};
/**
 * Process the JavaScripts returned
 * @param {type} result
 * @returns {undefined}
 */
jw.actions.processJsScripts = function (result)
{
    if (result.jsScripts)
    {
        $.each(result.jsScripts, function (i, item)
        {
            jw.actions.loadScript(item);
        });
    }
    if (result.events)
    {
        $.each(result.events, function (i, item)
        {
            jw.actions.loadScript(item);
        });
    }
    if (result.features)
    {
        $.each(result.features, function (i, item)
        {
            jw.actions.loadScript(item);
        });
    }
};

jw.actions.loadScript = function (item, tries)
{
    if (!tries)
        tries = 0;
    try
    {
        var result = eval(item);
    } catch (e)
    {
        console.log(e);
        tries = tries + 1;
        if (tries < 10)
            setTimeout(jw.actions.loadScript(item, tries), 1500);
    }
};

/**
 * Adds the css reference to the head
 * @param {type} result
 * @returns {undefined}
 */
jw.actions.processCssReferences = function (result)
{
    $.each(result.cssLinks, function (i, item) {
        var ss = document.styleSheets;
        var found = false;
        for (var i = 0, max = ss.length; i < max; i++) {
            if (ss[i].href === item)
            {
                found = true;
                break;
            }
        }
        if (!found)
        {
            $('head').append('<link rel="stylesheet" type="text/css" href="' + item + '">');
        }
    });
};
/**
 * Goes through each component replacing its html
 * @param {type} result
 * @returns {undefined}
 */
jw.actions.processHtml = function (result, $scope, $compile) {
    $.each(result.components, function (i, item) {
        if (item.insertType === 'Replace')
        {
            $('#' + item.id).replaceWith((item.html));
        } else if (item.insertType === 'Append')
        {
            $('#' + item.id).after((item.html));
        } else if (item.insertType === 'Prepend')
        {
            $('#' + item.id).before((item.html));
        } else if (item.insertType === 'Insert')
        {
            $('#' + item.id).prepend((item.html));
        } else if (item.insertType === 'Insert_Last')
        {
            $('#' + item.id).append((item.html));
        }

        if ($compile)
        {
            $compile($('body').find('#' + item.id))($scope);
        }
    });
};
/**
 * Goes through each reaction performing each task
 * @param {type} result
 * @returns {undefined}
 */
jw.actions.processReactions = function (result) {
    $.each(result.reactions, function (i, item) {
        var title = item.reactionTitle;
        var message = item.reactionMessage;
        var type = item.reactionType;
        var dialogType = item.type;
        var timeout = item.actionTimeout;

        if (type === 'DialogDisplay')
        {
            jw.actions.showDialog(title, message, dialogType);
        } else if (type === 'RedirectHome')
        {
            setTimeout('location.reload();', timeout);
        }
    });
};

/**
 * @param title The title of the dialog
 * @param message The message to display
 * @param type the type of dialog - Danger,Success,Warning,Primary,Information,Default
 */
jw.actions.showDialog = function (title, message, type) {
    if (BootstrapDialog)
    {
        if (type === 'Danger')
            BootstrapDialog.show({
                title: title,
                message: message,
                type: BootstrapDialog.TYPE_DANGER
            });
        else if (type === 'Success')
            BootstrapDialog.show({
                title: title,
                message: message,
                type: BootstrapDialog.TYPE_SUCCESS
            });
        else if (type === 'Warning')
            BootstrapDialog.show({
                title: title,
                message: message,
                type: BootstrapDialog.TYPE_WARNING
            });
        else if (type === 'Primary')
            BootstrapDialog.show({
                title: title,
                message: message,
                type: BootstrapDialog.TYPE_INFO
            });
        else if (type === 'Information')
            BootstrapDialog.show({
                title: title,
                message: message,
                type: BootstrapDialog.TYPE_INFO
            });
        else if (type === 'Default')
            BootstrapDialog.show({
                title: title,
                message: message,
                type: BootstrapDialog.TYPE_INFO
            });
    }
};


/**
 * Loads up cached url script objects.
 * Used when pulling scripts from the server
 * $.cachedScript( "ajax/test.js" ).done(function( script, textStatus ) {});
 * $.cachedScript( "ajax/test.js",{async:true).done(function( script, textStatus ) {});
 * @param {type} url The URL to use
 * @param {type} options Any $.ajax options
 *
 * @returns {jqXHR} The ajax object for chaining
 */
jQuery.cachedScript = function (url, options) {
    // Allow user to set any option except for dataType, cache, and url
    options = $.extend(options || {}, {
        dataType: "script",
        cache: true,
        url: url,
        async: true
    });
    // Use $.ajax() since it is more flexible than $.getScript
    // Return the jqXHR object so we can chain callbacks
    return jQuery.ajax(options);
};

/**
 * Loads up cached url script objects.
 * Used when pulling scripts from the server
 * $.cachedScript( "ajax/test.js" ).done(function( script, textStatus ) {});
 * $.cachedScript( "ajax/test.js",{async:true).done(function( script, textStatus ) {});
 * @param {type} url The URL to use
 * @param {type} options Any $.ajax options
 *
 * @returns {jqXHR} The ajax object for chaining
 */
jQuery.cachedScriptSync = function (url, options) {
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

/**
 * Loads up non-cached url script objects.
 * Used when pulling scripts from the server
 * $.cachedScript( "ajax/test.js" ).done(function( script, textStatus ) {});
 * $.cachedScript( "ajax/test.js",{async:true).done(function( script, textStatus ) {});
 * @param {type} url The URL to use
 * @param {type} options Any $.ajax options
 *
 * @returns {jqXHR} The ajax object for chaining
 */
jQuery.notCachedScript = function (url, options) {
    // Allow user to set any option except for dataType, cache, and url
    options = $.extend(options || {}, {
        dataType: "script",
        cache: false,
        url: url,
        async: true
    });
    // Use $.ajax() since it is more flexible than $.getScript
    // Return the jqXHR object so we can chain callbacks
    return jQuery.ajax(options);
};

/**
 * Loads up non-cached url script objects.
 * Used when pulling scripts from the server
 * $.cachedScript( "ajax/test.js" ).done(function( script, textStatus ) {});
 * $.cachedScript( "ajax/test.js",{async:true).done(function( script, textStatus ) {});
 * @param {type} url The URL to use
 * @param {type} options Any $.ajax options
 *
 * @returns {jqXHR} The ajax object for chaining
 */
jQuery.notCachedScriptSync = function (url, options) {
    // Allow user to set any option except for dataType, cache, and url
    options = $.extend(options || {}, {
        dataType: "script",
        cache: false,
        url: url,
        async: false
    });
    // Use $.ajax() since it is more flexible than $.getScript
    // Return the jqXHR object so we can chain callbacks
    return jQuery.ajax(options);
};