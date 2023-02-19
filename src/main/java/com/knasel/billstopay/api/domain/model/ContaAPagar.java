package com.knasel.billstopay.api.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "tb_contas_a_pagar")
public class ContaAPagar {

    @Id
    private Long id;
    private String descricao;
    private BigDecimal valorAtualDaConta;
    private boolean possuiParcelas;
    private Integer totalDeParcelas;
    private boolean cobrancaRecorrente;
    private boolean despesaFixa;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_mes_referencia")
    private MesReferencia mesReferencia;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_ano_referencia")
    private AnoReferencia anoReferencia;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_situacao_pagamento")
    private SituacaoPagamento situacaoPagamento;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "id_saldo_devedor")
    private SaldoDevedor saldoDevedor;

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

    public BigDecimal getValorAtualDaConta() {
        return valorAtualDaConta;
    }

    public void setValorAtualDaConta(BigDecimal valorAtualDaConta) {
        this.valorAtualDaConta = valorAtualDaConta;
    }

    public boolean isPossuiParcelas() {
        return possuiParcelas;
    }

    public void setPossuiParcelas(boolean possuiParcelas) {
        this.possuiParcelas = possuiParcelas;
    }

    public Integer getTotalDeParcelas() {
        return totalDeParcelas;
    }

    public void setTotalDeParcelas(Integer totalDeParcelas) {
        this.totalDeParcelas = totalDeParcelas;
    }

    public boolean isCobrancaRecorrente() {
        return cobrancaRecorrente;
    }

    public void setCobrancaRecorrente(boolean cobrancaRecorrente) {
        this.cobrancaRecorrente = cobrancaRecorrente;
    }

    public boolean isDespesaFixa() {
        return despesaFixa;
    }

    public void setDespesaFixa(boolean despesaFixa) {
        this.despesaFixa = despesaFixa;
    }

    public MesReferencia getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(MesReferencia mesDeReferencia) {
        this.mesReferencia = mesDeReferencia;
    }

    public AnoReferencia getAnoReferencia() {
        return anoReferencia;
    }

    public void setAnoReferencia(AnoReferencia anoDeReferencia) {
        this.anoReferencia = anoDeReferencia;
    }

    public SituacaoPagamento getSituacaoPagamento() {
        return situacaoPagamento;
    }

    public void setSituacaoPagamento(SituacaoPagamento situacaoPagamento) {
        this.situacaoPagamento = situacaoPagamento;
    }

    public SaldoDevedor getSaldoDevedor() {
        return saldoDevedor;
    }

    public void setSaldoDevedor(SaldoDevedor saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }
}
