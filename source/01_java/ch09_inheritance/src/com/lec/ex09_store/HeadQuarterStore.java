package com.lec.ex09_store;
//º»»çÁöÄ§ : ±èÄ¡Âî°³-0     ºÎ´ëÂî°³-0     ºñºö¹ä-0     ¼ø´ë±¹-0      °ø±â¹ä-0
// HeadQuarterStore headStore = new  HeadQuarterStore("=º»»ç=")
public class HeadQuarterStore {
	private String storeName;

	public HeadQuarterStore(String storeName) {
		
		this.storeName = storeName;
	}
	public void kimchi() {
		System.out.println("±èÄ¡Âî°³ -8,000¿ø");
	}
	public void bude() {
		System.out.println("ºÎ´ëÂî°³ -9,000¿ø");	
	}
	public void bibib() {
		System.out.println("ºñºö¹ä -9,000¿ø");
	}
	public void sunde() {
		System.out.println("¼ø´ë±¹ -8,000¿ø");	
	
	}				
	public void gongibab() {
		System.out.println("°ø±â¹ä -8,000¿ø");
	}	
	public String getStr() {return storeName;
						}
	public char[] getStoreName() {
		// TODO Auto-generated method stub
		return null;
	}
						
		
		}

