package com.lec.ex2_access;

public class AccessTest {
	private int privateMember; //
	int defaultMember; //����Ʈ �������� : ���� ��Ű�������� ���
	protected int protectMember;//���� ��Ű���� ��ӹ��� Ŭ�������� ���
	public int publicMember ;
	
	private void privateMethod() {
		System.out.println("private �޼ҵ� / privateMember:" + privateMember);
	
	}
	void defaultMethod() {
		System.out.println("����Ʈ �������� �޼ҵ�");
	
	}
	protected void protectMethod() {
		System.out.println("protected �޼ҵ�");
		
	}
	public void	publicMethod() {
		System.out.println("public �޼ҵ�");
	}
}
	
	

