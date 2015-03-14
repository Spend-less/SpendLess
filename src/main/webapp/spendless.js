var spendlessModule = angular.module('spendless', ["ngResource"]);

(function () {
    spendlessModule.controller('SpendlessController', function($scope, $resource){
        var spendless = this;
        spendless.exps = [];
        $scope.expenses = $resource(document.URL + 'expenses');
        var results = $scope.expenses.query(function() {
            spendless.exps = results;
        });
    })
})();
