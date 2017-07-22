(function() {
    'use strict';
    angular.module('vehicleTracker')
        .service('vehicleService', vehicleService);

    vehicleService.$inject = ['$q', '$http'];

    function vehicleService($q, $http) {
        var self = this;
        self.get = getVehicles;

        function getVehicles() {
            return $http.get('http://localhost:8500/vehicles')
                .then(successFn, errorFn);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(error) {
            return $q.reject(error);
        }
    }
})();/**
 * Created by Ananth on 7/20/2017.
 */

