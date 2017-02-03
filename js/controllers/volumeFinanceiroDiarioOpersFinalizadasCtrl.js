function VolumeFinanceiroDiarioOpersFinalizadasCtrl($scope,
									$stateParams,
									_volumesPorProduto) {
	var ctrl = this;
	
	var title = "Volume financeiro de operações finalizadas";
	var options = {
		    chart: {
		        type: 'discreteBarChart',
		        height: 350,
		        margin : {
		            top: 20,
		            right: 20,
		            bottom: 60,
		            left: 150
		        },
		        x: function(d){ return d.key; },
		        y: function(d){ return d.value; },
		        showValues: true,
		        valueFormat: function(d){
		            return d3.format(',.4f')(d);
		        },
		        transitionDuration: 500,
		        xAxis: {
		            axisLabel: 'Tipos de IF'
		        },
		        yAxis: {
		            axisLabel: 'Volume financeiro',
		            axisLabelDistance: 80
		        }
		    }
		};
		//pattern para expor os valores privados para publicos, poderia também setar direto no ctrl
	    angular.extend(ctrl, {
		  volumes: _volumesPorProduto,
		  title: title,
		  options: options
	    });
};

VolumeFinanceiroDiarioOpersFinalizadasCtrl.$inject = ["$scope",
                                      "$stateParams",
                                      "_volumesPorProduto"];

VolumeFinanceiroDiarioOpersFinalizadasCtrl.resolve = {
    _volumesPorProduto: ["volumeFinanceiroAPI","$stateParams","constantes", function (volumeFinanceiroAPI,$stateParams,constantes) {
    	console.log($stateParams);
    	return volumeFinanceiroAPI.getVolumeFinanceiroDiarioFinalizadas();
    }]
};

angular.module('operacao').controller('VolumeFinanceiroDiarioOpersFinalizadasCtrl',VolumeFinanceiroDiarioOpersFinalizadasCtrl);