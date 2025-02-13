package util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

import controller.AddMemberErrorUI;
import controller.AddMemberSuccessUI;
import controller.AddMemberUI;
import controller.AddOrderUI;
import controller.LoginErrorUI;
import controller.LoginSuccessUI;
import controller.MenuUI;
import controller.OrderListUI;
import dao.impl.MemberDaoImpl;
import dao.impl.RoomDaoImpl;
import model.Member;
import model.Order;
import model.Room;
import service.impl.RoomServiceImpl;


public class Tool extends JFrame{
	public static void save(Object s,String filename)
	{
		
		try {
			
			FileOutputStream fos=new FileOutputStream(filename);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			
			oos.writeObject(s);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Object read(String filename)
	{
		Object o=null;
		
		try {
			FileInputStream fis=new FileInputStream(filename);
			ObjectInputStream ois=new ObjectInputStream(fis);
			o=ois.readObject();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return o;
	}
	
	public static void gotoOrderListUI() {
		OrderListUI ui = new OrderListUI();
		ui.setVisible(true);
	}
	public static void gotoAddOrderUI() {
		AddOrderUI ui = new AddOrderUI();
		ui.setVisible(true);
	}
	public static void gotoMenuUI() {
		MenuUI menu = new MenuUI();
		menu.setVisible(true);

	}
	public static void gotoAddMemberUI() {
		AddMemberUI ui = new AddMemberUI();
		ui.setVisible(true);
	}
	public static void gotoAddMemberSuccessUI() {
		AddMemberSuccessUI ui = new AddMemberSuccessUI();
		ui.setVisible(true);
	}
	public static void gotoAddMemberErrorUI() {
		AddMemberErrorUI ui = new AddMemberErrorUI();
		ui.setVisible(true);
	}
	public static void gotoLoginSuccessrUI() {
		LoginSuccessUI ui = new LoginSuccessUI();
		ui.setVisible(true);
	}
	public static void gotoLoginErrorUI() {
		LoginErrorUI ui = new LoginErrorUI();
		ui.setVisible(true);
	}
	
	public static void initRoomList(JList list, List<Room> allroom) {

		DefaultListModel listModel = new DefaultListModel();
		for(Room room:allroom) {
			listModel.addElement(room.getId() +":"+room.getName()+":金額:"+room.getPrice());
		}
		list.setModel(listModel);
	}
	
	public static void initOrderList(JList list, List<Order> allorder) {
		int member_id;
		int room_id;
		Integer price;
		DefaultListModel listModel = new DefaultListModel();
		for(Order order:allorder) {
			member_id = order.getMember_id();
			room_id = order.getRoom_id();
			price = order.getPrice();
		    List<Room> room = new RoomDaoImpl().selectById(room_id);
		    String room_name = room.get(0).getName();
		    List<Member> member = new MemberDaoImpl().selectById(member_id);
		    String member_name = member.get(0).getName();
			
			listModel.addElement("orderId:"+order.getId() +":member:"+member_id+":"+member_name+":"+room_id+":金額:"+price);
		}
		list.setModel(listModel);
	}
	

}
