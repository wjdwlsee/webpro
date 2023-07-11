package strategy1.step4.modularzation;

public abstract class Robot {
	public abstract void actionFly();
	public abstract void actionMissile();
	public abstract void actionKnife();
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
}