package com.example.demo.configuration.Properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "authorization-server.client.web-client")
public class WebClientProperties {
    private String clientId;
    private String clientSecret;
    private String redirectUri;
    private String postLogoutRedirectUri;
}
