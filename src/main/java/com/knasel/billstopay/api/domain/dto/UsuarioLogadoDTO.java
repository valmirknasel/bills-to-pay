package com.knasel.billstopay.api.domain.dto;

import org.springframework.security.oauth2.jwt.Jwt;

import java.util.ArrayList;
import java.util.List;

public class UsuarioLogadoDTO {

    private String nomeCompleto;
    private String login;
    private List<String> perfis;

    public UsuarioLogadoDTO(Jwt userToken) {
        var claims = userToken.getClaims();
        ArrayList<String> roles = (ArrayList<String>) claims.get("roles");
        List<String> sortedRoles = roles.stream().sorted().toList();
        this.setNomeCompleto(claims.get("name").toString());
        this.setLogin(claims.get("preferred_username").toString());
        this.setPerfis(sortedRoles);
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<String> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<String> perfis) {
        this.perfis = perfis;
    }
}
