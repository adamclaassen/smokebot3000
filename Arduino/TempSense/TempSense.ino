//Temperature Sensor

//5v to pin 3, ground pin 1 and hook up a digital line to pin 2. Make sure to put a 4.7k resistor between pin 3 and 2.*




#include <OneWire.h>

int eTape = 0;
//eTape_RawVoltageOut

// DS18S20 Temperature chip i/o
OneWire ds(10);  // on pin 10

void setup(void) {
  // initialize inputs/outputs
  // start serial port
  Serial.begin(9600);
}

void loop(void) {

  //liquid level


  Serial.print("Voltage");
  Serial.println(analogRead(A5));

  //Salinity


  eTape = analogRead(A4);  //Change Analog pin used here
  Serial.print("eTape Voltage Depth");
  Serial.println(eTape, DEC); 

 
}









/*
eTape_rcTime_Output

long rcTime(int pin){                         // ..returns decay time                                            
  pinMode(pin, OUTPUT);                      // Charge capacitor
  digitalWrite(pin, HIGH);                   // ..by setting pin ouput-high
  delay(10);                                  // ..for 10 ms
  pinMode(pin, INPUT);                       // Set pin to input
  digitalWrite(pin, LOW);                    // ..with no pullup
  long time  = micros();                     // Mark the time
  while(digitalRead(pin));                   // Wait for voltage < threshold
  time = micros() - time;                    // Calculate decay time
  return time;                               // Return decay time
}  

*/

/*

//Liquid Level


void loop(){

Serial.print("Water level Sensor Value:");
Serial.println(analogRead(A5));
delay(100);

}


//Salinity


*/

/*
  10/16/2014 www.parallax.com
  
  Measures eTape variable resistance output using a resistor-capacitor 
  circuit built on Board of Education Shield and Arduino Uno.
  The rcTime function measures the decay time in microseconds. Decay time will be inversely 
  proportional to the liquid level: lower output values mean higher liquid levels.  

  Read the eTape sensor datasheet for instructions on positioning and mounting
  the sensor in a container of fluid, and for the sensor's pin descriptions.

  Connect one eTape Rsense terminal to ground.
  Use a 100 or 220 ohm resistor to connect the other Rsense terminal to Digital Pin 3.
  Place a capacitor across the terminals. A 0.1 uF cap will give a lower resolution, 
  and a 1.0 mF cap will give a higher resolution. If using a polar 1.0 uF cap,
  watch the polarity: be sure to connect its (-) lead to the grounded eTape terminal,
  and its (+)lead to the terminal on Digital Pin 3.  
  
  Run the Serial Monitor to see the output.  
*/


/*

void loop()                                  // Main loop auto-repeats
{
  long eTape = rcTime(3);                    // Change digital pin used here
 
  Serial.print("eTape = ");                  // Display eTape label
  Serial.print(eTape);                       // Display eTape value
  Serial.println(" us");                     // Display eTape units + newline

  delay(1000);                               // 1 second delay
}
                                             // rcTime function at pin  



*/


/*

//Liquid level sensor 8” #2

// the value of the 'other' resistor
#define SERIESRESISTOR 560    
 
// What pin to connect the sensor to
#define SENSORPIN A0 
 
void setup(void) {
  Serial.begin(9600);
}
 
void loop(void) {
  float reading;
 
  reading = analogRead(SENSORPIN);
 
  Serial.print("Analog reading "); 
  Serial.println(reading);
 
  // convert the value to resistance
  reading = (1023 / reading)  - 1;
  reading = SERIESRESISTOR / reading;
  Serial.print("Sensor resistance "); 
  Serial.println(reading);
 
  delay(1000);
}
Servo
#include <Servo.h>

Servo myservo;  // create servo object to control a servo 
                // a maximum of eight servo objects can be created 
 
int pos = 0;    // variable to store the servo position 
 
void setup() 
{ 
  myservo.attach(9);  // attaches the servo on pin 9 to the servo object 
} 
 
 
void loop() 
{ 
  //while(do code) {
  for(pos = 150; pos>=1; pos-=1)     // goes from 180 degrees to 0 degrees 
  {                                
    myservo.write(pos);              // tell servo to go to position in variable 'pos' 
    delay(15);                       // waits 15ms for the servo to reach the position 
  } 
  delay(60000);                      // waits at the bottom
  for(pos = 0; pos < 150; pos += 1)  // goes from 0 degrees to 180 degrees 
  {                                  // in steps of 1 degree 
    myservo.write(pos);              // tell servo to go to position in variable 'pos' 
    delay(15);                       // waits 15ms for the servo to reach the position 
  } 
  //set do code = false
  
  
}
*/
