package com.lec.ex1_list;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Friend {
	private String name;
	private String tel;
	private Date birth;
	public Friend(String name, String tel) {
		this.name = name;
		this.tel = tel;
		// birth = null;
	}
	public Friend(String name, String tel, Date birth) {
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}
	@Override
	public String toString() {
		if(birth!=null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
			return "[name]" + name + "\t[tel]" + tel + "\t[birth]" + sdf.format(birth);
		}else {
			return  "[name]" + name + "\t[tel]" + tel;
		}
		
	}
		public Date getBirth() {
			return birth;
		
	}
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}
}
