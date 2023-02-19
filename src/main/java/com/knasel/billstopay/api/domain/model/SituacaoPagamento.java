package com.knasel.billstopay.api.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class SituacaoPagamento {

    @Id
    private Long id;
    private String descricaoSituacao;

    @OneToMany(mappedBy = "situacaoPagamento", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ContaAPagar> constasAPagar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoSituacao() {
        return descricaoSituacao;
    }

    public void setDescricaoSituacao(String descricaoSituacao) {
        this.descricaoSituacao = descricaoSituacao;
    }
}
