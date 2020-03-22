package com.waes.scalableweb.controller;

import com.waes.scalableweb.controller.response.DiffDto;
import com.waes.scalableweb.controller.response.DiffResponse;
import com.waes.scalableweb.service.DiffService;
import com.waes.scalableweb.util.Base64Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/v1")
public class DiffController {

    private DiffService diffService;

    @Autowired
    public DiffController(DiffService diffService) {
        this.diffService = diffService;
    }

    @Valid
    @PostMapping(path = "/diff/{id}/left", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DiffDto> diffLeft(@PathVariable(value = "id") Integer id,
                                            @RequestBody @NotNull byte[] base64Content) {
        String content = Base64Utils.decode(base64Content);

        return new ResponseEntity<>(diffService.diffLeft(id, content), HttpStatus.OK);
    }

    @PostMapping("/diff/{id}/right")
    public ResponseEntity<DiffDto> diffRight(@PathVariable(value = "id") Integer id,
                                             @RequestBody byte[] base64Content) {
        String content = Base64Utils.decode(base64Content);

        return new ResponseEntity<>(diffService.diffRight(id, content), HttpStatus.OK);
    }

    @GetMapping("/diff/{id}")
    public ResponseEntity<DiffResponse> diff(@PathVariable(value = "id") Integer id) {

        return new ResponseEntity<>(diffService.diff(id), HttpStatus.OK);
    }
}
