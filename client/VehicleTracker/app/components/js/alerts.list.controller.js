/**
 * Created by Ananth on 7/20/2017.
 */
(function() {

    angular.module('vehicleTracker').controller('HighAlertsController', HighAlertsController);

    HighAlertsController.$inject = ['alertService'];

    function HighAlertsController(alertService) {
        var highAlertsVm = this

        highAlertsVm.sorter = {
            sortBy: 'vin',
            sortOrder: true
        };

        alertService.get()
            .then(function(alerts){
                highAlertsVm.alerts = alerts;
            }, function (error){
                console.log(error);
            });
    }

})();

/**
 * Created by Ananth on 7/21/2017.
 */
