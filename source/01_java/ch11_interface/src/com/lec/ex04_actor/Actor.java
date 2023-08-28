package com.lec.ex04_actor;

public class Actor implements IFireFighter, IPoliceMan, IChef {
	private String name;
	public Actor(String  name) {
		this.name = name;
		
	}
	@Override
	public void makePizza() {
		System.out.println(name+"은(는) 쉐프 입니다. 피자를 만듭니다.");

	}

	@Override
	public void makeSpagetti() {
		System.out.println(name+"은(는) 쉐프 입니다. 스파게티를 만듭니다.");

	}

	@Override
	public void canCatchcriminal() {
		System.out.println(name+"은(는) 경찰관 입니다. 범인을 잡습니다.");

	}

	@Override
	public void canSerch() {
		
		System.out.println(name+"은(는) 경찰관 입니다. 물건을 찾습니다.");
	}

	@Override
	public void outFire() {
		System.out.println(name+ "는(은) 소방관 입니다. 불을 끕니다");

	}

	@Override
	public void saveMan() {
		System.out.println(name+" 은(는) 소방관 입니다. 사람을 구합니다");

	}

}
