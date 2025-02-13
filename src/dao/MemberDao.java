package dao;

import java.util.List;

import model.Member;

public interface MemberDao {
	//create
	void add(Member member);
	
	//read
	List<Member> selectAll();//select * from member
	List<Member> selectLoginIdAndPassword(String loginId,String password);//select * from member where loginId=? and password=?
	List<Member> selectById(int id);
	List<Member> selectByLoginId(String loginId);
	
	//update
	void update(Member member);
	
	//delete
	void delete(int id);
}
