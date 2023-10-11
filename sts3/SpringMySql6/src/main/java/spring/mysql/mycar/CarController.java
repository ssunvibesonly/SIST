package spring.mysql.mycar;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller //�� ���
public class CarController {
	
	@Autowired
	MyCarDao dao;
	
	@GetMapping("/kakao/list")
	public String list(Model model) {
		
		//dao�κ��� �� ���� ��������
		int totalCount=dao.getTotalCount();
		
		//��� ��������
		List<MyCarDto> list=dao.getAllCars();
		
		//request�� ����
		model.addAttribute("totalCount",totalCount);
		model.addAttribute("list",list);
		
		return "car/carlist";
		
	}
	
	@GetMapping("kakao/writeform")
	public String writeform() {
		
		return "car/mywriteform";
	}
	
	@PostMapping("kakao/write")
	public String insertMyCar(@ModelAttribute MyCarDto dto) {
		
		dao.insertCar(dto);		
				
		return "redirect:list";
	}
	
	@GetMapping("/kakao/delete")
	public String delete(@RequestParam String num) {
		
		dao.deleteOfMyCar(num);
		
		return "redirect:list";
		
	}
	
	
	@GetMapping("/kakao/updateform")
	public String getData(Model model,@RequestParam String num) {
		
		MyCarDto mdto=dao.getData(num);
		model.addAttribute("mdto", mdto);
		
		
		return "car/updateForm";
	}
	
	@PostMapping("/kakao/update")
	public String update(MyCarDto dto) {
		
		dao.updateMyCar(dto);
		
		return "redirect:list";
	}
	
	
}
