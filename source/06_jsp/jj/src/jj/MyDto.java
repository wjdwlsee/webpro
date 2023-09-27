package jj;

import java.sql.Date;

public class MyDto {
	private String id;
	private String pw;
	private String name;
	private int age;
	private String favoritefood;
	private String favoritecolor;
	private String favoritespot;
	private String mbti;
	private   Date birth;
	private String gender;
	public MyDto() {}
	public MyDto(String id, String pw, String name, int age,  String favoritefood, String favoritecolor,
			String favoritespot, String mbti, Date birth, String gender) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.favoritefood = favoritefood;
		this.favoritecolor = favoritecolor;
		this.favoritespot = favoritespot;
		this.mbti = mbti;
		this.birth = birth;
		this.gender = gender;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getFavoritefood() {
		return favoritefood;
	}
	public void setFavoritefood(String favoritefood) {
		this.favoritefood = favoritefood;
	}
	public String getFavoritecolor() {
		return favoritecolor;
	}
	public void setFavoritecolor(String favoritecolor) {
		this.favoritecolor = favoritecolor;
	}
	public String getFavoritespot() {
		return favoritespot;
	}
	public void setFavoritespot(String favoritespot) {
		this.favoritespot = favoritespot;
	}
	public String getMbti() {
		return mbti;
	}
	public void setMbti(String mbti) {
		this.mbti = mbti;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "MyDto [id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + ", favoritefood=" + favoritefood
				+ ", favoritecolor=" + favoritecolor + ", favoritespot=" + favoritespot + ", mbti=" + mbti + ", birth="
				+ birth + ", gender=" + gender + "]";
	}
	
	
}