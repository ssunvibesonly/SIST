package spring.mvc.reboard;

import java.util.List;

public interface BoardDaoInter {
	public int getTotalCount();
	public int getMaxNum();
	public void updateRestep(int regroup,int restep);
	public void insertReboard(BoardDto dto);
	public List<BoardDto> getPagingList(int start,int perpage);
	public BoardDto getData(int num);
	public void readCountOfReboard(int num);
	public int getCheckPass(int num,int pass);
	public void update(BoardDto dto);
	public void delete(int num);
}
