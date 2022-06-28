/**
 * 
 */

	var xhr = new XMLHttpRequest();

function callServlet(){
	
		var usrNameFld = document.getElementById("userName");
		
	  
		usrNameFld.addEventListener("blur",function(){
			
			var userName = usrNameFld.value;
			
			var url = "validate?userName="+userName;

			xhr.onreadystatechange = processRequest
			
			xhr.open('GET',url,true);
			
			xhr.send(null);

		});

	
		
}

function processRequest(){
	
	if(xhr.status ==200 && xhr.readyState==4){
		
		var msgFld = document.getElementById("msg");
		
		var color ='red';
		
		var text = xhr.responseText;
		
		if(text.trim()=='valid'){
             color ='green';
		}
		msgFld.style.color=color;
	     msgFld.innerHTML = text;

	}
	
}