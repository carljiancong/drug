package com.harmonycloud.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author qidong
 * @date 2019/3/10
 */
public class DrugFavouriteGroupDto implements Serializable {
    Integer drugFavouriteGroupId;
    String groupName;
    List<DrugFavouriteGroupDrugDto> drugFavouriteGroupDrugDtoList;

    public DrugFavouriteGroupDto(Integer drugFavouriteGroupId, String groupName,
                                 List<DrugFavouriteGroupDrugDto> drugFavouriteGroupDrugDtoList) {
        this.drugFavouriteGroupId = drugFavouriteGroupId;
        this.groupName = groupName;
        this.drugFavouriteGroupDrugDtoList = drugFavouriteGroupDrugDtoList;
    }

    public DrugFavouriteGroupDto() {
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

    public List<DrugFavouriteGroupDrugDto> getDrugFavouriteGroupDrugDtoList() {
        return drugFavouriteGroupDrugDtoList;
    }

    public void setDrugFavouriteGroupDrugDtoList(List<DrugFavouriteGroupDrugDto> drugFavouriteGroupDrugDtoList) {
        this.drugFavouriteGroupDrugDtoList = drugFavouriteGroupDrugDtoList;
    }
}
