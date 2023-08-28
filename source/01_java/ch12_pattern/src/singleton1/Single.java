package singleton1;

public class Single {
	private int i;
	private static Single INSTANCE = new Single();
	private Single() {}
	public static Single getInstance() {
		return INSTANCE;
	}
//	private static Single INSTANCE; //= null; //대분자로(S) 시작하면 null로 청소 
//	private Single() {} //생성자 함수 프라이빗
//	public static Single getInstance() { //클래스이름으로 static 만듬
//	//Single형 객체를 생성한 적 없으면 객체 생성 
//		if(INSTANCE==null) {
//			INSTANCE = new Single();
//		}
//		return INSTANCE; 
//	
//	}
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
	
}
