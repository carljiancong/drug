package com.harmonycloud.service;

import com.harmonycloud.dto.DrugFavouriteGroupDrugDto;
import com.harmonycloud.dto.DrugFavouriteGroupDto;
import com.harmonycloud.entity.DrugFavouriteGroup;
import com.harmonycloud.monRepository.DrugFavouriteGroupMonRepository;
import com.harmonycloud.result.ErrorMsgConstant;
import com.harmonycloud.result.CimsResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qidong
 * @date 2019/3/10
 */
@Service
public class DrugFavouriteGroupService {

    @Autowired
    DrugFavouriteGroupMonRepository drugFavouriteGroupMonRepository;

    @Autowired
    DrugFavouriteGroupDrugService drugFavouriteGroupDrugService;

    /**
     * 根据clinicId，搜索部门，在根据部门的id搜索常用的药
     * @param clinicId
     * @return
     */
    public CimsResponseWrapper getDepFavList(Integer clinicId) throws Exception{
        List<DrugFavouriteGroupDto> drugFavouriteGroupDtoList = new ArrayList<>();
        List<DrugFavouriteGroup> drugFavouriteGroupList = null;

        //搜索部门
        try {
            drugFavouriteGroupList = drugFavouriteGroupMonRepository.findByClinicId(clinicId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(ErrorMsgConstant.QUERY_DATA_ERROR);
        }

        //根据部门的id搜索常用的药
        for (DrugFavouriteGroup dfg : drugFavouriteGroupList) {
            List<DrugFavouriteGroupDrugDto> dgfdDtoList = drugFavouriteGroupDrugService.getDrugFavGroupDrug(dfg.getDrugFavouriteGroupId());
            DrugFavouriteGroupDto drugFavouriteGroupDto = new DrugFavouriteGroupDto();

            drugFavouriteGroupDto.setDrugFavouriteGroupId(dfg.getDrugFavouriteGroupId());
            drugFavouriteGroupDto.setGroupName(dfg.getGroupName());
            drugFavouriteGroupDto.setDrugFavouriteGroupDrugDtoList(dgfdDtoList);

            drugFavouriteGroupDtoList.add(drugFavouriteGroupDto);
        }

        return CimsResponseWrapper.buildSuccess(drugFavouriteGroupDtoList);
    }
}
