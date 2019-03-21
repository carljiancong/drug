package com.harmonycloud.oraRepository;

import com.harmonycloud.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @date 2019/3/4
 */
@Repository
public interface DrugOraRepository extends JpaRepository<Drug, Integer> {
    List<Drug> findByIngredient(String keyword);

    List<Drug> findByTradeNameContaining(String keyword);

    Drug findByDrugId(Integer drugId);
}
