angular.module('cardForm', ['statusTranslate'])

	.directive('cardForm', function () {
		return {
			scope: {},
			controller: function ($scope, $http) {

				$scope.cardCard = {};

				$scope.save = function () {
					$http.post('rest/card', $scope.cardCard)
						.success(function (response) {
							$scope.cardCard = {};
							$scope.cardForm.submitted = false;
							$scope.status = response.status;
						});
				};

			},
			templateUrl: 'app/component/card-form/card-form.html'
		}
	})

;