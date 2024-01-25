package com.lfailasse.RPBackend.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "RPRecipient")
public class EntityRPRecipient {

    @Id
    @NonNull
    @Column(name = "recipient_document")
    private String document;

    @NonNull
    @Column(name = "recipient_name")
    private String name;

    @Column(name = "recipient_lastpayment")
    private String lastpayment;

    @Column(name = "credito_banco_n")
    private Integer credito_banco_n;

    @Column(name = "credito_banco_nome")
    private String credito_banco_nome;

    @Column(name = "credito_agencia_n")
    private Integer credito_agencia_n;

    @Column(name = "credito_agencia_nome")
    private String credito_agencia_nome;

    @Column(name = "credito_cc_n")
    private Integer credito_cc_n;

    @Column(name = "pix")
    private String pix;

    public EntityRPRecipient() {

    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastpayment() {
        return lastpayment;
    }

    public void setLastpayment(String lastpayment) {
        this.lastpayment = lastpayment;
    }

    public String getCredito_banco_nome() {
        return credito_banco_nome;
    }

    public void setCredito_banco_nome(String credito_banco_nome) {
        this.credito_banco_nome = credito_banco_nome;
    }

    public Integer getCredito_agencia_n() {
        return credito_agencia_n;
    }

    public void setCredito_agencia_n(Integer credito_agencia_n) {
        this.credito_agencia_n = credito_agencia_n;
    }

    public String getCredito_agencia_nome() {
        return credito_agencia_nome;
    }

    public void setCredito_agencia_nome(String credito_agencia_nome) {
        this.credito_agencia_nome = credito_agencia_nome;
    }

    public Integer getCredito_cc_n() {
        return credito_cc_n;
    }

    public void setCredito_cc_n(Integer integer) {
        this.credito_cc_n = integer;
    }

    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }

    public Integer getCredito_banco_n() {
        return credito_banco_n;
    }

    public void setCredito_banco_n(Integer integer) {
        this.credito_banco_n = integer;
    }

}
