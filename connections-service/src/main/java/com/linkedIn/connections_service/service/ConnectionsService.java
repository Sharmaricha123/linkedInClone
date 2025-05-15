package com.linkedIn.connections_service.service;

import com.linkedIn.connections_service.entity.Person;
import com.linkedIn.connections_service.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConnectionsService {

    private  final PersonRepository personRepository;

    public List<Person> getFirstDegreeConnections(Long userId){
        log.info("Getting first degree connections for user id: {}",userId);

        return personRepository.getFirstDegreeConnections(userId);
    }



}
