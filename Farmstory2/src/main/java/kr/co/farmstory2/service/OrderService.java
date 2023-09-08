package kr.co.farmstory2.service;

import java.util.List;

import kr.co.farmstory2.dao.OrderDAO;
import kr.co.farmstory2.dto.OrderDTO;

public enum OrderService {
	INSTANCE;
	
	private OrderDAO dao = new OrderDAO();
	
	public void insertOrder(OrderDTO dto) {
		dao.insertOrder(dto);
	}
	
	public OrderDTO selectOrder(int orderNo) {
		return dao.selectOrder(orderNo);
	}
	
	public List<OrderDTO> selectOrders(int start) {
		return dao.selectOrders(start);
	}
	
	public void updateOrder(OrderDTO dto) {
		dao.updateOrder(dto);
	}
	
	public void deleteOrder(String orderNo) {
		dao.deleteOrder(orderNo);
	}
	
	public int selectCountOrders() {
		return dao.selectCountOrders();
	}

}