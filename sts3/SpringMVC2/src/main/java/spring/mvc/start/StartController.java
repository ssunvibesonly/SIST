
package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //��Ʈ�ѷ��� ������ �ϴ� ������ �������� component�� �ƴ� controller�� ����.
public class StartController {
	
	//start.jsp�� �������� �޼���(������) ���� / �ܼ��ϰ� �����带 ��ų �� jsp ���� �̸��� ������ �ǹǷ� String����
	@GetMapping("/") //�����͸� �ܼ��ϰ� ���۸� ��ų�Ŵϱ� getMapping
	public String start(Model model) {
		
		//Model: request�� �����͸� �����ϱ� ���� �������̽�
		//servlet���� �ϴ� request.setAttribute�� ����.
		model.addAttribute("name", "�迵ȯ");
		model.addAttribute("addr", "����� ������");
		return "start"; //WEB-INF/day1005/start.jsp
	}
}
