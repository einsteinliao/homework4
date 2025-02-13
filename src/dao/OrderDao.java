package dao;

import java.util.List;

import model.Order;

public interface OrderDao {

	void add(Order order);
	
	List<Order> selectAll();
	List<Order> selectByMember(Integer loginId);
	
	void update(Order order);
	void delete(int id);
}
