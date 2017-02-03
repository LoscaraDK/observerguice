'use strict';

angular.module('mainApp.controllers',[])

  .controller('dashboardCtrl', ['$scope', '$timeout', '$injector','$stateParams',
    function($scope, $timeout, $injector,$stateParams) {
      $scope.gridsterOptions = {
        margins: [20, 20],
        columns: 4,
        //mobileBreakPoint: 1000,
        mobileModeEnabled: false,
        draggable: {
          handle: 'h3'
        },
        resizable: {
          enabled: true,
          handles: ['n', 'e', 's', 'w', 'ne', 'se', 'sw', 'nw'],

          // optional callback fired when resize is started
          start: function(event, $element, widget) {},

          // optional callback fired when item is resized,
          resize: function(event, $element, widget) {
            if (widget.chart.api) widget.chart.api.update();
          },

          // optional callback fired when item is finished resizing
          stop: function(event, $element, widget) {
            $timeout(function(){
              if (widget.chart.api) widget.chart.api.update();
            },400)
          }
        }
      };

      //console.log(generator)
//      $scope.dashboard = {
//        widgets: [
//        {
//            sizeY: 1,
//            sizeX: 1,
//            title: "Teste"
//          }
//
//        ]
//      };
      $scope.dashboard = $injector.get('dashboardAPI')['findAllWidgetsByUser']();
      
      console.log($scope.dashboard);
      
      
      // widget events
      $scope.events = {
        resize: function(e, scope){
          $timeout(function(){
            if (scope.api && scope.api.update) scope.api.update();
          },200)
        }
      };

      $scope.config = { visible: false };

      //make chart visible after grid have been created
      $timeout(function(){
        $scope.config.visible = true;
      }, 200);

      //subscribe widget on window resize event
      angular.element(window).on('resize', function(e){
        $scope.$broadcast('resize');
      });

      // grid manipulation
      $scope.clear = function() {
        $scope.dashboard.widgets = [];
      };

      $scope.addWidget = function() {
        $scope.dashboard.widgets.push({
          title: "New Widget",
          sizeX: 1,
          sizeY: 1
        });
      };
    }
  ])

  .controller('CustomWidgetCtrl', ['$scope', '$modal','$injector',
    function($scope, $modal, $injector) {

      $scope.remove = function(widget) {
          $scope.dashboard.widgets.splice($scope.dashboard.widgets.indexOf(widget), 1);
    	  console.log('remover o widget');
    	  console.log(widget);
    	  $injector.get('widgetSettingAPI')['deleteWidget'](widget);
    	  console.log('fim do remover o widget');
      };

      $scope.openSettings = function(widget) {
        $modal.open({
          scope: $scope,
          templateUrl: 'js/gridster/widgetSettings.html',
          controller: 'WidgetSettingsCtrl',
          resolve: {
            widget: function() {
            	console.log(widget);
              return widget;
            }
          }
        });
      };

    }
  ])

  .controller('WidgetSettingsCtrl', ['$scope', '$timeout', '$rootScope', '$modalInstance', 'widget', '$injector',
    function($scope, $timeout, $rootScope, $modalInstance, widget, $injector) {
      $scope.widget = widget;
      //$scope.widgetTypes = Object.keys(generator);
      $scope.widgetTypes = $injector.get('widgetSettingAPI')['getTypes']();
      console.log($injector.get('widgetSettingAPI')['getQuerys']());
      $scope.widgetQuerys = $injector.get('widgetSettingAPI')['getQuerys']();
      console.log($scope.widgetTypes);
      $scope.form = {
    	title: widget.title,
        sizeX: widget.sizeX,
        sizeY: widget.sizeY,
        col: widget.col,
        row: widget.row,
        //novo
        numIdWidgetType: widget.numIdWidgetType,
        numIdWidgetQuery: widget.numIdWidgetQuery,
        numIdWidget: widget.numIdWidget
      };
      
      $scope.selectedWidgetQuery = function() {
    	  widget.widgetQuery =  $scope.widgetQuerys.find(
			  function (query){
		  			if(query.numIdWidgetQuery === $scope.form.numIdWidgetQuery){
		  					console.log(query);
			  				return query;
		  			}
			  });
      };
      
      $scope.selectedWidgetType = function() {
    	  widget.widgetType =  $scope.widgetTypes.find(
    		  function (type){
		  			if(type.numIdWidgetType === $scope.form.numIdWidgetType){
		  					console.log(type);
			  				return type;
		  			}
			  });
	  };
      
      $scope.dismiss = function() {
        $modalInstance.dismiss();
      };

      $scope.remove = function() {
        $scope.dashboard.widgets.splice($scope.dashboard.widgets.indexOf(widget), 1);
        $modalInstance.close();
      };
      
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
      
      $scope.submit = function() {
        angular.extend(widget, $scope.form);
        console.log(widget);
     
        if (widget.numIdWidgetType && widget.numIdWidgetQuery) {
        	console.log('parse do json')
            widget.chart.options = parseJsonFromBD(widget.widgetType.options);
        	console.log(widget.widgetQuery);
            widget.chart.data = [{ key: widget.widgetQuery.desQuery, values: $injector.get(widget.widgetQuery.nomService)[widget.widgetQuery.nomMethodQuery]() }];
            
            if(widget.numIdWidget){
            	console.log('atualiza')
            	$injector.get('widgetSettingAPI')['updateWidget'](widget);
            }else{
            	console.log('salva')
            	$injector.get('widgetSettingAPI')['saveWidget'](widget);
            }
        }
        
        
        
        $modalInstance.close(widget);
        
        

        //update new chart
        $timeout(function(){
          widget.chart.api.update();
        },600)
      };

    }
  ])

  .filter('object2Array', function() {
    return function(input) {
      var out = [];
      for (var i in input) {
        out.push(input[i]);
      }
      return out;
    }
  });


   