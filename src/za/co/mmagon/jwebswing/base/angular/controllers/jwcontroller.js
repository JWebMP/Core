/* global JW_APP_NAME, BootstrapDialog */

JW_APP_NAME.controller('JW_APP_CONTROLLER', function ($scope, $compile, $parse, $timeout) {

    var self = this;
    /**
     * Loads up the initial variables into angular
     * @returns {undefined}
     */
    $scope._init = function ()
    {
        try
        {
            if (window.Modernizr)
            {
                $scope.Modernizr = window.Modernizr;
            }
        } catch (e)
        {
            console.warn("moderniz not enabled");
        }

        var toGo = 'jwad?o=body';
        $.ajax({
            type: "POST",
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
            fail: function (xhr, textStatus, errorThrown) {
                var err = eval("(" + xhr.responseText + ")");
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
            model.assign($scope, item.variable);
        });

        $timeout(function () {});
    };

    /**
     * Performs a post send to the server
     * @param {type} $event
     * @param {type} dataVariables
     * @param {type} eventId
     * @returns {undefined}
     */
    $scope.perform = function ($event, dataVariables, eventId) {
        if (window.Pace)
            window.Pace.start();
        //alert('doing stuff');
        var eventStuff = $scope.getEventObject($event);
        //alert(JSON.stringify($event));
        var element = $event.currentTarget.id;
        //disable the element on perform (it has already happened wait for server response / show loader on item etc)
        var el$ = $('#' + element);
        //el$.


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
                    jsonVariable.variableName = arrItem; //the name
                    jsonVariable.variableText = data; //transforms to string on the server via deserializer
                    jsonVariable.$jwid = data.$jwid;
                    article.variableData.push(jsonVariable);
                }
            } catch (e)
            {
                console.log("Unable to find variable " + arrItem);
            }
        }
        //article.variableData = [].concat(dataVariables);

        $.ajax({
            type: "POST",
            url: "jwajax",
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
                try
                {
                    if (window.Pace)
                        window.Pace.stop();
                } catch (e)
                {

                }
            },
            fail: function (xhr, textStatus, errorThrown) {
                var err = eval("(" + xhr.responseText + ")");
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
                try
                {
                    if (window.Pace)
                        window.Pace.stop();
                } catch (e)
                {

                }
                //alert('Ooops this is never supposed to happen! How did it get through the servlet?\n' + textStatus);
            }
        });
    };

    /**
     *
     * @param {type} data
     * @returns {undefined}
     */
    $scope.performAngularFetch = function (data) {
        if (Pace)
            Pace.start();

        //alert('angular fetch data  : ' + data);
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
        $scope.processJsScripts(result);
    };

    /**
     * Adds the style tag to the html
     * @param {type} result
     * @returns {undefined}
     */
    $scope.processCss = function (result)
    {
        $('head').append('<style>' + result + '</style>');
    };

    /**
     * Adds the JS Reference
     * @param {type} result
     * @returns {undefined}
     */
    $scope.processJSReferences = function (result)
    {
        $.each(result.jsReferences, function (i, item) {

            var len = $('script[src="' + item + '"]').length;
            if (len === 0)
                $.cachedScript(item);
        });
    };

    /**
     * Process the JavaScripts returned
     * @param {type} result
     * @returns {undefined}
     */
    $scope.processJsScripts = function (result)
    {
        $.each(result.jsScripts, function (i, item) {
            var result = eval(item);
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
            var len = $('link[href="' + item + '"]').length;
            if (len === 0)
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
     * @param title The title of the dialog
     * @param message The message to display
     * @param type the type of dialog - Danger,Success,Warning,Primary,Information,Default
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
}); //end of controller
