package com.oil.av.web.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class ActionLogHandlerInterceptor implements HandlerInterceptor {
    private static Log log = LogFactory.getLog(ActionLogHandlerInterceptor.class);
    private Long       startTime;
    private Long       endTime;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse arg1, Object arg2,
                                Exception arg3) throws Exception {
        //        endTime = System.currentTimeMillis();
        //        try {
        //            // 获取sessionID
        //            String ip = this.getIpAddr(request);
        //            // 获取登录用户
        //            CustomModel user = LoginUserUtils.getLoginUser();
        //            // 获取请求地址
        //            String URI = request.getRequestURI();
        //            log.info("[ ACTION ] [ USERNAME:" + user.getName() + " ] " + "[ IP:" + ip + " ] "
        //                     + "[ URI:" + URI + " ]" + " [ TIME:" + (endTime - startTime) + "ms ]");
        //        } catch (Exception e) {
        //            // TODO
        //        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj,
                           ModelAndView model) throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                             Object arg2) throws Exception {
        startTime = System.currentTimeMillis();
        return true;
    }

    /**
     * 获取客户端真实IP
     * 
     * @param request
     * @return
     */
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("http_client_ip");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        // 如果是多级代理，那么取第�?��ip为客户ip
        if (ip != null && ip.indexOf(",") != -1) {
            ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
        }
        return ip;
    }

}
