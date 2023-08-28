package com.lec.quiz;

public class StudentTestMain {
	public static void main(String[] args) {
		Student s1 = new Student("���켺 ", 90,80,95);
		Student s2 = new Student("���ϴ�", 100,80,95);
		Student s3 = new Student("Ȳ���� ", 95,80,90);
		Student s4 = new Student("������ ", 95,90,99);
		Student s5 = new Student("������ ", 90,90,90);
		Student[] students = {s1, s2, s3, s4, s5};
		String[] title = {"��ȣ�̸�","����","����","����","����","���"};		
		int[] total = new int[5];		
		line();
		System.out.println("\t\t\t�� �� ǥ");
		line('_');
		for(String t : title) {
			System.out.print("\t" + t);		
		}
		System.out.println();
		line('-');	
		for(int idx=0 ; idx<students.length ; idx++) {
			System.out.println(students[idx].infoString());
			total[0] += students[idx].getKor(); // ���� ����
			total[1] += students[idx].getEng(); // ���� ����
			total[2] += students[idx].getMat(); // ���� ����
			total[3] += students[idx].getTot(); // �հ� ����
			total[4] += students[idx].getAvg(); // ��� ����
			
		
		//System.out.println("\t");
		//		Product.staticMethod();
		
		}
		line('-');
		System.out.print("\t ����");
		for(int tot : total) {
				System.out.printf("\t%4d", tot);
		}
		System.out.print("\n\t���");
		for(int tot : total) {
			System.out.printf("\t%.1f",  (double)tot/students.length);
		}
		System.out.println();
		line();
	}	
					
		private static void line(char c) { // ���ϰ� �� ���� �Ѹ���
			System.out.println('\t');
			for(int i=0 ; i<50 ; i++) {
				System.out.print('-');
				}
				System.out.println();
		
	}

	private static void line() {
		for(int i=0 ; i<50 ; i++) {
			System.out.print('��');
		}
		System.out.println();
	}
	
}
			
			
			
			
		
