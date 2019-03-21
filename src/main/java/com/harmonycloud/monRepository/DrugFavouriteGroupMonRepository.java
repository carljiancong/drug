package com.harmonycloud.monRepository;

import com.harmonycloud.entity.DrugFavouriteGroup;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * @date 2019/3/10
 */
@RepositoryRestResource
public interface DrugFavouriteGroupMonRepository extends MongoRepository<DrugFavouriteGroup, Integer> {

    List<DrugFavouriteGroup> findByClinicId(Integer clinicId);
}
