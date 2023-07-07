package com.lec.ex09_store;

public class StoreNum3 extends HeadQuarterStore {
	public StoreNum3(String storeName) {
		super(storeName);
	}
	@Override
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³-9,000¿ø");
	}
	@Override
	public void bude() {
		System.out.println("ºÎ´ëÂî°³-10,000¿ø");
	}
	@Override
	public void bibib() {
		System.out.println("ºñºö¹ä-10,000¿ø");
	}
	@Override
	public void sunde() {
		System.out.println("¾óÅ«¼ø´ë±¹-9,000");
   
	}
}
