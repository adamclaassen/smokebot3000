package robot;

public class RunRobot{
	static Robot robot;

	public static void main(String[] args) {
		//insert starting code here
		robot = new TeamFourRobot();
		robot.currentPos.setNearbyRadius(10);
		robot.commandList.forEach((command) -> command.run());
	}
}
