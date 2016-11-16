JW_APP_NAME.directive('ngReceive', function ($parse) {
        return function (scope, element, attrs) {
            var fn = $parse(attrs.ngReceive);
            element.on('receive', function (event) {
                scope.$apply(function () {
                    event.preventDefault();
                    fn(scope, {$event: event});
                });
            });
        };
    }); 