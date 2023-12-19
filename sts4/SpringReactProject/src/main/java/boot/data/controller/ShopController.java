package boot.data.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import boot.data.dto.ShopDto;
import boot.data.service.ShopService;
import jakarta.servlet.http.HttpServletRequest;

@RestController //파일 내에서 이동할 곳이 없으므로
@CrossOrigin //각각의 서로 다른 도메인을 연결 (react: 3000번 Spring:9000번 이므로)
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	String photoname; //리액트에서 업로드 or 변경했을 때의 이미지명
	
	@PostMapping("/upload")
	public String fileUpload(@RequestParam MultipartFile uploadFile,
			HttpServletRequest request){
		
		//업로드 할 폴더 위치
		String path=request.getServletContext().getRealPath("/save");
		
		//파일명
		String fileName=uploadFile.getOriginalFilename();
		
		//파일명 변경
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		photoname=sdf.format(new Date())+"_"+fileName;
		
		System.out.println("fileName : "+ fileName + " ==> "+photoname);
		
		//save폴더에 업로드
		try {
			uploadFile.transferTo(new File(path+"\\"+photoname));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return photoname;
		
	}
	
	@PostMapping("/insert")
	public void insertShop(@RequestBody ShopDto dto) //RequestBody는 JSON으로 보낸 걸 자바클래스로 변환해야 하므로 
	{
		//업로드 한 사진
		dto.setPhoto(photoname);
		
		//insert
		shopService.insertShop(dto);
	}
	
	@GetMapping("/list")
	public List<ShopDto> list(){
		return shopService.getShopDatas();
	}
	
	@GetMapping("/detail")
	public ShopDto detail(@RequestParam int num) {
		return shopService.getData(num);
	}
	
	@DeleteMapping("/delete")
	public void deleteShop(@RequestParam int num,HttpServletRequest request) {
		
		//save경로 구하기
		String path=request.getServletContext().getRealPath("/save");
		
		//num에 해당하는 photo
		String photo=shopService.getData(num).getPhoto();
		
		//해당파일이 존재할경우 삭제
		File file=new File(path+"/"+photo);
		if(file.exists()) {
			file.delete();
		}
		
		//db삭제
		shopService.deleteShop(num);
		
		shopService.deleteShop(num);
	}
}
