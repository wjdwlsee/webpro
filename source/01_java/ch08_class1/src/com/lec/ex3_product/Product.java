package com.lec.ex3_product;
//������ :Serial number
//main���� product p1 = new product();
public class Product {
	private int serialNo;
	public static int count = 100;
	public Product() {
		serialNo = ++count;
	}
	public static void staticMethod() {
		System.out.println("static �޼ҵ�");
	}
	public void infoPrint() {
		System.out.println("�ø����ȣ : "+ serialNo + "\t�������� count: "+ count );
		
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
}
