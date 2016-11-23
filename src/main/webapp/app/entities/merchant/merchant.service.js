(function() {
    'use strict';
    angular
        .module('jhipsterSampleApp')
        .factory('Merchant', Merchant);

    Merchant.$inject = ['$resource'];

    function Merchant ($resource) {
        var resourceUrl =  'api/merchants/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
