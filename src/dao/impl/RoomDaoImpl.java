package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.RoomDao;
import model.Member;
import model.Room;
import util.DbConnection;

public class RoomDaoImpl implements RoomDao{

	private static Connection conn=DbConnection.getDbConnection();
	
	public static void main(String[] args) {
		List<Room> allroom= new RoomDaoImpl().selectAll();
		for (Room r : allroom) {
			System.out.println("id:"+ r.getId() + "\tname:"+r.getName() + "\t price:"+ r.getPrice());
		}
	}

	@Override
	public List<Room> selectAll() {
		String SQL = "select * from room";
		List<Room> allroom=new ArrayList<Room>();
		
		PreparedStatement preparedstatement;
		try {
			preparedstatement = conn.prepareStatement(SQL);
		
			ResultSet resultset=preparedstatement.executeQuery();

			while(resultset.next())
			{
				Room room=new Room();
				room.setId(resultset.getInt("id"));
				room.setName(resultset.getString("name"));
				room.setPrice(resultset.getInt("price"));

				allroom.add(room);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allroom;
	}

	@Override
	public List<Room> selectById(int id) {
		List<Room> allroom = new RoomDaoImpl().selectAll();
		List<Room> myroom = new ArrayList<Room>();
		for(Room room : allroom) {
			if( room.getId() == id) {
				myroom.add(room);
			}
		}
		return myroom;
	}

	@Override
	public List<Room> selectAvailable() {
		
		// 找出 room 有, 但 xorder 沒有的 房間
		String  SQL = "select * from room where id not in (select room_id from xorder)";
		List<Room> allroom=new ArrayList<Room>();
		
		PreparedStatement preparedstatement;
		try {
			preparedstatement = conn.prepareStatement(SQL);
		
			ResultSet resultset=preparedstatement.executeQuery();

			while(resultset.next())
			{
				Room room=new Room();
				room.setId(resultset.getInt("id"));
				room.setName(resultset.getString("name"));
				room.setPrice(resultset.getInt("price"));

				allroom.add(room);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allroom;
	}

}
