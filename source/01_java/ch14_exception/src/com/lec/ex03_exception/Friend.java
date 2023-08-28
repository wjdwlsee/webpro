package com.lec.ex03_exception;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Friend {
	private String name;
	private String tel;
	private Date date;
	public Friend(String name, String tel) {
		super();
		this.name = name;
		this.tel = tel;
	}
	public Friend(String name, String tel, Date date) {
		super();
		this.name = name;
		this.tel = tel;
		this.date = date;
	}
	@Override
	public String toString() {
	SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
		return "Friend [name=" + name + ", tel=" + tel + "]";
	}

	
	
}
