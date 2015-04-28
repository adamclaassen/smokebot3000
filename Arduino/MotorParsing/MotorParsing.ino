int motor1 = 9;
int motor2 = 10;

void setup(){
	Serial.begin(9600);
	pinMode(motor1, OUTPUT);
	pinMode(motor2, OUTPUT);
}

void loop(){
	int counter = Serial.available();
	String info;
	for(int i = 0; i<= counter; i++){
		char input = Serial.read();
		info = info + input;
	}
	//m - motor, r - readSensor
	if(info[0] == 'm'){
		String 
		for(int j = 0; j<=counter; j++){
			if(j < counter && j > 1){

			}
		}
	}
	else if(info[0] == 'r'){
		//do Sensor stuff
	}
	else(){

	}

}