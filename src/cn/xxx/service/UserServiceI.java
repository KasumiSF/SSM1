package cn.xxx.service;

import cn.xxx.ssm.pojo.UserCustom;

public interface UserServiceI {
	//根据id查询人员信息
	public UserCustom findUserById(Integer id) throws Exception;
	    
	//修改人员信息，这里id本来已经在userCustom存在，但是为了更好的开发，还是将id提取出来
	//更新
	public void updateUser(Integer id, UserCustom userCustom) throws Exception;



}
