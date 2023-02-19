package com.knasel.billstopay.api.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class MesReferencia {

    @Id
    private Long id;
    private String descricao;

    @OneToMany(mappedBy = "mesReferencia", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ContaAPagar> constasAPagar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
