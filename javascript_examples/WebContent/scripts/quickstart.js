/**
 * 
 */

function display(){
	
	alert("welcome to java script");
}


var app ={}


  app.display =function() {
	
	
	alert("I am from annoymous function");
}

app.readFile = function(){
	
	var messageOne = document.getElementById("msg");
	
	alert(messageOne.innerHTML);
	
	var messageTwo = document.getElementsByTagName("div")[0];
	
	alert(messageTwo.innerHTML);  
}


app.attachEvent = function(){
	
		var cityBtn = document.getElementById("city");
	
	cityBtn.addEventListener("click",function(){
		
		var messageOne = document.getElementById("msg");

		 messageOne.innerHTML ="Best City is Chennai";  
		
	});
	

	var linkToWelcome = document.getElementById("link");
	
	linkToWelcome.addEventListener("click",function(event){
		
		event.preventDefault();
                 		
	});

	
}