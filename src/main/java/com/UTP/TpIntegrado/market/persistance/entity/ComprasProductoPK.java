package com.UTP.TpIntegrado.market.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;


@Embeddable

public class ComprasProductoPK {
    @Column(name="id_Compra")
    private Integer idCompra;


    @Column(name="id_producto")
    private Integer idProducto;


    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
