package com.waes.scalableweb.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiffDto {

    private Integer id;
    private String left;
    private String right;

}
