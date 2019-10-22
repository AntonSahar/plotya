package com.example.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {
    private DataSource dataSource;
    //инжектим датасорс, чтобы получить доступ к источнику данных
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.jdbcAuthentication - говорим, что аутентификация будет происходить через бд
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //любый запросы будут доступны всем, но если на детеилс,то польователь должен иметь роль АДМИН
        http.authorizeRequests()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .anyRequest().permitAll()
                .and().formLogin().loginPage("/login").permitAll()
                .loginProcessingUrl("/authenticateTheUser");
        //когда эзер отправляет данные, то они отправляются куда-то, где спринг-секюрити может проверить корректность,
        // для проверки вводим специальный юрл
    }
}
