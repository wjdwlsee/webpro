package singleton2;

public class SecondClass {
	public SecondClass() {
	System.out.println("SecondClass 생성자 실행 중 ★★★★★★★★★★");
	SingletonClass singletonobject = SingletonClass.getInstance();
	System.out.println("싱클톤 객체의 i값은 " + singletonobject.getI());
	System.out.println("SecondClass 생성자 실행 끝 ★★★★★★★★★★");
}
}