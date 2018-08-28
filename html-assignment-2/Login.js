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

function validatePassword() {
	var str = document.getElementById("My_password");
	if(str.value.length == 0){
	str.style.borderColor = "red";
	return false;
	} else {
	str.style.borderColor = "green";
	return true;
	}
	}
function sendto(){
	if(validateEmail() && validatePassword()){
	document.getElementById("Login_Details").submit();}
	else{
		alert("Invalid entry");
	}
}