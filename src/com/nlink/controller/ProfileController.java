package com.nlink.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.nlink.dao.MemberDAOImpl;
import com.nlink.model.Member;

@Controller
public class ProfileController {

	@RequestMapping("/userprofile.html")
	public ModelAndView UserProfile(HttpServletRequest request) {

		MemberDAOImpl memberDAOImpl = new MemberDAOImpl();

		Member member = memberDAOImpl
				.GetMember(Long.parseLong(request.getSession().getAttribute("member_id").toString()));

		ModelAndView mv = new ModelAndView("profile/userprofile");

		mv.addObject("member", member);
		return mv;
	}

	@RequestMapping(value = "updateprofile.html", method = RequestMethod.POST)
	public void UpdateProfile(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("member_name") String member_name, @RequestParam("member_surname") String member_surname,
			@RequestParam("member_dob") String member_dob, @RequestParam("member_gender") String member_gender,

			@RequestParam("member_province_id") String member_province_id,
			@RequestParam("member_contact_no") String member_contact_no,
			@RequestParam("member_email") String member_email,
			@RequestParam("member_password") String member_password) {

		MemberDAOImpl memberDAOImpl = new MemberDAOImpl();

		Member member = memberDAOImpl
				.GetMember(Long.parseLong(request.getSession().getAttribute("member_id").toString()));

		member.setMember_name(member_name);
		
		member.setMember_surname(member_surname);

		member.setMember_dob(member_dob);
		
		member.setMember_gender(Integer.parseInt(member_gender));
		
		member.setMember_province_id(Integer.parseInt(member_province_id));

		member.setMember_contact_no(member_contact_no);

		member.setMember_email(member_email);

		memberDAOImpl.UpdateMember(member);
	}
}
