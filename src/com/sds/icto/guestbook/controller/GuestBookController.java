package com.sds.icto.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sds.icto.guestbook.dao.GuestbookDao;
import com.sds.icto.guestbook.vo.guestbookVo;


@Controller
public class GuestBookController {
	@Autowired  //spring에 emaillisdao 객체 생성
	GuestbookDao guestbookDao;
	
	@RequestMapping("/index")
	public String index(Model model) {
		List<guestbookVo> list = guestbookDao.fetchList();
		model.addAttribute("list",list);
		return "index";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteform(@RequestParam int no){
		
		return "deleteform";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(@RequestParam int no,
			@RequestParam String pwd){
		
		guestbookDao.delete(no,pwd);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String insert(@RequestParam("name") String id,
			@RequestParam String pwd,
			@RequestParam String meg){
		
		guestbookVo vo=new guestbookVo();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setMeg(meg);
		
		
		guestbookDao.insert(vo);
		return "redirect:/index";
	}
}
