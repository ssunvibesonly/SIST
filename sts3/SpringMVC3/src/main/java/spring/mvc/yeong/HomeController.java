package spring.mvc.yeong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String start() {
		
		return "start"; //==return "form" / redirect:경로를 써줘야 주소창에 경로가 다 나온다.
	}
	
	@GetMapping("/login/form")
	public String form() {
		
		return "form";
	}
	
	@GetMapping("/login/read")
	public String process(Model model,@RequestParam String myid,
			@RequestParam(value = "mypass") String pass) { 
		//form에 있는 mypass를 여기선 pass로 쓰겠다. 
		//명확하게만 써준다면 @RequestParam 생략하고 String myid 이런식으로도 가능
		
		model.addAttribute(myid, myid); //@RequestParam(value = "id") String id 이면 model.addAttribute("id", myid);
		String msg="";
		
		if(pass.equals("1234")) {
			msg="로그인 성공!";
		}else {
			msg="로그인 실패!";
		}
		
		model.addAttribute("msg", msg);
		
		
		return "result";
	}
}
