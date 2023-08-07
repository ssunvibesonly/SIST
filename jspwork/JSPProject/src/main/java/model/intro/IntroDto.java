package model.intro;

import java.sql.Timestamp;

public class IntroDto {
	private String num;
	private String name;
	private String mbti;
	private String hp;
	private String city;
	private Timestamp gaip;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMbti() {
		return mbti;
	}
	public void setMbti(String mbti) {
		this.mbti = mbti;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Timestamp getGaip() {
		return gaip;
	}
	public void setGaip(Timestamp gaip) {
		this.gaip = gaip;
	}
}
