JW_APP_NAME.directive('ngUpdate', function ($parse) {
    return function (scope, element, attrs) {
        var fn = $parse(attrs.ngStop);
        element.on('update', function (event) {
            scope.$apply(function () {
                event.preventDefault();
                fn(scope, {$event: event});
            });
        });
    };
});