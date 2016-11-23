(function() {
    'use strict';

    angular
        .module('jhipsterSampleApp')
        .controller('MerchantDeleteController',MerchantDeleteController);

    MerchantDeleteController.$inject = ['$uibModalInstance', 'entity', 'Merchant'];

    function MerchantDeleteController($uibModalInstance, entity, Merchant) {
        var vm = this;

        vm.merchant = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Merchant.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
