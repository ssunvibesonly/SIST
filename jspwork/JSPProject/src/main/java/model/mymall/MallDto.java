package model.mymall;

import java.sql.Timestamp;

public class MallDto {
	private String no;
	private String sang;
	private String photo;
	private String price;
	private String ipgo;
	private Timestamp writeday;
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getSang() {
		return sang;
	}
	public void setSang(String sang) {
		this.sang = sang;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getIpgo() {
		return ipgo;
	}
	public void setIpgo(String ipgo) {
		this.ipgo = ipgo;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	
}
