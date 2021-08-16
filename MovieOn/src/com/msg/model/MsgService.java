package com.msg.model;

import java.sql.Timestamp;
import java.util.List;

public class MsgService {
	private MsgDAO_interface dao;

	public MsgService() {
		dao = new MsgDAO();
	}

	public MsgVO addMsg(Integer reviewId, Integer userId, Timestamp msgTime, String msgContext) {
		MsgVO msgVO = new MsgVO();

		msgVO.setReviewId(reviewId);
		msgVO.setUserId(userId);
		msgVO.setMsgTime(msgTime);
		msgVO.setMsgContext(msgContext);

		dao.update(msgVO);
		return msgVO;
	}

	public MsgVO updateMsg(Integer msgId, Integer reviewId, Integer userId, Timestamp msgTime, String msgContext) {
		MsgVO msgVO = new MsgVO();

		msgVO.setMsgId(msgId);
		msgVO.setReviewId(reviewId);
		msgVO.setUserId(userId);
		msgVO.setMsgTime(msgTime);
		msgVO.setMsgContext(msgContext);

		dao.update(msgVO);
		return msgVO;
	}

	public void deleteMsg(Integer msgId) {
		dao.delete(msgId);
	}

	public MsgVO getOneMsg(Integer msgId) {
		return dao.findByPrimaryKey(msgId);
	}

	public List<MsgVO> getAll() {
		return dao.getAll();
	}
}
