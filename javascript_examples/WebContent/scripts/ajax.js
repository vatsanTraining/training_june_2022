/**
 * 
 */

function callServlet(){
	
	var xhr = new XMLHttpRequest();
	
	
		var usrNameFld = document.getElementById("userName");
		
	
		usrNameFld.addEventListener("blur",function(){
			

			var userName = usrNameFld.value;
			
			var url = "validate?userName="+userName;

			xhr.onreadystatechange = processRequest
			
			xhr.open(GET,url,true);
			
			xhr.send(null);

		});

	
		
}

function processRequest(){
	
	if(xhr.status ==200 && xhr.readyState==4){
		
		var msgFld = document.getElementById("msg");

		msgFld.innerHTML = xhr.responseText;
	}
	
}