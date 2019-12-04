package cn.net.immortal.common.filter;

import cn.net.immortal.common.response.ResponseWrapper;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class SSOFilter implements Filter {

    private StringRedisTemplate stringRedisTemplate;

    private List<String> excludeUri;

    private static final String  SSO_TOKEN = "user-token";

    public static final String  ACCOUNT_ID = "account-id";

    SSOFilter(StringRedisTemplate stringRedisTemplate, List<String> excludeUrl){
        this.stringRedisTemplate = stringRedisTemplate;
        this.excludeUri = excludeUrl;
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse rep = (HttpServletResponse) servletResponse;
        if(matches(req.getRequestURI())){
            filterChain.doFilter(servletRequest, servletResponse);
            Object userId = req.getAttribute(ACCOUNT_ID);
            if(Objects.nonNull(userId)) {
                String token = UUID.randomUUID().toString().replace("-", "");
                stringRedisTemplate.opsForValue().set(token, String.valueOf(userId), 360, TimeUnit.SECONDS);
                rep.setHeader(SSO_TOKEN, token);
                req.removeAttribute(ACCOUNT_ID);
            }
        }else{
            String SSOToken = req.getHeader(SSO_TOKEN);
            String userId = stringRedisTemplate.opsForValue().get(Optional.ofNullable(SSOToken).orElse(SSO_TOKEN));
            if(Objects.nonNull(userId)){
                filterChain.doFilter(servletRequest, servletResponse);
            }else{
                rep.setStatus(403);
                rep.getWriter().print(ResponseWrapper.failure("login exception"));
            }
        }
    }

    private Boolean matches(final String uri){
        List<String> collect = excludeUri.stream().filter(uriPattern -> uri.matches(uriPattern)).collect(Collectors.toList());
        return collect.size() > 0;
    }


}
