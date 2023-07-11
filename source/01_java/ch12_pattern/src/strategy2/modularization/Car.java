package strategy2.modularization;

import strategy2.interfaces.EngineImpl;
import strategy2.interfaces.FuelImpl;
import strategy2.interfaces.KmImpl;

//속성변수 - 생성자 메소드(일반메소드-Setter&getter-오버라이드한 메소드)
public abstract class Car {
	private EngineImpl engine;
	private KmImpl km;
	private FuelImpl fuel;
	public void drive() {
		System.out.println("드라이브 할 수 있습니다");
	}
	public abstract void shape();
	public void isEngine() {
		engine.engine();
	}
	public void isKmperLiter() {
		km.kmPerLiter();
	}
	public void isfuel() {
		fuel.fuel();
	}
	public void setEngine(EngineImpl engine) {
		this.engine = engine;
	}
	public void setKm(KmImpl km) {
		this.km = km;
	}
	public void setFuel(FuelImpl fuel) {
		this.fuel = fuel;
	}
	
	
}
