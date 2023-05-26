package com.kosta.openday.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

 
import com.kosta.openday.user.dto.UserDTO;
import com.kosta.openday.user.service.UserService;

@Controller
public class UserController {
 
	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;

	@RequestMapping("/")
	public String main() {
		return "main";
	}

	//회원가입폼
	@RequestMapping("/joinform")
	public String joinForm() {
		return "mypage/join";
	}

	//회원가입
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinUser(@ModelAttribute UserDTO user) throws Exception {
		try { 
			userService.joinUser(user); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "mypage/joinResult";
	}

	
	//마이페이지 (테스트용) 
	@RequestMapping(value = "/mypage", method=RequestMethod.GET)
	public ModelAndView myPayge() {
		ModelAndView mav = new ModelAndView();
		try {
//			String id = "sbsb";
//			session.setAttribute("id", id); 
//			UserDTO user = userService.getUserInfo(id); 
//			mav.addObject("user", user);
			mav.setViewName("mypage/myPage");
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return mav;
	}
	
	//프로필수정
	@RequestMapping(value = "/mypage/editprofile", method=RequestMethod.POST)
	public ModelAndView editProfile(HttpSession session,@RequestParam(value="file", required=false) MultipartFile file,
			@RequestParam(value="nickname", required=false) String nickname, @RequestParam(value="tel",required=false) String tel) {
		ModelAndView mav = new ModelAndView(); 
		try {
			String id = (String) session.getAttribute("id");
			userService.editUserProfile(id,nickname, tel,file);
		}catch(Exception e) {
			System.out.println("실패");
			e.printStackTrace();
		}
		return mav;
	}
	
//	//선호카테고리
//	@RequestMapping("/mypage/myprefer") 
//	public ModelAndView myPrefer() throws Exception{ 
//		ModelAndView mav = new ModelAndView();
//		try {
//			List<CodeDTO> list = userService.getCategoryList();
//			mav.addObject("cateNames",list);
//			mav.setViewName("mypage/myPreference");
//			  
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return mav;
//	}
	
	//찜한클래스
	@RequestMapping("/mypage/myheart")
	public String df() {
		return "mypage/heart";
	}
	
	//팔로우
	@RequestMapping("/mypage/myfollow")
	public String fddsf() {
		return "mypage/follow";
	}
	
	//예약결제내역
	@RequestMapping("/mypage/reservedrecord")
	public String fdsdf() {
		return "mypage/reservedRecord";	
	}
	
	
	//선호카테고리 수정하기
	@RequestMapping(value="/mypage/prefer",method=RequestMethod.POST)
	public ModelAndView preferUpload() {
		ModelAndView mav = new ModelAndView();
		try {
//			List<CategoryDTO> list = cateService.getCategoryList();
//			
//			List<String>
//			mav.addObject("cateNames",user);
//			mav.setViewName("redirect:/mypage/myPreference");
			//변경, 받아오고 리다이렉
			  
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	

}
