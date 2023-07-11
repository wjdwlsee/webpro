package strategy1.step5.modularzation;

import strategy1.step4.interfaces.FlyNO;
import strategy1.step4.interfaces.KnifeNo;
import strategy1.step4.interfaces.MIssileNO;

public class LowRobot extends Robot{

	public LowRobot() {
		setFly(new FlyNO());
		setMissile(new MIssileNO());
		setKnife(new KnifeNo());
	}
	
	
	
}
