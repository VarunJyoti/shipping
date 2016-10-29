angular.module("gasstation.company").controller("CompanyController", function($scope, $state,$uibModal, $stateParams,CompanyService){
	$scope.rowCollection = [
      {companyId: "1", name: "dssf", phone: '323243', username: 'sa@e.com', address: "USA", balance: 102, email: 'whatever@gmail.com'},
      {companyId: "2", name: "fhhd", phone: '6565765', username: 'as@sa.com', address: "India", balance: -2323.22, email: 'oufblandou@gmail.com'},
      {companyId: "3", name: "ewe", phone: '545435', username: 'hj@d.com', address: "Canada", balance: 42343, email: 'raymondef@gmail.com'},
      {companyId: "4", name: "vcf", phone: '543634', username: 'sa@e.com', address: "USA", balance: 102, email: 'whatever@gmail.com'},
      {companyId: "5", name: "fde", phone: '5435', username: 'as@sa.com', address: "India", balance: -2323.22, email: 'oufblandou@gmail.com'},
      {companyId: "6", name: "rdd", phone: '54353', username: 'hj@d.com', address: "Canada", balance: 42343, email: 'raymondef@gmail.com'}
  ];

  /*DataService.getCompanyList().query(function(response){
  	$scope.rowCollection = response;
  },function(failed){

  });*/

  if($stateParams.companyId != ""){
    $scope.record = $scope.rowCollection.find(function(e){
      if(e.companyId == $stateParams.companyId){
        return true;
      }
    });
  }

  $scope.addEditCompany = function(row){
    if(!row){
      $state.go("dashboard.addcompany",{companyId:""});
    }else{
      $state.go("dashboard.addcompany",{companyId:row.companyId});
    }
  	
  }

  $scope.goBack = function(){
    $state.go("dashboard.listcompany");
  }

  
})