package com.knasel.billstopay.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(authorizeConfig -> {
                    authorizeConfig.requestMatchers("/", "/login", "/logout").permitAll();
                    authorizeConfig.requestMatchers("/api/v1/admin/**").hasAuthority("ADMIN");
                    authorizeConfig.requestMatchers("/api/v1/usuarios/**").hasAnyAuthority("ADMIN", "BASIC_USER");
                    authorizeConfig.requestMatchers("/api/v1/consultas/**").hasAnyAuthority("ADMIN", "BASIC_USER", "READ_ONLY");
                    authorizeConfig.anyRequest().authenticated();
                })
                .oauth2ResourceServer(httpSecurityOAuth2ResourceServerConfigurer ->
                        httpSecurityOAuth2ResourceServerConfigurer
                                .jwt()
                                // realiza o mapeamento do token JWT para que o Spring Security leia as Roles do JWT corretamente
                                .jwtAuthenticationConverter(jwtCustomAuthenticationConverter())
                )
                .logout().and()
                .build();
    }

    /**
     * @return // Cria um conversor JWT para mapear os perfis de usuario corretamente conforme a claim "roles" do JWT.
     * É necessário configurar um mapper para o respectivo "client" no Keycloak (Aba Mappers do Client) e configurar o "Token Claim Name = roles"
     * para que o conversor reconheça os perfis de usuario mapeados. As "Roles" devem ser mapeadas no respectivo Client do Keycloak
     * em: Acessar o respectivo Realm > Clients > Clicar no client que vai configurar > Aba Roles
     */
    private JwtAuthenticationConverter jwtCustomAuthenticationConverter() {
        // Necessario configurar um mapper do client no keycloak com "Token Claim Name = roles" e os respectivos perfis na aba "Roles" no Client
        JwtGrantedAuthoritiesConverter jac = new JwtGrantedAuthoritiesConverter();
        jac.setAuthoritiesClaimName("roles");
        jac.setAuthorityPrefix(""); // remove o prefixo SCOPE das claims dentro de "roles"
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jac);
        return jwtAuthenticationConverter;
    }
}
