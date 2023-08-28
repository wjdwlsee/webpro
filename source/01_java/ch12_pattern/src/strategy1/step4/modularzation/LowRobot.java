package strategy1.step4.modularzation;

import strategy1.step4.interfaces.*;

public class LowRobot extends Robot{
	private FlyImpl fly ;
	private MissileImpl missile;
	private KnifeImpl knife;
	public LowRobot() {
		setFly(new FlyNO());
		setMissile(new MIssileNO());
		setKnife(new KnifeNo());
	}
	
	@Override
	public void actionFly() {
		fly.fly();
	}
	@Override
	public void actionMissile() {
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
