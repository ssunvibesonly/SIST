package spring.mvc.yeong;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.data.dto.FormDto;

@Controller
public class FormController {

//myforms가 나오게 포워드 할 것!
@GetMapping("/data/myform")
public String start() {
	
	return "myforms";
}

//read1_get방식폼 전송

@GetMapping("data/read1")
public ModelAndView read1(@RequestParam(value = "myname")String name,
		int myage,@RequestParam(value = "msg",defaultValue = "HappyDay!!!!") String msg) { //값이 없지만 값을 출력하고싶을 때 defaultValue
	
	ModelAndView mvc=new ModelAndView();
	
	//Request에 저장
	mvc.addObject("name",name );
	mvc.addObject("age", myage);
	mvc.addObject("msg", msg);
	
	//포워드
	mvc.setViewName("process1");
	
	return mvc;
}
@PostMapping("data/read2")
public ModelAndView read2(@ModelAttribute FormDto dto) {
	
	ModelAndView model=new ModelAndView();
	
	model.addObject("dto", dto);
	
	model.setViewName("process2");
	
	return model;
}

@PostMapping("data/read3")
public ModelAndView read3(@RequestParam Map<String, String> map) { //키값은 무조건 String형태만 가능
	ModelAndView mvc=new ModelAndView();
	
	String sang=map.get("sang");
	String price=map.get("price");
	
	String data=sang+"의 가격은 "+price+"입니다.";
	
	mvc.addObject("data", data);
	
	mvc.setViewName("process3");
	
	
	return mvc;
}
}
