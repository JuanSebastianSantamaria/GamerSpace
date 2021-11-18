package com.project.GamerSpaceServer.configuration;

import org.springframework.core.env.Environment;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    private Environment environment;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired LogoutSuccessHandlerGS logoutSuccessHandler;

    public WebSecurityConfig(Environment environment){
        this.environment = environment;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .cors().and()
			.headers().frameOptions().disable().and()
			.csrf().disable()
			.authorizeRequests().antMatchers("/login", "/customer/new", "/h2/**").permitAll()
			.anyRequest().authenticated().and()
			.logout().logoutSuccessHandler(logoutSuccessHandler).and()
			.addFilter(new JWTAuthenticationFilter(authenticationManager()))
			.addFilter(new JWTAuthorizationFilter(authenticationManager()));
    }

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder(){
		return new BCryptPasswordEncoder();
	}

    @Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(getListProperty("cors.allowed.origins"));
		config.setAllowedMethods(getListProperty("cors.allowed.methods"));
		config.setAllowedHeaders(getListProperty("cors.allowed.headers"));
		config.setExposedHeaders(getListProperty("cors.exposed.headers"));
		config.setAllowCredentials(getBooleanProperty("cors.allow.credentials"));
		config.setMaxAge(getLongProperty("cors.maxage"));
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}

    private List<String> getListProperty(String key){
		return Arrays.asList(environment.getProperty(key).split(","));
	}
	
	private Boolean getBooleanProperty(String key){
		return Boolean.valueOf(environment.getProperty(key));
	}
	
	private Long getLongProperty(String key){
		return Long.valueOf(environment.getProperty(key));
	}


}
