package singleton2;

	
public class FirstClass {
	public FirstClass() {
		System.out.println("FirstClass 积己磊 角青 吝");
		SingletonClass singletonObject = SingletonClass.getInstance();
		System.out.println("教臂沛 按眉狼 i 蔼 :" + singletonObject.getI());
		singletonObject.setI(999);
		System.out.println("教臂沛 按眉狼 I蔼 (荐沥饶) :" + singletonObject.getI());
		System.out.println("FirstClass 积己磊 角青 场 ----------------- ");
	}

}
