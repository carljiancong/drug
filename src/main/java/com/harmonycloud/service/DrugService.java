package com.harmonycloud.service;

import com.harmonycloud.dto.DrugIntegerList;
import com.harmonycloud.entity.Drug;
import com.harmonycloud.monRepository.DrugMonRepository;
import com.harmonycloud.result.CimsResponseWrapper;
import com.harmonycloud.result.ErrorMsgConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public CimsResponseWrapper getDrugList(String keyword) throws Exception {
        List<Drug> drugList = null;
        if (keyword != null) {
            try {
                drugList = drugMonRepository.findByIngredientLike(keyword);
                drugList.addAll(drugMonRepository.findByTradeNameLike(keyword));
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception(ErrorMsgConstant.QUERY_DATA_ERROR);
            }
        }
        return CimsResponseWrapper.buildSuccess(drugList);
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
            throw new Exception(ErrorMsgConstant.QUERY_DATA_ERROR);
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
    public List<Drug> getDrugListByIntegerList(Integer[] drugIdList) throws Exception {
        List<Drug> drugList = new ArrayList<>();
        try {
//            for (Integer i: drugIntegerList.getIntegerList()) {
//                Drug drug = drugMonRepository.findByDrugId(i);
//                drugList.add(drug);
//            }
            for (int i = 0; i < drugIdList.length; i++) {
                Drug drug = drugMonRepository.findByDrugId(drugIdList[i]);
                drugList.add(drug);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(ErrorMsgConstant.QUERY_DATA_ERROR);
        }
        return drugList;
    }
}
