<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询人员列表</title>
<script type="text/javascript">
    function deleteUser(){
        //提交form
        document.userForm.action="${pageContext.request.contextPath }/user/deleteUser.action";
        document.userForm.submit();
    }
    function queryUser(){

        document.userForm.action="${pageContext.request.contextPath }/user/query.action";
        document.userForm.submit();
    }
</script>
</head>
<body>
    <form name="userForm" action="${pageContext.request.contextPath }/user/query.action" method="post">
        查询条件：
        <table width="100%" border=1>
            <tr>
             	<td>人员的名称<input name="userCustom.name"/></td>
                <td><input type="button" value="查询" onclick="queryUser()"/></td>
                <td><input type="button" value="批量删除" onclick="deleteUser()" /></td>
            </tr>
        </table>
        人员列表：
        <table width="100%" border=1>
            <tr>
            	<td>选择</td>
                <td>名字</td>
                <td>性别</td>
                <td>年龄</td>
                <td>等级</td>
                <td>所在部门</td>
                <td>创建时间</td>
            </tr>
            <c:forEach items="${userList }" var="user" varStatus="status">
                <tr <c:if test="${status.count%2==0}">bgcolor="#B0E0E6"</c:if>>
                	<td><input type="checkbox" name="id" value="${user.id}" /></td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age }</td>
                    <td>${user.level }</td>
                    <td>${user.department }</td>
                   	<td><fmt:formatDate value="${user.creationTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>

                    <td><a href="${pageContext.request.contextPath }/user/editUser.action?id=${user.id}">修改</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="2" align="center">
		        <a href="${pageContext.request.contextPath }/user/addUser.action"
		         shape="circle" target="_blank" style="color:#111;font-size:30px;">添加</a>
                </td>
        </table>
    </form>
</body>
</html>