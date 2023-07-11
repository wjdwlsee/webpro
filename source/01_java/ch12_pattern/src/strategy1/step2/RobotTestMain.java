package strategy1.step2;

public class RobotTestMain {
	public static void main(String[] args) {
		SuperRobot superRobot = new SuperRobot();
		StandardRobot standardRobot = new StandardRobot();
		LowRobot lowRobot = new LowRobot();
		Robot[] robots = { superRobot, standardRobot, lowRobot };
		for (Robot robot : robots) {
			robot.shape();
			robot.actionWalk();
			robot.actionWalk();
			if (robot instanceof SuperRobot) {
				SuperRobot tempRobot = (SuperRobot) robot;
				tempRobot.actionFly();
				tempRobot.actionKnife();
				tempRobot.actionMissile();
			} else if(robot instanceof StandardRobot) {
				StandardRobot tempRobot = (StandardRobot) robot;
				tempRobot.actionFly();
				tempRobot.actionKnife();
				tempRobot.actionMissile();
			} else if (robot instanceof LowRobot) {
				LowRobot tempRobot = (LowRobot) robot;
				tempRobot.actionFly();
				tempRobot.actionKnife();
				tempRobot.actionMissile();

			}

		}
	}

}
