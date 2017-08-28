var j = $.noConflict();
var app = angular.module("gumgaApp", []);

app.controller("PasswordMeterController", function($scope, $http, $filter) {
	$scope.password = "";
	$scope.model = new Object();

	$scope.focoPadrao = function() {
		j("#password").focus();
	};

	$scope.checkPassword = function() {
		var url = "/api/v1/password-meter/check-password?password="
				+ encodeURIComponent($scope.password);

		$http({
			url : url,
			method : "GET",
		}).then(function sucess(response) {
			$scope.model = response.data.result.model;
		}, function error(response) {
			console.log(response.data);
		});
	};

	$scope.checkPassword();
	$scope.focoPadrao();
});