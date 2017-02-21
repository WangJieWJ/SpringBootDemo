package com.springBootBasic.webLogAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * Title:
 * Description: 实现Web层的日志切面
 *
 * //AOP切面的优先级；我们可能会对Web层做多个切面，校验用户，校验头信息等等，这个时候经常会碰到切面的处理顺序为所以，
 * 我们需要定义每个切面的优先级，我们需要 @Order(i) 注解来标识切面的优先级。 i的值越小，优先级越高。
 * 假设我们还有一个切面是 CheckNameAspect 用来校验name必须为didi，我们为其设置 @Order(10) ，而上文中WebLogAspect设置为 @Order(5) ，所以WebLogAspect有更高的优先级，这个时候执行顺序是这样的：
 * 在 @Before 中优先执行 @Order(5) 的内容，再执行 @Order(10) 的内容
 * 在 @After 和 @AfterReturning 中优先执行 @Order(10) 的内容，再执行 @Order(5) 的内容
 * 所以我们可以这样子总结：
 * 在切入点前的操作，按order的值由小到大执行
 * 在切入点后的操作，按order的值由大到小执行
 *
 * Project: SpringBoot
 * Create User: wangjie
 * Create Time: 2017/2/9 0009
 */
@Aspect
@Component
@Order(5)
public class WebLogAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 解决AOP切面中的同步问题
     */
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 定义一个切入点
     * 解释下：
     * <p>
     * 第一个 * 代表任意修饰符及任意返回值。
     * 第二个 ..* 表示Controller包及其子包下
     * 第三个 * 任意方法
     * ..  匹配任意数量的参数
     */
    @Pointcut("execution(* com.springBootBasic.controller..*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {

        startTime.set(System.currentTimeMillis());
        //接收到请求，记录请求的内容
        logger.info("开始处理Web请求");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //记录下请求内容
        System.out.println("URL: " + request.getRequestURL().toString());
//        logger.info("URL: " + request.getRequestURL().toString());
//        logger.info("HTTP_METHOD: " + request.getMethod());
//        logger.info("IP: " + request.getRemoteAddr());
//        logger.info("CLASS_METHOD: " + joinPoint.getSignature().getName());
//        logger.info("ARGS: " + Arrays.toString(joinPoint.getArgs()));
        //获取所有参数方法
        Enumeration<String> enumeration = request.getParameterNames();
        System.out.println("params:");
        if (!enumeration.hasMoreElements()){
            System.out.println("       NoParams");
        }
        while (enumeration.hasMoreElements()) {
            String paraName = (String) enumeration.nextElement();
            System.out.println("       " + paraName + ": " + request.getParameter(paraName));
        }
        System.out.println("------------------------------------------------");
    }

    @AfterReturning("webLog()")
    public void doAfterReturning(JoinPoint joinPoint) {
        //处理完请求，返回内容
        logger.info("Web请求处理结束");
        logger.info("SPEND TIME : " + (System.currentTimeMillis() - startTime.get()) + "ms");
    }
}
