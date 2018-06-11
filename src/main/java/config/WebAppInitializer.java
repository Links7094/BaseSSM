package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }


//    public void onStartup(ServletContext servletContext) throws ServletException {
//        super.onStartup(servletContext);
//        // 新建一个WebApplicationContext的注册配置类，并和当前的servletContext关联
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(WebConfig.class);
//        context.setServletContext(servletContext);
//
////         日志配置(如果 classpath 里有  logback.xml文件， logback 会试图用它进行自我配置，所以下面两句代码可以不写)
//        servletContext.setInitParameter("logbackConfigLocation", "classpath:logback.xml");
//        servletContext.addListener(LogbackConfigListener.class);
//
//    }
}
