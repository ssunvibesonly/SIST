package spring.mvc.Friday;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class InfoController {
	
	@Autowired
	InfoDao dao;
	
	@GetMapping("/info/list")
	public String selectTotalCount(Model model) {
		
		List<InfoDto> list=dao.getAllInfos();
		
		int totalCount=dao.selectTotalCount();
		model.addAttribute("totalCount", totalCount);
		model.addAttribute("list", list);
		
		return "info/infolist";
	}
	
	@GetMapping("/info/writeform")
	public String addform() {
		return "/info/addform";
	}
	
	@PostMapping("/info/insert")
	public String insert(@ModelAttribute InfoDto dto, //멀티파트 부분 빼고 가져온 것
			@RequestParam MultipartFile upload,
			HttpSession session) { //HTTPSession은 realPath때문에 준다.
		
		String path=session.getServletContext().getRealPath("/resources/image");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		String photo="";
		
		//사진선택을 안했을 경우 no..
		if(upload.getOriginalFilename().equals("")) {
			photo=null; //no로 주고 싶다면, photo='no'
		}else {
			String fName=upload.getOriginalFilename();
			fName=sdf.format(new Date())+"_"+fName;
			photo=fName;
			
			//업로드
			try {
				upload.transferTo(new File(path+"/"+photo)); // /는 한 번 \\ 두번, 멀티파트에서 받아온 파일을 실제경로로 올리는 작업
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		//dto의 photo에 넣기
		dto.setPhoto(photo);
		
		//insert
		dao.insertMyInfo(dto);
		
		
		
		return "redirect:list";
	}
	
	@GetMapping("info/delete")
	public String delete(@RequestParam String num,HttpSession session) {
		
		String photo=dao.getData(num).getPhoto();
		
		if(photo!=null)
		{
			String path=session.getServletContext().getRealPath("/resources/image/");
			
			File file=new File(path+"\\"+photo);
			file.delete();
		}
		
		//db삭제
		dao.delete(num);
		
		return "redirect:list";
	}
	
	@GetMapping("info/uform")
	public String getData(Model model,@RequestParam String num) {
		
		InfoDto dto=dao.getData(num);
		model.addAttribute("dto", dto);
		
		return "info/updateform";
	}
	
	@PostMapping("/info/update")
	public String update(@ModelAttribute InfoDto dto,
			@RequestParam MultipartFile upload,
			HttpSession session) {
		
		String path=session.getServletContext().getRealPath("/resources/image");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		String photoname; //dto에 담을 변수
		
		//사진 선택안할경우 null
		if(upload.getOriginalFilename().equals(""))
			photoname=null;
		else {
			photoname=upload.getOriginalFilename();
			photoname=sdf.format(new Date())+"_"+photoname;
			//업로드
			try {
				upload.transferTo(new File(path+"\\"+photoname));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//dto의 photo에 업로드한 photoname 넣어주기
		dto.setPhoto(photoname);
		
		//update 
		dao.updateMyInfo(dto);
		
		return "redirect:list";
	}
}
