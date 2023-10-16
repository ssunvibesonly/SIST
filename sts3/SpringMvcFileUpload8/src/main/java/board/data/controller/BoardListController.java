package board.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.reboard.BoardDao;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardListController {
	
	/*
	 * @GetMapping("board/list") public String boardlist() {
	 * 
	 * return "reboard/boardlist"; }
	 */
	
	@Autowired
	BoardDao dao;
	
	@GetMapping("board/list")
	public ModelAndView boardlist(@RequestParam(value = "currengPage",defaultValue = "1") int currentPage){
		
		ModelAndView model=new ModelAndView();

		int totalCount=dao.getTotalCount();
		
		//페이징 처리에 필요한 변수 선언
		int totalPage; //총 페이지 수
		int startPage; //각 블럭에서 보여질 시작 페이지
		int endPage; //각 블럭에서 보여질 끝 페이지
		int startNum; //db에서 가져올 글의 시작 번호 (mysql은 첫글이 0, oracle은 첫글이 1)
		int perPage=3; //한 페이지당 보여질 글의 갯수
		int perBlock=5; //한 블럭당 보여질 페이지 갯수

		   
		  //총 페이지수 구하기
		  //총 글의 갯수/한 페이지당 보여질 갯수로 나눔(7/5=1)
		  //나머지가 1이라도 있으면 무조건 +1페이지(1+1=2페이지가 필요)
			totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);

		  //각 블럭당 보여야 할 시작페이지
		  //perBlock=5일 경우는 현재페이지 1~5 시작:1 끝:5
		  //현재페이지 13 시작:11 끝:15
			startPage=(currentPage-1)/perBlock*perBlock+1;
		   
			endPage=startPage+perBlock-1;
		  
		   //총 페이지가 23일 경우 마지막 블럭은 25가 아니라 23이다
		    if(endPage>totalPage)
		      	endPage=totalPage;
			
		   //각 페이지에서 보여질 시작 번호
		   //1페이지: 0, 2페이지:5, 3페이지:10...		   
		   startNum=(currentPage-1)*perPage;

		   //각페이지에서 필요한 게시긃 가져오기
		   List<BoardDto> list=dao.getPagingList(startNum, perPage);
		   
		   //각 페이지에 출력할 시작번호
		   int no=totalCount+(currentPage-1)*perPage;
		
		model.addObject("totalCount", totalCount);
		model.addObject("list", list);
		model.addObject("startPage", startPage);
		model.addObject("endPage", endPage);
		model.addObject("totalPage", totalPage);
		model.addObject("no", no);
		model.addObject("currentPage", currentPage);
		
		model.setViewName("reboard/boardlist");
		
		return model;
	}
	
}
