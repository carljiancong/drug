package com.harmonycloud.dto;

/**
 * @date 2019/3/10
 */
public class DrugFavouriteGroupDrugDto {
    Integer drugFavGrpDrugId;
    Integer drugId;
    String ingredient;
    String tradeName;
    String regimenLine;

    public DrugFavouriteGroupDrugDto(Integer drugFavGrpDrugId, Integer drugId, String ingredient,
                                     String tradeName, String regimenLine) {
        this.drugFavGrpDrugId = drugFavGrpDrugId;
        this.drugId = drugId;
        this.ingredient = ingredient;
        this.tradeName = tradeName;
        this.regimenLine = regimenLine;
    }

    public DrugFavouriteGroupDrugDto() {
    }

    public Integer getDrugFavGrpDrugId() {
        return drugFavGrpDrugId;
    }

    public void setDrugFavGrpDrugId(Integer drugFavGrpDrugId) {
        this.drugFavGrpDrugId = drugFavGrpDrugId;
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
