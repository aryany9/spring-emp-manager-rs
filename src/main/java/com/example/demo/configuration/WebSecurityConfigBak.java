//package com.example.demo.configuration;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
//import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
//import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
//import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
//import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
//import org.springframework.security.oauth2.jwt.JwtClaimNames;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.stereotype.Component;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.*;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//public class WebSecurityConfig {
//
//    @Bean
//    SecurityFilterChain
//    clientSecurityFilterChain(HttpSecurity http, InMemoryClientRegistrationRepository clientRegistrationRepository)
//            throws Exception {
//        http.oauth2Login(withDefaults());
//        http.logout(logout -> {
//            logout.logoutSuccessHandler(new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository));
//        });
//        // @formatter:off
//        http.authorizeHttpRequests(ex -> ex
//                .requestMatchers("/", "/login/**", "/oauth2/**").permitAll()
//                .requestMatchers("/nice.html").hasAuthority("NICE")
//                .anyRequest().authenticated());
//        // @formatter:on
//        return http.build();
//    }
//
//    @Component
//    @RequiredArgsConstructor
//    static class GrantedAuthoritiesMapperImpl implements GrantedAuthoritiesMapper {
//
//        @Override
//        public Collection<? extends GrantedAuthority> mapAuthorities(Collection<? extends GrantedAuthority> authorities) {
//            Set<GrantedAuthority> mappedAuthorities = new HashSet<>();
//
//            authorities.forEach(authority -> {
//                if (OidcUserAuthority.class.isInstance(authority)) {
//                    final var oidcUserAuthority = (OidcUserAuthority) authority;
//                    final var issuer = oidcUserAuthority.getIdToken().getClaimAsURL(JwtClaimNames.ISS);
//                    mappedAuthorities.addAll(extractAuthorities(oidcUserAuthority.getIdToken().getClaims()));
//
//                } else if (OAuth2UserAuthority.class.isInstance(authority)) {
//                    try {
//                        final var oauth2UserAuthority = (OAuth2UserAuthority) authority;
//                        final var userAttributes = oauth2UserAuthority.getAttributes();
//                        final var issuer = new URL(userAttributes.get(JwtClaimNames.ISS).toString());
//                        mappedAuthorities.addAll(extractAuthorities(userAttributes));
//
//                    } catch (MalformedURLException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            });
//
//            return mappedAuthorities;
//        };
//
//        @SuppressWarnings({ "rawtypes", "unchecked" })
//        private static Collection<GrantedAuthority> extractAuthorities(Map<String, Object> claims) {
//            /* See resource server solution above for authorities mapping */
//            return null;
//        }
//    }
//}
