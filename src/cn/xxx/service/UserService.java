package cn.xxx.service;

import java.util.List;

import cn.xxx.ssm.pojo.User;
import cn.xxx.ssm.pojo.UserCustom;
import cn.xxx.ssm.pojo.UserQueryVo;

/**
 * 人员信息管理service
 * 也是查询条件
 * @author Administrator
 */
public interface UserService{
	//人员信息查询列表
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	
	//根据id查询人员信息
	public UserCustom findUserById(Integer id) throws Exception;
	
	//修改人员信息
	//需要传入id和VendorsCustom
	public void updateUser(Integer id,UserCustom userCustom )throws Exception;

	public void deleteBathById(Integer[] id) throws Exception;
	//添加人员信息	
	public void insert(UserCustom userCustom) throws Exception;
	
}