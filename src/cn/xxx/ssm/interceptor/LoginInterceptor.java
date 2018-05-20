package cn.xxx.ssm.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//登录认证拦截器
public class LoginInterceptor implements HandlerInterceptor{
    
    //在进入handler方法之前执行，用于身份认证、身份授权等权限管理
    //比如身份认证，如果认证没有通过，则需要此方法拦截，不再向下执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        
        //获取请求的url
        String url = request.getRequestURI();
        //判断url是否是公开地址，实际使用时应该将公开地址配置在配置文件中，这里公开地址是登录提交的地址
        if(url.indexOf("login.action") >= 0){
            //如果是登录提交，则放行
            return true;
        }
        //判断session
        HttpSession session = request.getSession();
        //从session中取出用于身份信息
        String username = (String) session.getAttribute("username");
        if(username != null){
            //身份信息存在，放行
            return true;    
        }
        //没有校验通过，表示用户身份需要认证，此时需要跳转到登录页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        //返回false表示拦截，不向下执行
        return false;
    }
    
    //在进入handler方法之后同时在返回modelAndView之前
    //应用场景从modelAndView出发，将一些公用的模型数据在这里传递到视图中（比如菜单的导航）
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler, ModelAndView modelAndView) throws Exception {
        
    }
    //在执行handler方法之后执行
    //应用场景：可以使用统一的异常处理，还可以用于统一的日志处理
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}