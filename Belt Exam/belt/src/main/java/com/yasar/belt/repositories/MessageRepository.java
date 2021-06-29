package com.yasar.belt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.yasar.belt.models.Message;


@Repository
public interface MessageRepository extends CrudRepository<Message, Long> {
}
