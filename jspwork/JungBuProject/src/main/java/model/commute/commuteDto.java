package model.commute;

import java.sql.Timestamp;

public class commuteDto {
	private String num2;
	private Timestamp workday;
	private String id2;
	private String position2;
	private String name2;
	private String department2;
	private Timestamp go;
	private Timestamp bye;
	private String worktime;
	
	public String getNum2() {
		return num2;
	}
	public void setNum2(String num2) {
		this.num2 = num2;
	}
	public Timestamp getWorkday() {
		return workday;
	}
	public void setWorkday(Timestamp workday) {
		this.workday = workday;
	}
	public String getId2() {
		return id2;
	}
	public void setId2(String id2) {
		this.id2 = id2;
	}
	public String getPosition2() {
		return position2;
	}
	public void setPosition2(String position2) {
		this.position2 = position2;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getDepartment2() {
		return department2;
	}
	public void setDepartment2(String department2) {
		this.department2 = department2;
	}
	public Timestamp getGo() {
		return go;
	}
	public void setGo(Timestamp go) {
		this.go = go;
	}
	public Timestamp getBye() {
		return bye;
	}
	public void setBye(Timestamp bye) {
		this.bye = bye;
	}
	public String getWorktime() {
		return worktime;
	}
	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}
}
