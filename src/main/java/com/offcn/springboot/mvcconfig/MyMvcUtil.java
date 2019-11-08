package com.offcn.springboot.mvcconfig;

import com.offcn.springboot.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
// 使用类替代我们的配置文件
// WebMvcConfigurationSupport  springBoot 提供了一个可以配置的springmvc内容的工具类
@Configuration
public class MyMvcUtil extends WebMvcConfigurationSupport{

    // 发送我们的请求给服务器，根据列表内容 跳转对应的页面
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        // springboot  模板引擎的位置  /templates/login.html
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
    }

    //给工程添加拦截器
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).excludePathPatterns("/","/index.html","/login").addPathPatterns("/**");
    }


}
