package service;

import model.Member;

public interface MemberService {
	void addMember(Member member);
	Member Login(String loginid,String password);
	boolean isLoginidExists(String loginid);
}
