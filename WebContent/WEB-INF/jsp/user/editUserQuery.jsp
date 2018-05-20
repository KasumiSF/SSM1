<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询人员列表</title>
<script type="text/javascript">
    function editUserAllSubmit(){
        //提交form
        document.userForm.action="${pageContext.request.contextPath }/user/editUserAllSubmit.action";
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
             	<td>人员的名称<input name="userCustom.userName"/></td>
                <td><input type="button" value="查询" onclick="queryUser()"/></td>
                <td><input type="button" value="批量修改的提交" onclick="editUserAllSubmit()" /></td>
            </tr>
        </table>
        人员列表：
        <table width="100%" border=1>
            <tr>
                <td>人员名称</td>
                <td>性别</td>
                <td>年龄</td>
                <td>等级</td>
                <td>所在部门</td>
                <td>添加时间</td>
            </tr>
            <c:forEach items="${userList }" var="user" varStatus="status">
                <tr>
                    <td><input name="userList[${status.index}].name" value="${user.name}"/></td>
                    <td><input name="userList[${status.index}].gender" value="${user.gender}"/></td>
                    <td><input name="userList[${status.index}].age" value="${user.age}"/></td>
                    <td><input name="userList[${status.index}].level" value="${user.level}"/></td>
                    <td><input name="userList[${status.index}].department" value="${user.department}"/></td>
                    <td><input name="userList[${status.index}].creationTime" value="<fmt:formatDate value="${user.creationTime}" pattern="yyyy-MM-dd HH:mm:ss" />"/></td>
                    <td><a href="${pageContext.request.contextPath }/user/editUser.action?userId=${user.userId}">修改</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</body>
</html>