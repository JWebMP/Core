JW_APP_NAME.directive('ngResize', function ($parse) {
        return function (scope, element, attrs) {
            var fn = $parse(attrs.ngResize);
            element.on('resize', function (event) {
                scope.$apply(function () {
                    event.preventDefault();
                    fn(scope, {$event: event});
                });
            });
        };
    }); 