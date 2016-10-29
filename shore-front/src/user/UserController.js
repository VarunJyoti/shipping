angular.module('gasstation.user').controller("UserController", function($scope, $state, $stateParams, $http, UserService){

 UserService.getUserList.query(function(response){
    $scope.rowCollection = response;
  },function(failed){
    
  });

  if($stateParams.userId){
    $scope.record = $scope.rowCollection.find(function(e){
        if(e.userId == $stateParams.userId){
          return true;
        }
      });
  }
  $scope.addEditUser = function(row){
    if(!row){
    	$state.go("dashboard.adduser",{userId:""});
    }else{
      
      $state.go("dashboard.adduser",{userId:row.userId});
    }
  }

  $scope.goBack = function(){
  	$state.go("dashboard.listuser");
  }

})