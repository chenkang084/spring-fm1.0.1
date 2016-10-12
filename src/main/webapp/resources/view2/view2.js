'use strict';

angular.module('myApp.view2', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view2', {
    templateUrl: './resources/view2/view2.html',
    controller: 'View2Ctrl'
  });
}])

.controller('View2Ctrl', ['$scope',function($scope) {
  $scope.age = 10;
}])
.directive('parent', function() {
  return {
    restrict: 'AE',
    transclude: true,
    template:'<div ng-transclude=""></div><child name="age"></child>',
    scope:{
      age:'=age',
    },
    controller: function ($scope) {
      $scope.name = 'Jack';
      console.log($scope);
    },
    link: function(scope, element, attrs, tabsCtrl) {
      console.log(scope);
    },

  };
})
.directive('child', function() {
  return {
    require: '^^parent',
    restrict: 'AE',
    //transclude: true,
    scope:{
      name:'=name'
    },
    template:"child:{{name}}",
    controller:function($scope){
      console.log($scope);
    },
    link: function(scope, element, attrs, tabsCtrl) {
      console.log(scope);
    },
  };
});
