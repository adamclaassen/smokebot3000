package robot;
import com.pi4j.io.spi.*;

public class AnalogDigitalConverter extends Sensor{

	public AnalogDigitalConverter(float inputHigh, float inputLow) {
		super(inputHigh, inputLow);
		
		
	}

	@Override
	public Object read() {
		
		return 0;
	}

}
