package sensor;

import com.pi4j.wiringpi.Spi;

public class AnalogDigitalConverter extends Sensor{

	private int spiChannel;
	
	public AnalogDigitalConverter(float inputHigh, float inputLow, int spiChannel) {
		super(inputHigh, inputLow);
		this.spiChannel = spiChannel;
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
		byte[] settings = {(byte) Integer.parseInt(String.format("000011{0}1", channel), 2)};
		int data = Spi.wiringPiSPIDataRW(Spi.CHANNEL_0, settings);
		return (double) data;
	}

	@Override
	Object read() {
		// TODO Auto-generated method stub
		return null;
	}

}
