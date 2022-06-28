/**
 * Example on Different ways of writing JavaScript functions
 * 
 */


// Simple Named function




function simple(){
	
	console.log('Hello world');
	
	
}

function display(){
	
	return "I Love JavaScript !";
}

//Simple Named function with argument and handling the case where argument is not passed

function withArgs(name){
	
	if(name==null){  // checking the presence of argument
		document.write('welcome Guest')
	} else {
	document.write('welcome:='+name)
	}
}

// Named function expression


var usdToInr = function(usd){
	
	return usd*0.80;
	
};

var InrToUsd = function(inr){
	
	var usd = inr/0.80;
};

//Function taking another Function as argument

function converter(funcRef,name){
	
	console.log(name);
	
	console.log(funcRef());
	
};

// pass display function to converter and test

(function(){
//   simple();
//   withArgs('ramesh');
//   withArgs();
//     console.log('function will get displayed' +usdToInr);
//     console.log('return value of function will get displayed'+usdToInr(100));
//     console.log('return value will undefined since the method is not having return statement'+InrToUsd(80));
     
  converter(function(){
	  return 'Good Morning'
  }, 'Greeting Function');	
})();