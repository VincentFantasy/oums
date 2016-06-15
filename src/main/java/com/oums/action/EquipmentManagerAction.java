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
import com.oums.bean.vo.EquipmentVo;
import com.oums.service.IEquipmentManagerService;
import com.oums.service.IEquipmentService;
import com.oums.service.IUserService;

/**
 * 
 * @author pzh
 * TODO 超级管理员的操作
 * 2016年6月7日
 */
@ParentPackage("basePackage")
@Namespace("/manager")
public class EquipmentManagerAction {
	
	@Autowired
	IEquipmentManagerService equipmentManagerService;
	@Autowired
	IEquipmentService equipmentService;
	@Autowired
	IUserService userService;
	
	private ReturnMessage returnMessage;
	private EquipmentVo equip;
	private Integer ids[][];
	public Integer[][] getIds() {
		return ids;
	}
	public void setIds(Integer[][] ids) {
		this.ids = ids;
	}
	public ReturnMessage getReturnMessage() {
		return returnMessage;
	}
	public EquipmentVo getEquipment() {
		return equip;
	}
	public void setReturnMessage(ReturnMessage returnMessage) {
		this.returnMessage = returnMessage;
	}
	public void setEquipment(EquipmentVo equip) {
		this.equip = equip;
	}
	
	
	/**
	 * 添加器材
	 * @return
	 * http://localhost:8080/OUMS/equipmentManager/addEquipment
	 */
	//, results={@Result(name="success", type="json", params={"root","returnMessage"})})
	@Action(value="addEquipment",results={@Result(name="success",location="index.jsp")})
	public String addEquipment() {
		
		//添加器材
		returnMessage = equipmentManagerService.addEquipment(equip);

		return "success";

	}
	
	/**
	 * 删除器材
	 * @return
	 * http://localhost:8080/OUMS/equipmentManager/delEquipment
	 */
	@Action(value="delEquipment")
//			, results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String delEquipment() {
		
		HttpServletRequest request=ServletActionContext.getRequest();//得到request对象
		HttpServletResponse response=ServletActionContext.getResponse();//得到response对象
		int id=Integer.parseInt( request.getParameter("equipId"));
		//删除器材
		returnMessage=equipmentManagerService.delEquipment(id);
		try {
			if(returnMessage.isFlat()){
				returnMessage = equipmentService.findAllEquipment();
				@SuppressWarnings("unchecked")
				List<EquipmentPo> list=(List<EquipmentPo>) returnMessage.getObject();
				request.setAttribute("list",list );
				request.getRequestDispatcher("../../equipmentDel.jsp").forward(request, response);
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
	 * 从界面接受 器材种类信息,
	 * 更新器材器材信息
	 * @return
	 * http://localhost:8080/OUMS/equipmentManager/updateEquipment
	 */
	@Action(value="updateEquipment", results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String updateEquipment() {
		//更新器材
		returnMessage=equipmentManagerService.updateEquipment(equip);
		
		try {
			HttpServletRequest request=ServletActionContext.getRequest();//得到request对象
			HttpServletResponse response=ServletActionContext.getResponse();//得到response对象
			request.getRequestDispatcher("../../equipment/FindequipmentByType.action").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "success";
	}
	
	/**
	 * 从界面接受 器材种类信息,
	 * 返回器材详细信息器材
	 * @return
	 * http://localhost:8080/OUMS/equipmentManager/delEquipment
	 */
	@Action(value="findEquipmentById")//	, results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String findEquipmentById() {
		HttpServletRequest request=ServletActionContext.getRequest();//得到request对象
		HttpServletResponse response=ServletActionContext.getResponse();//得到response对象
		int id=Integer.parseInt( request.getParameter("equipId"));
		returnMessage=equipmentManagerService.findEquipmentById(id);
		try {
			if(returnMessage.isFlat()){
				EquipmentPo list=(EquipmentPo) returnMessage.getObject();
				request.setAttribute("list",list );
				request.getRequestDispatcher("../../equipmentDetail.jsp").forward(request, response);
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
	 * 
	 * 查找待确认订单
	 * @return
	 * http://localhost:8080/OUMS/equipmentManager/delEquipment
	 */
	@Action(value="findWaitSureOrder")//	, results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String findWaitSureOrder() {
		HttpServletRequest request=ServletActionContext.getRequest();//得到request对象
		HttpServletResponse response=ServletActionContext.getResponse();//得到response对象
		
		returnMessage=equipmentManagerService.findWaitSureOrder();
		try {
			if(returnMessage.isFlat()){
				List<OrderPo> list=(List<OrderPo>) returnMessage.getObject();
				request.setAttribute("list",list );
				request.getRequestDispatcher("../../equipmentManagerSureOrder.jsp").forward(request, response);
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
	 * 
	 * 确认订单
	 * @return
	 * http://localhost:8080/OUMS/equipmentManager/delEquipment
	 */
	@Action(value="sureOrder")//	, results={@Result(name="success", type="json", params={"root","returnMessage"})})
	public String sureOrder() {
		HttpServletRequest request=ServletActionContext.getRequest();//得到request对象
		HttpServletResponse response=ServletActionContext.getResponse();//得到response对象
		int id=Integer.parseInt( request.getParameter("orderId"));
		returnMessage=equipmentManagerService.sureOrder(id);
		try {
			if(returnMessage.isFlat()){
				returnMessage=equipmentManagerService.findWaitSureOrder();
				EquipmentPo list=(EquipmentPo) returnMessage.getObject();
				request.setAttribute("list",list );
				request.getRequestDispatcher("../../equipmentManagerSureOrder.jsp").forward(request, response);
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
}
