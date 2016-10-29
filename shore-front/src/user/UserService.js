angular.module('gasstation.user').factory('UserService',function($resource){

	var userService = {};

	userService.getUserList = $resource('/userlist');
	return userService;
	
});