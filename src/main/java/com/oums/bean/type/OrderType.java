package com.oums.bean.type;

/**
 * 订单状态
 * @author 谭治
 *
 */
public class OrderType {
	
	/* 未付款  */
	public final static Integer NOPAY = 0x01;
	
	/* 等待确认  */
	public final static Integer WAITSURE = 0x02;
	
	/* 已确认  */
	public final static Integer SURE = 0x03;
	
	/* 已取消  */
	public final static Integer CANCEL = 0x04;
	
	/* 已退款  */
	public final static Integer REFUND = 0x05;
	
	/* 已拒绝  */
	public final static Integer REFUSE = 0x06;
}
