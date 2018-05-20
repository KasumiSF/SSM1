<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<title>添加人员信息</title>

<script type="text/javascript">
    function addaddUser(){
    	var name = document.getElementById("name").value;
		var age = document.getElementById("age").value;
    if(name==""||name==null){
        alert("名字不能为空");
        return false;
    }else if(age==""||age==null){
        alert("年龄不能为空");
        return false;
    }else{
        //window.location.href="index.jsp";  
        return true;
    }
}
</script>
</head>
<body>
    <form id="form1" action="${pageContext.request.contextPath }/user/addUserSubmit.action"
        method="post" onsubmit="return addaddUser();">
        <input type="hidden" name="id" value="${userCustom.id }" /> 添加人员信息：
        <table width="100%" border=1>
            <tr>
                <td>名字</td>
                <td><input type="text" id="name" name="name" value="${userCustom.name }" /></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><select id="gender" name="gender">
				       <option value="0" >男</option>
				       <option value="1" >女</option>
					</select>
				</td>
            </tr>
             <tr>
                <td>年龄</td>
                <td><input type="text" id="age" name="age" value="${userCustom.age }" /></td>
            </tr>
             <tr>
                <td>等级</td>
                <td><select id="level" name="level">
				       <option value="1" >1级</option>
				       <option value="2" >2级</option>
				       <option value="3" >3级</option>
				       <option value="4" >4级</option>
				       <option value="5" >5级</option>
					</select>
				</td>
            </tr>
             <tr>
                <td>所在部门</td>
                <td><select id="department" name="department">
				       <option value="1" >开发部</option>
				       <option value="2" >支持部</option>
				       <option value="3" >工程质量部</option>
					</select>
				</td>            
			</tr>
             <tr>
                 <%  java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");    
   					java.util.Date currentTime = new java.util.Date();    
   					String time = simpleDateFormat.format(currentTime).toString();  %>
   					<%-- <%out.println(time);%> --%>
                <td>创建时间</td>
                <td><input type="text" name="creationTime" value="<%out.println(time);%>"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                <input type="submit" value="提交" /></td>
            </tr>
        </table>
    </form>
</body>
</html>