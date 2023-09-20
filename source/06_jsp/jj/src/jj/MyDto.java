package jj;

import java.sql.Date;

public class MyDto {
	private String id;
	private String pw;
	private String name;
	private String age;
	private String gender;
	private String favoritefood;
	private String favoritestyle;
	private String favoritecolor;
	private String favoritespot;
	private String mbti;
	private String address;
	private   Date birth;
	public MyDto() {}
	public MyDto(String id, String pw, String name, String age, String gender, String favoritefood, String favoritestyle,
			String favoritecolor, String favoritespot, String mbti, String address, Date birth) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.favoritefood = favoritefood;
		this.favoritestyle = favoritestyle;
		this.favoritecolor = favoritecolor;
		this.favoritespot = favoritespot;
		this.mbti = mbti;
		this.address = address;
		this.birth = birth;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFavoritefood() {
		return favoritefood;
	}
	public void setFavoritefood(String favoritefood) {
		this.favoritefood = favoritefood;
	}
	public String getFavoritestyle() {
		return favoritestyle;
	}
	public void setFavoritestyle(String favoritestyle) {
		this.favoritestyle = favoritestyle;
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
	@Override
	public String toString() {
		return "Dto [id=" + id + ", pw=" + pw + ", name=" + name + ", age=" + age + ", gender=" + gender
				+ ", favoritefood=" + favoritefood + ", favoritestyle=" + favoritestyle + ", favoritecolor="
				+ favoritecolor + ", favoritespot=" + favoritespot + ", mbti=" + mbti + ", address=" + address
				+ ", birth=" + birth + "]";
	}
	
}
