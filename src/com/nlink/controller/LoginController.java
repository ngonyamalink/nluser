package com.nlink.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.nlink.dao.MemberDAOImpl;
import com.nlink.model.Member;

@Controller
public class LoginController {
	@RequestMapping("/loginform.html")
	public ModelAndView LoginForm(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("login/loginform");
		return mv;
	}

	@RequestMapping(value = "loginformaction.html", method = RequestMethod.POST)
	public void LoginFormAction(HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value = "username") String username, @RequestParam("password") String password)
			throws IOException {

		boolean authenticated = false;

		MemberDAOImpl memberDAOImpl = new MemberDAOImpl();
		List<Member> member = memberDAOImpl.GetMember(username, password);

		for (Member m : member) {

			// load session

			request.getSession().setAttribute("member_id", m.getMember_id());

			request.getSession().setAttribute("member_name", m.getMember_name());

			request.getSession().setAttribute("member_surname", m.getMember_surname());

			request.getSession().setAttribute("member_dob", m.getMember_dob());

			request.getSession().setAttribute("member_gender", m.getMember_gender());

			request.getSession().setAttribute("country_id", m.getCountry_id());

			request.getSession().setAttribute("member_province_id", m.getMember_province_id());

			request.getSession().setAttribute("member_location", m.getMember_location());

			request.getSession().setAttribute("member_contact_no", m.getMember_contact_no());

			request.getSession().setAttribute("member_email", m.getMember_email());

			request.getSession().setAttribute("member_password", m.getMember_password());

			request.getSession().setAttribute("member_date_added", m.getMember_date_added());

			request.getSession().setAttribute("active", m.getActive());

			request.getSession().setAttribute("activation_code", m.getActivation_code());

			request.getSession().setAttribute("usercategory_id", m.getUsercategory_id());

			// set auth string

			memberDAOImpl = new MemberDAOImpl();
			Member member_record = memberDAOImpl.GetMember(m.getMember_id());
			member_record.setAuthstring(request.getSession().getId());
			memberDAOImpl.UpdateMember(member_record);

			authenticated = true;

		}

		if (authenticated) {
			response.sendRedirect("userdata.html?authstring=" + request.getSession().getId());
		} else {
			response.sendRedirect("loginform.html");
		}
	}

	@RequestMapping(value = "userdata.html", method = RequestMethod.GET)
	public ModelAndView UserData(HttpServletRequest request, @RequestParam("authstring") String authstring) {

		MemberDAOImpl memberDAOImpl = new MemberDAOImpl();

		List<Member> member = memberDAOImpl.GetMember(authstring);

		String javaObjectString = null;
		for (Member m : member) {

			// load session

			request.getSession().setAttribute("member_id", m.getMember_id());

			request.getSession().setAttribute("member_name", m.getMember_name());

			request.getSession().setAttribute("member_surname", m.getMember_surname());

			request.getSession().setAttribute("member_dob", m.getMember_dob());

			request.getSession().setAttribute("member_gender", m.getMember_gender());

			request.getSession().setAttribute("country_id", m.getCountry_id());

			request.getSession().setAttribute("member_province_id", m.getMember_province_id());

			request.getSession().setAttribute("member_location", m.getMember_location());

			request.getSession().setAttribute("member_contact_no", m.getMember_contact_no());

			request.getSession().setAttribute("member_email", m.getMember_email());

			request.getSession().setAttribute("member_password", m.getMember_password());

			request.getSession().setAttribute("member_date_added", m.getMember_date_added());

			request.getSession().setAttribute("active", m.getActive());

			request.getSession().setAttribute("activation_code", m.getActivation_code());

			request.getSession().setAttribute("usercategory_id", m.getUsercategory_id());

			// print json

			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd' 'HH:mm:ss").create();

			JsonElement jsonElement = gson.toJsonTree(m);

			JsonObject jsonObject = (JsonObject) jsonElement;
			jsonObject.remove("property");
			javaObjectString = jsonObject.toString();

			System.out.println(javaObjectString);

		}

		ModelAndView mv = new ModelAndView("userdata/userdata");
		mv.addObject("authstring", authstring);
		mv.addObject("userdata", javaObjectString);
		return mv;
	}

	@RequestMapping("logout.html")

	public void LogOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		

		MemberDAOImpl memberDAOImpl = new MemberDAOImpl();

		Member member = memberDAOImpl
				.GetMember(Long.parseLong(request.getSession().getAttribute("member_id").toString()));
		
		member.setAuthstring(null);
		
		memberDAOImpl.UpdateMember(member);
		
		request.getSession().invalidate();
		
		response.sendRedirect("loginform.html");
	}

}
