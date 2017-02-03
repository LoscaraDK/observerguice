angular.module('operacao').factory("widgetSettingAPI",function ($resource,constantes) {
    var _getTypes = function () {
		return $resource("rest/setting/types",{},{
        	query: {
	        			method: 'GET', 
	        			isArray: true, 
	        			cancellable: false,
	        			transformResponse: function(data) {
	        				return angular.fromJson(data);
	        			}
        			} 
        }).query();
    };
    
     var _getQuerys = function () {
		return $resource("rest/setting/querys",{},{
        	query: {
	        			method: 'GET', 
	        			isArray: true, 
	        			cancellable: false,
	        			transformResponse: function(data) {
	        				return angular.fromJson(data);
	        			}
        			} 
        }).query();
    };
	
	 var _saveWidget = function (widget) {
		var WidgetAction  = $resource("rest/setting/save");
        WidgetAction.save(widget, function(response){
        	console.log(response.numIdWidget);
        	widget.numIdWidget = response.numIdWidget;
        	console.log('id retornado do widget');
        	console.log(widget);
        	console.log('fim id retornado do widget');
        });
        
    };
    
    var _updateWidget = function (widget) {
		var WidgetAction = $resource("rest/setting/update/:id",null,{
			update: {
				method: 'PUT'
			}			
		});
		
		WidgetAction.update(widget,function(response){
			console.log('entrou no response do update');
			console.log(response);
			console.log('saiu do response no update');
		});      
    };
	
	var _deleteWidget = function (widget) {
		console.log('factory vai remover o widget');
		console.log(widget);
		var WidgetAction = $resource("rest/setting/delete/:id",{ id:'@id' },{
			delete: {
				method: 'DELETE'
			}			
		});
		WidgetAction.delete({id: widget.numIdWidget});
		console.log('fim factory vai remover o widget');      
    };
	
	
    return{
    	getTypes: _getTypes,
    	getQuerys: _getQuerys,
    	saveWidget: _saveWidget,
    	updateWidget: _updateWidget,
    	deleteWidget: _deleteWidget    	
    };
})