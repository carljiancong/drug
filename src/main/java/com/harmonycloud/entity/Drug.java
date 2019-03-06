package com.harmonycloud.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

/**
 * @author qidong
 * @date 2019/2/13
 */
@Document(collection = "drug")
@Entity
@Table(name = "drug")
public class Drug {
    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer drugId;
    @Column(name = "ingredient")
    private String ingredient;
    @Column(name = "trade_name")
    private String tradeName;

    public Drug() {
    }

    public Drug(Integer drugId, String ingredient, String tradeName) {
        this.drugId = drugId;
        this.ingredient = ingredient;
        this.tradeName = tradeName;
    }

    public Integer getId() {
        return drugId;
    }

    public void setId(Integer drugId) {
        this.drugId = drugId;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }
}
