JW_APP_NAME.directive('ngDropOver', function ($parse) {
    return function (scope, element, attrs) {
        var fn = $parse(attrs.ngDropOver);
        element.on('dropover', function (event) {
            scope.$apply(function () {
                event.preventDefault();
                fn(scope, {$event: event});
            });
        });
    };
});
