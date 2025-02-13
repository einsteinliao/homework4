package service.impl;

import java.util.List;

import dao.impl.MemberDaoImpl;
import model.Member;
import service.MemberService;

public class MemberServiceImpl implements MemberService{

	public static void main(String[] args) {
		System.out.println(new MemberServiceImpl().isLoginidExists("abcrrr"));
		System.out.println(new MemberServiceImpl().isLoginidExists("root"));

	}
	
	private static MemberDaoImpl memberdaoimpl=new MemberDaoImpl();

	@Override
	public void addMember(Member member) {
		memberdaoimpl.add(member);
		
	}

	@Override
	public Member Login(String loginid, String password) {
		/*
		 * 1.判斷member
		 * true-->Member物件
		 * false-->null
		 */
		Member member=null;
		List<Member> l=memberdaoimpl.selectLoginIdAndPassword(loginid, password);
		if(l.size()!=0)
		{
			member=l.get(0);
		}		
		
		return member;
	}

	
	@Override
	public boolean isLoginidExists(String loginid) {
		// TODO Auto-generated method stub
		return !memberdaoimpl.selectByLoginId(loginid).isEmpty();
	}

}
