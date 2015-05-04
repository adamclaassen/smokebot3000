package tests;
import comm.ArduinoAdapter;

public class ArduinoAdapterTest {

	public static ArduinoAdapter aa;
	
	public static void main(String[] args) {
		aa = new ArduinoAdapter();
		aa.readData();
		aa.setMotorSpeed(9, 165);
		aa.setMotorSpeed(10, 165);
	}

}
