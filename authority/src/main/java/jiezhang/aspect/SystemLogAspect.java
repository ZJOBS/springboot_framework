package jiezhang.aspect;

import jiezhang.constant.AuthorityConstant;
import jiezhang.entity.UAI;
import jiezhang.entity.db.Log;
import jiezhang.entity.db.SystemLog;
import jiezhang.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 日志过滤
 *
 * @param
 * @author ZhangJie
 * @description
 * @date 4:22 下午 2020/7/16
 * @return
 */
@Aspect
@Component
public class SystemLogAspect {

    @Autowired
    private LogService logService;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 配置接入点,如果不知道怎么配置,可以百度一下规则
     */
    //匹配多个项目路径不一致情况，因为console项目没有controller，没有试验过
    @Pointcut("@annotation(jiezhang.entity.db.SystemLog)")
    private void controllerAspect() {
    }//定义一个切入点

    @Around("controllerAspect()&& @annotation(systemLog)")
    public Object around(ProceedingJoinPoint pjp, SystemLog systemLog) throws Throwable {
        //常见日志实体对象
        Log log = new Log();
        //获取登录用户账户
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        UAI uai = (UAI) request.getSession().getAttribute(AuthorityConstant.UAI);

        String path = request.getServletPath();
        if ("/".equals(path)) {
            return pjp.proceed();
        }
        if (path.startsWith("/index")) {
            //首页不需要拦截
            return pjp.proceed();
        }

        if (path.startsWith("/login")) {
            //登入界面，无法获取到请求参数，暂时放过拦截
            return pjp.proceed();
        }

        log.setAdminId(uai.getAdminId());
        //获取系统时间
        String time = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date());
        log.setDateTime(time);

        //获取系统ip,这里用的是我自己的工具类,可自行网上查询获取ip方法
        String ip = getIP(request);
        log.setIp(ip);

        //方法通知前获取时间,为什么要记录这个时间呢？当然是用来计算模块执行时间的
        long start = System.currentTimeMillis();
        // 拦截的实体类，就是当前正在执行的controller
        Object target = pjp.getTarget();
        // 拦截的方法名称。当前正在执行的方法
        String methodName = pjp.getSignature().getName();
        // 拦截的方法参数
        Object[] args = pjp.getArgs();
        // 拦截的放参数类型
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Class[] parameterTypes = msig.getMethod().getParameterTypes();

        Object object = null;
        // 获得被拦截的方法
        Method method = null;
        try {
            method = target.getClass().getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            e.getMessage();
        } catch (SecurityException e) {
            e.getMessage();
        }
        if (null != method) {
            // 判断是否包含自定义的注解，说明一下这里的SystemLog就是我自己自定义的注解
            log.setModuleName(systemLog.module());
            log.setMethod(systemLog.methods());
            try {
                object = pjp.proceed();
                long end = System.currentTimeMillis();
                //将计算好的时间保存在实体中
                log.setResponseDate("" + (end - start));
                log.setResult("执行成功！");
                //保存进数据库
                logService.createEntity(log);
                mongoTemplate.save(log);
            } catch (Throwable e) {
                long end = System.currentTimeMillis();
                log.setResponseDate("" + (end - start));
                log.setResult("执行失败");
                logService.createEntity(log);
                mongoTemplate.save(log);
            }
        } else { //不需要拦截直接执行
            object = pjp.proceed();
        }
        return object;
    }

    private String getIP(HttpServletRequest request) {
        //先从nginx自定义配置获取
        String ip = request.getHeader("X-real-ip");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    @AfterThrowing(value = "@annotation(jiezhang.entity.db.SystemLog)", throwing = "e")
    private void doAfterThrow(JoinPoint joinPoint, Throwable e) {

    }


    //主体方法异常，依然会走 after的方法
    @After("controllerAspect()")
    public void destroyUserFunction(JoinPoint joinPoint) {

    }


}
