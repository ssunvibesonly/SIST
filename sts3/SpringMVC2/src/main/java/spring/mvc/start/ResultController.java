package spring.mvc.start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {
	
	//@GetMapping("/apple/list.do") //list�ڿ� .do�� �ٸ� Ȯ���ڸ� ������ �� ȣ���(��Ʈ�ѷ��� ���� mapping�ּҷθ� ã�ư���)
	@GetMapping("/apple/list")
	public String result1(Model model) { //model�� ���� �������ֱ����� �뵵
		
		model.addAttribute("myname", "�����");
		model.addAttribute("height", "167");
		
		return "result1";
	}
	
	@GetMapping("/banana/insert")
	public ModelAndView banana() {
		//ModelAndView �� request�� �����ϱ� ���� Model�� 
		//������ �ϱ����� View�� ���ĳ��� Ŭ�����Դϴ�.
		ModelAndView mview=new ModelAndView();
		
		//request�� ����
		mview.addObject("java", 88);
		mview.addObject("spring", 99);
		
		//�������� jsp���� ����
		mview.setViewName("result2");
		
		
		return mview;
	}
	
	@GetMapping("/orange/delete")
	public ModelAndView orange() {
		
		ModelAndView mview2=new ModelAndView();
		
		mview2.addObject("sang", "�����е�");
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
