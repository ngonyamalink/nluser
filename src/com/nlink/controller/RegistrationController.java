package com.nlink.controller;

import java.io.IOException;

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
public class RegistrationController {

	@RequestMapping("/registrationform")
	public ModelAndView UserProfile(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("registration/registrationform");
		return mv;
	}

	@RequestMapping(value = "registrationformaction.html", method = RequestMethod.POST)
	public void RegistrationFormAction(HttpServletRequest request,HttpServletResponse response, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("email") String email,
			@RequestParam("password") String password) throws IOException {

		// set member information
		Member member = new Member();

		member.setMember_name(firstname);
		member.setMember_surname(lastname);
		member.setMember_email(email);
		member.setCountry_id(101);
		member.setMember_province_id(1);
		member.setActive(1);
		member.setMember_password(MD5(password));

		// add-insert member details
		MemberDAOImpl memberDAOImpl = new MemberDAOImpl();
		memberDAOImpl.AddMember(member);

		response.sendRedirect("registered");
	}

	@RequestMapping("/registered.html")
	public ModelAndView Registered(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("registration/registered");
		return mv;
	}

	public String MD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}

}
