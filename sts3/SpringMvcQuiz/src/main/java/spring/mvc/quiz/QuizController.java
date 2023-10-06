package spring.mvc.quiz;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.quiz.dto.QuizDto;

@Controller
public class QuizController {
	
	@GetMapping("/ilike/movie")
	public String start1() {
		return "form";
	};
	
	
	  @GetMapping("/ilike/read1") 
	  public String mtitle(Model model,
			  @RequestParam(value = "mtitle") String title ) {
	 
	  model.addAttribute("title", title);
	  
	  return "result1";
	  }
	  
	  @GetMapping("/school/myinfo")
	  public String start2() {
		  return "form";
	  }
	  
	  @GetMapping("/school/read2")
	  public ModelAndView school(String myname,String myschool,String mygrade,
			  @RequestParam (value = "myschooladdr") String addr) {
		  
		  ModelAndView model=new ModelAndView();
		  
		  model.addObject("name", myname);
		  model.addObject("school",myschool);
		  model.addObject("grade", mygrade);
		  model.addObject("addr", addr);
		  
		  model.setViewName("result2");
		  return model;
	  }
	 
	@GetMapping("/shop/ipgo")
	public String start3() {
		
		return "form";
	}
	
	@PostMapping("/shop/read3")
	public ModelAndView shop(@ModelAttribute QuizDto dto) {
		ModelAndView model=new ModelAndView();
		
		model.addObject("dto",dto);
		
		model.setViewName("result3");
		
		return model;
		
	}
	
	@GetMapping("/myshinsang")
	public String start4() {
		
		return "form";
	}
	
	@PostMapping("/read4")
	public ModelAndView shinsang(@RequestParam Map<String, String> map) {
		ModelAndView model=new ModelAndView();
		
		String name=map.get("name");
		String age=map.get("age");
		String blood=map.get("blood");
		String addr=map.get("addr");
		
		String msg="제 이름은"+name+"이고 나이는 "+age+"살 입니다.\n"+"혈액형은 "+blood+"이며 주소는 "+addr+"입니다.";
		
		model.addObject("msg", msg);
		
		model.setViewName("result4");
		
		return model;
		
	}
	
	
	
};
