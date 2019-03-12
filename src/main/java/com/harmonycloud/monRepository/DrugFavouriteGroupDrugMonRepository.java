package com.harmonycloud.monRepository;

import com.harmonycloud.entity.DrugFavouriteGroupDrug;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author qidong
 * @date 2019/3/10
 */
@RepositoryRestResource
public interface DrugFavouriteGroupDrugMonRepository extends MongoRepository<DrugFavouriteGroupDrug, Integer> {

    public List<DrugFavouriteGroupDrug> findByDrugFavouriteGroupId(Integer drugFavouriteGroupId);

}
