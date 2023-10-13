package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //json ���� ��Ʈ�ѷ�(������ ajax�� �ϱ� ���� RESTAPI)
public class JsonTest2Controller {

	@GetMapping("/list2") //list2 = ajax url �̸�
	public Map<String, String> list2(){
		
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("sang", "������");
		map.put("color", "�׷�����Ʈ");
		map.put("price", "1500000");
		
		return map;
	}
	
	@GetMapping("/list4")
	public Map<String, Object> list4(@RequestParam String mname){ //object�� ���� or ���ڰ� ���� ���� �� ���� ���
		
		List<PhotoDto> list=new ArrayList<PhotoDto>();
				
				list.add(new PhotoDto("������", "01.png"));
				list.add(new PhotoDto("�����", "02.png"));
				list.add(new PhotoDto("�̴Ͼ�3", "03.png"));
				list.add(new PhotoDto("�̴Ͼ�4", "04.png"));
				list.add(new PhotoDto("�̴Ͼ�5", "05.png"));
				
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("mname", "���� �̴Ͼ�");
				map.put("photo", "5.jpg");
				
				for(PhotoDto dto:list) {
					if(mname.equals(dto.getName())) {
						map.put("mname", dto.getName());
						map.put("photo", dto.getPhoto());
						
					}
				}
				
				
				return map;
				
	}
	
}
