package com.waes.scalableweb.repository;

import com.waes.scalableweb.model.DiffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiffRepository extends JpaRepository<DiffEntity, Integer> {


}
