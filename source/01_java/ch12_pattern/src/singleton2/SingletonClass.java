package singleton2;

public class SingletonClass {
	private int i;
	private static SingletonClass INSTANCE = new SingletonClass();
	private SingletonClass() {
		i=10;
	}
		public static SingletonClass getInstance() { //메소드 이름 getIntance
			
		return INSTANCE;
}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
}
