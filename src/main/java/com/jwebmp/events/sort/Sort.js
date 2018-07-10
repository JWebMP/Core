JW_APP_NAME.directive('ngSort', function ($parse) {
    return function (scope, element, attrs) {
        var fn = $parse(attrs.ngSort);
        element.on('sort', function (event) {
            scope.$apply(function () {
                event.preventDefault();
                fn(scope, {$event: event});
            });
        });
    };
});
