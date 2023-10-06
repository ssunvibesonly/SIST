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

//myforms�� ������ ������ �� ��!
@GetMapping("/data/myform")
public String start() {
	
	return "myforms";
}

//read1_get����� ����

@GetMapping("data/read1")
public ModelAndView read1(@RequestParam(value = "myname")String name,
		int myage,@RequestParam(value = "msg",defaultValue = "HappyDay!!!!") String msg) { //���� ������ ���� ����ϰ���� �� defaultValue
	
	ModelAndView mvc=new ModelAndView();
	
	//Request�� ����
	mvc.addObject("name",name );
	mvc.addObject("age", myage);
	mvc.addObject("msg", msg);
	
	//������
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
public ModelAndView read3(@RequestParam Map<String, String> map) { //Ű���� ������ String���¸� ����
	ModelAndView mvc=new ModelAndView();
	
	String sang=map.get("sang");
	String price=map.get("price");
	
	String data=sang+"�� ������ "+price+"�Դϴ�.";
	
	mvc.addObject("data", data);
	
	mvc.setViewName("process3");
	
	
	return mvc;
}
}
