package com.luxoft.training.spring.cloud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessingRepository extends JpaRepository<ProcessingEntity, Integer> {
    ProcessingEntity findByCard(String card);
    List<ProcessingEntity> findByAccountIdIn(List<Integer> accountIdList);
}
