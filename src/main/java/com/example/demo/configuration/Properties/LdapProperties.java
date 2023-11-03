package com.example.demo.configuration.Properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.ldap.embedded")
public class LdapProperties {
    private String ldif;
    private String baseDn;
    private int port;
}