JW_APP_NAME.directive('ngResponse', function ($parse) {
    return function (scope, element, attrs) {
        var fn = $parse(attrs.ngResponse);
        element.on('response', function (event) {
            scope.$apply(function () {
                event.preventDefault();
                fn(scope, {$event: event});
            });
        });
    };
});
