JW_APP_NAME.directive('ngDeActtivate', function ($parse) {
        return function (scope, element, attrs) {
            var fn = $parse(attrs.ngDeActivate);
            element.on('deactivate', function (event) {
                scope.$apply(function () {
                    event.preventDefault();
                    fn(scope, {$event: event});
                });
            });
        };
    }); 