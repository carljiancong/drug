package com.harmonycloud.service;

import com.harmonycloud.dto.DrugFavouriteGroupDrugDto;
import com.harmonycloud.entity.Drug;
import com.harmonycloud.entity.DrugFavouriteGroupDrug;
import com.harmonycloud.monRepository.DrugFavouriteGroupDrugMonRepository;
import com.harmonycloud.monRepository.DrugMonRepository;
import com.harmonycloud.oraRepository.DrugFavouriteGroupDrugOraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @date 2019/3/10
 */
@Service
public class DrugFavouriteGroupDrugService {

    @Autowired
    private DrugFavouriteGroupDrugMonRepository drugFavouriteGroupDrugMonRepository;

    @Autowired
    private DrugFavouriteGroupDrugOraRepository drugFavouriteGroupDrugOraRepository;

    @Autowired
    private DrugService drugService;



    /**
     * get favourite drug by drugFavouriteGroupId
     * @param drugFavouriteGroupId
     * @return
     * @throws Exception
     */
    public List<DrugFavouriteGroupDrugDto> getDrugFavGroupDrug(Integer drugFavouriteGroupId) throws Exception {
        List<DrugFavouriteGroupDrugDto> dfgddList = new ArrayList<>();
        List<DrugFavouriteGroupDrug> drugFavouriteGroupDrugList = drugFavouriteGroupDrugMonRepository.findByDrugFavouriteGroupId(drugFavouriteGroupId);

        //oracle search
        if (drugFavouriteGroupDrugList == null || drugFavouriteGroupDrugList.size() == 0) {
            drugFavouriteGroupDrugList = drugFavouriteGroupDrugOraRepository.findByDrugFavouriteGroupId(drugFavouriteGroupId);
        }

        // 通过查询整个integer list, 获取drug list
        List<Integer> integerList = new ArrayList<>();
        Map<Integer, Drug> drugMap = null;
        for (DrugFavouriteGroupDrug dfgd : drugFavouriteGroupDrugList) {
            integerList.add(dfgd.getDrugId());
        }
        drugMap = drugService.getDrugByInteger(integerList);


        for (DrugFavouriteGroupDrug dfgd : drugFavouriteGroupDrugList) {

            Drug drug = drugMap.get(dfgd.getDrugId());
            DrugFavouriteGroupDrugDto drugFavouriteGroupDrugDto = new DrugFavouriteGroupDrugDto();

            drugFavouriteGroupDrugDto.setDrugFavGrpDrugId(dfgd.getDrugFavGrpDrugId());
            drugFavouriteGroupDrugDto.setDrugId(drug.getDrugId());
            drugFavouriteGroupDrugDto.setIngredient(drug.getIngredient());
            drugFavouriteGroupDrugDto.setTradeName(drug.getTradeName());
            drugFavouriteGroupDrugDto.setRegimenLine(dfgd.getRegimenLine());

            dfgddList.add(drugFavouriteGroupDrugDto);
        }

        return dfgddList;
    }
}
