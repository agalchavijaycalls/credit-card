angular.module('cardSearch', [])

	.directive('cardSearch', function () {
		return {
			scope: {},
			controller: function ($scope, $http) {

				$scope.cards = [];

				$scope.searchBy = function (number) {
					if (number == undefined) {
						number = "";
					}
					$http.get('rest/card/' + number).success(function (response) {
						$scope.cards = response;
					});
				};

			},
			templateUrl: 'app/component/card-search/card-search.html'
		}
	})

;