/**
 * Created by Ananth on 7/20/2017.
 */
(function() {

    angular.module('vehicleTracker').controller('VehicleController', VehicleController);

    VehicleController.$inject = ['vehicleService'];

    function VehicleController(vehicleService) {
        var vehicleListVm = this;

        vehicleService.get()
            .then(function(vehicles){
              vehicleListVm.vehicles = vehicles;
            }, function (error){
                console.log(error);
            });
    }

})();

