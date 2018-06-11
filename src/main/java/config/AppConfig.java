package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"service", "aop"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
//@Import({LogbackConfig.class})
public class AppConfig {

}
