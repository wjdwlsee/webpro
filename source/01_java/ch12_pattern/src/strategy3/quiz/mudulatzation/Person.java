package strategy3.quiz.mudulatzation;

import strategy3.quiz.interfaces.GetImpl;
import strategy3.quiz.interfaces.JopImpl;

public class Person {
	private String name;
	private String id;
	private JopImpl jop;
	private GetImpl get;

	public Person(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public void isjop() {
		jop.Jop();
	}

	public void isget() {
		get.Get();
	}
	public void print() {
		System.out.print("[id]" + id +"\t[¿Ã∏ß]"+ name);
	}

	
	public void setJop(JopImpl jop) {
		this.jop = jop;
	}

	public void setGet(GetImpl get) {
		this.get = get;
	}
}
