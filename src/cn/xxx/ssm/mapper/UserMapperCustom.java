package cn.xxx.ssm.mapper;


import cn.xxx.ssm.pojo.UserCustom;
import cn.xxx.ssm.pojo.UserQueryVo;

import java.util.List;


public interface UserMapperCustom {

    List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
    
    int deleteBathById(Integer[] id);

}