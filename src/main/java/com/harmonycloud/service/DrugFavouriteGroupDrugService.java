package com.harmonycloud.service;

import com.harmonycloud.dto.DrugFavouriteGroupDrugDto;
import com.harmonycloud.entity.Drug;
import com.harmonycloud.entity.DrugFavouriteGroupDrug;
import com.harmonycloud.monRepository.DrugFavouriteGroupDrugMonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qidong
 * @date 2019/3/10
 */
@Service
public class DrugFavouriteGroupDrugService {

    @Autowired
    DrugFavouriteGroupDrugMonRepository drugFavouriteGroupDrugMonRepository;

    @Autowired
    DrugService drugService;

    /**
     * 根据部门id搜索部门常用的药
     * @param drugFavouriteGroupId
     * @return
     */
    public List<DrugFavouriteGroupDrugDto> getDrugFavGroupDrug(Integer drugFavouriteGroupId) throws Exception{
        List<DrugFavouriteGroupDrugDto> dfgddList = new ArrayList<>();
        List<DrugFavouriteGroupDrug> drugFavouriteGroupDrugList = drugFavouriteGroupDrugMonRepository.findByDrugFavouriteGroupId(drugFavouriteGroupId);
        for (DrugFavouriteGroupDrug dfgd: drugFavouriteGroupDrugList) {
            Drug drug = drugService.getDrug(dfgd.getDrugId());

            DrugFavouriteGroupDrugDto drugFavouriteGroupDrugDto = new DrugFavouriteGroupDrugDto();

            drugFavouriteGroupDrugDto.setDrugFavGrpDrugId(dfgd.getDrugFavGrpDrugId());
            drugFavouriteGroupDrugDto.setDrugId(drug.getId());
            drugFavouriteGroupDrugDto.setIngredient(drug.getIngredient());
            drugFavouriteGroupDrugDto.setTradeName(drug.getTradeName());
            drugFavouriteGroupDrugDto.setRegimenLine(dfgd.getRegimenLine());

            dfgddList.add(drugFavouriteGroupDrugDto);
        }

        return dfgddList;
    }
}
