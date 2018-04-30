JW_APP_NAME.directive('ngDragStop', function ($parse) {
    return function (scope, element, attrs) {
        var fn = $parse(attrs.ngDragStop);
        element.on('dragstop', function (event) {
            scope.$apply(function () {
                event.preventDefault();
                fn(scope, {$event: event});
            });
        });
    };
});
