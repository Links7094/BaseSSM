package aop;

import exception.ValidateException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;

//@Component
//@Aspect
//@Order(2)
public class ParamValidatorInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(ParamValidatorInterceptor.class);

    @Pointcut("execution(* web.controller.UserController.get(..))")
//    @Pointcut("execution(* web.controller.UserController.get(..))")
    public void matchController() {
    }

    @Before("matchController()")
    public void before() {
        logger.debug("before");
    }

    @After("matchController()")
    public void after() {
        logger.debug("after");
    }

    @AfterReturning("matchController()")
    public void afterReturning() {
        logger.debug("afterReturning");
    }

    @AfterThrowing("matchController()")
    public void afterThrowing() {
        logger.debug("afterThrowing");
    }

    @Around("matchController()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.debug("around");
        Object[] args = joinPoint.getArgs();
        Object lastParam = args[args.length - 1];
        if (lastParam instanceof Errors) {
            Errors errors = (Errors) lastParam;
            if (errors.hasErrors()) {
                throw new ValidateException(args[0], errors.getFieldError().getDefaultMessage());
            }
        }
        return joinPoint.proceed();
    }
}
