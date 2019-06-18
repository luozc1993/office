package cn.luozc.filter;


import cn.luozc.common.RequestHolder;
import cn.luozc.model.SysUser;
import com.alibaba.druid.util.PatternMatcher;
import com.alibaba.druid.util.ServletPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LoginFilter implements Filter {

    private   String whiteList = "";
    private Set<String> excludesPattern;
    protected String contextPath;
    protected PatternMatcher pathMatcher = new ServletPathMatcher ();
    @Override
    public void init(FilterConfig config) throws ServletException {
        String param = config.getInitParameter("whiteList");
        if (param != null && param.trim().length() != 0) {
            this.excludesPattern = new HashSet (Arrays.asList(param.split("\\s*,\\s*")));
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String servletPath = req.getServletPath();

        String[] arr = whiteList.split (",");
        boolean flag = false;
        for (String str :arr) {
        }
        boolean exclusion = isExclusion (servletPath);
//        SysUser sysUser = (SysUser)req.getSession().getAttribute("user");
//        if (sysUser == null&&!exclusion) {
//            String path = "/user/login";
//            resp.sendRedirect(path);
//            return;
//        }
        //RequestHolder.add(sysUser);
        //RequestHolder.add(req);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    public boolean isExclusion(String requestURI) {
        if (this.excludesPattern == null) {
            return false;
        } else {
            if (this.contextPath != null && requestURI.startsWith(this.contextPath)) {
                requestURI = requestURI.substring(this.contextPath.length());
                if (!requestURI.startsWith("/")) {
                    requestURI = "/" + requestURI;
                }
            }

            Iterator var2 = this.excludesPattern.iterator();

            String pattern;
            do {
                if (!var2.hasNext()) {
                    return false;
                }

                pattern = (String)var2.next();
            } while(!this.pathMatcher.matches(pattern, requestURI));

            return true;
        }
    }
}
