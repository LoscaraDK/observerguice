angular.module('operacao').factory("volumeFinanceiroAPI",function ($resource,constantes) {
    var _getVolumeFinanceiroDiario = function () {
		return $resource("rest/volumefinanceirodiario/:codigoSituacaoOperacao",{codigoSituacaoOperacao:'@codigoSituacaoOperacao'},{
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
    	getVolumeFinanceiroDiario: _getVolumeFinanceiroDiario,
    	getVolumeFinanceiroDiarioFinalizadas: function(){
    		return _getVolumeFinanceiroDiario().query(constantes.SITUACAO_FINALIZADA);
    	},
    	getVolumeFinanceiroDiarioPendContraParte: function(){
    		return _getVolumeFinanceiroDiario().query(constantes.SITUACAO_PEND_CONTRA_PARTE);
    	},
    	getVolumeFinanceiroDiarioPendLiquidacao: function(){
    		return _getVolumeFinanceiroDiario().query(constantes.SITUACAO_PEND_LIQUIDACAO);
    	}
    	
    };
})