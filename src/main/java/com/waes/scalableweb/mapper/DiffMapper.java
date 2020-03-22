package com.waes.scalableweb.mapper;

import com.waes.scalableweb.controller.response.DiffDto;
import com.waes.scalableweb.model.DiffEntity;

public class DiffMapper {

    public static DiffDto fromEntity(DiffEntity diffEntity) {
        DiffDto response = new DiffDto();
        response.setId(diffEntity.getId());
        response.setLeft(diffEntity.getLeft());
        response.setRight(diffEntity.getRight());
        return response;
    }

}
