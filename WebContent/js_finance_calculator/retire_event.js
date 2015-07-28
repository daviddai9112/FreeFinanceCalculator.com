/*
this is used for write all the events of retirement calculator
*/


//get elementvalue to the variable
function getElementValue(){
	cur_income_value = document.getElementById("cur_income").value ; //get income slider
	save_rates_value = document.getElementById("save_rates").value;  // get save rates slider
}


//set the element value to the variable here
function setELementValue(){
	document.getElementById("cur_income").value = cur_income_value; //set income slider
	document.getElementById("income").innerHTML = cur_income_value; // set income span
	document.getElementById("save_rates").value = save_rates_value; //set income slider
	document.getElementById("rates").innerHTML = save_rates_value * 100; //set income slider
}


function addEvent() {
	//if page just load, then cur should be 0
	if(cur == 0){
		editor.innerHTML = document.getElementById('ed0').innerHTML;
		//setELementValue(); // syn the value
	}
	nextBtn.onclick = nextClickEvent;//set click event
	preBtn.onclick = preClickEvent; // pre btn click event 
};

//when next button is clicked the following happens
function nextClickEvent(){
	cur = cur+1;
	editor.innerHTML = document.getElementById(contents[cur%contents.length]).innerHTML;
	//setELementValue(); // syn the value
}
//when pre button is clicked
function preClickEvent(){
	if(cur > 0){
		cur = cur -1;
		editor.innerHTML = document.getElementById(contents[cur%contents.length]).innerHTML;
		setELementValue(); // syn the value
	}
} 
