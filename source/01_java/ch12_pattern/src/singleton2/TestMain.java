package singleton2;

public class TestMain {
	public static void main(String[] args) {
		FirstClass firstobj = new FirstClass();
		SecondClass secondobj = new SecondClass();
		SingletonClass singobj = SingletonClass.getInstance();
		System.out.println("main ÇÔ¼ö¿¡¼­ÀÇ ½Ì±ÛÅæ °´Ã¼ i °ª :" + singobj.getI());

	}
	
}
