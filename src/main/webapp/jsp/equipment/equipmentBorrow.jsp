<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>器材列表</title>
</head>
<body>
	
	<form >
	 	<table  border="1" width="100%" >
	 		<tr>
			 	<th>器材名称</th>
			 	<th>器材品牌</th>
			 	<th>收购价格</th>
			 	<th>出租价格</th>
			 	<th>器材数量</th>				
	 		</tr>
<%-- 	 		<c:forEach items="${requestScope.list}" var="cust" > --%>
	 		<c:forEach items="${requestScope.list}" var="item" >
	 			<tr>
	 				<td>${item.equipName}</td>
	 				<td>${item.equipBrand}</td>
	 				<td>${item.equipPrice}</td>
	 				<td>${item.rentPrice}</td>
	 				<td>${item.equipNum}</td>
	 			</tr>
	 		</c:forEach>
		</table>
	</form>
	 <form action="../../equipmentManager/addEquipment.action" method="post">
        器材名：<input name="equipment.equipName" type="text" /><br/>
        器材品牌：<input name="equipment.equipBrand" type="text" /><br/>
      	器材数量：<input name="equipment.totalNum" type="text" /><br/>
      	租借时间：天数:<select name="day">
                    <option value="0" selected="selected">0</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                </select><br/>
                 小时:<select name="hour">
                    <option value="1" selected="selected">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                    <option value="9">9</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                    <option value="13">13</option>
                    <option value="14">14</option>
                    <option value="15">15</option>
                    <option value="16">16</option>
                    <option value="17">17</option>
                    <option value="18">18</option>
                    <option value="19">19</option>
                    <option value="20">20</option>
                    <option value="21">21</option>
                    <option value="22">22</option>
                    <option value="23">23</option>
                    <option value="24">24</option>
                </select><br/>
        场地备注：<input name="equipment.equipDtail" type="text" /><br/>
        <input type="submit" value="添加" />
    </form>
</body>
</html>