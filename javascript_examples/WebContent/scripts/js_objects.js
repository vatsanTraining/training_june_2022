/**
 * 
 */


function usingWindowObj(){
	
	
	window.location = "http://www.google.com";
	
}


function windowObjOpen(){
	
	
	window.open('index.html','indexPage');
	
}

function invoke(){
	
	var goToGoogleButton = document.getElementById("googleBtn");
	
	goToGoogleButton.addEventListener('click',usingWindowObj);
	

   var openWindowButton = document.getElementById("openBtn");
	
   openWindowButton.addEventListener('click',windowObjOpen);

   var printButton = document.getElementById("printBtn");
	
   printButton.addEventListener('click',function(){
	   window.print();
   });
		
}


function usingArrays(){
	
	// Arrays using shortcut
	
	var linkTexts = ["home","client","career","aboutus","downloads"];
	
	writeToFile(linkTexts);

	
	// Arrays using constructor
	
	var cities =new Array("chennai","mumbai","delhi");
	
	// Arrays using zero arg constructor

	writeToFile(cities);

	var countries = new Array();
	
	countries[0]='nepal';
	countries[1]='srilanka';
	countries[2]='azerbaijan';
	
	writeToFile(countries);

	
}

function usingDate(){
	
	var birthDate = new Date();
	
	var option = confirm("is this your date of birth"+birthDate);
	
	 if(!option){
		 
		 birthDate.setFullYear(1999,5,12);
		 
		 document.write("I found your  Birthdate:=")      
		 document.write("Year :"+ birthDate.getFullYear());
		 document.write("Month :"+ birthDate.getMonth());
		 document.write("Day :"+ birthDate.getDay());
	} else {

		 document.write("Year :"+ birthDate.getFullYear());
		 document.write("Month :"+ birthDate.getMonth());
		 document.write("Day :"+ birthDate.getDay());

	}
	 }
	       

function writeToFile(items){
	
	document.write("<ul>");
	
	for(idxPos in items){
		document.write("<li>"+items[idxPos]+"</li>")
	}
	document.write("</ul>");
	
}

(function(){

	invoke();
   usingArrays();
   usingDate();
})();

