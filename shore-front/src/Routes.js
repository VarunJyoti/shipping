angular.module('gasstation').config(function($stateProvider, $locationProvider) {
  
  var loginState = {
    name: 'login',
    url: '/',
    templateUrl: 'views/login.html',
    controller:"LoginController"
  }

  var aboutState = {
    name: 'dashboard',
    abstract: true,
    url: '/',
    templateUrl: 'views/dashboard.html'
  }

  var contentState = {
    name: 'dashboard.content',
    parent: aboutState,
    url: 'content',
    templateUrl: 'views/content.html'
  }

  var addCompanyState = {
    name: 'dashboard.addcompany',
    parent:aboutState,
    url: 'addcompany/{companyId}',
    templateUrl: 'views/addcompany.html',
    controller: 'CompanyController'
  }

  var listCompanyState = {
    name: 'dashboard.listcompany',
    parent: aboutState,
    url: 'listcompany',
    templateUrl: 'views/companylist.html',
    controller: 'CompanyController'
  }

  var listUserState = {
    name: 'dashboard.listuser',
    parent: aboutState,
    url: 'listuser',
    templateUrl: 'views/userlist.html',
    controller: 'UserController'
  }

  var addUserState = {
    name: 'dashboard.adduser',
    parent: aboutState,
    url: 'adduser/{userId}',
    templateUrl: 'views/adduser.html',
    controller: 'UserController'
  }

  var listProductState = {
    name: 'dashboard.listproduct',
    parent: aboutState,
    url: 'listproduct',
    templateUrl: 'views/productlist.html',
    controller: 'ProductController'
  }

  var addProductState = {
    name: 'dashboard.addproduct',
    parent: aboutState,
    url: 'addproduct/{productId}',
    templateUrl: 'views/addproduct.html',
    controller: 'ProductController'
  }

  $stateProvider.state(loginState);
  $stateProvider.state(aboutState);
  $stateProvider.state(contentState);
  $stateProvider.state(addCompanyState);
  $stateProvider.state(listCompanyState);
  $stateProvider.state(listUserState);
  $stateProvider.state(addUserState);
  $stateProvider.state(listProductState);
  $stateProvider.state(addProductState);

  $locationProvider.html5Mode({
    enabled: true,
    requireBase: false
  })
});
