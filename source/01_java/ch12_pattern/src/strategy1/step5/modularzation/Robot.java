package strategy1.step5.modularzation;

import strategy1.step4.interfaces.FlyImpl;
import strategy1.step4.interfaces.KnifeImpl;
import strategy1.step4.interfaces.MissileImpl;
//1.�����߰�, 2.setter�߰� , 3.�߻�޼ҵ� ����
public class Robot {
		private FlyImpl fly ;
		private MissileImpl missile;
		private KnifeImpl knife;
		public void actionFly() {
			fly.fly();
		}
		public void actionMissile() {
			missile.missile();
		}
		public void actionKnife() {
			knife.knife();
		}	
		
		
		public void actionWalk() {
			System.out.println("���� �� �ִ�");
		}
		public void actionRun() {
			System.out.println("�� �� �ִ�");
		}
		public void shape() { //"XXRobot �� ��, �ٸ� . ����, �Ӹ��� �ֽ��ϴ�" ���
			String ClassName = getClass().getName();//"strategy1.step2.SuperRobot"
			int idx = ClassName.lastIndexOf("."); //�� �������� ������ "."�� ��ġ 15
			String name = ClassName.substring(idx+1); //16��°���� ������ ���ڿ��� ����
			System.out.println(name + "�� ������ ��, �ٸ�, ����, �Ӹ��� �ֽ��ϴ�");
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