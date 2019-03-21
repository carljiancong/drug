package com.harmonycloud.service;

import com.harmonycloud.dto.DrugFavouriteGroupDrugDto;
import com.harmonycloud.dto.DrugFavouriteGroupDto;
import com.harmonycloud.entity.DrugFavouriteGroup;
import com.harmonycloud.monRepository.DrugFavouriteGroupMonRepository;
import com.harmonycloud.oraRepository.DrugFavouriteGroupOraRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DrugFavouriteGroupService {

    private static final Logger logger = LoggerFactory.getLogger(DrugFavouriteGroupService.class);

    @Autowired
    private DrugFavouriteGroupMonRepository drugFavouriteGroupMonRepository;

    @Autowired
    private DrugFavouriteGroupDrugService drugFavouriteGroupDrugService;

    @Autowired
    private DrugFavouriteGroupOraRepository drugFavouriteGroupOraRepository;

    /**
     * get department favoute drug by clinic id
     * @param clinicId
     * @return
     * @throws Exception
     */
    public List<DrugFavouriteGroupDto> getDepFavList(Integer clinicId) throws Exception {
        List<DrugFavouriteGroupDto> drugFavouriteGroupDtoList = new ArrayList<>();
        List<DrugFavouriteGroup> drugFavouriteGroupList = null;

        //搜索部门
        drugFavouriteGroupList = drugFavouriteGroupMonRepository.findByClinicId(clinicId);

        //oracle search
        if (drugFavouriteGroupList == null || drugFavouriteGroupList.size() == 0) {
            drugFavouriteGroupList = drugFavouriteGroupOraRepository.findByClinicId(clinicId);
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

        return drugFavouriteGroupDtoList;
    }
}
