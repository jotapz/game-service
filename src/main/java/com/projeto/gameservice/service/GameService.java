package com.projeto.gameservice.service;

import com.projeto.gameservice.exception.NotFoundException;
import com.projeto.gameservice.model.Game;
import com.projeto.gameservice.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class GameService {
    private final GameRepository gameRepository;


    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    public Game createGame(Game game) {
        return gameRepository.save(game);
    }

    public Game getGame(Long id) {
        return gameRepository.findById(id).orElseThrow(() -> new NotFoundException("Não foi encontrado"));
    }

    public Game updateGame(Long id, Game game) {
        game.setId(id);
        return gameRepository.save(game);
    }

    public void deleteGame(Long id) {
        gameRepository.deleteById(id);
    }
}
