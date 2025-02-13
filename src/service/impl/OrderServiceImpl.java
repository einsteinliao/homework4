package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.impl.MemberDaoImpl;
import dao.impl.OrderDaoImpl;
import model.Member;
import model.Order;
import service.OrderService;
import util.Tool;

public class OrderServiceImpl implements OrderService  {

	private static OrderDaoImpl orderdaoimpl=new OrderDaoImpl();
	
	public static void main(String[] args) {
		Member member=(Member)Tool.read("member.txt");
		System.out.println("member-id:"+member.getId());
		List<Order> allorder = new OrderServiceImpl().selectOrderByMember(member);
		for(Order o :allorder) {
			System.out.println(o.getId() +":"+o.getMember_id()+":"+o.getRoom_id());
		}
		

	}

	@Override
	public void addOrder(Order order) {
		orderdaoimpl.add(order);
		
	}

	@Override
	public List<Order> selectOrderByMember(Member member) {
		List<Order> allorder = orderdaoimpl.selectAll();
		List<Order> myorder=new ArrayList<Order>();
		for(Order order: allorder) {
			//System.out.println(order.getMember_id()+" - " + member.getId());
			if( order.getMember_id() == member.getId()) {
				//System.out.println(order.getMember_id()+" - " + member.getId())
				myorder.add(order);
			}
		}
		return myorder;
	}

	@Override
	public void deleteOrder(int order_id) {
		orderdaoimpl.delete(order_id);
		
	}

}
