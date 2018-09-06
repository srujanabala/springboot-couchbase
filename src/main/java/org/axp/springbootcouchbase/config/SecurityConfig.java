package org.axp.springbootcouchbase.config;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigureAdapter {

    @Override
    protected void configure(HTTPSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/css/**","/index").permitAll()
                .antMatchers("/user/**").hasRole("USER")
                .and()
                .formLogin()
                .loginPage("/login").failureUrl("?login-error");

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
