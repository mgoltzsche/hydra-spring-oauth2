package de.algorythm.eval.sso.spring.resourceserver;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().disable()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/", "/premium/**", "/user", "/static/**", "/resources/**","/resources/public/**").permitAll()
                //.antMatchers("/premium/**").authenticated()
                .anyRequest().authenticated();
                /*.and()
                .httpBasic().realmName("ssosample");*/
    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        super.configure(auth);
        auth.inMemoryAuthentication().withUser("admin").password("secret").roles("USER");
    }*/
}
