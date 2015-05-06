// Index into array; where to store the character
char msgType;


void setup() {
    pinMode(9, OUTPUT);
    pinMode(10, OUTPUT);
    Serial.begin(9600);
    analogWrite(9,150);
}

void loop(){
    for(int i = 0; i < 255; i+= 10){
      analogWrite(9, i);
      delay(100);
    }
    //while(Serial.available() >= 0){
      //Serial.write(Serial.read());
    //}
}

String parseData() {
    String inData = ""; // Allocate some space for the string
    char inChar = (char)Serial.read();
    if(inChar == '<'){
      while (inChar != '>'){
        inData += inChar;// Store it
        inChar = (char)Serial.read();
      }
      inData += inChar;
      processInput(inData);
    }

}
void processInput(String msg){
    //Serial.write(msg);
    if(msg[1] == 'r'){
      acknowledge();
      readSensor();
    }
    if(msg[1] == 'm'){
      acknowledge();
      motorControl(msg);
    }
}

void motorControl(String msg){
    boolean isOn1 = false;
    boolean isOn2 = false;
    String pin="";
    String spd="";

    for(int i = 0; i<msg.length();i++){
        if(msg[i] == '/' && !isOn1){
            isOn1 = true;
            isOn2 = false;
        }

        else if(msg[i] == '/' && isOn1){
            isOn1 = false;
            isOn2 = true;
        }

        else if(isOn1){
            pin += msg[i];
        }

        else if(isOn2 && msg[i] != '>'){
            spd += msg[i];
        }
    }
    analogWrite(pin.toInt(),spd.toInt());
}

void readSensor(){
  //must Serial.write(sensor_data)
}

void acknowledge(){
   Serial.write("<a//>");
}
 
