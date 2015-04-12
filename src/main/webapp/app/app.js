angular

	.module('app', [
		'ngRoute',
		'angularPayments',

		'cardForm',
		'cardSearch'
	])

	.config(function ($routeProvider) {
		$routeProvider.
			when('/home', {
				templateUrl: 'app/view/home.html'
			}).
			when('/search', {
				templateUrl: 'app/view/search.html'
			}).
			otherwise({
				redirectTo: '/home'
			});
	})

;
