// Index into array; where to store the character
char msgType;


void setup() {
    pinMode(9, OUTPUT);
    pinMode(10, OUTPUT);
    Serial.begin(9600);
    Serial.write("Power On");
}

void loop(){
    while(Serial.available() > 0){
        parseData();
    }
}

String parseData() {
    String inData = ""; // Allocate some space for the string
    char inChar=-1; // Where to store the character read
    
    while ((char)Serial.read() != '>'){
        inChar = Serial.read(); // Read a character
        inData += (char)inChar;// Store it
    }
    processInput(inData);
   
}
void processInput(String msg){
    if(msg[1] == 'r'){

    }
    if(msg[1] == 'm'){
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