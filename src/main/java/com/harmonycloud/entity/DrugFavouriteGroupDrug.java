package com.harmonycloud.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

/**
 * @author qidong
 * @date 2019/2/13
 */
@Document(collection = "drug_favourite_group_drug")
@Entity
@Table(name = "drug_favourite_group_drug")
public class DrugFavouriteGroupDrug {

    @Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer drugFavouriteGroupDrugId;
    @Column(name = "drug_favourite_group_id")
    private Integer drugFavouriteGroupId;
    @Column(name = "drug_id")
    private Integer drugId;
    @Column(name = "regimen_line")
    private String regimenLine;

    public DrugFavouriteGroupDrug() {
    }

    public DrugFavouriteGroupDrug(Integer drugFavouriteGroupDrugId, Integer drugFavouriteGroupId, Integer drugId, String regimenLine) {
        this.drugFavouriteGroupDrugId = drugFavouriteGroupDrugId;
        this.drugFavouriteGroupId = drugFavouriteGroupId;
        this.drugId = drugId;
        this.regimenLine = regimenLine;
    }

    public Integer getDrugFavouriteGroupDrugId() {
        return drugFavouriteGroupDrugId;
    }

    public void setDrugFavouriteGroupDrugId(Integer drugFavouriteGroupDrugId) {
        this.drugFavouriteGroupDrugId = drugFavouriteGroupDrugId;
    }

    public Integer getDrugFavouriteGroupId() {
        return drugFavouriteGroupId;
    }

    public void setDrugFavouriteGroupId(Integer drugFavouriteGroupId) {
        this.drugFavouriteGroupId = drugFavouriteGroupId;
    }

    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public String getRegimenLine() {
        return regimenLine;
    }

    public void setRegimenLine(String regimenLine) {
        this.regimenLine = regimenLine;
    }
}
