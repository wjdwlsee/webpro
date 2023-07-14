package QuizSawon;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Sawon {
	public static final String COMPUTER = "COMPUTER";
	public static final String PLANNING = "PLANNING";
	public static final String DESIGN   = "DESIGN";
	private String no;
	private String name;
	private String part;
	private Date date;
	public Sawon(String no, String name, String part) {
		this.no =no;
		this.name=name;
		this.part=part;
		date =new Date();		
	}		
	public Sawon(String no, String name, String part, int y, int m, int d) {
		this.no =no;
		this.name=name;
		this.part=part;
	
		date =new Date(new GregorianCalendar(y,m-1,d).getTimeInMillis());
	
	}
//	public String infoPrint() {
//		SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.dd");		
//		String str =sdf.format(date);	
//		return "[사번]" + no + "\t[이름] " + name + "\t[부서] " + part + "\t[입사일]"+str;		
//		
//	}
	@Override
	public String toString() {
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
		return "[사번]" +no +"\t[이름]" +name + "\t[부서]" + part +"\t[입사일]" + sdf.format(date);	
		
	}

}