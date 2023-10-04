package spring.anno.ex4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("logic") //Ŭ�������� �� ��� ()�ȿ� ���ϴ� id������ ���´�. id�� logic�� �ȴ�.
public class logicController {
	
	
	@Autowired //bean�� �ڵ� ����
	//��Ȯ�� bean�� ���̵�� ����_��ȣ���� �ִ� ��쿡�� @Resource(name="��Ȯ�� Ŭ������") ex)@Resource(name="myDao")
	
	DaoInter daointer; //daointer�� �������� mydao�� �ڷ������� �������� �Ȱ���.
	
	public logicController(MyDao dao) {
		this.daointer=dao;
	}
	
	//insert
	public void insert(String str) {
		
		daointer.insertData(str);
	}
	
	//delete
	public void delete(String num) {
		
		daointer.deleteData(num);
	}
	
}
