/* global JW_APP_NAME, BootstrapDialog, Pace, JW_SCOPE_INSERTIONS, jw */

jw.afterInit = function () {};

JW_APP_NAME.controller('JW_APP_CONTROLLER', function ($scope, $compile, $parse, $timeout) {
    jw.angularLoading = true;
    /**
     * Loads up the initial variables into angular
     * @returns {undefined}
     */
    $scope._init = function ()
    {
        var initData = {};
        initData.localStorage = jw.localstorage;
        initData.sessionStorage = jw.sessionstorage;

        jw.isLoading = true;
        try
        {
            if (window.Modernizr)
            {
                $scope.Modernizr = window.Modernizr;
                initData.modernizr = window.Modernizr;
            }
        } catch (e)
        {
            console.warn("moderniz not enabled");
        }

        var toGo = 'jwad?o=body';
        return $.ajax({
            type: "POST",
            url: toGo,
            dataType: "json",
            contentType: 'application/json',
            mimeType: 'application/json',
            asynch: false,
            cache: false,
            data: JSON.stringify(initData),
            beforeSend: function (xhr) {
                try
                {
                    if (window.Pace)
                    {
                        window.Pace.start();
                        jw.isLoading = true;
                    }
                } catch (e)
                {
                }
            },
            converters: {
                'json': true
            },
            success: function (result, status, xhr) {
                jw.actions.processResponse(result, $scope, $parse, $timeout, $compile);
                //jw.actions.loadData(result, $scope, $parse, $timeout);
                jw.isLoading = false;
                if (jw.afterInit)
                    jw.afterInit();
            },
            fail: function (xhr, textStatus, errorThrown) {
                var err = eval("(" + xhr.responseText + ")");
                if (BootstrapDialog)
                {
                    BootstrapDialog.show({
                        title: "Server Error",
                        message: "An error was encountered during the initial phase between the server and the client.<br>" + textStatus + "<br>" + err,
                        type: BootstrapDialog.TYPE_DANGER,
                        buttons: [{
                                label: 'Close',
                                action: function (dialogItself) {
                                    dialogItself.close();
                                }
                            }]
                    });
                }
                jw.isLoading = false;
                if (jw.afterInit)
                    jw.afterInit();
            },
            complete: function (jqXHR, textStatus) {
                try
                {
                    if (window.Pace)
                    {
                        window.Pace.stop();
                    }
                } catch (e)
                {
                } finally
                {
                    jw.isLoading = false;
                    jw.angularLoading = false;
                }
            }
        });
    };

    $scope._init();
    /**
     * Performs a post send to the server
     * @param {type} $event
     * @param {type} dataVariables
     * @param {type} eventId
     * @returns {undefined}
     */
    $scope.perform = function ($event, dataVariables, eventId) {
        jw.isLoading = true;
        if (window.Pace)
            window.Pace.start();

        var eventStuff = $scope.getEventObject($event);
        var element = $event.currentTarget.id;
        var el$ = $('#' + element);

        var getdate = new Date();
        var article = new Object();
        article.componentId = element;
        article.eventType = $event.type;
        article.eventTypeFrom = $event.type;
        article.datetime = getdate;
        article.value = eventStuff;
        article.eventId = eventId;

        article.variableData = [];
        for (var i = 0; i < dataVariables.length; i++)
        {
            var arrItem = dataVariables[i];
            try
            {
                var data = $scope.$eval(arrItem);
                if (data !== 'undefined')
                {
                    var jsonVariable = {};
                    jsonVariable.variableName = arrItem;
                    jsonVariable.variableText = data;
                    jsonVariable.$jwid = data.$jwid;
                    article.variableData.push(jsonVariable);
                }
            } catch (e)
            {
                console.log("Unable to find variable " + arrItem);
            }
        }
        $.ajax({
            type: "POST",
            url: "jwajax",
            data: JSON.stringify(article),
            dataType: "json",
            contentType: 'application/json',
            mimeType: 'application/json',
            asynch: true,
            cache: true,
            beforeSend: function (xhr) {
                try
                {
                    if (window.Pace)
                    {
                        window.Pace.start();
                        jw.isLoading = true;
                    }
                } catch (e)
                {
                }
            },
            converters: {
                'json': true
            },
            success: function (result, status, xhr) {
                try
                {
                    jw.actions.processResponse(result, $scope, $parse, $timeout, $compile);
                } catch (e)
                {
                    console.log("Error in processing response : " + result);
                }
                try
                {
                    if (window.Pace)
                    {
                        window.Pace.stop();
                        jw.isLoading = false;
                    }
                } catch (e)
                {
                }
            },
            fail: function (xhr, textStatus, errorThrown) {
                var err = eval("(" + xhr.responseText + ")");
                if (BootstrapDialog)
                {
                    BootstrapDialog.show({
                        title: "Server Error",
                        message: "An error was encountered in the connection between the server and the client<br>" + textStatus + "<br>" + err + "<br>" + errorThrown,
                        type: BootstrapDialog.TYPE_DANGER,
                        buttons: [{
                                label: 'Close',
                                action: function (dialogItself) {
                                    dialogItself.close();
                                }
                            }]
                    });
                }
                try
                {
                    if (window.Pace)
                    {
                        window.Pace.stop();
                        jw.isLoading = false;
                    }
                } catch (e)
                {
                }
            },
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
    //JW_SCOPE_INSERTIONS

    jw.pageLoading = false;
}); //end of controller
