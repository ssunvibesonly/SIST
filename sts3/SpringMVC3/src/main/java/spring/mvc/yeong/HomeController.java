package spring.mvc.yeong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String start() {
		
		return "start"; //==return "form" / redirect:��θ� ����� �ּ�â�� ��ΰ� �� ���´�.
	}
	
	@GetMapping("/login/form")
	public String form() {
		
		return "form";
	}
	
	@GetMapping("/login/read")
	public String process(Model model,@RequestParam String myid,
			@RequestParam(value = "mypass") String pass) { 
		//form�� �ִ� mypass�� ���⼱ pass�� ���ڴ�. 
		//��Ȯ�ϰԸ� ���شٸ� @RequestParam �����ϰ� String myid �̷������ε� ����
		
		model.addAttribute(myid, myid); //@RequestParam(value = "id") String id �̸� model.addAttribute("id", myid);
		String msg="";
		
		if(pass.equals("1234")) {
			msg="�α��� ����!";
		}else {
			msg="�α��� ����!";
		}
		
		model.addAttribute("msg", msg);
		
		
		return "result";
	}
}
