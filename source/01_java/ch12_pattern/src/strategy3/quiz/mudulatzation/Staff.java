package strategy3.quiz.mudulatzation;

import strategy3.quiz.interfaces.GetSalary;
import strategy3.quiz.interfaces.JopMng;

public class Staff extends Person {
	private String part;
	public Staff(String id, String name, String part) {
		super(id,name);
		this.part=part;
		setJop(new JopMng());
		setGet(new GetSalary());
					
		}
	@Override
	public void print() {
		super.print();
		System.out.println("\t[¹Ý] + part");
	}
}
