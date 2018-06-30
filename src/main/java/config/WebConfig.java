package config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import web.interceptor.TestInterceptor;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"web.controller"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class WebConfig extends WebMvcConfigurerAdapter {

    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    private static List<MediaType> buildDefaultMediaTypes(){
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.TEXT_HTML);
        list.add(MediaType.APPLICATION_JSON_UTF8);
        return list;
    }

    /**
     * 配置HTTP消息转换器
     * @param converters 转换器集合
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        // StringHttpMessageConverter io流 - 字符串 转换器
        converters.add(stringHttpMessageConverter());
        // MappingJackson2HttpMessageConverter 字符串 - 对象 转换器
        converters.add(mappingJackson2HttpMessageConverter());
        super.extendMessageConverters(converters);
    }

    @Bean
    public StringHttpMessageConverter stringHttpMessageConverter(){
        StringHttpMessageConverter converter = new StringHttpMessageConverter(DEFAULT_CHARSET);
        List<MediaType> list = buildDefaultMediaTypes();
        converter.setSupportedMediaTypes(list);
        return converter;
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        //此设置使输出json时不显示null类型的字段
        //mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        converter.setObjectMapper(mapper);
        List<MediaType> list = buildDefaultMediaTypes();
        converter.setSupportedMediaTypes(list);
        return converter;
    }

    /**
     * 注册Spring MVC 拦截器
     * @param registry 注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new TestInterceptor());
    }

    /**
     * 跨域请求
     * @param registry 注册器
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        super.addCorsMappings(registry);
        registry.addMapping("");
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        super.addReturnValueHandlers(returnValueHandlers);
    }
}
