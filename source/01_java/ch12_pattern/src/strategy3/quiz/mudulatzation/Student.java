package strategy3.quiz.mudulatzation;

import strategy3.quiz.interfaces.GetSalary;
import strategy3.quiz.interfaces.GetStudenPay;
import strategy3.quiz.interfaces.JopMng;
import strategy3.quiz.interfaces.JopStudy;

public class Student extends Person {
	private String ban; 	
	public Student(String name, String id, String ban) {
			super(name, id);
			this.ban=ban;
			setGet(new GetStudenPay());
			setJop(new JopStudy());
		}
		@Override
		public void print() {
				super.print();
				System.out.println("\t[¹Ý]+ban");
		}
}
