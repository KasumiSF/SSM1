package cn.xxx.ssm.controller;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    //登录
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password) throws Exception{
        
        //进行身份认证
        session.setAttribute("username", username);//在session中保存用户身份信息
        //重定向人员列表页面
        return "redirect:/user/query.action";
    }
    
    //退出
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception{
        //清除session
        session.invalidate();
        return "redirect:/user/query.action";
    }
}
