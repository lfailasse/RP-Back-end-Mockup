package com.lfailasse.RPBackend.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RP")
public class EntityRP {

    @Id
    @Column(name = "rp_id")
    private String id;

    @Column(name = "rp_dataemissao")
    private String dataemissao;

    @Column(name = "rp_debprojeto")
    private String debprojeto;

    @Column(name = "rp_centrodecustos")
    private String centrodecustos;

    @Column(name = "rp_datapagamento")
    private String datapagamento;

    @Column(name = "rp_favorecido")
    private String favorecido;

    @Column(name = "rp_documento")
    private String documento;

    @Column(name = "rp_desc")
    private String desc;

    @Column(name = "rp_anexo")
    private String anexo;

    @Column(name = "rp_banco_n")
    private Integer banco_n;

    @Column(name = "rp_banco_nome")
    private String banco_nome;

    @Column(name = "rp_agencia_n")
    private Integer agencia_n;

    @Column(name = "rp_agencia_nome")
    private String agencia_nome;

    @Column(name = "rp_cc_n")
    private Integer cc_n;

    @Column(name = "rp_pagamento")
    private String pagamento;

    @Column(name = "rp_total")
    private Double total;

    @Column(name = "rp_count")
    private long count = 1;

    @Column(name = "rp_status")
    private Boolean status;

    @OneToMany(mappedBy = "entityRP", cascade = CascadeType.ALL)
    private List<EntityRPItems> rpitems = new ArrayList<>();

    public EntityRP() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataemissao() {
        return dataemissao;
    }

    public void setDataemissao(String dataemissao) {
        this.dataemissao = dataemissao;
    }

    public String getDebprojeto() {
        return debprojeto;
    }

    public void setDebprojeto(String debprojeto) {
        this.debprojeto = debprojeto;
    }

    public String getCentrodecustos() {
        return centrodecustos;
    }

    public void setCentrodecustos(String centrodecustos) {
        this.centrodecustos = centrodecustos;
    }

    public String getDatapagamento() {
        return datapagamento;
    }

    public void setDatapagamento(String datapagamento) {
        this.datapagamento = datapagamento;
    }

    public String getFavorecido() {
        return favorecido;
    }

    public void setFavorecido(String favorecido) {
        this.favorecido = favorecido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<EntityRPItems> getRpitems() {
        return rpitems;
    }

    public void setRpitems(List<EntityRPItems> rpitems) {
        this.rpitems = rpitems;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public Integer getBanco_n() {
        return banco_n;
    }

    public void setBanco_n(Integer banco_n) {
        this.banco_n = banco_n;
    }

    public String getBanco_nome() {
        return banco_nome;
    }

    public void setBanco_nome(String banco_nome) {
        this.banco_nome = banco_nome;
    }

    public Integer getAgencia_n() {
        return agencia_n;
    }

    public void setAgencia_n(Integer agencia_n) {
        this.agencia_n = agencia_n;
    }

    public String getAgencia_nome() {
        return agencia_nome;
    }

    public void setAgencia_nome(String agencia_nome) {
        this.agencia_nome = agencia_nome;
    }

    public Integer getCc_n() {
        return cc_n;
    }

    public void setCc_n(Integer cc_n) {
        this.cc_n = cc_n;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}