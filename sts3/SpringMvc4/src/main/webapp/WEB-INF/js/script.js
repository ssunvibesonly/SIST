/**
 * 
 */
 $(function(){
 	$("#myimg").attr("src","../image/빵빵이.jpg");
 
 	$("#myimg").hover(function(){
 	$(this).attr("src","../image/16.png");
 	},function(){
 	$(this).attr("src","../image/빵빵이.jpg");
 	
 	})
 	

 	
 });	