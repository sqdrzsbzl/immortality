package cn.net.immortal.common.filter;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootConfiguration
@ConfigurationProperties(
        prefix = "filter"
)
public class FilterConfiguration {

    private static final String SSO = "SSOFilter";

    private List<String> ssoExcludeUri;

    public List<String> getSsoExcludeUri() {
        return ssoExcludeUri;
    }

    public void setSsoExcludeUri(List<String> ssoExcludeUri) {
        this.ssoExcludeUri = ssoExcludeUri;
    }

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Bean
    public FilterRegistrationBean<SSOFilter> ssoFilter() {
        FilterRegistrationBean<SSOFilter> filterRegistrationBean =
                new FilterRegistrationBean<>(new SSOFilter(stringRedisTemplate,ssoExcludeUri));
        filterRegistrationBean.setName(SSO);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }
}
