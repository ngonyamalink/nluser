package com.nlink.model;

import javax.persistence.Table;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "Member")
public class Member {

	
	@Id
	@Column(name="member_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long member_id;
	
	private String member_name;
	private String member_surname;
	private String member_dob;
	private int member_gender;
	private int country_id;
	private int member_province_id;
	private String member_location;
	private String member_contact_no;
	private String member_email;
	private String member_password;
	private Date member_date_added;
	private int active;
	private String activation_code;
	private String profile_pic_url;
	private int usercategory_id;
	
	private String authstring;

	
	
	
	public Long getMember_id() {
		return member_id;
	}

	public void setMember_id(Long member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getMember_surname() {
		return member_surname;
	}

	public void setMember_surname(String member_surname) {
		this.member_surname = member_surname;
	}

	public String getMember_dob() {
		return member_dob;
	}

	public void setMember_dob(String member_dob) {
		this.member_dob = member_dob;
	}

	public int getMember_gender() {
		return member_gender;
	}

	public void setMember_gender(int member_gender) {
		this.member_gender = member_gender;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public int getMember_province_id() {
		return member_province_id;
	}

	public void setMember_province_id(int member_province_id) {
		this.member_province_id = member_province_id;
	}

	public String getMember_location() {
		return member_location;
	}

	public void setMember_location(String member_location) {
		this.member_location = member_location;
	}

	public String getMember_contact_no() {
		return member_contact_no;
	}

	public void setMember_contact_no(String member_contact_no) {
		this.member_contact_no = member_contact_no;
	}

	public String getMember_email() {
		return member_email;
	}

	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}

	public String getMember_password() {
		return member_password;
	}

	public void setMember_password(String member_password) {
		this.member_password = member_password;
	}

	public Date getMember_date_added() {
		return member_date_added;
	}

	public void setMember_date_added(Date member_date_added) {
		this.member_date_added = member_date_added;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getActivation_code() {
		return activation_code;
	}

	public void setActivation_code(String activation_code) {
		this.activation_code = activation_code;
	}

	public String getProfile_pic_url() {
		return profile_pic_url;
	}

	public void setProfile_pic_url(String profile_pic_url) {
		this.profile_pic_url = profile_pic_url;
	}

	public int getUsercategory_id() {
		return usercategory_id;
	}

	public void setUsercategory_id(int usercategory_id) {
		this.usercategory_id = usercategory_id;
	}
	
    public String getAuthstring() {
        return authstring;
    }

    public void setAuthstring(String authstring) {
        this.authstring = authstring;
    }
}
