package com.abijit.droolspoc.controller;

import com.abijit.droolspoc.model.Request;
import com.abijit.droolspoc.model.Response;
import com.abijit.droolspoc.service.DroolsPOCService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/drools")
public class DroolsController {
    private final DroolsPOCService droolsPOCService;

    public DroolsController(DroolsPOCService droolsPOCService) {
        this.droolsPOCService = droolsPOCService;
    }

    @PostMapping("/simple-response")
    public ResponseEntity<Response> getSimpleResponse(@RequestBody Request request) {
        Response response = droolsPOCService.getSimpleResponse(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/response")
    public ResponseEntity<Response> getResponse(@RequestBody Request request) {
        Response response = droolsPOCService.getResponse(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/responses")
    public ResponseEntity<List<Response>> getResponses(@RequestBody Request request) {
        var responses = droolsPOCService.getResponses(request);
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
