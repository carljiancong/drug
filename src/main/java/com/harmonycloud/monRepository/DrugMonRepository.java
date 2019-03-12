package com.harmonycloud.monRepository;

import com.harmonycloud.entity.Drug;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @author qidong
 * @date 2019/3/4
 */
@RepositoryRestResource
public interface DrugMonRepository extends MongoRepository<Drug,Integer> {
    public List<Drug> findByIngredientLike(String keyword);

    public List<Drug> findByTradeNameLike(String keyword);

    public Drug findByDrugId(Integer drugId);
}
