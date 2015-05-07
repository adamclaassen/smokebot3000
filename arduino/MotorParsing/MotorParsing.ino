// Index into array; where to store the character
#include <Servo.h>
Servo sensor;
char msgType;
char inChar;
int base = 77;
String msg;
void setup() {
    pinMode(9, OUTPUT);
    pinMode(10, OUTPUT);
    Serial.begin(9600);
    sensor.attach(11);
    //analogWrite(9,150);
    
  sensor.write(base);
}

void loop(){
  /*if(Serial.available()>0){
    Serial.println("hi");
  }*/
  if(Serial.available()>=5){
    //Serial.println("found more than or eual to 5 serial bytes");
    msg = Serial.readString();
  }
  while(msg.length()>=5){
    //Serial.println(msg);
    processInput(msg.substring(msg.indexOf("<"), msg.indexOf(">")));
    msg = msg.substring(msg.indexOf(">"))+1;
  }
}


void processInput(String msg){
    //Serial.write(msg);
    if(msg[1] == 'r'){
      dip();
      acknowledge();
    }
    if(msg[1] == 'm'){
      motorControl(msg);
      acknowledge();
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
    //Serial.println("<a//>");
}
void dip(){
  sensor.write(base+15);
  delay(2000);
  for(int i = base; i>base-30; i--){
    sensor.write(i);
    delay(100);
  }
  sensor.write(base-60);
  delay(2000);
}  
void acknowledge(){
   Serial.write("<a//>");
}
 
