package com.oums.bean.type;

/**
 * 物品的状态，主要用在器材、场地
 * @author 谭治
 *
 */
public class ItemState {

	/* 正在被使用 */
	public final static int USERING = 111;
	
	/* 空闲 */
	public final static int FREE = 222;
	
	/* 维修 */
	public final static int MAINTAIN = 333;
	
	/* 教学使用 */
	public final static int TEACHING = 444;
	
	/* 暂停使用 */
	public final static int CLOSEING = 555;
	
	/* 被预约 */
	public final static int ORDERED = 666;
}
