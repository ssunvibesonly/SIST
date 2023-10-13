package spring.mvc.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonTestController {
	
	@GetMapping("/list1")
	@ResponseBody //json으로 처리한 다음에 브라우저로 출력(일반적인 controller에서 json으로 저장하고 싶을때)
	//map이 listdb를 가져오는 거랑 같은데 , 여기선 아직 db연결을 안했기 때문에 map 자료형으로 작성해준다.
	public Map<String, String> list1(){
		
		Map<String, String> map=new HashMap<String, String>();
		
		map.put("name", "장순영");
		map.put("hp", "010-111-2222");
		map.put("addr", "수원시 장안구");
		
		return map;
	}
	
	@GetMapping("/list3")
	public @ResponseBody List<PhotoDto> list3(){
		
		List<PhotoDto> list=new ArrayList<PhotoDto>();
		
		list.add(new PhotoDto("minion1", "01.png"));
		list.add(new PhotoDto("minion2", "02.png"));
		list.add(new PhotoDto("minion3", "03.png"));
		list.add(new PhotoDto("minion4", "04.png"));
		list.add(new PhotoDto("minion5", "05.png"));
		
		return list;
		
	}
}
