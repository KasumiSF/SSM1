package cn.xxx.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.xxx.service.UserService;
import cn.xxx.ssm.mapper.UserMapper;
import cn.xxx.ssm.mapper.UserMapperCustom;
import cn.xxx.ssm.pojo.User;
import cn.xxx.ssm.pojo.UserCustom;
import cn.xxx.ssm.pojo.UserQueryVo;

/**
 * 人员管理
 * @author Administrator
 *
 */
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapperCustom userMapperCustom;
	@Autowired
	private UserMapper userMapper;
	
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) 
			throws Exception {
		
		//通过userMapperCustom查询数据库
		return userMapperCustom.findUserList(userQueryVo);
	}
	
	@Override
	public UserCustom findUserById(Integer id) throws Exception { 
		User user = userMapper.selectByPrimaryKey(id);
		//中间对人员信息进行业务处理
		//.......
        //查询出来的数据可能需要进行一些业务处理，最后要返回userCustom
		UserCustom userCustom = new UserCustom();
        //将user内容拷贝到userCustom
        BeanUtils.copyProperties(user, userCustom);
        
        return userCustom;
    }

	@Override
    public void updateUser(Integer id, UserCustom userCustom) throws Exception {

    	userCustom.setId(id);
        userMapper.updateByPrimaryKey(userCustom);
    }

	@Override
	public void deleteBathById(Integer[] id) throws Exception {

			userMapperCustom.deleteBathById(id);
		
	}

	@Override
	public void insert(UserCustom userCustom) throws Exception {
		userMapper.insert(userCustom);
	}

}
