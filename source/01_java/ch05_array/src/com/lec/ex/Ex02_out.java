package com.lec.ex;
//�Ϲ� for��vs. Ȯ�� for�� (Array,ArrayList������)
public class Ex02_out {
	public static void main(String[] args) {
		double[] arr = {999.0, 987.0, 920.0}; //{0,0,0}  //new double[3]
		//Ȯ��for�� (�迭 ���� ���)
		for(double a : arr) {
				System.out.println(a);
		}
		
		//�Ϲ� for���� (�ε����� ���� ���� ���)
		System.out.println("10%����");
		for(int idx=0; idx<arr.length; idx++) {
			System.out.printf("arr[%d] = %.1f\t" , idx, arr[idx]);
		}
		// �迭 ���� ����(10%�� ����)
		System.out.print("\n10%����");
		for(double a : arr) {
			a *= 1.1;
		}
//		for(int idx=0; idx<arr.length; idx++) { // Ȯ�� for�� �� �̿��� �� ������ �Ұ�
//			arr[idx] *=1.1; // arr[idx] = arr[idx] * 1.1; (�ȵ�)
//		}
		
		for(double a :arr) { //�迭 �� ���
			 	System.out.printf("%.1f\t" , a);
		}
	}
}