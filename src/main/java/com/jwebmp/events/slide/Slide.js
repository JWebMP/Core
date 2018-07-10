JW_APP_NAME.directive('ngSlide', function ($parse) {
    return function (scope, element, attrs) {
        var fn = $parse(attrs.ngSlide);
        element.on('slide', function (event) {
            scope.$apply(function () {
                event.preventDefault();
                fn(scope, {$event: event});
            });
        });
    };
});
