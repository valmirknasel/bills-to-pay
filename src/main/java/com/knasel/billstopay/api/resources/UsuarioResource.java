package com.knasel.billstopay.api.resources;

import com.knasel.billstopay.api.domain.dto.UsuarioLogadoDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioResource {

    @GetMapping
    public String usuariosHome(@AuthenticationPrincipal Jwt userToken) {
        var usuarioLogado = new UsuarioLogadoDTO(userToken);
        return "Welcome "+ usuarioLogado.getNomeCompleto() + " ("+ usuarioLogado.getLogin()
                + ")! You are accessing a restricted area! Your Current Role(s): " + usuarioLogado.getPerfis() + ".";
    }
}
