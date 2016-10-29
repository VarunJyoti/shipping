angular.module('gasstation.product').controller("ProductController", function($scope, $state, $stateParams){
	$scope.rowCollection = [
      {productId: "1", name: 'Regular', price: '1.34', quantity: "21"},
      {productId: "2", name: 'Super', price: '3.34', quantity: "24"},
      {productId: "3", name: 'Diesel', price: '1.34', quantity: "100"},
      {productId: "4", name: 'Propane', price: '4.55', quantity: "34"}
  ];

  if($stateParams.productId != ""){
    $scope.record = $scope.rowCollection.find(function(e){
      if(e.productId == $stateParams.productId){
        return true;
      }
    });
  }

  $scope.addEditProduct = function(row){
    if(!row){
  	 $state.go("dashboard.addproduct",{productId:""});
    }else{
      $state.go("dashboard.addproduct",{productId:row.productId});
    }
  }

  $scope.goBack = function(){
  	$state.go("dashboard.listproduct");
  }

})