package htw.calenderproject.config;

import htw.calenderproject.service.UserService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurityConfig(UserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests(authorize -> {
                    authorize
                            //Pages
                            .antMatchers(
                                    Endpoints.INDEX,
                                    Endpoints.LOGIN,
                                    Endpoints.REGISTER
                            ).permitAll()
                            //Static Resources
                            .antMatchers(
                                    "/css/**",
                                    "/images/**",
                                    "/js/**"
                            ).permitAll();
                })
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage(Endpoints.LOGIN)
                    .loginProcessingUrl(Endpoints.LOGIN)
                    .failureUrl(Endpoints.LOGIN + "?badCredentials")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .defaultSuccessUrl(Endpoints.CALENDER)
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }

}

/* resources: https://mainul35.medium.com/spring-mvc-spring-security-in-memory-user-details-configuration-90d106b53d23
https://github.com/DanielW1987/tinder-for-dogs
 */