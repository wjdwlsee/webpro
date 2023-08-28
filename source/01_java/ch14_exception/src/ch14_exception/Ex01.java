package ch14_exception;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Ex01 {
	
		public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
			int i, j = 1; // ����ڿ��� �Է¹��� �� ����
			do {
				try {
					System.out.println("ù��° ������(��Ģ���� ����� ����)?");
					i = scanner.nextInt();
					break;
				}catch(InputMismatchException e) {
					System.out.println("���� ���ڸ� ���� ������");
					scanner.nextLine(); // ���۸� ����� ����(\n�ձ��� ���ڸ� return�ϰ� \n�� ����� �Լ�)
				}
			System.out.print("ù��° ������(��Ģ���� ����� ����)?");
			i = scanner.nextInt();
			System.out.print("�ι�° ������(��Ģ���� ����� ����)?");
			j = scanner.nextInt();
			try {
				j = scanner.nextInt();
				System.out.println("i / j = " + (i/j)); // ���ܰ� �߻��� ���� �ְ�, �� �� �� �ִ� �κ�								
			}catch(ArithmeticException e) { // ArithmeticException ���� ��ü �߻��� ���� �κ�
				// e.printStackTrace(); // �� �� �ڼ��� ���� �޼���
				System.out.println(e.getMessage()); // ���ܰ�ü�� ���ܸ޼��� ���
				System.out.println("�ι��� ������ �߸� �Է��ϸ� ������ 1�� ó���մϴ�");
			}catch(Exception e) {
				System.out.println("e.get");
			}
			System.out.println("i * j = " + (i*j));
			System.out.println("i - j = " + (i-j));
			System.out.println("i + j = " + (i+j));
			System.out.println("DONE");
			scanner.close();
		
			
		}
		
	}
}
