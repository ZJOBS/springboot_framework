package jiezhang.filter;

import jiezhang.entity.UAI;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jiezhang
 * @date 2017/5/25
 */
public class UserLogInInterceptor implements HandlerInterceptor {

    /**
     * 不做登陆拦截的对象数组
     */
    private static String[] LoginUrl = {"loginAction", "logoutAction", "index"};
//    /**
//     * 需要拦截的对象的后缀 集合
//     */
//    private static String[] OnFilter = {".do"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getServletPath().substring(1);
        boolean filterFlag = true;
        //检查请求后缀，判断是否需要拦截
//        for (int i = 0; i < OnFilter.length; i++) {
//            if (url.endsWith(OnFilter[i])) {
//                filterFlag = false;
//            }
//        }
        if (filterFlag) {
            //log.info("登陆拦截-结束-url(" + url + ")不在拦截范围之内");
            return true;
        }

        //登陆放行集合检测， 如果需要放行，则放行。
        for (int i = 0; i < LoginUrl.length; i++) {
            if (url.substring(0, url.lastIndexOf(".do") + 3).equals(LoginUrl[i])) {
                //log.info("登陆拦截-结束-请求地址放行：" + LogUrl[i]);
                return true;
            }
        }
        //拿取session中登陆标志对象
        Object obj = request.getSession().getAttribute("UAI");
        if (obj == null) {
            response.sendRedirect(request.getContextPath() + "/index.do");
            return false;
        } else {
            UAI uai = (UAI) obj;
            String UID = uai.getAdminId();
            if (UID == null) {
                //log.info("登陆拦截-结束-未登录，跳转登陆");
                response.sendRedirect(request.getContextPath() + "/index.do");
                return false;
            } else {
                //log.info("登陆拦截-结束-已登录");
                return true;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
