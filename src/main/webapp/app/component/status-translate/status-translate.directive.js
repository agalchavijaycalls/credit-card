angular.module('statusTranslate', [])

	.directive('statusTranslate', function () {
		return {
			scope: {
				status: '='
			},
			templateUrl: 'app/component/status-translate/status-translate.html'
		}
	})
;