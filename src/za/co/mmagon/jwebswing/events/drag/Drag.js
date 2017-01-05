JW_APP_NAME.directive('ngDrag', function ($parse) {
        return function (scope, element, attrs) {
            var fn = $parse(attrs.ngDrag);
            element.on('drag', function (event) {
                scope.$apply(function () {
                    event.preventDefault();
                    fn(scope, {$event: event});
                });
            });
        };
    }); 