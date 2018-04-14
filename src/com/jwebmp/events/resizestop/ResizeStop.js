JW_APP_NAME.directive('ngResizeStop', function ($parse) {
        return function (scope, element, attrs) {
            var fn = $parse(attrs.ngResizeStop);
            element.on('resizestop', function (event) {
                scope.$apply(function () {
                    event.preventDefault();
                    fn(scope, {$event: event});
                });
            });
        };
    }); 