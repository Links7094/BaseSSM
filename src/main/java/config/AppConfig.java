package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"service", "aop"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableTransactionManagement
@Import(DbConfig.class)
//@Import({LogbackConfig.class})
public class AppConfig {

}
