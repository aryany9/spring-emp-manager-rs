package com.example.demo.service.keycloak;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.representations.idm.GroupRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;

@Service
public class KeycloakUserServiceImpl implements KeycloakUserService{

    private static final String role = "FIU";
    private final RealmResource realmResource;
    public KeycloakUserServiceImpl(
            final @Value("${app.keycloak.url}") String authServerUrl,
            final @Value("${app.keycloak.realm}") String realm,
            final @Value("${app.keycloak.client}") String clientId,
            final @Value("${app.keycloak.clientSecret}") String clientSecret) {

        realmResource =
                KeycloakBuilder.builder()
                        .serverUrl(authServerUrl)
                        .grantType(OAuth2Constants.CLIENT_CREDENTIALS)
                        .realm(realm)
                        .clientId(clientId)
                        .clientSecret(clientSecret)
                        .resteasyClient(new ResteasyClientBuilder().connectionPoolSize(10).build())
                        .build()
                        .realm(realm);

        try {
            realmResource.roles().get(role).toRepresentation();
        } catch (NotFoundException e) {
            log.info("Added new role for FIU");
            RoleRepresentation roleRepresentation = new RoleRepresentation();
            roleRepresentation.setName(role);
            realmResource.roles().create(roleRepresentation);
        }

        if (realmResource.groups().groups().stream().noneMatch(group -> group.getName().equals(parentGroupName))) {
            GroupRepresentation entityGroupRepresentation = new GroupRepresentation();
            entityGroupRepresentation.setName(parentGroupName);
            realmResource.groups().add(entityGroupRepresentation);
            GroupRepresentation groupRepresentation =
                    realmResource.getGroupByPath("/" + parentGroupName);
            realmResource.roles().get("ADMIN").getRoleUserMembers().forEach(userRepresentation -> {
                UserResource userResource = realmResource.users().get(userRepresentation.getId());
                userResource.joinGroup(groupRepresentation.getId());
            });
        }
    }
}
