package spring.mvc.tea;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import model.data.dto.ShopDto;

@Controller
@RequestMapping("/naver") //servlet-context.xml bean에 등록
public class NaverController {
	
	@GetMapping("/form1")
	public String form1() {
		return "day1010/form1";
		
	}
	
	@PostMapping("/read1")
	public ModelAndView read1(
			@RequestParam String name, @RequestParam String gender,
			@RequestParam String addr) {
		
		ModelAndView model=new ModelAndView();
		
		//모델에 넣어주고
		model.addObject("name", name);
		model.addObject("gender", gender);
		model.addObject("addr", addr);
		
		//포워드
		model.setViewName("day1010/result1");
		
		
		return model;
	}
	
	@GetMapping("/form2")
	public String form2() {
		return "day1010/form2";
		
	}
	
	//@ModelAttribute : 폼의 데이터를 읽어서 dto에 넣고 model에 저장
	//단, model에는 ShopDto 타입일 경우 앞에만 소문자(shopDto)가 되어 자동 저장
	//만약 다른 이름 원하면 @ModelAttribute("이름")
	@PostMapping("/read2")
	public String read2(@ModelAttribute ShopDto dto) {
		 
		return "day1010/result2";
	}
	
	@GetMapping("/form3")
	public String form3() {
		return "day1010/form3";
	}
	
	@PostMapping("/read3")
	//폼태그의 name이 key값으로, 입력값은 value값으로...
	public ModelAndView read3(@RequestParam Map<String, String> map) {
		
		ModelAndView model=new ModelAndView();
		
		model.addObject("sang", map.get("sang"));
		model.addObject("color", map.get("color"));
		model.addObject("price", map.get("price"));
		model.addObject("image", map.get("image"));
		
		model.setViewName("day1010/result3");
		
		return model;
	}
	
	@GetMapping("/form4")
	public String form4() {
		
		return "upload/uploadform1";
	}
	
	@PostMapping("/upload1")
	public ModelAndView read1(@RequestParam String title,
			@RequestParam MultipartFile photo,
			HttpSession session) {
		
		ModelAndView model=new ModelAndView();
		
		//업로드할 실제경로 구하기
		String path=session.getServletContext().getRealPath("/WEB-INF/image");
		String fileName=photo.getOriginalFilename(); //업로드된 파일명
		
		//현재날짜와 시간 이용해서 파일명에 저장(동시에 여러사진 올려도 중복이 안되게 하기 위해)
		SimpleDateFormat sdf=new SimpleDateFormat("yyyymmddHHss");
		
		if(!fileName.equals("")) {
			fileName=sdf.format(new Date())+"_"+fileName;
			
			//path에 업로드
		      try {
		         photo.transferTo(new File(path+"\\"+fileName));
		      } catch (IllegalStateException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      } catch (IOException e) {
		         // TODO Auto-generated catch block
		         e.printStackTrace();
		      }
		}else {
			fileName="no"; //업로드 안했을 경우
		}

		model.addObject("fileName", fileName);
		model.addObject("title", title);
		model.addObject("path", path);
		
		model.setViewName("upload/uploadresult1");
		
		return model;
		
	}
	
	//여러개 업로드하는 폼으로 이동
	@GetMapping("/uploadform5")
	public String uploadform5() {
		
		return "upload/uploadform2";
	}
	
	//여러개 업로드에서 2번 결과창으로 이동
	@PostMapping("/upload2")
	public ModelAndView read2(@RequestParam String title,
			@RequestParam ArrayList<MultipartFile> photo,
			HttpSession session) {
		
		ModelAndView model=new ModelAndView();
		
		//업로드할 실제경로 구하기
		String path=session.getServletContext().getRealPath("/WEB-INF/image");
		
		//현재날짜와 시간 이용해서 파일명에 저장(동시에 여러사진 올려도 중복이 안되게 하기 위해)
		SimpleDateFormat sdf=new SimpleDateFormat("yyyymmddHHss");
		
		ArrayList<String> files=new ArrayList<String>();
		
		//파일명 담기
		for(MultipartFile f:photo) {
			String fileName=sdf.format(new Date())+"_"+f.getOriginalFilename();
			files.add(fileName);
			
			//업로드
			try {
				f.transferTo(new File(path+"\\"+fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addObject("files", files);
		model.addObject("title", title);
		model.addObject("path", path);
		
		model.setViewName("upload/uploadresult2");
		
		return model;
		
	}
	
}
