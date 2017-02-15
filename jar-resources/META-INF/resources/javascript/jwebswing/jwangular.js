/*
 * Copyright (C) 2016 GedMarc
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

/* global Pace, BootstrapDialog */

//***********************************
// Angular Implementation
//***********************************
(function (angular) {
    'use strict';
    var jwApp = angular.module('jwApp_jw', []);

    jwApp.directive('ngRightClick', function ($parse) {
        return function (scope, element, attrs) {
            var fn = $parse(attrs.ngRightClick);
            element.bind('contextmenu', function (event) {
                scope.$apply(function () {
                    event.preventDefault();
                    fn(scope, {$event: event});
                });
            });
        };
    });

    jwApp.controller('JWController', [function ($scope, $compile, $parse) {

            /**
             * Loads up the initial variables into angular
             * @returns {undefined}
             */
            $scope._init = function ()
            {
                var toGo = 'ad?o=body';
                $.ajax({
                    type: "GET",
                    url: toGo,
                    dataType: "json",
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    asynch: false,
                    cache: false,
                    converters: {
                        'json': true
                    },
                    success: function (result, status, xhr) {
                        //alert("result : " + result);
                        $scope.loadData(result);
                    },
                    error: function (xhr, textStatus, errorThrown) {
                        var err = eval("(" + xhr.responseText + ")");
                        BootstrapDialog.show({
                            title: "Server Error",
                            message: "An error was encountered in the connection between the server and the client<br>" + textStatus + "<br>" + err,
                            type: BootstrapDialog.TYPE_DANGER,
                            buttons: [{
                                    label: 'Close',
                                    action: function (dialogItself) {
                                        dialogItself.close();
                                    }
                                }]
                        });
                    }
                });
            };
            $scope._init();

            /**
             * Loads an angular JSON variables object from the server
             * @param {type} data
             * @returns {undefined}
             */
            $scope.loadData = function (data) {
                $.each(data.variables, function (i, item) {
                    var the_string = item.variableName;
                    var model = $parse(the_string);
                    model.assign($scope, item.variableObject);
                    $timeout(function () {});
                    //$scope.$apply();
                });
            };

            /**
             * Performs a post send to the server
             * @param {type} $event
             * @param {type} dataVariable
             * @returns {undefined}
             */
            $scope.perform = function ($event, dataVariable) {
                if (Pace)
                    Pace.start();
                //alert('doing stuff');
                var eventStuff = $scope.getEventObject($event);
                //alert(JSON.stringify($event));
                var element = $event.currentTarget.id;
                var getdate = new Date();
                var article = new Object();
                article.componentId = element;
                article.eventType = $event.type;
                article.eventTypeFrom = $event.type;
                article.datetime = getdate;
                article.value = JSON.stringify(eventStuff);

                article.variableData = [].concat(dataVariable);

                $.ajax({
                    type: "POST",
                    url: "JWebSwingAjaxReceiver",
                    data: JSON.stringify(article),
                    dataType: "json",
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    asynch: true,
                    cache: true,
                    converters: {
                        'json': true
                    },
                    success: function (result, status, xhr) {
                        $scope.processResponse(result, status, xhr);
                    },
                    error: function (xhr, textStatus, errorThrown) {
                        var err = eval("(" + xhr.responseText + ")");
                        BootstrapDialog.show({
                            title: "Server Error",
                            message: "An error was encountered in the connection between the server and the client<br>" + textStatus + "<br>" + err,
                            type: BootstrapDialog.TYPE_DANGER,
                            buttons: [{
                                    label: 'Close',
                                    action: function (dialogItself) {
                                        dialogItself.close();
                                    }
                                }]
                        });
                        //alert('Ooops this is never supposed to happen! How did it get through the servlet?\n' + textStatus);
                    }
                });
                if (Pace)
                    Pace.stop();
            };

            /**
             *
             * @param {type} data
             * @returns {undefined}
             */
            $scope.performAngularFetch = function (data) {
                if (Pace)
                    Pace.start();

                alert('angular fetch data  : ' + data);
                Pace.stop();
            };



            /**
             * Creates a new variable object translatable by the server
             * @param {type} name The name of the object
             * @param {type} object The physical object
             * @returns {Object} The new data bound object
             */
            $scope.dataVariable = function (name, object) {
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
            $scope.processResponse = function (result, status, xhr) {
                $scope.processHtml(result);
                $scope.processCssReferences(result);
                $scope.processJSReferences(result);
                $scope.processCss(result);
                $scope.loadData(result);
                $scope.processReactions(result);
            };

            /**
             * Adds the style tag to the html
             * @param {type} result
             * @returns {undefined}
             */
            $scope.processCss = function (result)
            {
                $('head').append('<style>' + result.css + '</style>');
            };

            /**
             * Adds the JS Reference
             * @param {type} result
             * @returns {undefined}
             */
            $scope.processJSReferences = function (result)
            {
                $.each(result.jsReferences, function (i, item) {

                    $.cachedScript(item);
                    var s = document.createElement("script");
                    s.type = "application/javascript";
                    s.src = item;
                    //$("head").append(s);


                });
            };

            /**
             * Adds the css reference to the head
             * @param {type} result
             * @returns {undefined}
             */
            $scope.processCssReferences = function (result)
            {
                $.each(result.cssLinks, function (i, item) {
                    $('head').append('<link rel="stylesheet" type="text/css" href="' + item + '">');
                });
            };

            /**
             * Goes through each component replacing its html
             * @param {type} result
             * @returns {undefined}
             */
            $scope.processHtml = function (result) {
                $.each(result.components, function (i, item) {
                    $('#' + item.id).replaceWith((item.html));
                    $compile($('body').find('#' + item.id))($scope);
                });
            };

            /**
             * Goes through each reaction performing each task
             * @param {type} result
             * @returns {undefined}
             */
            $scope.processReactions = function (result) {
                $.each(result.reactions, function (i, item) {
                    var title = item.reactionTitle;
                    var message = item.reactionMessage;
                    var type = item.reactionType;
                    var dialogType = item.type;
                    var timeout = item.actionTimeout;

                    if (type === 'DialogDisplay')
                    {
                        $scope.showDialog(title, message, dialogType);
                    } else if (type === 'RedirectHome')
                    {
                        setTimeout('location.reload();', timeout);
                    }
                });
            };

            /**
             * Shows the dialog with the given text and structure
             * @param {type} title
             * @param {type} message
             * @param {type} type
             * @returns {undefined}
             */
            $scope.showDialog = function (title, message, type) {
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


            };

            /**
             * The event object that gets sent through
             * @param {type} $event jquery event
             * @returns {Object} The Event DTO
             */
            $scope.getEventObject = function ($event) {
                var newEvent = new Object();
                newEvent.altKey = $event.altKey;
                newEvent.ctrlKey = $event.ctrlKey;
                newEvent.bubbles = $event.bubbles;
                newEvent.cancelable = $event.cancelable;
                newEvent.clientX = $event.clientX;
                newEvent.clientY = $event.clientY;
                newEvent.componentID = $event.currentTarget.id;
                newEvent.detail = $event.detail;
                newEvent.eventPhase = $event.eventPhase;
                newEvent.metaKey = $event.metaKey;
                newEvent.offsetX = $event.offsetX;
                newEvent.offsetY = $event.offsetY;
                newEvent.pageX = $event.pageX;
                newEvent.pageY = $event.pageY;
                newEvent.screenX = $event.screenX;
                newEvent.screenY = $event.screenY;
                newEvent.shiftKey = $event.shiftKey;
                newEvent.type = $event.type;
                newEvent.data = $event.data;
                newEvent.target = $event.target.id;
                newEvent.which = $event.which;
                return newEvent;
            };
        }]); //end of controller
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
        async: false
    });

    // Use $.ajax() since it is more flexible than $.getScript
    // Return the jqXHR object so we can chain callbacks
    return jQuery.ajax(options);
};

jQuery.cachedScriptNonAsync = function (url, options) {
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