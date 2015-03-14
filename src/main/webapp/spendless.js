var spendlessModule = angular.module('spendless', ["ngResource"]);

(function () {
    spendlessModule.controller('SpendlessController', function($scope, $resource){
        var spendless = this;
        $scope.showDetails = function(items) {
            var text = '';
            items.forEach(function(item) {
                text += item.name + ' ' + item.price + ' ' + item.quantity + '\n';
            });
            alert(text);
        };
        spendless.exps = [];
        $scope.expenses = $resource(document.URL + 'expenses');
        var results = $scope.expenses.query(function() {
            spendless.exps = results;
        });
    })
})();
