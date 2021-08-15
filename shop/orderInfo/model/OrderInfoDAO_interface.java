package com.orderInfo.model;

import java.util.List;

public interface OrderInfoDAO_interface {
	public void insert(OrderInfoVO orderInfoVO);          //�s�W�q��
	public void update(OrderInfoVO orderInfoVO);          //��s�q��
	public OrderInfoVO findByPrimaryKey(Integer orderId); //���ѭq��s���d�߭q��
	public List<OrderInfoVO> getAll();                    //�d��Ҧ����
	
	//�ϥΪ̨C�e�X�@���q��һݫO�s����,�]���S���]�w�R���q�檺��k
}
