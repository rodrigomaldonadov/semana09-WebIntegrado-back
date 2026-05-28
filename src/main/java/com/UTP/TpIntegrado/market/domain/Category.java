package com.UTP.TpIntegrado.market.domain;

import com.UTP.TpIntegrado.market.persistance.entity.Producto;

import java.util.List;

public class Category {


    private int categoryId;
    private String category;
    private boolean active;






    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    //FALTO AGREGAR ESTO

}
