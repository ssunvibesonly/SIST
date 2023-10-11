package spring.mysql.mycar;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository //빈에 등록
public class MyCarDao {
	
	@Autowired
	SqlSession session; //프레임워크에서는 sqlsession으로 받는다.
	
	String namespace="spring.mysql.mycar.MyCarDao";
	
	public int getTotalCount() {
		return session.selectOne(namespace+".getTotalCountOfMyCar");
		
	}
	
	//insert
	public void insertCar(MyCarDto dto) {
		
		session.insert("insertOfMyCar", dto); //(id값,파라메터값)
		
	}
	
	//전체 리스트 출력
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
