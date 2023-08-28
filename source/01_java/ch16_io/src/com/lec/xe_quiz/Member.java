package com.lec.xe_quiz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
	private String name;
	private String tel;
	private String address;
	private Date birth;
	public Member(String name, String tel,String address, Date birth) {
		
		this.name = name;
		this.tel = tel;
		this.address = address;
		this.birth = birth;
	
	
	
	}
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return  name + "\t"+ tel+ "\t" + sdf.format(birth) +  "\t" + address+"\n";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	
}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
}