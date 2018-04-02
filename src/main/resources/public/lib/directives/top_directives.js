/**
 * 
 */

app
.directive('topDirective',['$timeout',function($timeout){
	return {
        restrict: 'E',       
        templateUrl : 'template/panel/top.tpl.html',        
    };
}])