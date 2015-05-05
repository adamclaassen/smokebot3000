// Index into array; where to store the character
char msgType;
char inChar;
String msg;
void setup() {
    pinMode(9, OUTPUT);
    pinMode(10, OUTPUT);
    Serial.begin(9600);
    //analogWrite(9,150);
}

void loop(){
    bool donePacket = false;
    while(Serial.available() >= 0 && donePacket != true){
      inChar = Serial.read();
      if(inChar == '<'){
        msg += inChar;
        while(Serial.available() >= 0 && !donePacket){
          inChar = Serial.read();
          msg += inChar;
          Serial.write(inChar);
          if(inChar == '>'){
            donePacket = true;
          }
        }
      }
    }  
  Serial.println(msg);
  processInput(msg);
  
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
    Serial.println("<a//>");
}

void readSensor(){
  //must Serial.write(sensor_data)
}

void acknowledge(){
   Serial.write("<a//>");
}
 
