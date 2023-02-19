package com.knasel.billstopay.api.resources;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminResource {

    @GetMapping
    public String adminHome(@AuthenticationPrincipal Jwt userToken) {
        Map<String, Object> claims = userToken.getClaims();
        String name = claims.get("name").toString();
        String login = claims.get("preferred_username").toString();
        ArrayList<String> roles = (ArrayList<String>) claims.get("roles");
        List<String> sortedRoles = roles.stream().sorted().collect(Collectors.toList());
        return "Welcome "+ name + " ("+ login + ")! Only Admins can access this resource! Your Current Role(s): " + sortedRoles + ".";
    }

    @GetMapping("/token-claims")
    public String token(@AuthenticationPrincipal Jwt userToken) {
        return userToken.getClaims().toString();
    }

    @GetMapping("/jwt-token")
    public String jwtToken(@AuthenticationPrincipal Jwt userToken) {
        return userToken.getTokenValue();
    }
}
