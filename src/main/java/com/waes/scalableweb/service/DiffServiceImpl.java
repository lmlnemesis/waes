package com.waes.scalableweb.service;

import com.waes.scalableweb.controller.response.DiffDto;
import com.waes.scalableweb.controller.response.DiffResponse;
import com.waes.scalableweb.excepcion.NotNullException;
import com.waes.scalableweb.mapper.DiffMapper;
import com.waes.scalableweb.model.DiffEntity;
import com.waes.scalableweb.repository.DiffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Objects;
import java.util.Optional;

@Service
public class DiffServiceImpl implements DiffService {

    private DiffRepository diffRepository;

    @Autowired
    public DiffServiceImpl(DiffRepository diffRepository) {
        this.diffRepository = diffRepository;
    }

    @Override
    @Transactional
    public DiffDto diffLeft(Integer id, String content) {
        this.validateDiffRequest(id, content);

        Optional<DiffEntity> optionalDiffEntity = diffRepository.findById(id);

        if (optionalDiffEntity.isPresent()) {
            DiffEntity diffEntity = optionalDiffEntity.get();
            diffEntity.setLeft(content);
            return DiffMapper.fromEntity(diffRepository.save(diffEntity));
        } else {
            DiffEntity newDiff = new DiffEntity();
            newDiff.setId(id);
            newDiff.setLeft(content);
            return DiffMapper.fromEntity(diffRepository.save(newDiff));
        }
    }

    @Override
    @Transactional
    public DiffDto diffRight(Integer id, String content) {
        this.validateDiffRequest(id, content);

        Optional<DiffEntity> optionalDiffEntity = diffRepository.findById(id);
        if (optionalDiffEntity.isPresent()) {
            DiffEntity diffEntity = optionalDiffEntity.get();
            diffEntity.setRight(content);
            return DiffMapper.fromEntity(diffRepository.save(diffEntity));
        } else {
            DiffEntity newDiff = new DiffEntity();
            newDiff.setId(id);
            newDiff.setRight(content);
            return DiffMapper.fromEntity(diffRepository.save(newDiff));
        }
    }

    @Override
    public DiffResponse diff(Integer id) {
        this.validateId(id);

        throw new NotImplementedException();
    }

    private void validateId(Integer id) {
        if (Objects.isNull(id)) {
            throw new NotNullException("Diff id should be not null");
        }
    }

    private void validateDiffRequest(Integer id, String content) {
        this.validateId(id);

        if (Objects.isNull(content)) {
            throw new NotNullException("Content should be not null");
        }
    }

}
