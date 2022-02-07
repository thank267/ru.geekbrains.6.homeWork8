angular.module('market-front').controller('recommendationController', function ($scope, $http, $location, $localStorage) {
    const contextPath = 'http://localhost:5555/recommendation/';

    $scope.loadPurchased = function () {
        $http({
            url: contextPath + 'api/v1/recommendation/purchased',
            method: 'GET'
        }).then(function (response) {
            $scope.purchased = response.data;
        });
    };

    $scope.loadAdded = function () {
        $http({
            url: contextPath + 'api/v1/recommendation/added',
            method: 'GET'
        }).then(function (response) {
            $scope.added = response.data;
        });
    };

    $scope.loadPurchased();
    $scope.loadAdded();
});
