package board.data.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;

import spring.mvc.reboard.BoardDao;

@Controller
public class BoardDeleteController {

	@Autowired
	BoardDao dao;
	
	@GetMapping("/board/deletepassform")
	public ModelAndView delPassForm(
			@RequestParam String num,
			@RequestParam String currentPage) {
		
		ModelAndView model=new ModelAndView();
		
		model.addObject("num", num);
		model.addObject("currentPage", currentPage);
		
		model.setViewName("reboard/deletepassform");
	
		return model;
	}
	
	@PostMapping("/board/delepass")
	public String delete(@RequestParam int num,
			@RequestParam int currentPage,@RequestParam int pass,HttpSession session) {
		
		int check=dao.getCheckPass(num, pass);
		
		if(check==1) {
			String photo=dao.getData(num).getPhoto();
			if(!photo.equals("no")) {
				
				String [] fName=photo.split(",");
				String path=session.getServletContext().getRealPath("/WEB-INF/photo/");
				
				for(String f:fName) {
					File file=new File(path+"\\"+f);
					file.delete();
				}
			}
			dao.delete(num);
			return "redirect:list?currentPage="+currentPage;
		}else {
			return "reboard/passfail";
		}

	}
}
