function run1(){
	document.frame.display.value += "1"
};
function run2(){
	document.frame.display.value += "2"
};
function run3(){
	document.frame.display.value += "3"
};
function run4(){
	document.frame.display.value += "4"
};
function run5(){
	document.frame.display.value += "5"
};
function run6(){
	document.frame.display.value += "6"
};
function run7(){
	document.frame.display.value += "7"
};
function run8(){
	document.frame.display.value += "8"
};
function run9(){
	document.frame.display.value += "9"
};
function run0(){
	document.frame.display.value += "0"
};
function runOptellen(){

	document.frame.display.value += "+"
};
function runAftrekken(){

	document.frame.display.value += "-"
};
function runDelen(){

	document.frame.display.value += "/"
};
function runVermenigvuldigen(){

	document.frame.display.value += "*"
};

function runC(){

	document.frame.display.value = ""
};


function runIs() {
	var uitkomst = eval(document.frame.display.value)
	document.frame.display.value = uitkomst;
}
