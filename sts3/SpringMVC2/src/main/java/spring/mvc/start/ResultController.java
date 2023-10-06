package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {
	
	//@GetMapping("/apple/list.do") //list뒤에 .do나 다른 확장자를 붙히면 다 호출됨(컨트롤러에 써준 mapping주소로만 찾아간다)
	@GetMapping("/apple/list")
	public String result1(Model model) { //model은 값을 저장해주기위한 용도
		
		model.addAttribute("myname", "장순영");
		model.addAttribute("height", "167");
		
		return "result1";
	}
	
	@GetMapping("/banana/insert")
	public ModelAndView banana() {
		//ModelAndView 는 request에 저장하기 위한 Model과 
		//포워드 하기위한 View를 합쳐놓은 클래스입니다.
		ModelAndView mview=new ModelAndView();
		
		//request에 저장
		mview.addObject("java", 88);
		mview.addObject("spring", 99);
		
		//포워드할 jsp파일 저장
		mview.setViewName("result2");
		
		
		return mview;
	}
	
	@GetMapping("/orange/delete")
	public ModelAndView orange() {
		
		ModelAndView mview2=new ModelAndView();
		
		mview2.addObject("sang", "아이패드");
		mview2.addObject("price", 2000000);
		mview2.addObject("color", "gray");
		
		mview2.setViewName("result3");
		
		return mview2;
	}
	
	@GetMapping("/shop/detail")
	public String resImage() {
		
		
		return "result4";
	}
	
	@GetMapping("/board/insert/data")
		public String resImage1() {
		
		return "result5";
	}
	
	
	
}
