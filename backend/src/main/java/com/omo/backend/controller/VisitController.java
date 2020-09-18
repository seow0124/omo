package com.omo.backend.controller;

import com.omo.backend.model.Visitor;
import com.omo.backend.payload.VisitorRequest;
import com.omo.backend.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class VisitController {

    @Autowired
    VisitService visitService;

    @PostMapping("/visitation")
    public ResponseEntity visit(@RequestBody VisitorRequest request) {
        Optional<Visitor> visitor = visitService.writeGuestBook(request.getName());
        if(visitor.isPresent())
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        else
            return new ResponseEntity<>(visitor, HttpStatus.OK);
    }
}