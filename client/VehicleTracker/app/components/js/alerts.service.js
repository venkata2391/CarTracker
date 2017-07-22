(function() {
    'use strict';
    angular.module('vehicleTracker')
        .service('alertService', alertService);

    alertService.$inject = ['$q', '$http'];

    function alertService($q, $http) {
        var self = this;
        self.getByVIN = getAlertsByVIN;
        self.get = getHighAlerts;

        function getAlertsByVIN(vin) {
            return $http.get('http://localhost:8500/alerts/getAlertsByVIN/vin')
                .then(successFn, errorFn);
        }

        function getHighAlerts(){
            return $http.get('http://localhost:8500/alerts')
                .then(successFn, errorFn);
        }

        function successFn(response) {
            console.log(response.data);
            return response.data;
        }

        function errorFn(error) {
            return $q.reject(error);
        }
    }
})();/**
 * Created by Ananth on 7/20/2017.
 */

/**
 * Created by Ananth on 7/21/2017.
 */
