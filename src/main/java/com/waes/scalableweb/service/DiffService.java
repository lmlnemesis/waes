package com.waes.scalableweb.service;

import com.waes.scalableweb.controller.response.DiffResponse;

public interface DiffService {

    /**
     * @param id
     * @return
     */
    Boolean diffLeft(Integer id);

    /**
     * @param id
     * @return
     */
    Boolean diffRight(Integer id);

    /**
     * @param id
     * @return
     */
    DiffResponse diff(Integer id);

}
