package jiezhang.filter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户权限拦截
 *
 * @author jiezhang
 */
public class AuthorityInterceptor implements HandlerInterceptor {

    /**
     * 不做登陆拦截的对象数组
     */
    private static String[] LoginUrl = {"loginAction.do", "logoutAction.do", "index.do"};
    /**
     * 需要拦截的对象的后缀 集合
     */
    private static String[] OnFilter = {".do"};

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //判断用户的操作是否有权限，如果没有权限，直接倒计时提示无权限，并退出到登入界面

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
