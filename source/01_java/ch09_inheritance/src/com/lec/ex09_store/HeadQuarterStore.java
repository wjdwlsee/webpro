package com.lec.ex09_store;
//������ħ : ��ġ�-0     �δ��-0     �����-0     ���뱹-0      �����-0
// HeadQuarterStore headStore = new  HeadQuarterStore("=����=")
public class HeadQuarterStore {
	private String storeName;

	public HeadQuarterStore(String storeName) {
		
		this.storeName = storeName;
	}
	public void kimchi() {
		System.out.println("��ġ� -8,000��");
	}
	public void bude() {
		System.out.println("�δ�� -9,000��");	
	}
	public void bibib() {
		System.out.println("����� -9,000��");
	}
	public void sunde() {
		System.out.println("���뱹 -8,000��");	
	
	}				
	public void gongibab() {
		System.out.println("����� -8,000��");
	}	
	public String getStr() {return storeName;
						}
	public char[] getStoreName() {
		// TODO Auto-generated method stub
		return null;
	}
						
		
		}

