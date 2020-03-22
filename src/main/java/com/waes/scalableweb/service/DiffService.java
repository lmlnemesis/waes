package com.waes.scalableweb.service;

import com.waes.scalableweb.controller.response.DiffDto;
import com.waes.scalableweb.controller.response.DiffResponse;

public interface DiffService {

    /**
     * @param id
     * @return
     */
    DiffDto diffLeft(Integer id, String content);

    /**
     * @param id
     * @return
     */
    DiffDto diffRight(Integer id, String content);

    /**
     * @param id
     * @return
     */
    DiffResponse diff(Integer id);

}
