package com.lfailasse.RPBackend.Models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Table(name = "RPItems")
@Entity
public class EntityRPItems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rpitems_id")
    private Integer id;

    @Column(name = "rpitems_name")
    private String name;

    @Column(name = "rpitems_valor")
    private Double valor;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rp_id")
    private EntityRP entityRP;

    public EntityRPItems() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntityRP getEntityRP() {
        return entityRP;
    }

    public void setEntityRP(EntityRP entityRP) {
        this.entityRP = entityRP;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
