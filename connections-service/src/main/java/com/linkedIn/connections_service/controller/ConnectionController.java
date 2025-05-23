package com.linkedIn.connections_service.controller;


import com.linkedIn.connections_service.entity.Person;
import com.linkedIn.connections_service.service.ConnectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/core")
@RequiredArgsConstructor
public class ConnectionController {

    private final ConnectionsService connectionsService;

    @GetMapping("/first-degree")
    public ResponseEntity<List<Person>> getFirstConnections(){
        return  ResponseEntity.ok(connectionsService.getFirstDegreeConnections());
    }

}
