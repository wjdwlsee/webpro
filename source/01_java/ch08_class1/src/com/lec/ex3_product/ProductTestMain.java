package com.lec.ex3_product;

public class ProductTestMain {
	public static void main(String[] args) {
		System.out.println("Static ���� : " + Product.count);
		Product.staticMethod();
		Product p1 = new Product();
		p1.infoPrint();
		Product p2 = new Product();
		System.out.println("static ���� :" + Product.count);
		p2.infoPrint();
		System.out.println("statix ����: " + Product.count);
		System.out.println("static ���� :" + p1.count);
		System.out.println("static ���� :" + p2.count);
	}
}
