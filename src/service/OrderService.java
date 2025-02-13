package service;

import java.util.List;

import model.Member;
import model.Order;

public interface OrderService {
	void addOrder(Order order);
	
	List<Order> selectOrderByMember(Member member);
	void deleteOrder(int order_id);
}
