package com.lec.ex03_speaktv;
//�������̽� : �۾�����(���ü�)��Ȱ
//�������̽� : (static final) ��� final ����)�� �߻�޼ҵ常 (���� : default�޼ҵ�, static �޼ҵ�)

public interface IVolume {
	public int TV_MAX_VOLUME = 50;
	public int SPEAKER_MAX_VOLUME =100;
	public int TV_MIN_VOLUME =2;
	public int SPEAKER_MIN_VOLUME = 0;
	public void volumeUp() ; //����1��ŭup
	public void volumeUp(int level);
	public void volumeDown();
	public void volumeDown(int level);
	public default void setMute(boolean mute) {//����Ʈ �޼ҵ�
		if(mute) {
			System.out.println("����");
		} else {
			System.out.println("���� ����");
		}
				
	}
	public static void changeBattery() { //static�޼ҵ� ��ü�ȸ���� ��밡��
		System.out.println("�������� ��ȯ�մϴ�");
	}
}
