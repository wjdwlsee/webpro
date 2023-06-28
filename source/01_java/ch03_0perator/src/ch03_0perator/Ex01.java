package ch03_0perator;

public class Ex01 {
	public static void main(String[] args) {
		int n1=33, n2=10;
		int result; double resultDouble;
		result = n1 + 12;
		System.out.printf("%d %c %d = %d\n" , n1, '+' , n2, result);
		result = n1 * 12;
		System.out.printf("%d %c %d = %d\n" , n1, '*' , n2, result);
		result = n1 / 12;
		System.out.printf("%d %c %d = %d\n" , n1, '/' , n2, result);
		resultDouble = n1 / 12;
		System.out.printf("%d %c %d = %f\n" , n1, '/' , n2, resultDouble);
		result = n1 % 12;
		System.out.printf("%d %c %d = %d\n" , n1, '%' , n2, result);
		// 나머지 연산자의 용도 : 짝수/홀수 판별/ 배수 판별 용도
		if ( (n1%2) == 0) {
			System.out.println("n1은 짝수");	
		}else {
			System.out.println("n1은 홀수");
		}
		if ( (n1%5) == 0) {
			System.out.println("n1은 5의 배수입니다");
		}else {
			System.out.println("n1은 5의 배수가 아닙니다");
		}
	}

}
