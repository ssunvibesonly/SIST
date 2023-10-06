
package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //컨트롤러의 역할을 하는 곳에선 이제부터 component가 아닌 controller를 쓴다.
public class StartController {
	
	//start.jsp로 가기위한 메서드(포워드) 생성 / 단순하게 포워드를 시킬 땐 jsp 파일 이름만 있으면 되므로 String형태
	@GetMapping("/") //데이터를 단순하게 전송만 시킬거니까 getMapping
	public String start(Model model) {
		
		//Model: request에 데이터를 저장하기 위한 인터페이스
		//servlet에서 하던 request.setAttribute와 같다.
		model.addAttribute("name", "김영환");
		model.addAttribute("addr", "서울시 강남구");
		return "start"; //WEB-INF/day1005/start.jsp
	}
}
