/**
 * 
 */

function setCookie(){
	
	var name ='bg_color'
	var value ='green';
	document.cookie =name+'='+value
}

function readCookie(){
		
   var mycookie = document.cookie;
	alert(mycookie);
		var cookieList =mycookie.split(";");
			var sizeCookie =cookieList[0]
			
			console.log(cookieList[1]);
				var values = sizeCookie.split("=")
			
			//	document.write('i will show you models & brands for size:='+values)
		
                var colorValue =values[1]

				document.body.setAttribute("style","background-color:"+colorValue);
				
	}
 


(function() {
	
	setCookie();
})();
