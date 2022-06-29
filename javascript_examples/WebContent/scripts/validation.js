/**
 * 
 */

function validate() {
	
	var result =true;
	console.log('validate Called');
	var textFlds = document.getElementsByTagName('input');
	for(var i=0;i<textFlds.length-1;i++){
	
		console.log(textFlds[i].value);
		
		if(textFlds[i].value ==''){
			document.getElementById("msg").innerHTML ="Required should not be blank"
   result =false
		}
	}
		return result;
}

function init(){
	
	var frmElement = document.getElementById("regForm");
	
	frmElement.addEventListener('submit',validate);
}

(function() {
	
	init();
})();