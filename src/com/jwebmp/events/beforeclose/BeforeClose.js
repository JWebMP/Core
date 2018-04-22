JW_APP_NAME.directive('ngBeforeClose', function ($parse) {
    return function (scope, element, attrs) {
        var fn = $parse(attrs.ngBeforeClose);
        element.on('beforeclose', function (event) {
            scope.$apply(function () {
                event.preventDefault();
                fn(scope, {$event: event});
            });
        });
    };
});
