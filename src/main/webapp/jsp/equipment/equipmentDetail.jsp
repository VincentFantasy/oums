<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>器材删除</title>
</head>
<body>
	<form action="../../equipment/FindequipmentByType.action" method="post">
 		请输入查询信息:<input type="text" name="content"   style="width:111px"/>
		<select name="type">
			<option value="equipName" selected="selected">器材名</option>
			<option  value="equipBrand">品牌名</option>
		</select>
 		<input type="submit" value="查询"/>
 	</form>
	<form >
	 	<table  border="1" width="100%" >
	 		<tr>
			 	<th>器材名称</th>
			 	<th>器材品牌</th>
			 	<th>器材收购价格</th>
			 	<th>器材出租价格</th>
			 	<th>器材备注</th>	
			 	<th>修改</th>			
	 		</tr>
<%-- 	 		<c:forEach items="${requestScope.list}" var="cust" > --%>
	 		<c:forEach items="${requestScope.list}" var="item" >
	 			<tr>
	 				<td>${item.equipName}</td>
	 				<td>${item.equipBrand}</td>
	 				<td>${item.equipPrice}</td>
	 				<td>${item.tentPrice}</td>
	 				<td>${item.equipDetail}</td>
	 				<td>${item.itemState}</td>
	 				<td> 
	 					<a href="../../equipmentManager/findEquipmentById.action?equipId=${item.equipId}">修改</a>
	 				</td> 
	 			</tr>
	 		</c:forEach>
		</table>
	</form>
</body>
</html>