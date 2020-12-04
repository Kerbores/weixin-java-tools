package com.binarywang.spring.starter.wxjava.mp.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.binarywang.spring.starter.wxjava.mp.properties.WxMpProperties;

/**
 * .
 *
 * @author someone
 */
@Configuration
@EnableConfigurationProperties(WxMpProperties.class)
@Import({WxMpStorageAutoConfiguration.class, WxMpServiceAutoConfiguration.class})
public class WxMpAutoConfiguration {
}
