package com.example.simpleviralgames.crud.respository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.simpleviralgames.crud.model.GameModel;

public interface GameRepository extends MongoRepository<GameModel, String> {
}
