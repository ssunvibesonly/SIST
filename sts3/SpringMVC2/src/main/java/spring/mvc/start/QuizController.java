package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuizController {

	@GetMapping("/happy")
	public String selectImage() {

		return "quiz1";
	}
	
	@GetMapping("/hello")
	public ModelAndView msg() {
		ModelAndView mvc1=new ModelAndView();
		
		mvc1.addObject("name", "장순영");
		mvc1.addObject("age","28"); 
		
		mvc1.setViewName("quiz2");
	
		return mvc1;
		
	}
	
	@GetMapping("/happy.do")
	public String msg2(Model model) {
		
		model.addAttribute("name", "장순영");
		model.addAttribute("age", "28");
		
		return "msg2";
	}
	
	@GetMapping("nice/hi")
	public ModelAndView myInfo() {
		
		ModelAndView mvc2=new ModelAndView();
		
		mvc2.addObject("name", "장순영");
		mvc2.addObject("age", "28");
		mvc2.addObject("addr", "경기도 수원시");
		
		return mvc2;
	}
}
