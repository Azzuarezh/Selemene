/**
 * 
 */

$(document).ready(function(){
	//w2ui panel function
	 var pstyle = 'background-color: #fffff; border: 2px solid #dfd0d0; padding: 5px;';
	 var pstyle2 = 'background-color: #fffff; border: 2px solid #dfd0d0; padding: 1px;';

	 var topPanelObject = { type: 'top',
	                        size: 131, 
	                        resizable: true, 
	                        style: pstyle2, 
	                        content: function(){
	                            $(this).load('panel/top.html');
	                        }
	                    };
	 var leftPanelObject ={ type: 'left', 
	                        size: 200, 
	                        resizable: true, 
	                        style: pstyle + 'overflow-x:hidden;', 
	                        content: function(){
	                            return $(this).load('panel/left.html');
	                            } 
	                        };

	var mainPanelObject = { type: 'main', 
	                        style: pstyle, 
	                        content: function(){
	                             return $(this).load('panel/main.html');
	                            }
	                        };

	var bottomPanelObject = { type: 'bottom', 
	                          size: 50, 
	                          resizable: true, 
	                          style: pstyle, 
	                          content: function(){
	                             return $(this).load('panel/bottom.html');
	                            }
	                        };
   
   $('#layout').w2layout({
       name: 'layout',
       panels: [topPanelObject,leftPanelObject,mainPanelObject,bottomPanelObject]
   });
	
})