package spring.mysql.carmember;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CarMemberDao implements CarMemberInter {

	@Autowired
	private SqlSession session; //framework���� private�� �ٿ��� �ٷ� ������ �� �� �ְ� �߱� ������ �����ϴ�.
	
	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return session.selectOne("getTotalCountOfCarMember");
	}
	
	@Override
	public void insertOfCarMem(CarMemberDto dto) {
		// TODO Auto-generated method stub
		session.insert("insertOfCarMember", dto);

	}

	@Override
	public List<CarMemberDto> getAllSelect() {
		// TODO Auto-generated method stub
		return session.selectList("selectAllOfCarMember");
	}

	@Override
	public void delete(int num) {
		session.delete("deleteOfCarMember", num);
		
	}

	@Override
	public CarMemberDto getData(int num) {
		// TODO Auto-generated method stub
		return session.selectOne("selectOneOfCarMem", num);
	}

	@Override
	public void updateOfCarMem(CarMemberDto dto) {
		// TODO Auto-generated method stub
		session.update("updateOfCarMem", dto);
	}

}
