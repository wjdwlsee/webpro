package singleton2;

public class TestMain {
	public static void main(String[] args) {
		FirstClass firstobj = new FirstClass();
		SecondClass secondobj = new SecondClass();
		SingletonClass singobj = SingletonClass.getInstance();
		System.out.println("main �Լ������� �̱��� ��ü i �� :" + singobj.getI());

	}
	
}
