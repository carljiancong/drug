package com.harmonycloud.monRepository;

import com.harmonycloud.entity.DrugFavouriteGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author qidong
 * @date 2019/3/10
 */
public interface DrugFavouriteGroupMonRepository extends MongoRepository<DrugFavouriteGroup, Integer> {

    public List<DrugFavouriteGroup> findByClinicId(Integer clinicId);
}
