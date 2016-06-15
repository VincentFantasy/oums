package com.oums.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.po.EquipmentPo;
import com.oums.bean.po.OrderPo;
import com.oums.bean.po.SitePo;
import com.oums.bean.po.UserPo;
import com.oums.bean.type.ItemState;
import com.oums.bean.type.OrderClass;
import com.oums.bean.type.OrderType;
import com.oums.bean.vo.EquipmentTypeVo;
import com.oums.bean.vo.EquipmentVo;
import com.oums.bean.vo.OrderVo;
import com.oums.bean.vo.UserVo;
import com.oums.service.IEquipmentManagerService;
import com.oums.service.IEquipmentService;
import com.oums.service.IUserService;
import com.oums.util.OrderUtil;
import com.oums.util.TimeUtil;

/**
 * 
 * @author pzh
 * TODO 普通用户以及超级管理员的操作
 * 2016年6月7日
 */

@ParentPackage("basePackage")
@Namespace("/equipment")
public class EquipmentAction {
	
	@Autowired
	IEquipmentService  equipmentService;
	@Autowired
	IEquipmentManagerService  equipmentManagerService;
	@Autowired
	IUserService userService;
	
	private EquipmentVo  equipment;
	private ReturnMessage returnMessage;
	private OrderVo order;
	private UserVo user;
	private String content;
	private String type;
	private EquipmentTypeVo  equipmentType;
	
	public EquipmentTypeVo getEquipmentType() {
		return equipmentType;
	}
	public void setEquipmentType(EquipmentTypeVo equipmentType) {
		this.equipmentType = equipmentType;
	}
	public String getContent() {
		return content;
	}
	public String getType() {
		return type;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setType(String type) {
		this.type = type;
	}
	public EquipmentVo getEquip() {
		return equipment;
	}
	public ReturnMessage getReturnMessage() {
		return returnMessage;
	}
	public OrderVo getOrder() {
		return order;
	}
	public UserVo getUser() {
		return user;
	}
	public void setEquip(EquipmentVo equipment) {
		this.equipment = equipment;
	}
	public void setReturnMessage(ReturnMessage returnMessage) {
		this.returnMessage = returnMessage;
	}
	public void setOrder(OrderVo order) {
		this.order = order;
	}
	public void setUser(UserVo user) {
		this.user = user;
	}
	
	/**
	 * 查找所有器材
	 * @return
	 * http://localhost:8080/OUMS/equipment/findAllEquipment
	 */
	@Action(value="findAllEquipment", 
			results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String findAllEquipment() {		
		
		ReturnMessage returnMessage = new  ReturnMessage();
		
		returnMessage = equipmentService.findAllEquipment();
		
//		request.setAttribute("list",list );
//		request.getRequestDispatcher("/listCust.jsp").forward(request, response);
		
		return "success";
	}

	
	/**
	 * 按条件查找器材
	 * @return
	 * http://localhost:8080/OUMS/equipment/findEquipment
	 */
	@Action(value="findEquipmentByType")
//			results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String findEquipmentByType() {		
		
		ReturnMessage returnMessage = new  ReturnMessage();
		
		returnMessage = equipmentService.findEquipmentByType(content,type);
		List<EquipmentPo> list=(List<EquipmentPo>) returnMessage.getObject();
		HttpServletRequest request=ServletActionContext.getRequest();//得到request对象
		HttpServletResponse response=ServletActionContext.getResponse();//得到response对象
		request.setAttribute("list",list );
		try {
			String type=request.getParameter("type");
			switch (type){
			case "detail" : 
				request.getRequestDispatcher("../../equipmentDetail.jsp").forward(request, response);
				break;
			case "borrow" : 
				request.getRequestDispatcher("../../equipmentBorrow.jsp").forward(request, response);
				break;
			case "find" : 
				request.getRequestDispatcher("../../equipmentFind.jsp").forward(request, response);
				break;
			case "list" : 
				request.getRequestDispatcher("../../equipmentList.jsp").forward(request, response);
				break;
			case "del" : 
				request.getRequestDispatcher("../../equipmentDel.jsp").forward(request, response);
				break;
			default : break;
			} 
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "success";
	}	
	
	/**
	 * 查找器材种类及数量
	 * @return
	 * http://localhost:8080/OUMS/equipment/findEquipmentType
	 */
	@Action(value="findEquipmentTypeAndNum")
//			results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String findEquipmentTypeAndNum() {		
		
		ReturnMessage returnMessage = new  ReturnMessage();
		
		returnMessage = equipmentService.findEquipmentTypeAndNum();
		
		HttpServletRequest request=ServletActionContext.getRequest();//得到request对象
		HttpServletResponse response=ServletActionContext.getResponse();//得到response对象
		try {
			request.getRequestDispatcher("../../equipmentList.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "success";
	}	
	
	/**
	 * 租借器材
	 * @return
	 * http://localhost:8080/OUMS/equipment/borrowEquipment
	 */
	@Action(value="borrowEquipment", results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String borrowEquipment() {		
		
		try {

			order = new OrderVo();
			order.setOrderNumber(OrderUtil.createOrderNumber());
			order.setIsDelete(false);
			order.setOrderType(OrderType.NOPAY);
			order.setOrderClass(OrderClass.EQUIPMENT);
			order.setBuildTime(TimeUtil.getNowTime());

			// 设置用户
			returnMessage = userService.getUserPoByCerNum(user.getCertificateNumber());
			if (returnMessage.isFlat()) {
				UserPo userPo = (UserPo) returnMessage.getObject();
				order.setUser(userPo);

				returnMessage = equipmentService.findFreeEquipment(equipmentType);
				if (returnMessage.isFlat()) {
						List<EquipmentPo> po=(List<EquipmentPo>) returnMessage.getObject();
						for(int i=0;i<po.size();i++){
							po.get(i).setItemState(ItemState.ORDERED);
							equipmentManagerService.updateEquipment(po.get(i));
							 order.getEquipmentList().add(po.get(i));
						}
						returnMessage=equipmentService.addOrder(order);
						if(returnMessage.isFlat()){
							returnMessage.setContent("租借成功");
						}else{
							returnMessage.setContent("租借失败");
						}
					} else {
						returnMessage.setContent("查找失败");
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	
	}
	
	/**
	 * 查找非删除的订单
	 * @return
	 * http://localhost:8080/OUMS/equipment/borrowEquipment
	 */
	@Action(value="findOrder")  //	, results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String findOrder() {		
		
		try {
			HttpServletRequest request=ServletActionContext.getRequest();//得到request对象
			HttpServletResponse response=ServletActionContext.getResponse();//得到response对象
			
			// 设置用户
			returnMessage = equipmentService.findOrder();
			if(returnMessage.isFlat()){
				List<OrderPo> list = (List<OrderPo>) returnMessage.getObject();
				request.setAttribute("list", list);
				returnMessage.setContent("订单查找成功!");
			}else{
				returnMessage.setContent("订单查找失败!");
			}
			request.getRequestDispatcher("../../equipmentList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 订单支付
	 * @return
	 * http://localhost:8080/OUMS/equipment/borrowEquipment
	 */
	@Action(value="findOrder") //	, results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String payOrder() {		
		
		try {
			HttpServletRequest request=ServletActionContext.getRequest();//得到request对象
			HttpServletResponse response=ServletActionContext.getResponse();//得到response对象
			int id = Integer.parseInt(request.getParameter("orderId"));
			// 设置用户
			returnMessage = equipmentService.payOrder(id);
			if(returnMessage.isFlat()){
				returnMessage.setContent("订单支付成功!");
			}else{
				returnMessage.setContent("订单支付失败!");
			}
			List<OrderPo> list = (List<OrderPo>) returnMessage.getObject();
			request.setAttribute("list", list);
			request.getRequestDispatcher("../../equipmentOrderList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 订单删除
	 * @return
	 * http://localhost:8080/OUMS/equipment/borrowEquipment
	 */
	@Action(value="delOrder")   //	, results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String delOrder() {		
		
		try {
			HttpServletRequest request=ServletActionContext.getRequest();//得到request对象
			HttpServletResponse response=ServletActionContext.getResponse();//得到response对象
			int id = Integer.parseInt(request.getParameter("orderId"));
			// 设置用户
			returnMessage = equipmentService.delOrder(id);
			if(returnMessage.isFlat()){
				List<OrderPo> list = (List<OrderPo>) returnMessage.getObject();
				request.setAttribute("list", list);
				returnMessage.setContent("订单删除成功!");
			}else{
				returnMessage.setContent("订单删除失败!");
			}
			request.getRequestDispatcher("../../equipmentOrderList.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
}
