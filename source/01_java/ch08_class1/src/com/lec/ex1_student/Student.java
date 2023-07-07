package com.lec.ex1_student;
//데이터(이름,국,영,수,총,평) 생성할함수, 메소드 setter&getter

//Student s = new Student("정우성 ,100, 99,99);
public class Student {
	private String name;
	private int 	kor;
	private int		eng;
	private int 	mat;
	private int 	tot;
	private double avg;
	public Student() {//디폴트 생성자
		
	}
	public Student(String name, int kor, int eng, int mat) {		
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot=kor+eng+mat;
		avg=tot/3.0;
	
	}
	public void print() {
		System.out.printf("\t%s \t %d \t %d \t %d \t %d \t %.2f\n", name, kor, eng,mat,tot,avg);//소주점 주자리는 .2를 붙인다
	}
	public String infotString() {
		//return "\t" +name+ "\t+ kor +"\t" +eng + "\t"
		return String.format("\t%s \t %d \t %d \t %d \t %d \t %.2f\n", 
				name, kor, eng,mat,tot,avg);
			
			
	}//getter
	
	public Student(String name, int kor, int eng, int mat, int tot, double avg) {
		
	
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
