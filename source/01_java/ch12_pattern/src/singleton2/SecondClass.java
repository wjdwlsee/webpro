package singleton2;

public class SecondClass {
	public SecondClass() {
	System.out.println("SecondClass ������ ���� �� �ڡڡڡڡڡڡڡڡڡ�");
	SingletonClass singletonobject = SingletonClass.getInstance();
	System.out.println("��Ŭ�� ��ü�� i���� " + singletonobject.getI());
	System.out.println("SecondClass ������ ���� �� �ڡڡڡڡڡڡڡڡڡ�");
}
}