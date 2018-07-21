JW_APP_NAME.directive('ngSelecting', function ($parse) {
    return function (scope, element, attrs) {
        var fn = $parse(attrs.ngSelecting);
        element.on('selecting', function (event) {
            scope.$apply(function () {
                event.preventDefault();
                fn(scope, {$event: event});
            });
        });
    };
});
