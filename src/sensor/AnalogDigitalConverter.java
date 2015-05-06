package sensor;

import java.io.IOException;

import com.pi4j.io.spi.*;

public class AnalogDigitalConverter extends Sensor{
	
	SpiDevice adc;

	public AnalogDigitalConverter(float inputHigh, float inputLow) {
		super(inputHigh, inputLow);
		try {
			adc = SpiFactory.getInstance(SpiChannel.CS0, SpiMode.MODE_1);
		} catch (IOException e) {
			robot.SimpleRobot.eHandler.addError(e);
		}
	}

	public byte[] read(int channel) {
		/*
		 * Format for spi: 000011(0/1)1
		 *  four leading zeros to make the byte
		 *  1st 1 is start bit
		 *  2nd 1 selects single ended mode (don't change)
		 *  3rd bit selects channel (channel 0 is 0)
		 *  4th bit selects MSB/LSB (keep 1 for MSB)
		 */
		//byte[] settings = {0,1,1,(byte) channel, 1,0,0,0  ,0,0,0,0 ,0,0,0,0};
		byte[] settings = {(byte) ((16*channel)+32+64+8), 0};
		byte[] data = robot.SimpleRobot.spi.write(adc, settings);
		return data;
	}

	@Override
	Object read() {
		// TODO Auto-generated method stub
		return null;
	}

}
