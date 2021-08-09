//package com.ssafy.hellingers.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter
//{
//
//    @Autowired
//    private UserDetailServiceImpl userDetailService;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        //Cross-origin-resource-sharing: 제공 -> localhost: 8080, 요청 -> localhost:4200 (cors로 허용/차단)
//        http.cors().and()
//        .authorizeRequests()
//                //모든 사람이 접근할 수 있는 공개 경로가 있습니다..
//                .antMatchers("/error", "/api/user/**").permitAll()
//                //관리자 역할만 접근할 수 있습니다. 여기서 ADMIN은 ADMIN 또는 ROLE_ADMIN을 의미합니다.
//                .antMatchers("/api/admin/**").hasRole("ADMIN")
//                //나머지 모든 경로는 인증이 필요합니다.
//                .anyRequest().fullyAuthenticated()
//                .and()
//                //logout will log the user out by invalidated session.
//                .logout().permitAll()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/api/user/logout", "POST"))
//                .and()
//                //로그인 형식 및 경로
//                .formLogin().loginPage("/api/user/login").and()
//                //기본 인증을 활성화합니다. 따라서 Authorization 유형은 BasicAuthorization입니다. bto(사용자 이름:비밀번호)
//                .httpBasic().and()
//
//                //기본 SessionPolicy는 IF_REQUIRED: 필요한 경우에만 세션이 생성됩니다.
//                //STATELESS: 세션이 생성되거나 사용되지 않습니다.
//                //예: 엔드포인트가 있는 USER에서 ADMIN으로 사용자 역할 변경.
//                // IF_REQUIRED는 세션 데이터(USER)를 유지하고 STATELESS는 새 데이터(ADMIN)를 유지합니다.
//
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                //Cross side request forgery.
//                .csrf().disable();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
//    }
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer()
//    {
//        return new WebMvcConfigurer()
//        {
//            @Override
//            public void addCorsMappings(CorsRegistry registry)
//            {
//                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*"); //모든 접근 허용
//            }
//        };
//    }
//}
