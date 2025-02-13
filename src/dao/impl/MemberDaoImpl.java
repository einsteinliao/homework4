package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import model.Member;
import util.DbConnection;

public class MemberDaoImpl implements MemberDao {
	
	private static Connection conn=DbConnection.getDbConnection();

	public static void main(String[] args) {
		/*
		Member m = new Member("name001", "loginid001", "pass001", "add001", "phone001");
		new MemberDaoImpl().add(m);
		*/
		
		/*
		List<Member> allmember = new MemberDaoImpl().selectAll();
		for(Member member:allmember) {
			System.out.println(member.show());
		}
		*/
		
		List<Member> allmember = new MemberDaoImpl().selectLoginIdAndPassword("loginid001", "pass001");
		//List<Member> allmember = new MemberDaoImpl().selectLoginIdAndPassword("loginid001", "pass002");
		System.out.println("check id/passwd exists: "+ !allmember.isEmpty());
		for(Member member:allmember) {
			System.out.println(member.show());
		}
	}

	@Override
	public void add(Member member) {
		String sql = "insert into member (name, loginid, password, address, phone) values (?, ?, ?, ?, ?)";
		PreparedStatement preparedstatement;
		try {
			preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1,member.getName());
			preparedstatement.setString(2,member.getLoginId());
			preparedstatement.setString(3,member.getPassword());
			preparedstatement.setString(4,member.getAddress());
			preparedstatement.setString(5,member.getPhone());
			System.out.println("MemberDaoImpl - add - name : "+ member.getName());
			System.out.println("MemberDaoImpl - add - phone : "+ member.getPhone());
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Member> selectAll() {
		String SQL="select * from member";
		List<Member> allmember=new ArrayList<Member>();

		PreparedStatement preparedstatement;
		try {
			preparedstatement = conn.prepareStatement(SQL);

			ResultSet resultset=preparedstatement.executeQuery();

			while(resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setLoginId(resultset.getString("loginId"));
				m.setPassword(resultset.getString("password"));
				m.setAddress(resultset.getString("address"));
				m.setPhone(resultset.getString("phone"));


				allmember.add(m);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allmember;
	}

	@Override
	public List<Member> selectLoginIdAndPassword(String loginId, String password) {
		String sql="select * from member where loginId=? and password=?";
		List<Member> lst=new ArrayList<Member>();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, loginId);
			preparedstatement.setString(2, password);
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setLoginId(resultset.getString("loginId"));
				m.setPassword(resultset.getString("password"));
				m.setAddress(resultset.getString("address"));
				m.setPhone(resultset.getString("phone"));
				
				lst.add(m);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return lst;
	}

	@Override
	public List<Member> selectById(int id) {
		String sql="select * from member where id=?";
		List<Member> lst=new ArrayList<Member>();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);			
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setLoginId(resultset.getString("loginId"));
				m.setPassword(resultset.getString("password"));
				m.setAddress(resultset.getString("address"));
				m.setPhone(resultset.getString("phone"));
				
				
				lst.add(m);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return lst;
	}

	@Override
	public List<Member> selectByLoginId(String loginId) {
String sql="select * from member where LoginId=?";
		
		List<Member> lst=new ArrayList<Member>();
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1, loginId);			
			
			ResultSet resultset=preparedstatement.executeQuery();
			
			if(resultset.next())
			{
				Member m=new Member();
				m.setId(resultset.getInt("id"));
				m.setName(resultset.getString("name"));
				m.setLoginId(resultset.getString("loginId"));
				m.setPassword(resultset.getString("password"));
				m.setAddress(resultset.getString("address"));
				m.setPhone(resultset.getString("phone"));
				
				
				lst.add(m);
			}
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return lst;
	}

	@Override
	public void update(Member member) {
		String sql="update member set name=?,password=?,address=?,phone=? where id=?";
		
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setString(1,member.getName());
			preparedstatement.setString(2,member.getPassword());
			preparedstatement.setString(3,member.getAddress());
			preparedstatement.setString(4,member.getPhone());
			preparedstatement.setInt(5,member.getId());
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void delete(int id) {
		String sql="delete from member where id=?";
		try {
			PreparedStatement preparedstatement=conn.prepareStatement(sql);
			preparedstatement.setInt(1, id);
			
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
