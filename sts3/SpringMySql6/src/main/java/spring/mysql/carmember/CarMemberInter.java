package spring.mysql.carmember;

import java.util.List;

public interface CarMemberInter {
	public int getTotalCount();
	//insert
	public void insertOfCarMem(CarMemberDto dto);
	//allselect
	public List<CarMemberDto> getAllSelect();
	//getdata
	public CarMemberDto getData(int num);
	//update
	public void updateOfCarMem(CarMemberDto dto);
	//delete
	public void delete(int num);
}
