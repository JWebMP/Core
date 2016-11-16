//***********************************
// Angular Implementation
//***********************************
(function (angular) {
    'use strict';
    
    /**
     * All Modules
     */
    JW_MODULES
    
    /**
     * All Directives
     */
    JW_DIRECTIVES
    
    /**
     * All Controllers
     */
    JW_CONTROLLERS
    
})(window.angular);

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