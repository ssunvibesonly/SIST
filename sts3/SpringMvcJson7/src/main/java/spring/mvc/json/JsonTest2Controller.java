package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //json 전용 컨트롤러(오로지 ajax를 하기 위한 RESTAPI)
public class JsonTest2Controller {

	@GetMapping("/list2") //list2 = ajax url 이름
	public Map<String, String> list2(){
		
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("sang", "아이폰");
		map.put("color", "그래파이트");
		map.put("price", "1500000");
		
		return map;
	}
	
	@GetMapping("/list4")
	public Map<String, Object> list4(@RequestParam String mname){ //object는 숫자 or 문자가 같이 있을 때 자주 사용
		
		List<PhotoDto> list=new ArrayList<PhotoDto>();
				
				list.add(new PhotoDto("강연주", "01.png"));
				list.add(new PhotoDto("장순영", "02.png"));
				list.add(new PhotoDto("미니언3", "03.png"));
				list.add(new PhotoDto("미니언4", "04.png"));
				list.add(new PhotoDto("미니언5", "05.png"));
				
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("mname", "없는 미니언");
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
