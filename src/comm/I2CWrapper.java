package comm;

import java.io.IOException;

import com.pi4j.io.i2c.*;


public class I2CWrapper {
	 public I2CBus bus;
	 //I2CDevice device;

<<<<<<< HEAD
	 public I2CWrapper(){
=======
public I2CWrapper(int address){
>>>>>>> f1657f0bd12841ce74ad91e16372ee300af993e1
		
        try {
			bus = I2CFactory.getInstance(I2CBus.BUS_1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			robot.SimpleRobot.eHandler.addError(e);
		}
        
     
        
	}
	
	public int read(I2CDevice myDevice) 
	{
		int temp = -1;
		try {
			 temp =  myDevice.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			robot.SimpleRobot.eHandler.addError(e);
		}
		return temp;
	}
	
	public void write(I2CDevice myDevice, String message){
		try {
			myDevice.write(message.getBytes(), message.getBytes().length , message.getBytes().length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			robot.SimpleRobot.eHandler.addError(e);
		}
		
	}

}
