JW_APP_NAME.directive('ngDropOut', function ($parse) {
        return function (scope, element, attrs) {
            var fn = $parse(attrs.ngDropOut);
            element.on('dropout', function (event) {
                scope.$apply(function () {
                    event.preventDefault();
                    fn(scope, {$event: event});
                });
            });
        };
    }); 