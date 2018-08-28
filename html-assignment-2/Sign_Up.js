function send() {
			if(validateFirstName() && validateLastName() && validateEmail() && validatePassword() && validateContactNumber() && validateConfirmPassword() ){
			alert("GOOD JOB..!!");
		    document.getElementById("signing_up").submit();
			}
			else{
			alert("Please enter valid details..!!");
			}
			}
			
		
			function validateFirstName(){
			var first_nm = document.getElementById("First_Name");
			var pattern = new RegExp("(^[a-zA-Z]+$)")
			if(first_nm.value.length < 2 || !pattern.test(first_nm.value)){
			alert("Your first Name should be of minimum length 2");
			first_nm.style.borderColor = "red";
			return false;
			}
			else {
			first_nm.style.borderColor = "green";
			return true;}
			}
			
			function validateLastName() { 
			var last_nm = document.getElementById("Last_Name");
			var pattern = new RegExp("(^[a-zA-Z]+$)")
			if(last_nm.value.length < 2 || !pattern.test(last_nm.value)){
			alert("Your last Name should be of minimum length 2");
			last_nm.style.borderColor = "red";
			return false;
			}else {
			last_nm.style.borderColor = "green";
			return true;}
			}
			
			function validateEmail(){
			var pattern = new RegExp("^[A-Za-z]+[.A-Za-z0-9]+@+[A-Za-z0-9]+(.[a-zA-Z]{2,4})+$");
			var str = document.getElementById("Email");
			if(!pattern.test(str.value) || str.value.length == 0) {
			str.style.borderColor = "red";
			return false;
			} else {
			str.style.borderColor = "green";
			return true;
			}
			}
			
			function validatePassword(){
			var pattern = new RegExp("^(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])(?=.*[a-z]).{8,}$");
			var str = document.getElementById("my_password");
			if(!pattern.test(str.value)){
			str.style.borderColor = "red";
			return false;
			}
			else{
			str.style.borderColor = "green";
			return true;
			}
			}
			
			function validateContactNumber(){
			var pattern = new RegExp("(^[0-9]+$)");
			var str = document.getElementById("Contact_number");
			if(!pattern.test(str.value) || str.value.length != 10){
			str.style.borderColor = "red";
			return false;
			}
			else{
			str.style.borderColor = "green";
			return true;
			}
			}
			
			function validateConfirmPassword() {
			var pswd = document.getElementById("my_password");
			var cnfrmpswd = document.getElementById("Confirm_password");
			if(!pswd.value == cnfrmpswd.value){
			cnfrmpswd.style.borderColor = "red";
			return false;
			}
			else{
			cnfrmpswd.style.borderColor = "green";
			return true;
			}
			}