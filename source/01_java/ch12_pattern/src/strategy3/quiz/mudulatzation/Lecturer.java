package strategy3.quiz.mudulatzation;

import strategy3.quiz.interfaces.GetSalary;
import strategy3.quiz.interfaces.JopLec;

public class Lecturer extends Person {
	private String subject;
	public Lecturer(String name, String id, String subject) {
		super(name, id);
		this.subject=subject;
		setGet(new GetSalary());
		setJop(new JopLec());
	}
	@Override
	public void print() {
		super.print();
		System.out.println("\t[°ú¸ñ]+subject");
	}
}
