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
	public String insert(@ModelAttribute InfoDto dto, //��Ƽ��Ʈ �κ� ���� ������ ��
			@RequestParam MultipartFile upload,
			HttpSession session) { //HTTPSession�� realPath������ �ش�.
		
		String path=session.getServletContext().getRealPath("/resources/image");
		System.out.println(path);
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		String photo="";
		
		//���������� ������ ��� no..
		if(upload.getOriginalFilename().equals("")) {
			photo=null; //no�� �ְ� �ʹٸ�, photo='no'
		}else {
			String fName=upload.getOriginalFilename();
			fName=sdf.format(new Date())+"_"+fName;
			photo=fName;
			
			//���ε�
			try {
				upload.transferTo(new File(path+"/"+photo)); // /�� �� �� \\ �ι�, ��Ƽ��Ʈ���� �޾ƿ� ������ ������η� �ø��� �۾�
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		//dto�� photo�� �ֱ�
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
		
		//db����
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
		
		String photoname; //dto�� ���� ����
		
		//���� ���þ��Ұ�� null
		if(upload.getOriginalFilename().equals(""))
			photoname=null;
		else {
			photoname=upload.getOriginalFilename();
			photoname=sdf.format(new Date())+"_"+photoname;
			//���ε�
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
		
		//dto�� photo�� ���ε��� photoname �־��ֱ�
		dto.setPhoto(photoname);
		
		//update 
		dao.updateMyInfo(dto);
		
		return "redirect:list";
	}
}
