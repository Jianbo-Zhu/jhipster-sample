(function() {
    'use strict';

    angular
        .module('jhipsterSampleApp')
        .controller('MerchantDetailController', MerchantDetailController);

    MerchantDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Merchant'];

    function MerchantDetailController($scope, $rootScope, $stateParams, previousState, entity, Merchant) {
        var vm = this;

        vm.merchant = entity;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('jhipsterSampleApp:merchantUpdate', function(event, result) {
            vm.merchant = result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
