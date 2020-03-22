package com.waes.scalableweb.service;

import com.waes.scalableweb.controller.response.DiffDto;
import com.waes.scalableweb.controller.response.DiffResponse;
import com.waes.scalableweb.controller.response.EDiffResult;
import com.waes.scalableweb.excepcion.NotFoundException;
import com.waes.scalableweb.excepcion.NotNullException;
import com.waes.scalableweb.mapper.DiffMapper;
import com.waes.scalableweb.model.DiffEntity;
import com.waes.scalableweb.repository.DiffRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
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

        Optional<DiffEntity> optionalDiffEntity = diffRepository.findById(id);
        if (optionalDiffEntity.isPresent()) {
            DiffEntity diffEntity = optionalDiffEntity.get();

            this.validateSide(diffEntity.getRight(), "Right side should be not null");
            this.validateSide(diffEntity.getLeft(), "Left side should be not null");

            DiffResponse response = new DiffResponse();

            if (diffEntity.getLeft().equals(diffEntity.getRight())) {
                response.setValue("Diff with id:" + id + " are EQUALS");
                response.setResult(EDiffResult.EQUALS);
            } else if (diffEntity.getLeft().length() != diffEntity.getRight().length()) {
                response.setValue("Diff with id:" + id + " got different sizes");
                response.setResult(EDiffResult.DIFFERENT_SIZE);
            } else {
                response.setValue("Diff with id:" + id + " are different");
                response.setResult(EDiffResult.DIFFERENT);

                List<String> differences = new ArrayList<>();
                differences.add(StringUtils.difference(diffEntity.getLeft(), diffEntity.getRight()));
                differences.add(StringUtils.difference(diffEntity.getRight(), diffEntity.getLeft()));

                response.setDifferences(differences);
            }
            return response;
        } else {
            throw new NotFoundException("Diff with id:" + id + " does not exist ");
        }
    }

    private void validateId(Integer id) {
        if (Objects.isNull(id)) {
            throw new NotNullException("Diff id should be not null");
        }
    }

    private void validateSide(String content, String message) {
        if (StringUtils.isEmpty(content)) {
            throw new NotNullException(message);
        }
    }

    private void validateDiffRequest(Integer id, String content) {
        this.validateId(id);

        if (Objects.isNull(content)) {
            throw new NotNullException("Content should be not null");
        }
    }

}
