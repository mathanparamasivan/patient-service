package com.app.patient.service.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public Map<String, Object> getUserInfo(@AuthenticationPrincipal OidcUser oidcUser) {
        return Map.of(
                "name", oidcUser.getFullName(),
                "email", oidcUser.getEmail(),
                "picture", oidcUser.getPicture(),
                "jwt", oidcUser.getIdToken().getTokenValue()
        );
    }

    @GetMapping("/token")
    public Map<String, Object> getToken(@AuthenticationPrincipal OAuth2AuthenticationToken authentication) {
        OAuth2User user = authentication.getPrincipal();
        return user.getAttributes();
    }
}
