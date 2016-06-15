package com.oums.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.oums.bean.ReturnMessage;
import com.oums.bean.vo.GonggaoVo;
import com.oums.service.IGonggaoService;

@ParentPackage("basePackage")
@Namespace("/jsp/gonggao")
public class GonggaoAction {

	@Autowired
	IGonggaoService gonggaoService;
	
	private ReturnMessage returnMessage;
	
	private GonggaoVo gonggao;

	public ReturnMessage getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(ReturnMessage returnMessage) {
		this.returnMessage = returnMessage;
	}

	public GonggaoVo getGonggao() {
		return gonggao;
	}

	public void setGonggao(GonggaoVo gonggao) {
		this.gonggao = gonggao;
	}
	
	/**
	 * 
	 * 
	 * @return http://localhost:8080/OUMS/jsp/gonggao/findGonggao
	 */
	@Action(value = "findGonggao", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String findGonggao() {

		returnMessage = gonggaoService.findGonggaoById(gonggao);

		return "success";

	}
	
	/**
	 * 
	 * 
	 * @return http://localhost:8080/OUMS/jsp/gonggao/findAllGonggao
	 */
	@Action(value = "findAllGonggao", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String findAllGonggao() {

		returnMessage = gonggaoService.getAllGonggao();

		return "success";

	}
	
	/**
	 * 
	 * 
	 * @return http://localhost:8080/OUMS/jsp/gonggao/addGonggao
	 */
	@Action(value = "addGonggao", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String addGonggao() {

		if(gonggao.getGonggaoDtail() != null && gonggao.getGonggaoTitile() != null)	
			returnMessage = gonggaoService.addGonggao(gonggao);
		else{
			returnMessage = new ReturnMessage();
			returnMessage.setContent("标题或内容不能为空");
			returnMessage.setFlat(false);
		}
			

		return "success";

	}
	
	/**
	 * 
	 * 
	 * @return http://localhost:8080/OUMS/jsp/gonggao/deleteGonggao
	 */
	@Action(value = "deleteGonggao", results = {
			@Result(name = "success", type = "json", params = { "root", "returnMessage" }) })
	public String deleteGonggao() {

		if(gonggao.getGonggaoId() != 0 || gonggao.getGonggaoId() != null)
			returnMessage = gonggaoService.deleteGonggao(gonggao);
		else {
			returnMessage = new ReturnMessage();
			returnMessage.setFlat(false);
			returnMessage.setContent("不能為空");
		}

		return "success";

	}
}
