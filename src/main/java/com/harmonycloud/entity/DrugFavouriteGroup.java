package com.harmonycloud.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

/**
 * @date 2019/2/13
 */
@Document(collection = "drug_favourite_group")
@Entity
@Table(name = "drug_favourite_group")
public class DrugFavouriteGroup {
    @Id
    @org.springframework.data.annotation.Id
    private Integer drugFavouriteGroupId;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "clinic_id")
    private Integer clinicId;

    public DrugFavouriteGroup() {
    }

    public DrugFavouriteGroup(Integer drugFavouriteGroupId, String groupName, Integer clinicId) {
        this.drugFavouriteGroupId = drugFavouriteGroupId;
        this.groupName = groupName;
        this.clinicId = clinicId;
    }

    public Integer getDrugFavouriteGroupId() {
        return drugFavouriteGroupId;
    }

    public void setDrugFavouriteGroupId(Integer drugFavouriteGroupId) {
        this.drugFavouriteGroupId = drugFavouriteGroupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }
}
