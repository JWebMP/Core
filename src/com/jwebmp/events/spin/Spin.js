JW_APP_NAME.directive('ngSpin', function ($parse) {
    return function (scope, element, attrs) {
        var fn = $parse(attrs.ngSpin);
        element.on('spin', function (event) {
            scope.$apply(function () {
                event.preventDefault();
                fn(scope, {$event: event});
            });
        });
    };
});
