JW_APP_NAME.directive('ngJstreeOnchanged', function ($parse) {
        return function (scope, element, attrs) {
            var fn = $parse(attrs.ngActivate);
            element.on('changed.jstree', function (event,data) {
                scope.$apply(function () {
                    event.preventDefault();
                    event.data.selected = data.changed.selected;
                    event.data.deselected = data.changed.deselected;
                    fn(scope, {$event: event});
                });
            });
        };
    }); 