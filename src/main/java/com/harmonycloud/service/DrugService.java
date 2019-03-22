package com.harmonycloud.service;

import com.harmonycloud.entity.Drug;
import com.harmonycloud.enums.ErrorMsgEnum;
import com.harmonycloud.exception.DrugException;
import com.harmonycloud.monRepository.DrugMonRepository;
import com.harmonycloud.oraRepository.DrugOraRepository;
import com.harmonycloud.result.CimsResponseWrapper;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2019/3/4
 */
@Service
public class DrugService {

    private static final Logger logger = LoggerFactory.getLogger(DrugService.class);

    @Autowired
    private DrugMonRepository drugMonRepository;

    @Autowired
    private DrugOraRepository drugOraRepository;


    /**
     * get drug list by key word in ingredient and tradename table
     * @param keyword
     * @return
     */
    public List<Drug> getDrugList(String keyword) throws Exception {
        List<Drug> drugList = null;
        drugList = drugMonRepository.findByIngredientLike(keyword);
        drugList.addAll(drugMonRepository.findByTradeNameLike(keyword));

        if (drugList == null || drugList.size() == 0) {
            drugList = drugOraRepository.findByIngredient(keyword);
            drugList.addAll(drugOraRepository.findByTradeNameContaining(keyword));
        }
        return drugList;
    }

    /**
     * get drug by drug id
     *
     * @param drugId
     * @return
     */
    public Drug getDrug(Integer drugId) throws DrugException {
        Drug drug = null;
        try {
            drug = drugMonRepository.findByDrugId(drugId);
            if (drug == null) {
                drug = drugOraRepository.findByDrugId(drugId);
            }
        } catch (Exception e) {
            throw new DrugException(ErrorMsgEnum.QUERY_DATA_ERROR.getMessage());
        }
        return drug;
    }

    /**
     * get drug list by integer list
     *
     * @param drugIdList
     * @return
     * @throws Exception
     */
    public Map<Integer, Object> getDrugListByIntegerList(Integer[] drugIdList) throws DrugException {

        Map<Integer, Object> drugMap = new HashMap<>();

        for (int i = 0; i < drugIdList.length; i++) {
            Drug drug = drugMonRepository.findByDrugId(drugIdList[i]);

            if (drug == null) {
                drug = drugOraRepository.findByDrugId(drugIdList[i]);
            }
            drugMap.put(drug.getDrugId(), drug);
        }


        return drugMap;
    }

    /**
     * get drug list by integer list
     * @param IntegerList
     * @return
     */
    public Map<Integer, Drug> getDrugByInteger(List<Integer> IntegerList) {
        Map<Integer, Drug> drugMap = new HashMap<>();
        Iterable<Drug> drugs = drugMonRepository.findAllById(IntegerList);
        if (drugs == null) {
            drugs = drugOraRepository.findAllById(IntegerList);
        }
        drugs.forEach(drug -> {
            drugMap.put(drug.getDrugId(), drug);
        });
        return drugMap;
    }
}
