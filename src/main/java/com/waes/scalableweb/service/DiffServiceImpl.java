package com.waes.scalableweb.service;

import com.waes.scalableweb.controller.response.DiffResponse;
import com.waes.scalableweb.repository.DiffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiffServiceImpl implements DiffService {

    private DiffRepository diffRepository;

    @Autowired
    public DiffServiceImpl(DiffRepository diffRepository) {
        this.diffRepository = diffRepository;
    }

    @Override
    public Boolean diffLeft(Integer id) {

        return null;
    }

    @Override
    public Boolean diffRight(Integer id) {

        return null;
    }

    @Override
    public DiffResponse diff(Integer id) {

        return null;
    }
}
