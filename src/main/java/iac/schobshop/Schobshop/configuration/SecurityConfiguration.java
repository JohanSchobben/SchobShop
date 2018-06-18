package iac.schobshop.Schobshop.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private DataSource dataSource;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private String usersQuery = "select email, password, active from user where email=?";
    private String rolesQuery = "select u.email, r.name from user u inner join user_role ur on(u.id=ur.user_id) inner join role r on(ur.role_id=r.id) where u.email=?";


    public SecurityConfiguration(DataSource dataSource, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.dataSource = dataSource;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        FormLoginConfigurer<HttpSecurity> httpSecurityFormLoginConfigurer = http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/category/**").permitAll()
                .antMatchers("/product/**").permitAll()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/shoppingcart/get").permitAll()
                .antMatchers(HttpMethod.POST, "/shoppingcart/update")
                .permitAll().and()
                .csrf()
                .disable()
                .authorizeRequests()
                .anyRequest().authenticated().and().formLogin().loginPage("/login")
                .defaultSuccessUrl("/profile")
                .usernameParameter("email")
                .passwordParameter("password").permitAll();

        http.cors().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/webjars/**", "/static/**", "/css/**",  "/js/**", "/images/**");
    }

}
