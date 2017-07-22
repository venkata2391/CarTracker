/**
 * Created by Ananth on 7/20/2017.
 */
(function() {

    angular.module('vehicleTracker').controller('AlertsController', AlertsController);

    AlertsController.$inject = ['alertService','$routeParams'];

    function AlertsController(alertService, $routeParams) {
        var alertListVm = this;

        alertService.getByVIN($routeParams.vin)
            .then(function(alerts){
                alertListVm.alerts = alerts;
            }, function (error){
                console.log(error);
            });
    }
})();

