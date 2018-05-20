package cn.xxx.ssm.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.xxx.service.UserService;
import cn.xxx.ssm.pojo.User;
import cn.xxx.ssm.pojo.UserCustom;
import cn.xxx.ssm.pojo.UserQueryVo;

/**
 * 人员的Controller
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	public UserService userService;
	
    @RequestMapping("/query")
    public ModelAndView handleRequest(HttpServletRequest request,UserQueryVo userQueryVo) throws Exception{
    	
    	//调用service查找数据库，查询
        List<UserCustom> userList = userService.findUserList(userQueryVo);
        
        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于request的setAttribute方法，在jsp页面中就可以通过items取数据了
        modelAndView.addObject("userList",userList);
        
        //指定视图
        modelAndView.setViewName("user/userList");
        
        return modelAndView;
    }
    //人员信息修改页面展示
    @RequestMapping(value="/editUser",method={RequestMethod.POST,RequestMethod.GET})
    public String editUser(Model model,@RequestParam(value="id",required=true) Integer id) throws Exception{
    	//调用service根据id查询人员信息
    	UserCustom userCustom = userService.findUserById(id);
    	
    	//返回人员修改页面
    	model.addAttribute("userCustom", userCustom);
    	
    	return "user/editUser";
    }

    
    //人员修改提交
    @RequestMapping("/editUserSubmit")
    public String editUserSubmit(HttpServletRequest request, Integer id,
    		UserCustom userCustom
    		) throws Exception{
        //调用service更新人员信息，页面需要将人员信息传到此方法
        //............
    	userService.updateUser(id, userCustom);
    	
        //返回人员修改页面
    	return "forward:query.action";
    }
    
  //批量删除人员信息
    @RequestMapping("/deleteUser")
    public String deleteUser(Integer[] id) throws Exception{
    	userService.deleteBathById(id);
        
        return "success";
    }
    //批量，人员提交
    //将数据存储到UserQueryVo的userList中
    @RequestMapping("/editUserAllSubmit")
    public String editUserAllSubmit(UserQueryVo userQueryVo) throws Exception{
                
        return "success";
    }
    
    
    @RequestMapping("/editUserQuery")
    public ModelAndView editUserQuery(HttpServletRequest request,UserQueryVo userQueryVo) throws Exception{
    	
    	//调用service查找数据库，查询
        List<UserCustom> userList = userService.findUserList(userQueryVo);
        
        //返回ModelAndView
        ModelAndView modelAndView = new ModelAndView();
        //相当于request的setAttribute方法，在jsp页面中就可以通过items取数据了
        modelAndView.addObject("userList",userList);
        
        //指定视图
        modelAndView.setViewName("user/editUserQuery");
        
        return modelAndView;
    }
    
    //添加人员信息的实现
    @RequestMapping("/addUserSubmit")
    public String addUserSubmit(HttpServletRequest request,UserCustom userCustom) throws Exception{

    	userService.insert(userCustom);
    	
        return "success";
    }
    
    //添加人员信息的页面跳转
    @RequestMapping("/addUser")
    public ModelAndView addUser() throws Exception{

        ModelAndView modelAndView = new ModelAndView();
        //指定视图
        modelAndView.setViewName("user/addUser");

        return modelAndView;
    }
   
}
