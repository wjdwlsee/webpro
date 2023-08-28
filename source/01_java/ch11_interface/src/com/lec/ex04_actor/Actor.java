package com.lec.ex04_actor;

public class Actor implements IFireFighter, IPoliceMan, IChef {
	private String name;
	public Actor(String  name) {
		this.name = name;
		
	}
	@Override
	public void makePizza() {
		System.out.println(name+"��(��) ���� �Դϴ�. ���ڸ� ����ϴ�.");

	}

	@Override
	public void makeSpagetti() {
		System.out.println(name+"��(��) ���� �Դϴ�. ���İ�Ƽ�� ����ϴ�.");

	}

	@Override
	public void canCatchcriminal() {
		System.out.println(name+"��(��) ������ �Դϴ�. ������ ����ϴ�.");

	}

	@Override
	public void canSerch() {
		
		System.out.println(name+"��(��) ������ �Դϴ�. ������ ã���ϴ�.");
	}

	@Override
	public void outFire() {
		System.out.println(name+ "��(��) �ҹ�� �Դϴ�. ���� ���ϴ�");

	}

	@Override
	public void saveMan() {
		System.out.println(name+" ��(��) �ҹ�� �Դϴ�. ����� ���մϴ�");

	}

}
