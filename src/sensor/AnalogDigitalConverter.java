package sensor;

import comm.SPIWrapper;

public class AnalogDigitalConverter extends Sensor{

	public AnalogDigitalConverter(float inputHigh, float inputLow) {
		super(inputHigh, inputLow);
	}

	@Override
	public Double read() {
		//this.spi.askfordata();
		return 0.0;
	}

}