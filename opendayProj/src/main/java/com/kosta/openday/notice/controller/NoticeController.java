package com.kosta.openday.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; 

@Controller
public class NoticeController {
	@RequestMapping(value = "/noticeList",method=RequestMethod.GET)
	public String noticeList() {
		return "notice/noticeList";
	}
	
}
