package com.waes.scalableweb.service;

import com.waes.scalableweb.controller.response.DiffDto;
import com.waes.scalableweb.excepcion.NotNullException;
import com.waes.scalableweb.model.DiffEntity;
import com.waes.scalableweb.repository.DiffRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DiffServiceTest {

    @Mock
    private DiffRepository diffRepository;

    @InjectMocks
    private DiffService diffService = new DiffServiceImpl(diffRepository);

    @Test(expected = NotNullException.class)
    public void diffLeftNullIdTestFailure() {
        diffService.diffLeft(null, "newTest");
    }

    @Test(expected = NotNullException.class)
    public void diffTightNullIdTestFailure() {
        diffService.diffLeft(null, "newTest");
    }

    @Test(expected = NotNullException.class)
    public void diffRightNullContentTestFailure() {
        diffService.diffRight(1, null);
    }

    @Test(expected = NotNullException.class)
    public void diffLeftNullContentTestFailure() {
        diffService.diffLeft(1, null);
    }

    @Test(expected = NotNullException.class)
    public void diffRightNullIdTestFailure() {
        DiffEntity existValue = new DiffEntity(1, "test", null);
        DiffEntity newValue = new DiffEntity(1, "newTest", null);

        diffService.diffRight(null, "newTest");
    }

    @Test
    public void diffLeftUpdateTestSuccess() {
        DiffEntity existValue = new DiffEntity(1, "test", null);
        DiffEntity newValue = new DiffEntity(1, "newTest", null);

        when(diffRepository.findById(anyInt())).thenReturn(Optional.of(existValue));
        when(diffRepository.save(any())).thenReturn(newValue);

        DiffDto result = diffService.diffLeft(1, "newTest");

        assertEquals(newValue.getId(), result.getId());
        assertEquals(newValue.getLeft(), result.getLeft());
        assertEquals(newValue.getRight(), result.getRight());
    }

    @Test
    public void diffLeftCreateTestSuccess() {
        DiffEntity newValue = new DiffEntity(1, "newTest", null);

        when(diffRepository.findById(anyInt())).thenReturn(Optional.empty());
        when(diffRepository.save(any())).thenReturn(newValue);

        DiffDto result = diffService.diffLeft(1, "newTest");

        assertEquals(newValue.getId(), result.getId());
        assertEquals(newValue.getLeft(), result.getLeft());
        assertEquals(newValue.getRight(), result.getRight());
    }

    @Test
    public void diffRightUpdateTestSuccess() {
        DiffEntity existValue = new DiffEntity(1, "test", null);
        DiffEntity newValue = new DiffEntity(1, "newTest", null);

        when(diffRepository.findById(anyInt())).thenReturn(Optional.of(existValue));
        when(diffRepository.save(any())).thenReturn(newValue);

        DiffDto result = diffService.diffRight(1, "newTest");

        assertEquals(newValue.getId(), result.getId());
        assertEquals(newValue.getLeft(), result.getLeft());
        assertEquals(newValue.getRight(), result.getRight());
    }

    @Test
    public void diffRightCreateTestSuccess() {
        DiffEntity newValue = new DiffEntity(1, "newTest", null);

        when(diffRepository.findById(anyInt())).thenReturn(Optional.empty());
        when(diffRepository.save(any())).thenReturn(newValue);

        DiffDto result = diffService.diffRight(1, "newTest");

        assertEquals(newValue.getId(), result.getId());
        assertEquals(newValue.getLeft(), result.getLeft());
        assertEquals(newValue.getRight(), result.getRight());
    }

}
