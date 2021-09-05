package com.creditcard.model;

import java.util.List;

public class CreditCardService {

	private CreditCardDAO_interface dao;
	
	public CreditCardService() {
		dao = new CreditCardJDBCDAO();
	}
	
	public CreditCardVO addCreditCard(Integer userid, String creditno, String creditexp, String cardholder, String creditpin) {
		
		CreditCardVO creditCardVO = new CreditCardVO();
		
		creditCardVO.setUserid(userid);
		creditCardVO.setCreditno(creditno);
		creditCardVO.setCreditexp(creditexp);
		creditCardVO.setCardholder(cardholder);
		creditCardVO.setCreditpin(creditpin);
		dao.insert(creditCardVO);
	
		return creditCardVO;
		
	}
	
	public CreditCardVO updateCreditCard(Integer creditid, Integer userid, String creditno, String creditexp, String cardholder, String creditpin) {
		
		CreditCardVO creditCardVO = new CreditCardVO();
		
		creditCardVO.setCreditid(creditid);
		creditCardVO.setUserid(userid);
		creditCardVO.setCreditno(creditno);
		creditCardVO.setCreditexp(creditexp);
		creditCardVO.setCardholder(cardholder);
		creditCardVO.setCreditpin(creditpin);
		dao.insert(creditCardVO);
	
		return creditCardVO;
		
	}
	
	public void deleteCreditCard(Integer creditid) {
		dao.delete(creditid);
	}
	
	public CreditCardVO getOneCreditCard(Integer creditid) {
		return dao.findByPrimaryKey(creditid);
	}
	
	public List<CreditCardVO> getALL() {
		return dao.getAll();
	}
	
}	
