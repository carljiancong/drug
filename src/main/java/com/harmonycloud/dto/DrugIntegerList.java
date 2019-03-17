package com.harmonycloud.dto;

import java.util.List;

/**
 * @author qidong
 * @date 2019/3/17
 */
public class DrugIntegerList {
    List<Integer> integerList;

    public DrugIntegerList() {
    }

    public DrugIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }
}
