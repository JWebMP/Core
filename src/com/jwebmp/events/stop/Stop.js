JW_APP_NAME.directive('ngStop', function ($parse) {
    return function (scope, element, attrs) {
        var fn = $parse(attrs.ngStop);
        element.on('stop', function (event) {
            scope.$apply(function () {
                event.preventDefault();
                fn(scope, {$event: event});
            });
        });
    };
});
