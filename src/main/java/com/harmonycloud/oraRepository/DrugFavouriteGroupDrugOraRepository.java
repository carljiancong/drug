package com.harmonycloud.oraRepository;

import com.harmonycloud.entity.DrugFavouriteGroupDrug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date 2019/3/10
 */
@Repository
public interface DrugFavouriteGroupDrugOraRepository extends JpaRepository<DrugFavouriteGroupDrug, Integer> {

    List<DrugFavouriteGroupDrug> findByDrugFavouriteGroupId(Integer drugFavouriteGroupId);

}
