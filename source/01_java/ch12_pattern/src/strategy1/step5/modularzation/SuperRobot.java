package strategy1.step5.modularzation;

import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.KnifeLazer;
import strategy1.step4.interfaces.MissileYes;

	public class SuperRobot extends Robot{
		
		public SuperRobot() {
		setFly(new FlyYes());
		setMissile(new MissileYes());	
		setKnife(new KnifeLazer());	//knife = new KnifeLazer();
			
		}
		
	}
	
