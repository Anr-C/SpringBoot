package lckiss.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    private final static Logger logger= LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        //在 com.lckiss.com.lckiss.controller 调用之前 访问这个方法
       Object object= request.getSession().getAttribute("name");
        if (object!=null&& object instanceof String){
            String name=(String)object;
            if ("testUser".equals(name)){
                logger.info("-----------登录成功---login success-----");
                return true;
            }
        }

        logger.info("-----------登录失败---login fail-----");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //在 controller 调用之后 访问这个方法

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //在 渲染完web 页面之后 访问这个方法

    }
}
