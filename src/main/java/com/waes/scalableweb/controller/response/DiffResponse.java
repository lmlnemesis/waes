package com.waes.scalableweb.controller.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiffResponse {

    private String value;
    private EDiffResult result;
    private List<String> differences;

}
