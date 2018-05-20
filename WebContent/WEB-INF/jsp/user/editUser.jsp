<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改人员信息</title>
</head>
<body>
    <form id="userForm" action="${pageContext.request.contextPath }/user/editUserSubmit.action"
        method="post">
        <input type="hidden" name="id" value="${userCustom.id }" /> 修改人员信息：
        <table width="100%" border=1>
            <tr>
                <td>名字</td>
                <td><input type="text" name="name" value="${userCustom.name }" /></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="text" name="gender" value="${userCustom.gender }" /></td>
            </tr>
             <tr>
                <td>年龄</td>
                <td><input type="text" name="age" value="${userCustom.age }" /></td>
            </tr>
             <tr>
                <td>等级</td>
                <td><input type="text" name="level" value="${userCustom.level }" /></td>
            </tr>
             <tr>
                <td>所在部门</td>
                <td><input type="text" name="department" value="${userCustom.department }" /></td>
            </tr>
            <tr>
                <td>创建时间</td>
                <td><input type="text" name="creationTime" value="<fmt:formatDate value="${userCustom.creationTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></td>
            </tr>
           <%--  <td>人员图片</td>
            <td><c:if test="${userCustom.userState !=null}">
                    <img src="/pic/${userCustom.userState}" width=100 height=100 /><br />
                </c:if>
                <input type="file" name="user_State" value="${userCustom.userState}"/>
            </td> --%>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="提交" /></td>
            </tr>
        </table>
    </form>
</body>
</html>