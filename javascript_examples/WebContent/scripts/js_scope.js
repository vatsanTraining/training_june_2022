/**
 * 
 */

var name='Global Hospital'; // Even if this has var since it is defined outside a function its global
phone=45020341;

function show(){
	
	console.log('Name :'+name);
	console.log('Phone Number:='+phone);
	
	 //var localBranch = 'velacherry';   This will be local variable cannot be accessed from other functions
	
	
     _localBranch = 'velacherry'; // this is not a local variable since its defined without var 
                                 //, event if it is inside a function 
	
     
	console.log("Branch :="+ _localBranch);
}

function invoke(){
	
	show();

	console.log('Name :'+name);
	console.log('Phone Number:='+phone);
	
	console.log("Branch :="+ _localBranch);

}

invoke();