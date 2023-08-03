package model.myteam;

import java.sql.Timestamp;

public class TeamDto {
	//DB에서 정한 변수랑 상관없음 자바내에서 쓸 변수 설정하는 것
	private String num; //DB에서 시퀀스는 정수형이라 자동으로 증가하지만, 자바에서 받아올 땐 문자로 받아옴 결국 수의 증가는 디비에서 이루어지므로
	private String name;
	private String driver;
	private String addr;
	private Timestamp writeday;
	
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
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	
}
