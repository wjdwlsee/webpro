package strategy1.step5.modularzation;

import strategy1.step4.interfaces.FlyNO;
import strategy1.step4.interfaces.KnifeWood;
import strategy1.step4.interfaces.MissileYes;

	public class StandardRobot extends Robot{
	
		public StandardRobot() {
			setFly(new FlyNO()); 
			setKnife(new KnifeWood());
			setMissile(new MissileYes());
		}
	
	}
