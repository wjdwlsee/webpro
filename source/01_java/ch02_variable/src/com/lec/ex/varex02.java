package com.lec.ex;

public class varex02 {
   public static void main(String[] args) {
	     //Ÿ�� ������ (���ĺ�, ����, _; �������� ) �Ҵ翬��(=) �ʱⰪ ;
       int i =10;
       byte j =127;
       double h =10.15;
       System.out.println("1="+i +"/t j=" + j + "\t h=" + h);// �ܼ�â���(��������)"
       System.out.printf("i=%d\t j=%d\t h=%.3f\n" , i, j, h);
       char c1 = 'A';
       char c2 = 'ȫ';
    		   //����(%c), ���ڿ�(%s), ����(%d), �Ǽ�(%f), boolean(%b)
       System.out.printf("c1=%c \t c2=%c\n", c1, c2); 		   
       System.out.printf("c1=%d \t c2=%d\n", (int)c1, (int)c2);
       System.out.println("���α׷� ��");
   }
}
