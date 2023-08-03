package model.sinsang;

import java.sql.Timestamp;

public class SinSangDto {
	
	private String num;
	private String name;
	private String addr;
	private Timestamp sdate; //timestmap 고를 때 sql로 골라야함 
	
	
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
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Timestamp getSdate() {
		return sdate;
	}
	public void setSdate(Timestamp sdate) {
		this.sdate = sdate;
	}
	
	
	
}
