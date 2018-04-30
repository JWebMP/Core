JW_APP_NAME.directive('ngLoad', function ($parse) {
    return function (scope, element, attrs) {
        var fn = $parse(attrs.ngLoad);
        element.on('load', function (event) {
            scope.$apply(function () {
                event.preventDefault();
                fn(scope, {$event: event});
            });
        });
    };
});
