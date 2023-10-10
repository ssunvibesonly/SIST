package spring.mvc.tea;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.data.dto.ShopDto;

@Controller
@RequestMapping("/naver") //servlet-context.xml bean에 등록
public class NaverController {
	
	@GetMapping("/form1")
	public String form1() {
		return "day1010/form1";
		
	}
	
	@PostMapping("/read1")
	public ModelAndView read1(
			@RequestParam String name, @RequestParam String gender,
			@RequestParam String addr) {
		
		ModelAndView model=new ModelAndView();
		
		//모델에 넣어주고
		model.addObject("name", name);
		model.addObject("gender", gender);
		model.addObject("addr", addr);
		
		//포워드
		model.setViewName("day1010/result1");
		
		
		return model;
	}
	
	@GetMapping("/form2")
	public String form2() {
		return "day1010/form2";
		
	}
	
	//@ModelAttribute : 폼의 데이터를 읽어서 dto에 넣고 model에 저장
	//단, model에는 ShopDto 타입일 경우 앞에만 소문자(shopDto)가 되어 자동 저장
	//만약 다른 이름 원하면 @ModelAttribute("이름")
	@PostMapping("/read2")
	public String read2(@ModelAttribute ShopDto dto) {
		 
		return "day1010/result2";
	}
	
	@GetMapping("/form3")
	public String form3() {
		return "day1010/form3";
	}
	
	@PostMapping("/read3")
	//폼태그의 name이 key값으로, 입력값은 value값으로...
	public ModelAndView read3(@RequestParam Map<String, String> map) {
		
		ModelAndView model=new ModelAndView();
		
		model.addObject("sang", map.get("sang"));
		model.addObject("color", map.get("color"));
		model.addObject("price", map.get("price"));
		model.addObject("image", map.get("image"));
		
		model.setViewName("day1010/result3");
		
		return model;
	}
}
