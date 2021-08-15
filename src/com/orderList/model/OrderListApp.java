package com.orderlist.model;

public class OrderListApp {
	
	public static void main(String[] args) {
		
		//creating a DAO
		OrderListJDBCDAO dao = new OrderListJDBCDAO();
		
		//find method
		OrderListVO olVO = dao.findByPrimaryKey(0001);
		int orderListId = olVO.getOrderId();       //訂單明細編號
		int price = olVO.getPrice();             //商品單價
		int itemQty = olVO.getItemQty();           //商品數量
		String orderRemark = olVO.getOrderRemark();        //商品備註
		int orderId = olVO.getOrderId();           //訂單編號
		int itemId = olVO.getItemId();            //商品編號
		
		//測試印幾個實體變數看看:
		System.out.println("明細鯿號: " + orderListId);
		System.out.println("單價: " + price);
		System.out.println("數量: " + itemQty);
		
		
	}

}
