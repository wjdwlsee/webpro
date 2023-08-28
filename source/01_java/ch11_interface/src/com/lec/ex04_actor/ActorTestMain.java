package com.lec.ex04_actor;

public class ActorTestMain {
	public static void main(String[] args) {
		Actor tom = new Actor ("≈Ω ≈©∑Á¡Ó");
		tom.canCatchcriminal();
		tom.canSerch();
		tom.makePizza();
		tom.makeSpagetti();
		tom.outFire();
		tom.saveMan();
		System.out.println("------------------");
		IFireFighter firetom = tom;
		firetom.outFire();
		firetom.saveMan();
		//firetom.makeSpaghetti();
		IChef chefTom = tom;
		chefTom.makePizza();
		chefTom.makeSpagetti();
		IPoliceMan policeTom = tom;
		policeTom.canCatchcriminal();
		policeTom.canSerch();
		
	
	
	
	
	
	
	}
}
