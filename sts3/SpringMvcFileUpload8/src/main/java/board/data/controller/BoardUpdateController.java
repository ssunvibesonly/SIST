package board.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.reboard.BoardDao;
import spring.mvc.reboard.BoardDto;

@Controller
public class BoardUpdateController {

	@Autowired
	BoardDao dao;
	
	@GetMapping("/board/updatepassfom")
	public ModelAndView upPassForm(@RequestParam String num,
			@RequestParam String currentPage) {
		
		ModelAndView model=new ModelAndView();
		
		model.addObject("num", num);
		model.addObject("currentPage", currentPage);
		
		model.setViewName("reboard/updatepassfom");
	
		return model;
	}
	
	@PostMapping("board/updatepass")
	public ModelAndView updatePass(@RequestParam int num,
			@RequestParam int pass,@RequestParam int currentPage) {
		
		ModelAndView model=new ModelAndView();
		BoardDto dto=new BoardDto();
		
		dto=dao.getData(num);
		
		 //����� ������ ����������, Ʋ���� passfail��
		int check=dao.getCheckPass(num, pass);
		
		if(check==1) {
			model.addObject("dto", dto);
			model.addObject("currentPage", currentPage);
			model.setViewName("reboard/updateform");
			
		}else { //0
			model.setViewName("reboard/passfail");
		}
		
		return model;
	}
	
	@PostMapping("/board/update")
	public String update(@ModelAttribute BoardDto dto,
			@RequestParam int num,
			@RequestParam int currentPage,
			@RequestParam ArrayList<MultipartFile> uimage,
			HttpSession session) {
		
		
		String path=session.getServletContext().getRealPath("/WEB-INF/photo/");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHss");
		
		String photoname=""; // dto�� ���� ����
		
		
		//photo�� �ִµ� �ٽ� ���� ���Ұ��(no�ϰ��)
		if(uimage.get(0).getOriginalFilename().equals("")) { //get(0)�� �̹��� ������ �־��� �� ù���� ���� 
			photoname=null; //mybatis���� �Ѿ��
		}else {
			
			//���� ���� �������� �����
			String pre_photo=dao.getData(num).getPhoto();
			
			String [] pre_fName=pre_photo.split(",");
			
			for(String f:pre_fName) {
				File file=new File(path+"\\"+f);
				file.delete();
			}
			
			for(MultipartFile f:uimage) {
				
				String fName=sdf.format(new Date())+"_"+f.getOriginalFilename(); 
				photoname+=fName+",";
				
				try {
					f.transferTo(new File(path+"\\"+fName));
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			photoname=photoname.substring(0, photoname.length()-1);
			 
		}
		
		
		//dto�� photo�� ���ε��� photoname �־��ֱ�
		dto.setPhoto(photoname);
		
		//update
		dao.update(dto);
		
		return "redirect:content?num="+num+"&currentPage="+currentPage;
	}
	
}
