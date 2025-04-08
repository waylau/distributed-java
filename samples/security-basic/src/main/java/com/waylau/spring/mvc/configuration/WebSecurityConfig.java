package com.waylau.spring.mvc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Web Security Configuration.
 *
 * @since 1.0.0 2018年3月21日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@EnableWebSecurity // 启用Spring Security功能
public class WebSecurityConfig
        extends WebSecurityConfigurerAdapter {

    /**
     * 自定义配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()//所有请求都需认证
                .and()
                .formLogin() // 使用form表单登录
                .and()
                .httpBasic(); // HTTP基本认证
    }

    @SuppressWarnings("deprecation")
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager =
                new InMemoryUserDetailsManager();

        manager.createUser(
                User.withDefaultPasswordEncoder()  // 密码编码器
                        .username("waylau")  // 用户名
                        .password("123")	// 密码
                        .roles("USER")		// 角色
                        .build()
        );
        return manager;
    }
}