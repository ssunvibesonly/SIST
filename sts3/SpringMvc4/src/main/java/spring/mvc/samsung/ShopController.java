package spring.mvc.samsung;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.data.dto.ShopDto;

@Controller
public class ShopController {
	
	@GetMapping("/shop/list")
	public String result3() {
		
		return "shop/list";
	}
	
	@GetMapping("/shop/form2")
	public String shopresult1() {
		return "shop/shopForm";
		
	}
	
	@PostMapping("/shop/process2")
	public String process2(@ModelAttribute ShopDto dto)
	//public String process2(@ModelAttribute("dto") ShopDto dto) -> dto.으로 출력 가능
	{ //넘겨야 될 것이 있을 땐 일반적으로 modelandview를 사용하고, 그러기 싫다면 model로 parameter값을 하나씩 넘겨줌
		
		
		return "shop/shopResult";
		
	}
	
	@GetMapping("shop/form3")
	public String shopresult2() {
		
		return "shop/mapForm";
	}
	
	@PostMapping("shop/process3")
	public ModelAndView process3(@RequestParam Map<String, String> map) {
		ModelAndView model=new ModelAndView();
		
		String sname=map.get("sname");
		String java=map.get("java");
		String spring=map.get("spring");
		String jquery=map.get("jquery");
		
		model.addObject("sname",sname); //model.addObject("name",map.get("sname"))
		model.addObject("java", java);
		model.addObject("spring",spring);
		model.addObject("jquery", jquery);
		
		model.setViewName("shop/mapResult");
		
		return model;
		
	}
}
