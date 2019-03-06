package com.harmonycloud.service;

import com.harmonycloud.entity.Drug;
import com.harmonycloud.monRepository.DrugMonRepository;
import com.harmonycloud.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qidong
 * @date 2019/3/4
 */
@Service
public class DrugService {

    @Autowired
    DrugMonRepository drugMonRepository;

    public Result getDrugList(String keyword) {
        List<Drug> drugList = null;
        if (keyword != null) {
            try {
                drugList = drugMonRepository.findByIngredientLike(keyword);
                drugList.addAll(drugMonRepository.findByTradeNameLike(keyword));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Result.buildSuccess(drugList);
    }
}
