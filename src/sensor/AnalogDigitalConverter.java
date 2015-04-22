package sensor;

import com.pi4j.wiringpi.Spi;

public class AnalogDigitalConverter extends Sensor{

	private int spiChannel;
	
	public AnalogDigitalConverter(float inputHigh, float inputLow, int spiChannel) {
		super(inputHigh, inputLow);
		this.spiChannel = spiChannel;
	}

	@Override
	public Double read() {
		return 0.0;
	}

}
