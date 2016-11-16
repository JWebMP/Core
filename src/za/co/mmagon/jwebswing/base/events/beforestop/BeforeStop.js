JW_APP_NAME.directive('ngBeforeStop', function ($parse) {
        return function (scope, element, attrs) {
            var fn = $parse(attrs.ngBeforeStop);
            element.on('beforestop', function (event) {
                scope.$apply(function () {
                    event.preventDefault();
                    fn(scope, {$event: event});
                });
            });
        };
    }); 