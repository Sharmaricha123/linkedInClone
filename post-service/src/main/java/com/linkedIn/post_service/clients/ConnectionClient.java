package com.linkedIn.post_service.clients;


import com.linkedIn.post_service.dto.PersonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "connections-service",path="/connections")
public interface ConnectionClient {

    @GetMapping("/core/first-degree")
    List<PersonDto> getFirstConnections();

}
