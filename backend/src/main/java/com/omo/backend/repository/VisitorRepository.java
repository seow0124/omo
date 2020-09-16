package com.omo.backend.repository;

import com.omo.backend.model.Visitor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VisitorRepository extends MongoRepository<Visitor, String> {

    Visitor findByName(String name);
    List<Visitor> findByVisitTime(LocalDateTime time);
}
