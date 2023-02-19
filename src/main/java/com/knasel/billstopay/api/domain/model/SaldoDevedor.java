package com.knasel.billstopay.api.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class SaldoDevedor {

    @Id
    private Long id;
    private BigDecimal saldoDevedor;

    @OneToMany(mappedBy = "saldoDevedor", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ContaAPagar> contasAPagar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSaldoDevedor() {
        return saldoDevedor;
    }

    public void setSaldoDevedor(BigDecimal saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }

    public List<ContaAPagar> getContasAPagar() {
        return contasAPagar;
    }

    public void setContasAPagar(List<ContaAPagar> contasAPagar) {
        this.contasAPagar = contasAPagar;
    }
}
