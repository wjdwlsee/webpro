//Hi.jave -(컴파일 : javac Hi-java)->Hi.clss -(실행:java Hi)-> Hello 출력
public class hi {
	public static void main(String[] args) {
		System.out.println("Hello");
		for(int i=0 ; i<args.length ; i++) {
			System.out.println("," +args[i]);
		}
	}
}
