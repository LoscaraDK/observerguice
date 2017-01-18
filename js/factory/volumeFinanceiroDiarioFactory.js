angular.module('operacao').factory("volumeFinanceiroAPI",function ($resource) {
    var _getVolumeFinanceiroDiario = function () {
		return $resource("rest/volumefinanceirodiario/:data/:codigoSituacaoOperacao",{data:'@data',codigoSituacaoOperacao:'@codigoSituacaoOperacao'},{
        	query: {
	        			method: 'GET', 
	        			isArray: true, 
	        			cancellable: false,
	        			transformResponse: function(data) {
	        				return angular.fromJson(data);
	        			}
        			} 
        });
    };

    return{
    	getVolumeFinanceiroDiario: _getVolumeFinanceiroDiario
    };
})