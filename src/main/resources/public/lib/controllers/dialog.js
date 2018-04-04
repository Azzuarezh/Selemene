/**
 * 
 */

app
.controller('dialogController',['$scope',function($scope){
	$scope.dialogs=[{
		id:'connect',
		iconTitle:'fa fa-plug',
		title:'Connect'
	},
	{
		id:'export',
		iconTitle:'fa fa-cloud-upload',
		title:'Export'
	}
	];		
	
}])