/**
 * 
 */
app
.directive('dialogDirective',['$timeout',function($timeout){
	return {
        restrict: 'E',       
        templateUrl : 'template/dialog/dialog.tpl.html',        
    };
}])