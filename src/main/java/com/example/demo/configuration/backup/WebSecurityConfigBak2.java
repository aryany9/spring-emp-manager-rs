//package com.example.demo.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class WebSecurityConfigBak2 {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .anyRequest().fullyAuthenticated()
//                .and()
//                .formLogin(Customizer.withDefaults());
//
//        return http.build();
//    }
//
//
//    @Autowired
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth
////                .ldapAuthentication()
////                .userDnPatterns("uid={0},ou=people")
////                .groupSearchBase("ou=groups")
////                .contextSource()
////                .url("ldap://localhost:8389/dc=springframework,dc=org")
////                .and()
////                .passwordCompare()
////                .passwordEncoder(new BCryptPasswordEncoder())
////                .passwordAttribute("userPassword");
//        auth.ldapAuthentication()
////                .userDetailsContextMapper(inetOrgPersonContextMapper())
//                .userSearchFilter("(uid={0})")
//                .userSearchBase("dc=example,dc=com")
//                .groupSearchBase("ou=mathematicians,dc=example,dc=com")
//                .groupSearchFilter("cn={0}")
//                .contextSource()
//                .url("ldap://ldap.forumsys.com")
//                .port(389)
//                .managerDn("cn=read-only-admin,dc=example,dc=com")
//                .managerPassword("password");
//    }
//}
