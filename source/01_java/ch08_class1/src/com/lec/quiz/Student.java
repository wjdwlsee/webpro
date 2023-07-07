package com.lec.quiz;

public class Student {
	private String name;
	private int serialNo;
	public static int count = 0;
	private int 	kor;
	private	int 	eng;
	private int    	mat;
	private int    	tot;
	private int 	avg;
	public Student() {
	}
	public Student(String name, int kor, int eng, int mat) {
		serialNo = ++count; //위치 확인
		this.name= name;
		this.kor= kor;
		this.eng= eng;
		this.mat= mat;
		tot = kor+ eng+mat;
		avg= (int)(tot/3.0+0.5); //반올림 
	}
	//public static void staticMethod() {
	//	System.out.println("static 메소드");
	//}
	//public void infoPrint() {
//		System.out.println("시리얼번호 : " + serialNo + "\t공유변수 count : " + count);
//	}
	
	public void print() {
		System.out.printf("seriaNO  \t \t%s \t %d \t %d \t %d \t %d \t %.1f",
				             name, kor,  eng,  mat,   tot,  avg);
	}
	public String infoString() {
				return String.format(" %d \t%s \t %d \t %d \t %d \t %d \t %.1f",
						serialNo, name, kor,  eng,  mat,   tot,  avg);
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	
	public String getName() {
		return name;
	}
	
	public int getKor() {
		return kor;
	}
	
	public int getEng() {
		return eng;
	}

	public int getMat() {
		return mat;
	}
	
	public int getTot() {
		return tot;
	}
	
	public double getAvg() {
		return avg;
	}
	
	}