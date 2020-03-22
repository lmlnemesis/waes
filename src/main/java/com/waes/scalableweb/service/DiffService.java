package com.waes.scalableweb.service;

import com.waes.scalableweb.controller.response.DiffDto;
import com.waes.scalableweb.controller.response.DiffResponse;

public interface DiffService {

    /**
     * This service will create a new diff with content value
     * in left side. If the diff exist will override the value
     * in the left side.
     *
     * @param id      identifier of diff
     * @param content new content of diff
     * @return the saved Diff
     */
    DiffDto diffLeft(Integer id, String content);

    /**
     * This service will create a new diff with content value
     * in right side. If the diff exist will override the value
     * in the right side.
     *
     * @param id      identifier of diff
     * @param content new content of diff
     * @return the saved Diff
     */
    DiffDto diffRight(Integer id, String content);

    /**
     * Get the differences in a diff,
     * get result for Equals values, different sizes or same size different content.
     * If are equals size but different content will return the
     *
     * @param id identifier of a diff
     * @return a difference response with result, message and differences if this one exists
     */
    DiffResponse diff(Integer id);

}
