var a = [
		{"numIdWidgetType": 1, "nomWidgetType": "teste1", "options":  {"chart":{"type":"discreteBarChart","margin":{"top":10,"right":20,"bottom":35,"left":150},"x":"function(d){return d.key;}","y":"function(d){return d.value;}","showValues":true,"valueFormat":"function(d){return d3.format(',.4f')(d);}","transitionDuration":500,"xAxis":{"axisLabel":"Tipos de Produto","axisLabelDistance":-8},"yAxis":{"axisLabel":"Volume Financeiro","axisLabelDistance":70}}}},
		{"numIdWidgetType": 2, "nomWidgetType": "teste2", "options":  {"chart":{"type":"discreteBarChart","margin":{"top":10,"right":20,"bottom":35,"left":150},"x":"function(d){return d.key;}","y":"function(d){return d.value;}","showValues":true,"valueFormat":"function(d){return d3.format(',.4f')(d);}","transitionDuration":500,"xAxis":{"axisLabel":"Tipos de Produto","axisLabelDistance":-8},"yAxis":{"axisLabel":"Volume Financeiro","axisLabelDistance":70}}}},
		{"numIdWidgetType": 3, "nomWidgetType": "teste3", "options":  {"chart":{"type":"discreteBarChart","margin":{"top":10,"right":20,"bottom":35,"left":150},"x":"function(d){return d.key;}","y":"function(d){return d.value;}","showValues":true,"valueFormat":"function(d){return d3.format(',.4f')(d);}","transitionDuration":500,"xAxis":{"axisLabel":"Tipos de Produto","axisLabelDistance":-8},"yAxis":{"axisLabel":"Volume Financeiro","axisLabelDistance":70}}}}
		
		];

//retorna o primeiro valor que passa no teste
console.log(
		
		a.find(function (item){
			if(item.numIdWidgetType === 2){
				return item;
			}
		})
		
);
