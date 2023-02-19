package com.knasel.billstopay.api.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class AnoReferencia {

    @Id
    private Long id;
    private Integer anoReferencia;

    @OneToMany(mappedBy = "anoReferencia", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ContaAPagar> constasAPagar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAnoReferencia() {
        return anoReferencia;
    }

    public void setAnoReferencia(Integer anoReferencia) {
        this.anoReferencia = anoReferencia;
    }
}
