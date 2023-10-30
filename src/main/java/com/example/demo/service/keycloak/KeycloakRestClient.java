package com.example.demo.service.keycloak;
import com.example.demo.model.request.AuthenticationAccessTokenRequest;
import com.example.demo.model.request.LoginRequest;
import com.example.demo.model.response.LoginResponse;
import feign.Headers;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import lombok.NoArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        value = "keycloakWithEncoder",
        url = "${app.keycloak.url}",
        configuration = KeycloakRestClientWithFormEncoder.FormSupportConfig.class)
public interface KeycloakRestClientWithFormEncoder {

    @RequestMapping(
            method = RequestMethod.POST,
            value = "realms/${app.keycloak.realm}/protocol/openid-connect/token",
            consumes = "application/x-www-form-urlencoded")
    LoginResponse verifyOtp(
            @RequestHeader("Authorization") String bearerToken, LoginRequest loginRequest);

    @RequestMapping(
            method = RequestMethod.POST,
            value = "realms/${app.keycloak.realm}/protocol/openid-connect/token",
            consumes = "application/x-www-form-urlencoded")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    LoginResponse verifyPassword(AuthenticateUserRequest authenticateUserRequest);

    @RequestMapping(
            method = RequestMethod.POST,
            value = "realms/${app.keycloak.realm}/protocol/openid-connect/token",
            consumes = "application/x-www-form-urlencoded")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    LoginResponse generateAccessToken(
            AuthenticationAccessTokenRequest authenticationAccessTokenRequest);

    @RequestMapping(
            method = RequestMethod.POST,
            value = "realms/${app.keycloak.realm}/protocol/openid-connect/logout",
            consumes = "application/x-www-form-urlencoded")
    @Headers("Content-Type: application/x-www-form-urlencoded")
    void logout(
            @RequestHeader("Authorization") String bearerToken, LogoutUserRequest logoutUserRequest);

    @NoArgsConstructor
    class FormSupportConfig {
        @Bean
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder();
        }
    }
}
