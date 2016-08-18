var myApp = angular.module("FormApp", [])
				.controller("myController",[
  '$scope', '$window', '$http',
  
  function($scope, $window, $http) {
	  $scope.mynewValue="hello";
    $scope.messages = [];
    // AngularJS will populate this object with input
    // values based on the data-ng-model mappings.
    $scope.data = {}; 
    $scope.submit = function() {
    $http({
      method: 'POST', url: 'FormRead',
      data: $scope.data
    }).
      success(function(data, status, headers, config) {
     	  console.log("success");
    	  $scope.mynewValue="displaying new Data";
    	  $scope.data.firstName += " abcd";
        }).
      error(function(data, status, headers, config) {
        if(status == 400) {
          $scope.messages = data;
        } else {
          alert('Unexpected server error.');
        }
      });
  };
}]);