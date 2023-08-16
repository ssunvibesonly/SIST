package model.memberSawon;

import java.sql.Timestamp;

public class memberSawonDto {

	private String num;
	private String id;
	private String name;
	private String position;
	private String department;
	private String go;
	private Timestamp bye;
	private String worktime;
	
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getGo() {
		return go;
	}
	public void setGo(String go) {
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
