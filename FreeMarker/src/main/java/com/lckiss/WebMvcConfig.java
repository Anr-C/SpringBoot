package com.lckiss;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor= registry.addInterceptor(new LoginInterceptor());
        //拦截的方法 可添加多个方法
        //addPathPatterns("/**").addPathPatterns("/log") 或者 addPathPatterns("/**","/log")
        interceptor.addPathPatterns("/log");
        //不拦截的方法
        interceptor.excludePathPatterns("/login");

        //继续添加拦截器
//        registry.addInterceptor(new xxxInterceptor());
    }

}
