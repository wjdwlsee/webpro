package com.lec.quiz;

public class StudentTestMain {
	public static void main(String[] args) {
		Student s1 = new Student("정우성 ", 90,80,95);
		Student s2 = new Student("김하늘", 100,80,95);
		Student s3 = new Student("황정민 ", 95,80,90);
		Student s4 = new Student("강동원 ", 95,90,99);
		Student s5 = new Student("유아인 ", 90,90,90);
		Student[] students = {s1, s2, s3, s4, s5};
		String[] title = {"번호이름","국어","영어","수학","총점","평균"};		
		int[] total = new int[5];		
		line();
		System.out.println("\t\t\t성 적 표");
		line('_');
		for(String t : title) {
			System.out.print("\t" + t);		
		}
		System.out.println();
		line('-');	
		for(int idx=0 ; idx<students.length ; idx++) {
			System.out.println(students[idx].infoString());
			total[0] += students[idx].getKor(); // 국어 누적
			total[1] += students[idx].getEng(); // 영어 누적
			total[2] += students[idx].getMat(); // 수학 누적
			total[3] += students[idx].getTot(); // 합계 누적
			total[4] += students[idx].getAvg(); // 평균 누적
			
		
		//System.out.println("\t");
		//		Product.staticMethod();
		
		}
		line('-');
		System.out.print("\t 총점");
		for(int tot : total) {
				System.out.printf("\t%4d", tot);
		}
		System.out.print("\n\t평균");
		for(int tot : total) {
			System.out.printf("\t%.1f",  (double)tot/students.length);
		}
		System.out.println();
		line();
	}	
					
		private static void line(char c) { // 진하고 긴 라인 뿌리기
			System.out.println('\t');
			for(int i=0 ; i<50 ; i++) {
				System.out.print('-');
				}
				System.out.println();
		
	}

	private static void line() {
		for(int i=0 ; i<50 ; i++) {
			System.out.print('■');
		}
		System.out.println();
	}
	
}
			
			
			
			
		
