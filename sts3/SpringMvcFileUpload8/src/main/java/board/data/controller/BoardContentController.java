package board.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.reboard.BoardDao;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardContentController {
	
	@Autowired //자동 주입 생성
	BoardDao dao;

	@GetMapping("board/content")
	public ModelAndView content(@RequestParam int num,@RequestParam int currentPage) {
		ModelAndView model=new ModelAndView();
		
		//조회수 증가
		dao.readCountOfReboard(num);
		//dto
		BoardDto dto=dao.getData(num);
		
		model.addObject("dto", dto);
		model.addObject("currentPage", currentPage); //currentPage가 있을 땐 무조건 넘겨줘야 한다.
		
		model.setViewName("reboard/content");
		return model;
	}

}
