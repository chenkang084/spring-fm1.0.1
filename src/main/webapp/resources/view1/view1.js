'use strict';

angular.module('myApp.view1', ['ngRoute','myApp.abcd'])



.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: './resources/view1/view1.html',
    controller: 'View1Ctrl'
  });
}])

.controller('View1Ctrl', ['$scope','$http','myConstant','myF',function($scope,$http,myConstant,myF) {
  $scope.name = 'Jack';
  myF.say();
  
  $http({
	  method: 'POST',
	  url: '/fm/testHead',
	  data: { test: 'test' },
	  headers:"application/x-www-form-urlencoded",
	}).then(function successCallback(response) {
	    console.log(11);
	  }, function errorCallback(response) {
		  console.log(22);
	  });

  
}])
.filter('myFilter',function(){
  return function (input,uppercase){
    input = input || '';
    var output = '';
    for (var i=0;i<input.length;i++){
      output += input.charAt(i).toUpperCase()
    }
    return output;
  }
})
.constant('myConstant', {
  name : "Tomcat"
})
.directive('test',function(){
  return {
    restrict: 'AE',
    transclude : true,
    replace : true,
    scope:{
      name:'@',
      isname:'@'
    },
    controller:function ($scope){

      //console.log($scope)
    }
  }
})
.directive('myTabs', function() {
  return {
    restrict: 'E',
    transclude: true,
    scope: {},

    controller: ['$scope', function($scope) {
      var panes = $scope.panes = [];

      $scope.select = function(pane) {
        angular.forEach(panes, function(pane) {
          pane.selected = false;
        });
        pane.selected = true;
      };

      this.addPane = function(pane) {
        if (panes.length === 0) {
          $scope.select(pane);
        }
        panes.push(pane);
      };

      this.subtract = function () {
        console.log()
      }
    }],
    templateUrl: './resources/view1/my-tabs.html'
  };
})
.directive('myPane', function() {
  return {
    require: '^myTabs',
    restrict: 'E',
    transclude: true,
    scope: {
      title: '@'
    },
    link: function(scope, element, attrs, tabsCtrl) {
      tabsCtrl.addPane(scope);
    },
    templateUrl: './resources/view1/my-pane.html'
  };
});










