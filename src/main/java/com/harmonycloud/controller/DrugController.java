package com.harmonycloud.controller;

import com.harmonycloud.dto.DrugFavouriteGroupDrugDto;
import com.harmonycloud.dto.DrugFavouriteGroupDto;
import com.harmonycloud.entity.Drug;
import com.harmonycloud.enums.ErrorMsgEnum;
import com.harmonycloud.result.CimsResponseWrapper;
import com.harmonycloud.service.DrugFavouriteGroupService;
import com.harmonycloud.service.DrugService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @date 2019/3/4
 */

@Api(tags = "Drug")
@RestController
public class DrugController {

    @Autowired
    private DrugService drugService;

    @Autowired
    private DrugFavouriteGroupService drugFavouriteGroupService;

    /**
     *  get drug list by key word
     * @param keyword
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "get drug list", httpMethod = "GET")
    @ApiImplicitParam(name = "keyword", value = "keyword", paramType = "query", dataType = "String")
    @GetMapping("/drugList")
    public CimsResponseWrapper<List> searchByKeyword(@RequestParam("keyword") String keyword) throws Exception {
        if (StringUtils.isEmpty(keyword)) {
            return new CimsResponseWrapper<>(false, ErrorMsgEnum.PARAMETER_ERROR.getMessage(), null);
        }
        List<Drug> drugList = drugService.getDrugList(keyword);
        return new CimsResponseWrapper<>(true, null, drugList);
    }

    /**
     * get department favourite drug list
     * @param clinicId
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "get department favourite drug list", httpMethod = "GET")
    @ApiImplicitParam(name = "clinicId", value = "clinicId", paramType = "query", dataType = "Integer")
    @GetMapping("/depFavList")
    public CimsResponseWrapper<List> getDepFavList(Integer clinicId) throws Exception {
        if (clinicId == null) {
            return new CimsResponseWrapper<>(false, ErrorMsgEnum.PARAMETER_ERROR.getMessage(), null);
        }

        List<DrugFavouriteGroupDto> drugFavouriteGroupDtoList = drugFavouriteGroupService.getDepFavList(clinicId);
        return new CimsResponseWrapper<>(true, null, drugFavouriteGroupDtoList);
    }

    /**
     * get drug list by integer list
     * @param drugIdList
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "get drug list by integer list", httpMethod = "GET")
    @ApiImplicitParam(name = "drugIdList", value = "drugIdList", paramType = "query", dataType = "Integer")
    @PostMapping("/drug")
    public CimsResponseWrapper<Map> getDrug(@RequestBody Integer[] drugIdList) throws Exception {

        Map<Integer, Object> drugMap = drugService.getDrugListByIntegerList(drugIdList);
        return new CimsResponseWrapper<Map>(true, null, drugMap);
    }
}
