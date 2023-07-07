package com.lec.ex03_speaktv;

public class TestNMain {
	public static void main(String[] args) {
		Speaker speaker = new Speaker();
		IVolume tv = new TV();
		IVolume [] devices = { speaker, tv} ;
		
		for(IVolume device : devices) {
			device.volumeUp();
			device.volumeUp(50);
			device.volumeDown();
			device.volumeDown(50);
			device.setMute(false);
			device.setMute(true);
		}
		IVolume.changeBattery(); //static
	}
}
