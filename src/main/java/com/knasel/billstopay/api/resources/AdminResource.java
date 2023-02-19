package com.knasel.billstopay.api.resources;

import com.knasel.billstopay.api.domain.dto.UsuarioLogadoDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminResource {

    @GetMapping
    public String adminHome(@AuthenticationPrincipal Jwt userToken) {
      var usuarioLogado = new UsuarioLogadoDTO(userToken);
        return "Welcome "+ usuarioLogado.getNomeCompleto() + " ("+ usuarioLogado.getLogin()
                + ")! Only Admins can access this resource! Your Current Role(s): " + usuarioLogado.getPerfis() + ".";
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
