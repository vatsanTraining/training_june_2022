/**
 * 
 */

// Using Function Constructor -Note the 'this' in the function body can create object using "new"
function usingFunctionConstructor(){
	
	var Book = function(name){
		
		this.name = name;
		this.discount = function(){
			return 0.25;
		}
	}
	
	var myBook = new Book('html')

	document.write('<p>'+'Book Name:='+myBook.name+'</p>')
	document.write('discount:='+myBook.discount())

	
}
	
	// Using the Empty Object Literal and dynamically adding methods and properties

function usingObjectLiteral(){
	
	var book = {};

	book.bookName='kathy sieera'
	
	book.discount=function(){
		
		return 0.10;
	}
	
	document.write('<p>'+'Book Name:='+book.bookName+'</p>')
	document.write('discount:='+book.discount())
}

// Using the Empty Object Literal and adding methods and properties at the creation time

function usingObjectLiteralSecondWay(){
	
	var book = {
	
			bookName:'Javascript in action',
				
				discount:function(){
					
					return 0.20;
				}
	};

	
	

	document.write('<p>'+'Book Name:='+book.bookName+'</p>')
	document.write('discount:='+book.discount())
}

// Using the Blank JavaScript  Object  and dynamically adding methods and properties

function usingBlankObject(){
	
	var book = new Object();

	book.bookName='Mastering Java'
	
	book.discount=function(){
		
		return 0.15;
	}
	

	document.write('<p>'+'Book Name:='+book.bookName+'</p>')
	document.write('discount:='+book.discount())
}

(function(){
	usingObjectLiteral()
	usingBlankObject()
	usingObjectLiteralSecondWay()
	usingFunctionConstructor();
})();