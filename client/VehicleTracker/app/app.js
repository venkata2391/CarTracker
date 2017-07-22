(function() {
    'use strict';
    angular.module('vehicleTracker', ['ngRoute']);


    angular.module('vehicleTracker')
        .config(moduleConfig)

    moduleConfig.$inject = ['$routeProvider'];

    function moduleConfig($routeProvider) {
         $routeProvider
            .when('/vehicles', {
                templateUrl: 'components/view/vehicle-list.html',
                controller: 'VehicleController',
                controllerAs: 'vehicleListVm'
            })
             .when('/getAlertsByVIN/:vin', {
                 templateUrl: 'components/view/vehicle-alerts.html',
                 controller: 'AlertsController',
                 controllerAs: 'alertListVm'
             })
             .when('/alerts', {
                 templateUrl: 'components/view/alerts-list.html',
                 controller: 'HighAlertsController',
                 controllerAs: 'highAlertsVm'
             })
            .otherwise({
                redirectTo: 'index.html'
            });
    }

})();




