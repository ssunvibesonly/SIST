package spring.mvc.Friday;

import java.util.List;
import java.util.Map;

public interface InfoInter {
	
	//ÃÑ °¹¼ö
	public int selectTotalCount();
	//insert
	public void insertMyInfo(InfoDto dto);
	//select
	//public List<InfoDto> getAllInfos(); 
	//delete
	public void delete(String num);
	//getData (update)
	public InfoDto getData(String num);
	//update
	public void updateMyInfo(InfoDto dto);
	//search
	public List<InfoDto> getAllIfInfoDtos(Map<String, String> map);
}
