var j = $.noConflict();
var app = angular.module("gumgaApp", []);

app.controller("PasswordMeterController", function($scope, $http, $filter) 
{
	$scope.model = new Object();

	$scope.password = "";
	$scope.scoreClass = "label-default";
	$scope.complexityClass = "label-danger";

	$scope.focoPadrao = function() 
	{
		j("#password").focus();
	};

	$scope.setNgClass = function() 
	{
		var score = $scope.model.score;

		if ((score >= 0) && (score < 20)) {
			$scope.scoreClass = (score == 0) ? "label-default"
					: "label-danger";
			$scope.complexityClass = "label-danger";
		} else if ((score >= 20) && (score < 40)) {
			$scope.scoreClass = "label-warning";
			$scope.complexityClass = "label-warning";
		} else if ((score >= 40) && (score < 60)) {
			$scope.scoreClass = "label-info";
			$scope.complexityClass = "label-info";
		} else if ((score >= 60) && (score < 80)) {
			$scope.scoreClass = "label-primary";
			$scope.complexityClass = "label-primary";
		} else if ((score >= 80) && (score <= 100)) {
			$scope.scoreClass = "label-success";
			$scope.complexityClass = "label-success";
		}
	};

	$scope.checkPassword = function() 
	{
		var url = "/api/v1/password-meter/check-password?password="
				+ encodeURIComponent($scope.password);

		$http({
			url : url,
			method : "GET",
		}).then(function sucess(response) {
			$scope.model = response.data.result.model;
			$scope.setNgClass();
		}, function error(response) {
			console.log(response.data);
		});
	};

	$scope.checkPassword();
	$scope.focoPadrao();

});