package service;

import java.util.List;

import model.Member;
import model.Room;

public interface RoomService {
	
	List<Room> getAllRoom();
	List<Room> getAvailable();

	
}
