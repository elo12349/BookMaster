
function myFunction() {

			var id = document.getElementById("bookId").value;	
			var MSG0001 ='Please input your ID';
			var MSG0002 ='Your ID not allow to used speacial character';
			if(id == 0){
				
				alert(MSG0001);
				return false;
			}
				if (/[^a-zA-Z0-9\-\/]/.test(id)) {
					alert(MSG0002);
					return false;
			}

			return true;
		}
		function myFunction2(){
			var id = document.getElementById("bookId").value;	var MSG0001='?ID????'; var MSG0002='?ID????????';
			var title = document.getElementById("bookTitle").value; var MSG0007='?????????????';
			var authorname = document.getElementById("authorName").value; var MSG0006='???????????????';
			var publisher = document.getElementById("publisher").value; var MSG0008='?????????????';
			var publicationyear = document.getElementById("publishcationYear").value; 
			var publicationmonth = document.getElementById("publishcationMonth").value;
			var publicationdate = document.getElementById("publishcationDate").value; 
			var MSG0009_Y='?????(?)????';
			var MSG0009_M='?????(?)????';
			var MSG0009_D='?????(?)????';
			var MSG00010_Y='?????(?)???????';
			var MSG00010_M='?????(?)???????';
			var MSG00010_D='?????(?)???????';
			if(id == 0){
				
				alert(MSG0001);
				if(title == 0){
					alert(MSG0006);
						
				}
				if(authorname == 0){
					alert(MSG0007);
				
				}
				if(publisher == 0){
					alert(MSG0008);
					
				}
				if(publicationyear == 0){
					alert(MSG0009_Y);
					
				}
				if(publicationmonth == 0){
					alert(MSG0009_M);
					
				}
				
				if(publicationdate == 0){
					alert(MSG0009_D);
					
				}
				
				
			}else{
				if (/[^a-zA-Z0-9\-\/]/.test(id)) {
					alert(MSG0002);  	 
					     		
				}
				if(title == 0){
					alert(MSG0006);	
					
				}
				if(authorname == 0){
					alert(MSG0007);
					
				}
				if(publisher == 0){
					alert(MSG0008);
					
				}
				if(publicationyear == 0){
					alert(MSG0009_Y);
					
				}
				if(publicationmonth == 0){
					alert(MSG0009_M);
					
				}
				if(publicationdate == 0){
					alert(MSG0009_D);
					
				}
				
			}if (/[^a-zA-Z0-9\-\/]/.test(publicationyear)) {
				alert(MSG0010_Y);  
					      		
			}if (/[^a-zA-Z0-9\-\/]/.test(publicationmonth)) {
				alert(MSG0010_M); 
				 	      		
			}if (/[^a-zA-Z0-9\-\/]/.test(publicationdate)) {
				alert(MSG0010_D); 
				 	      		
			}

			return true;
		}
		function myFunction3(){
			var id = document.getElementById("bookId").value;	var MSG0001='?ID????'; var MSG0002='?ID????????';
			var title = document.getElementById("bookTitle").value; var MSG0007='?????????????';
			var authorname = document.getElementById("authorName").value; var MSG0006='???????????????';
			var publisher = document.getElementById("publisher").value; var MSG0008='?????????????';
			var publicationyear = document.getElementById("publishcationYear").value; 
			var publicationmonth = document.getElementById("publishcationMonth").value;
			var publicationdate = document.getElementById("publishcationDate").value; 
			var MSG0009_Y='?????(?)????';
			var MSG0009_M='?????(?)????';
			var MSG0009_D='?????(?)????';
			var MSG00010_Y='?????(?)???????';
			var MSG00010_M='?????(?)???????';
			var MSG00010_D='?????(?)???????';
			if(id == 0){
				
				alert(MSG0001);
				if(title == 0){
					alert(MSG0006);
						
				}
				if(authorname == 0){
					alert(MSG0007);
				
				}
				if(publisher == 0){
					alert(MSG0008);
					
				}
				if(publicationyear == 0){
					alert(MSG0009_Y);
					
				}
				if(publicationmonth == 0){
					alert(MSG0009_M);
					
				}
				
				if(publicationdate == 0){
					alert(MSG0009_D);
					
				}
				
				
			}else{
				if (/[^a-zA-Z0-9\-\/]/.test(id)) {
					alert(MSG0002);  	 
					     		
				}
				if(title == 0){
					alert(MSG0006);	
					
				}
				if(authorname == 0){
					alert(MSG0007);
					
				}
				if(publisher == 0){
					alert(MSG0008);
					
				}
				if(publicationyear == 0){
					alert(MSG0009_Y);
					
				}
				if(publicationmonth == 0){
					alert(MSG0009_M);
					
				}
				if(publicationdate == 0){
					alert(MSG0009_D);
					
				}
				
			}if (/[^a-zA-Z0-9\-\/]/.test(publicationyear)) {
				alert(MSG0010_Y);  
					      		
			}if (/[^a-zA-Z0-9\-\/]/.test(publicationmonth)) {
				alert(MSG0010_M); 
				 	      		
			}if (/[^a-zA-Z0-9\-\/]/.test(publicationdate)) {
				alert(MSG0010_D); 
				 	      		
			}

			return true;
		}
		function myFunction4(){	
			var id = document.getElementById("bookId").value;	
			var MSG0001 ='Please input your ID';
			var MSG0002 ='Your ID not allow to used speacial character';
			if(id == 0){
				
				alert(MSG0001);
				return false;
			}
				if (/[^a-zA-Z0-9\-\/]/.test(id)) {
					alert(MSG0002);
					return false;
			}

			return true;
		}	
	