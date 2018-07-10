JW_APP_NAME.directive('ngComplete', function ($parse) {
    return function (scope, element, attrs) {
        var fn = $parse(attrs.ngComplete);
        element.on('complete', function (event) {
            scope.$apply(function () {
                event.preventDefault();
                fn(scope, {$event: event});
            });
        });
    };
});
