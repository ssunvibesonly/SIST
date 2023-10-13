package spring.mysql.carmember;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarMemberController {

	@Autowired
	CarMemberDao inter;
	
	@GetMapping("/member/list")
	public String memberStart(Model model) {
		
		//갯수가져오기
		int count=inter.getTotalCount();
		List<CarMemberDto> list=inter.getAllSelect();
		
		model.addAttribute("count", count);
		model.addAttribute("list", list);
		
		return "/carmember/memberlist";
	}
	
	@GetMapping("/member/addform")
	public String memberAddform() {
		
		return "/carmember/addform";
	}
	
	@PostMapping("/member/memberadd")
	public String insertOfCarMem(@ModelAttribute("cdto") CarMemberDto dto) { //클래스 자료형일땐 @ModelAttribute 단일 객체, RequestGetParam
		inter.insertOfCarMem(dto);
		
		return "redirect:list";
	}
	
	@GetMapping("/member/delete")
	public String deleteOfCarMem(@RequestParam int num) {
		
		inter.delete(num);
		
		return "redirect:list";
	}
	
	@GetMapping("/member/updateform")
	public String getDataCarMem(Model model,@RequestParam int num) {
		
		CarMemberDto dto= inter.getData(num);
		model.addAttribute("dto", dto);
		
		return "/carmember/updateForm";
	}
	
	@PostMapping("/member/update")
	public String updateOfCarMem(@ModelAttribute CarMemberDto dto) {
		
		inter.updateOfCarMem(dto);
		
		
		return "redirect:list";
	}
	
}
