/**
 * 
 */
	 var baseSize = 15;

 function incFontSize(){
	 var size = baseSize+'px';
	 baseSize= baseSize+5;
	 console.log(baseSize);
	 var para = document.getElementById("firstPara");

	 //para.setAttribute("class","fontSizeUp");
	 para.setAttribute("style","font-size:"+size);
	 
 }
 
 
 function addClickEvent(){
	 
	 var imgRef = document.getElementById("increment");
	 
	  imgRef.addEventListener('click',incFontSize);

 }
 
 
(function(){
	
	addClickEvent();
})();
