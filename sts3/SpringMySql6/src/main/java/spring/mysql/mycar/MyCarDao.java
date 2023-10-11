package spring.mysql.mycar;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //�� ���
public class MyCarDao {
	
	@Autowired
	SqlSession session; //�����ӿ�ũ������ sqlsession���� �޴´�.
	
	String namespace="spring.mysql.mycar.MyCarDao";
	
	public int getTotalCount() {
		return session.selectOne(namespace+".getTotalCountOfMyCar");
		
	}
	
	//insert
	public void insertCar(MyCarDto dto) {
		
		session.insert("insertOfMyCar", dto); //(id��,�Ķ���Ͱ�)
		
	}
	
	//��ü ����Ʈ ���
	public List<MyCarDto> getAllCars(){
		
		return session.selectList("getAllListOfMyCar");		
	}
	
	//delete 
	public void deleteOfMyCar(String num) {

		
		session.delete("deleteOfMyCar",num);
	}
	//getData
	public MyCarDto getData(String num) {
		
		return session.selectOne("getDataOfMyCar", num);
	}
	//update
	public void updateMyCar(MyCarDto dto) {
		
		session.update("updateOfMyCar", dto);
	}
}
