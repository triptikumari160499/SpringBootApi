package com.example.simpleviralgames.crud.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleviralgames.crud.model.GameModel;
import com.example.simpleviralgames.crud.respository.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
public class Controller {
    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public List<GameModel> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<GameModel> getGameById(@PathVariable String id) {
        return gameRepository.findById(id);
    }

    @PostMapping
    public GameModel createGame(@RequestBody GameModel game) {
        return gameRepository.save(game);
    }

    @PutMapping("/{id}")
    public GameModel updateGame(@PathVariable String id, @RequestBody GameModel game) {
        game.setId(id);
        return gameRepository.save(game);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable String id) {
        gameRepository.deleteById(id);
    }
}
