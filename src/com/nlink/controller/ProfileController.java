package com.nlink.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.nlink.dao.MemberDAOImpl;
import com.nlink.model.Member;
@Controller
public class ProfileController {

	
	@RequestMapping("/userprofile.html")
	public ModelAndView UserProfile(HttpServletRequest request) {
		
		MemberDAOImpl memberDAOImpl = new MemberDAOImpl();
		
		
		Member member = memberDAOImpl.GetMember(Long.parseLong(request.getSession().getAttribute("member_id").toString()));
		
		ModelAndView mv = new ModelAndView("profile/userprofile");
		
		mv.addObject("member", member);
		return mv;
	}
}
