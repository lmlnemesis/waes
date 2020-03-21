package com.waes.scalableweb.controller;

import com.waes.scalableweb.controller.response.DiffResponse;
import com.waes.scalableweb.service.DiffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class DiffController {

    private DiffService diffService;

    @Autowired
    public DiffController(DiffService diffService) {
        this.diffService = diffService;
    }

    @PostMapping("/diff/{id}/left")
    public ResponseEntity<Boolean> diffLeft(@PathVariable(value = "id") Integer id) {

        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/diff/{id}/right")
    public ResponseEntity<Boolean> diffRight(@PathVariable(value = "id") Integer id) {


        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/diff/{id}")
    public ResponseEntity<DiffResponse> diff(@PathVariable(value = "id") Integer id) {

        return new ResponseEntity<>(new DiffResponse(), HttpStatus.OK);
    }
}
