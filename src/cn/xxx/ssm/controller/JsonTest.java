package cn.xxx.ssm.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.xxx.ssm.pojo.UserCustom;

//json交互测试
@Controller
public class JsonTest {
    //请求json（人员信息），输出json（人员信息）
    /*
     * @RequestBody将请求的人员信息的json串转换成java对象
     * @ResponseBody将java对象转换成json输出
     * */
    @RequestMapping("/requestJson")
    public @ResponseBody UserCustom requestJson(@RequestBody UserCustom userCustom){
        
        return userCustom;
    }
    
    @RequestMapping("/responseJson")
    public @ResponseBody UserCustom responseJson(UserCustom userCustom){
            
        return userCustom;
    }
    
}