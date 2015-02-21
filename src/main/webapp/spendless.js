var spendlessModule = angular.module('spendless', ["ngResource"]);

(function () {
    spendlessModule.controller('SpendlessController', function($scope, $resource){
        $scope.expenses = $resource('http://localhost:8080/:action', {action: 'expenses', callback: 'JSON_CALLBACK', is_array: true});
        $scope.expensesResult = $scope.expenses.get();
    })
})();
