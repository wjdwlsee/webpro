package com.lec.ex03_speaktv;
//인터페이스 : 작업명세서(지시서)역활
//인터페이스 : (static final) 상수 final 변수)와 추상메소드만 (예외 : default메소드, static 메소드)

public interface IVolume {
	public int TV_MAX_VOLUME = 50;
	public int SPEAKER_MAX_VOLUME =100;
	public int TV_MIN_VOLUME =2;
	public int SPEAKER_MIN_VOLUME = 0;
	public void volumeUp() ; //볼륨1만큼up
	public void volumeUp(int level);
	public void volumeDown();
	public void volumeDown(int level);
	public default void setMute(boolean mute) {//디폴트 메소드
		if(mute) {
			System.out.println("무음");
		} else {
			System.out.println("무음 해제");
		}
				
	}
	public static void changeBattery() { //static메소드 객체안만들고 사용가능
		System.out.println("건전지를 교환합니다");
	}
}
