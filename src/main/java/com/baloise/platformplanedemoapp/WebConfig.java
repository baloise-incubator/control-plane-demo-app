package com.baloise.platformplanedemoapp;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

@Configuration
@ConditionalOnExpression(
        "${forwardedheader.enabled:true}"
)
public class WebConfig {

  @Bean
  public FilterRegistrationBean<ForwardedHeaderFilter> forwardedHeaderFilter() {
    FilterRegistrationBean<ForwardedHeaderFilter> filterRegBean = new FilterRegistrationBean<>();
    filterRegBean.setFilter(new ForwardedHeaderFilter());
    filterRegBean.setOrder(0);
    return filterRegBean;
  }
}