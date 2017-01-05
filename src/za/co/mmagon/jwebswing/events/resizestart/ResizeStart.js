JW_APP_NAME.directive('ngResizeStart', function ($parse) {
        return function (scope, element, attrs) {
            var fn = $parse(attrs.ngResizeStart);
            element.on('reizestart', function (event) {
                scope.$apply(function () {
                    event.preventDefault();
                    fn(scope, {$event: event});
                });
            });
        };
    }); 