//function to append a new theme stylesheet with the new style changes
function updateSourceCodeTheme(newTheme) {
    $('link.prettifyTheme').remove();
    var cssLink = '<link href="' + newTheme + '" rel="stylesheet" type="text/css" class="CSSLink prettifyTheme">';
    $('head').append(cssLink);
    prettyPrint();
}

/**
 * Creates a new dynamic source code instance
 * @param {type} opts The options to apply
 * @returns {$}
 */
$.fn.dynamicSourceCode = function (opts)
{
    opts = $.extend({}, $.fn.dynamicSourceCode.defaults, opts);
    $(this).data('opts', opts);
    updateSourceCodeTheme(opts.defaultTheme);
};

/**
 * Registers a new event to the element id that changes the source code of this compoent to the value of the element
 * Always run from the same component that you did dynamicSourceCode on
 * 
 * @param {type} elementId The element ID to change
 * @param {type} onEvent The event to do it on
 * @returns {undefined}
 */
$.fn.dynamicSourceCodeAddChanger = function (elementId, onEvent)
{
    var opts = $(this).data('opts');
    var preDiv = $(this);
    var grr = $('#' + elementId);
    grr.on('click', function () {
        var newClass = $(this).attr("value");
        var url = opts.srcUrl + newClass + opts.fileExtension;

        $.get(url, function (data) {
            preDiv.html(data);
            preDiv.removeClass(opts.prettyPrintClass);
            prettyPrint();
        });
    });
};

/**
 * Removes and adds a new CSS Link for the given theme
 * @param {type} elementId
 */
$.fn.dynamicSourceCodeAddThemeChanger = function (elementId)
{
    var opts = $(this).data('opts');
    var ele = $('#' + elementId);
    
    ele.on('click', function () {
        var themeToApply = $(this).attr("value");
        updateSourceCodeTheme(themeToApply);
    });
};

/**
 * All the defaults
 */
$.fn.dynamicSourceCode.defaults =
        {
            srcUrl: 'java/',
            prettyPrintClass: "prettyprinted",
            defaultTheme: "bower_components/google-code-prettify/bin/prettify.min.css",
            fileExtension: ".java"
        };