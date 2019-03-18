package com.harmonycloud.service;

import com.harmonycloud.dto.DrugIntegerList;
import com.harmonycloud.entity.Drug;
import com.harmonycloud.enums.ErrorMsgEnum;
import com.harmonycloud.exception.DrugException;
import com.harmonycloud.monRepository.DrugMonRepository;
import com.harmonycloud.result.CimsResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qidong
 * @date 2019/3/4
 */
@Service
public class DrugService {

    @Autowired
    DrugMonRepository drugMonRepository;

    /**
     * 根据关键字，在inredient 和 tradename搜索相应的药品
     *
     * @param keyword
     * @return
     */
    public CimsResponseWrapper<List> getDrugList(String keyword) throws Exception {
        List<Drug> drugList = null;
        if (keyword != null) {
            try {
                drugList = drugMonRepository.findByIngredientLike(keyword);
                drugList.addAll(drugMonRepository.findByTradeNameLike(keyword));
            } catch (Exception e) {
                e.printStackTrace();
                throw new DrugException(ErrorMsgEnum.QUERY_DATA_ERROR.getMessage());
            }
        }
        return new CimsResponseWrapper<List>(true, null, drugList);
    }

    /**
     * 根据drugid搜索药品
     *
     * @param drugId
     * @return
     */
    public Drug getDrug(Integer drugId) throws Exception {
        Drug drug = null;
        try {
            drug = drugMonRepository.findByDrugId(drugId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new DrugException(ErrorMsgEnum.QUERY_DATA_ERROR.getMessage());
        }
        return drug;
    }

    /**
     * 根据 integer list 查询 drug list
     *
     * @param drugIdList
     * @return
     * @throws Exception
     */
    public Map<Integer, Object> getDrugListByIntegerList(Integer[] drugIdList) throws Exception {

        Map<Integer, Object> drugMap = new HashMap<>();
        try {
            for (int i = 0; i < drugIdList.length; i++) {
                Drug drug = drugMonRepository.findByDrugId(drugIdList[i]);
                drugMap.put(drug.getDrugId(), drug);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new DrugException(ErrorMsgEnum.QUERY_DATA_ERROR.getMessage());
        }
        return drugMap;
    }
}
