package boot.data.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import boot.data.dto.MemberDto;
import boot.data.service.MemberService;

@RestController //ajax용 controller로 만듦
public class RestLoginController {

	@Autowired
	MemberService service;
	
	@GetMapping("/member/login")
	public Map<String, String> loginprocess(String id,String pass,HttpSession session)
	{
		Map<String, String> map=new HashMap<>();
		
		int result=service.loginPassCheck(id, pass);
		
		if(result==1)
		{
			//session은 저장하고 싶은 만큼 저장
			session.setMaxInactiveInterval(60*60*4);
			session.setAttribute("loginok", "yes");
			session.setAttribute("myid", id);
			
			MemberDto mdto=service.getDataById(id);
			
			session.setAttribute("loginphoto", mdto.getPhoto());
			session.setAttribute("loginname", mdto.getName());
		}
		
		map.put("result", result==1?"success":"fail");
		
		return map;
	}
	
	@GetMapping("/member/logout")
	public void logout(HttpSession session)
	{
		session.removeAttribute("loginok");
		session.removeAttribute("myid");
	}
}
