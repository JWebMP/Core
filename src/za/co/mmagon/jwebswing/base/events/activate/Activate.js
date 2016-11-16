JW_APP_NAME.directive('ngActivate', function ($parse) {
        return function (scope, element, attrs) {
            var fn = $parse(attrs.ngActivate);
            element.on('activate', function (event) {
                scope.$apply(function () {
                    event.preventDefault();
                    fn(scope, {$event: event});
                });
            });
        };
    }); 