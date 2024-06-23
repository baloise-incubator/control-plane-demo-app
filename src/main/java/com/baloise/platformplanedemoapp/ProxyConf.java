package com.baloise.platformplanedemoapp;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Configuration
@ConditionalOnExpression(
        "${proxy.enabled:true}"
)
class ProxyConf {
  @Bean
  public RestTemplateCustomizer proxyRestTemplateCustomizer() {
    return (RestTemplate restTemplate) -> {
      Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8888));
      SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
      requestFactory.setProxy(proxy);
      restTemplate.setRequestFactory(requestFactory);
    };
  }
}
