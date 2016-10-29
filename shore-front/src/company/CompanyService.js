angular.module("gasstation.company").factory('CompanyService',function($resource){
	var companyService = {};


	companyService.getCompanyList = $resource('/companylist');
	return companyService;
});