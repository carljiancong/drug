package com.harmonycloud.oraRepository;

import com.harmonycloud.entity.DrugFavouriteGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date 2019/3/10
 */
@Repository
public interface DrugFavouriteGroupOraRepository extends JpaRepository<DrugFavouriteGroup, Integer> {

    List<DrugFavouriteGroup> findByClinicId(Integer clinicId);
}
