package strategy1.step4.modularzation;

import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.FlyYes;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.KnifeLazer;
import strategy1.step4.interfaces.MissileImpl;
import strategy1.step4.interfaces.MissileYes;

	public class SuperRobot extends Robot{
		private FlyImpl fly ;
		private MissileImpl missile;
		private KnifeImpl knife;
		public SuperRobot() {
		setFly(new FlyYes());
		setMissile(new MissileYes());	
		setKnife(new KnifeLazer());	//knife = new KnifeLazer();
			
		}
		@Override
		public void actionFly() {
			fly.fly();
		}
		@Override
		public void actionMissile () {
			missile.missile();	
		}
		@Override
		public void actionKnife() {
			knife.knife();
		
		}
		public void setFly(FlyImpl fly) {
			this.fly = fly;
		}
	
		public void setMissile(MissileImpl missile) {
			this.missile = missile;
		}
	
		public void setKnife(KnifeImpl knife) {
			this.knife = knife;
		}
	}
	
