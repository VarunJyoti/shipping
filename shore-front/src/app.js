angular.module('gasstation', [
  'ui.router',
  'ui.bootstrap', 
  'smart-table',
  'ngResource',
  'gasstation.user',
  "gasstation.company",
  'gasstation.product',
  "gasstation.login"
  ]);
angular.module('gasstation').controller("MainCtrl", function($scope, $state){});
