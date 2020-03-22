package com.waes.scalableweb.repository;

import com.waes.scalableweb.model.DiffEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiffRepository extends CrudRepository<DiffEntity, Integer> {


}
