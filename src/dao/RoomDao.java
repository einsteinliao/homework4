package dao;

import java.util.List;

import model.Room;

public interface RoomDao {

	List<Room> selectAll();
	List<Room> selectById(int id);
	
	List<Room> selectAvailable();
}
