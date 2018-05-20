package cn.xxx.ssm.pojo;

import java.util.List;

/**
 * Vo是表现层的东西
 * @author Administrator
 *
 */
public class UserQueryVo {
	
	//商品信息
	private User user;
	
	//为了系统的扩展性，对原pojo进行增强（不该改变原来生成的文件）
	private UserCustom userCustom;
	
	//批量商品信息
	private List<UserCustom> userList;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<UserCustom> getUserList() {
		return userList;
	}

	public void setUserList(List<UserCustom> userList) {
		this.userList = userList;
	}
	
}
