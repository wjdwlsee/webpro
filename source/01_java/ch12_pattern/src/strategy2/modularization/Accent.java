package strategy2.modularization;

import strategy2.interfaces.EngineLow;
import strategy2.interfaces.FuelDisel;
import strategy2.interfaces.Km20;

public class Accent extends Car {
	 public Accent() {
		setEngine(new EngineLow());
		setKm(new Km20());
		setFuel(new FuelDisel());		
	 }
	@Override
	public void shape() {
		System.out.println("����Ʈ ������ ��, ��Ʈ,�ڵ�� �̷���� �ֽ��ϴ�");

	}

}
