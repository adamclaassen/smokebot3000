package robot;
import com.pi4j.io.spi.*;

public class AnalogDigitalConverter extends Sensor{

	public AnalogDigitalConverter(float inputHigh, float inputLow) {
		super(inputHigh, inputLow);
		// TODO Auto-generated constructor stub
		
		
	}

	@Override
	public Object read() {
		
		return 0;
	}

}
