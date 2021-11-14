function validateField(){
var name=$('#brandName').val();
var modelNo=$('#modelNo').val();
var modelName=$('#modelName').val();
var type=$('#type').val();
var ram=$('#ram').val();
var rom=$('#rom').val();
var price=$('#price').val();
var availability=$('#availability').val();

if(name == "" ){
       $('#errName').html("Invalid brand name").css("color", "red");
   }
   else if(modelNo == ""){
       $('#errModelNo').html("Invalid model number.").css("color", "red");
   }
   else if(modelName == ""){
        $('#errModelName').html("Invalid model name.").css("color", "red");
   }
   else  if(type != ""){
       $('#errModelType').html("Invalid brand type").css("color", "red");
   }
   else if(ram != ""){
       $('#errRam').html("Invalid RAM.").css("color", "red");
   }
   else if(rom != "" && rom.match(number)){
       $('#errRom').html("Invalid ROM.").css("color", "red");
   }
   else if(price != "" && price.match(number)){
       $('#errPrice').html("Invalid Price.").css("color", "red");
   }
if(availability != ""){
       $('#errAvailable').html('&#10004;').css("color", "green");
   }else{
       $('#errAvailable').html("Select your availability.").css("color", "red");
   }
}

function validateName(){
   var name=$('#brandName').val();
   if(name != ""){
       $('#errName').html("Valid brand name").css("color", "green");
   }else{
       $('#errName').html("Invalid brand name").css("color", "red");
   }
}

function validateModelNumber(){
   var modelNo=$('#modelNo').val();
   if(modelNo != ""){
       $('#errModelNo').html("Valid model number").css("color", "green");
   }else{
       $('#errModelNo').html("Invalid model number.").css("color", "red");
   }
}

function validateModelName(){
   var modelName=$('#modelName').val();
   if(modelName != "" ){
       $('#errModelName').html("Valid model name").css("color", "green");
   }else{
       $('#errModelName').html("Invalid model name.").css("color", "red");
   }
}

function validateMobileType(){
   var type=$('#type').val();
   if(type !=""){
       $('#errModelType').html("Valid mobile type").css("color", "green");
   }else{
       $('#errModelType').html("Invalid mobile type").css("color", "red");
   }
}

function validateRAM(){
   var ram=$('#ram').val();
   if(ram != "" ){
       $('#errRam').html("Valid RAM").css("color", "green");
   }else{
       $('#errRam').html("Invalid RAM.").css("color", "red");
   }
}

function validateROM(){
   var rom=$('#rom').val();
   var number = /^[0-9]+$/;
   if(rom != "" ){
       $('#errRom').html("Valid ROM").css("color", "green");
   }else{
       $('#errRom').html("Invalid ROM.").css("color", "red");
   }
}

function validatePrice(){
   var price=$('#price').val();
   if(price != ""){
       $('#errPrice').html("Valid Price").css("color", "green");
   }else{
       $('#errPrice').html("Invalid Price.").css("color", "red");
   }
}