package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import model.Member;
import model.Order;
import util.DbConnection;

public class OrderDaoImpl implements OrderDao {

	private static Connection conn=DbConnection.getDbConnection();
	
	public static void main(String[] args) {
		Order order = new Order(1,1,1000);
		new OrderDaoImpl().add(order);

	}

	@Override
	public void add(Order order) {
		String SQL = "Insert Into xorder (member_id, room_id, price) values (?,?,?)";
		PreparedStatement preparedstatement;
		
		try {
			preparedstatement = conn.prepareStatement(SQL);

			preparedstatement.setInt(1, order.getMember_id());
			preparedstatement.setInt(2, order.getRoom_id());
			preparedstatement.setInt(3, order.getPrice());
			System.out.println("OrderDaoImpl - add - member_id : "+ order.getMember_id());
			System.out.println("OrderDaoImpl - add - room_id : "+ order.getRoom_id());
			System.out.println("OrderDaoImpl - add - price: "+ order.getPrice());
			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Order> selectAll() {
		String SQL = "select * from xorder";
		List<Order> allorder=new ArrayList<Order>();

		PreparedStatement preparedstatement;

		try {
			preparedstatement = conn.prepareStatement(SQL);


			ResultSet resultset=preparedstatement.executeQuery();

			while(resultset.next())
			{
				Order order=new Order();
				order.setId(resultset.getInt("id"));
				order.setMember_id(resultset.getInt("member_id"));
				order.setRoom_id(resultset.getInt("room_id"));
				order.setPrice(resultset.getInt("price"));

				allorder.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allorder;
	}

	@Override
	public List<Order> selectByMember(Integer loginId) {
		String SQL = "select * from xorder where member_id = ?";
		List<Order> allorder=new ArrayList<Order>();

		PreparedStatement preparedstatement;

		try {
			preparedstatement = conn.prepareStatement(SQL);
			preparedstatement.setInt(1, loginId);

			ResultSet resultset=preparedstatement.executeQuery();

			while(resultset.next())
			{
				Order order=new Order();
				order.setId(resultset.getInt("id"));
				order.setMember_id(resultset.getInt("member_id"));
				order.setRoom_id(resultset.getInt("room_id"));
				order.setPrice(resultset.getInt("price"));

				allorder.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allorder;
	}

	@Override
	public void update(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		String SQL = "delete from xorder where id = ?";
		PreparedStatement preparedstatement;
		
		try {
			preparedstatement = conn.prepareStatement(SQL);
			
			preparedstatement.setInt(1, id);

			preparedstatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
