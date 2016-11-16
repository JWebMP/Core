JW_APP_NAME.directive('ngSelect', function ($parse) {
        return function (scope, element, attrs) {
            var fn = $parse(attrs.ngSelect);
            element.on('select', function (event) {
                scope.$apply(function () {
                    event.preventDefault();
                    fn(scope, {$event: event});
                });
            });
        };
    }); 