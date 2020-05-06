
function validate(frm){
	//set vflag to "yes" indicating client side form validations are done
	frm.vflag.value="yes";
	//clear error messages
	document.getElementById("nameErr").innerHTML="";
	document.getElementById("ageErr").innerHTML="";
	//read form data
	var name=frm.pname.value;
	var age=frm.page.value;
	//perform client side form validations
	if(name=="")//required rule
	{
		//alert("Person name is mandatory");
		document.getElementById("nameErr").innerHTML="<font color='red'>Person name is mandatory</font>";
		frm.pname.focus();
		return false;
	}
	if(age=="")//required rule
	{
		//alert("Person age is mandatory");
		document.getElementById("ageErr").innerHTML="<font color='red'>Person age is mandatory</font>";
		frm.page.focus();
		return false;
	}
	else
	{
		if(isNaN(age))//check weather it is valid or not
		{
			//alert("Person age must be numeric value");
			document.getElementById("ageErr").innerHTML="<font color='red'>Person age must be numeric value</font>";
			frm.page.focus();
			return false;
		}
		else if(age<=0||age>=125)
		{
			//alert("Person age must be in 1 through 125");
			document.getElementById("ageErr").innerHTML="<font color='red'>Person age must be in 1 through 125</font>";
			frm.page.focus();
			return false;
		}
	}
	return true;		
}//function
