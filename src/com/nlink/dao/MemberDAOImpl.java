package com.nlink.dao;

import com.nlink.model.Member;
import com.nlink.model.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

import org.hibernate.Query;

public class MemberDAOImpl implements MemberDAO {

	Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public void AddMember(Member member) {
		// TODO Auto-generated method stub

		session.beginTransaction();

		session.save(member);

		session.getTransaction().commit();

	}

	@Override
	public  Member GetMember(Long member_id) {
		// TODO Auto-generated method stub

		session.beginTransaction();

		Member member = (Member) session.get(Member.class, member_id);

		session.getTransaction().commit();

		return member;
	}

	@Override
	public List<Member> GetMember(String email, String password) {

		password = MD5(password);

		// TODO Auto-generated method stub

		session.beginTransaction();

		Query query = session.createQuery("From Member where (member_email=:email and member_password=:password)");

		query.setParameter("email", email);

		query.setParameter("password", password);

		List<Member> member = query.list();

		session.getTransaction().commit();

		return member;
	}

	@Override
	public void DeleteMember(Long member_id) {
		// TODO Auto-generated method stub

		session.beginTransaction();

		Member member = (Member) session.get(Member.class, member_id);

		session.delete(member);

		session.getTransaction().commit();
	}

	@Override
	public void DeleteMember(Member member) {
		// TODO Auto-generated method stub
		session.beginTransaction();

		session.delete(member);

		session.getTransaction().commit();
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

	@Override
	public void UpdateMember(Member member) {
		// TODO Auto-generated method stub

		session.beginTransaction();

		session.update(member);

		session.getTransaction().commit();
	}

	@Override
	public List<Member> GetMember(String authstring) {
		// TODO Auto-generated method stub

		session.beginTransaction();

		Query query = session.createQuery("From Member where (authstring=:astring)");

		query.setParameter("astring", authstring);

 
		List<Member> member = query.list();

		session.getTransaction().commit();

		return member;
	}
}