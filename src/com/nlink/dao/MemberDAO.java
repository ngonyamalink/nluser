package com.nlink.dao;

import java.util.List;

import com.nlink.model.Member;

public interface MemberDAO {

	public void AddMember(Member member);

	public  Member GetMember(Long member_id);
	
	public  List<Member> GetMember(String authstring);

	public List<Member> GetMember(String email, String password);
	
	public void DeleteMember(Long member_id);

	public void DeleteMember(Member member);
	
	public void UpdateMember(Member member);
}
