package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ParamValidatorInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ParamValidatorInterceptor.class);

    @Pointcut("execution(* controller.UserController.get(..))")
    public void matchController(){}

    @Before("matchController()")
    public void before(){
        logger.debug("before");
    }

    @After("matchController()")
    public void after(){
        logger.debug("after");
    }

    @AfterReturning("matchController()")
    public void afterReturning(){
        logger.debug("afterReturning");
    }

    @AfterThrowing("matchController()")
    public void afterThrowing(){
        logger.debug("afterThrowing");
    }

    @Around("matchController()")
    public Object around(ProceedingJoinPoint joinPoint){
        logger.debug("around");
        Object o = null;
        try {
            o = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return o;
    }
}
