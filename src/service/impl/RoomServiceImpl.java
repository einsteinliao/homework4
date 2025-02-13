package service.impl;

import java.util.List;

import dao.impl.RoomDaoImpl;
import model.Member;
import model.Room;
import service.RoomService;

public class RoomServiceImpl implements RoomService{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Room> getAllRoom() {
		List<Room> allroom= new RoomDaoImpl().selectAll();
		/*for (Room r : allroom) {
			System.out.println("id:"+ r.getId() + "\tname:"+r.getName() + "\t price:"+ r.getPrice());
		}*/
		return allroom;
	}

	@Override
	public List<Room> getAvailable() {
		List<Room> allroom= new RoomDaoImpl().selectAvailable();
		return allroom;
	}





}
