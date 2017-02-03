angular.module('operacao').factory("dashboardAPI",function ($resource,constantes, $injector) {
    var _findAllWidgetsByUser = function () {
    	var retorno = {};
		return $resource("rest/widgets/all",{},{
        	query: {
	        			method: 'GET', 
	        			isArray: false, 
	        			transformResponse: function(response) {
	        			
	        				 function parseJsonFromBD(jsonText){
						    	  return JSON.parse(jsonText, function (key, value) {
						              if (value && (typeof value === 'string') && value.indexOf("function") === 0) {
						                  // we can only pass a function as string in JSON ==> doing a real function
						                  var jsFunc = new Function('return ' + value)();
						                  return jsFunc;
						              }
						                   
						              return value;
						          });
						      }
	        				 
	        				var json = angular.fromJson(response);
	        				
	        				for(var w in json.widgets){
	    		  					json.widgets[w].chart = {};
	    		  					json.widgets[w].chart.options = parseJsonFromBD(json.widgets[w].widgetType.options);
	    		  					json.widgets[w].chart.api = {};
	    		  					json.widgets[w].chart.data =[{ key: json.widgets[w].widgetQuery.desQuery, values: $injector.get(json.widgets[w].widgetQuery.nomService)[json.widgets[w].widgetQuery.nomMethodQuery]() }];
	    		  					json.widgets[w].numIdWidgetType = json.widgets[w].widgetType.numIdWidgetType;
	    		  					json.widgets[w].numIdWidgetQuery = json.widgets[w].widgetQuery.numIdWidgetQuery;
	    	  				}
	    	  				
	        				return json;
	        			}
        			} 
        }).query();
    };
    
    return{
    	findAllWidgetsByUser : _findAllWidgetsByUser,
    };
})