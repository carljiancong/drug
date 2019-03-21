package com.harmonycloud.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

/**
 * @date 2019/2/13
 */
@Document(collection = "drug")
@Entity
@Table(name = "drug")
public class Drug {
    @Id
    @org.springframework.data.annotation.Id
    private Integer drugId;
    @Column(name = "ingredient")
    private String ingredient;
    @Column(name = "trade_name")
    private String tradeName;
    @Column(name = "regimen_line")
    private String regimenLine;

    public Drug() {
    }

    public Drug(Integer drugId, String ingredient, String tradeName, String regimenLine) {
        this.drugId = drugId;
        this.ingredient = ingredient;
        this.tradeName = tradeName;
        this.regimenLine = regimenLine;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
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

    public String getRegimenLine() {
        return regimenLine;
    }

    public void setRegimenLine(String regimenLine) {
        this.regimenLine = regimenLine;
    }
}
