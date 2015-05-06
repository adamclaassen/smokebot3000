package sensor;

import java.io.IOException;

import com.pi4j.io.spi.*;

public class AnalogDigitalConverter extends Sensor{
	
	SpiDevice adc;

	public AnalogDigitalConverter(float inputHigh, float inputLow) {
		super(inputHigh, inputLow);
		try {
			adc = SpiFactory.getInstance(SpiChannel.CS0);
		} catch (IOException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
	}

	public Double read(int channel) {
		/*
		 * Format for spi: 000011(0/1)1
		 *  four leading zeros to make the byte
		 *  1st 1 is start bit
		 *  2nd 1 selects single ended mode (don't change)
		 *  3rd bit selects channel (channel 0 is 0)
		 *  4th bit selects MSB/LSB (keep 1 for MSB)
		 */
		byte[] settings = {(byte) Integer.parseInt(String.format("000011%d1", channel), 2)};
		byte[] data = robot.SimpleRobot.spi.write(adc, settings);
		double voltage = 0;
		String binary = "";
		for(byte b:data){
			binary.concat(Integer.toString((int) b));
		}
		voltage = Integer.parseInt(binary, 2);
		voltage *= (5/1024);
		return voltage;
	}

	@Override
	Object read() {
		// TODO Auto-generated method stub
		return null;
	}

}
