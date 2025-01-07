package vttp5.paf.day21.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp5.paf.day21.model.Game;
import vttp5.paf.day21.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepo;

    public List<Game> getGames()
    {
        return gameRepo.getGames(5);
    }

    public List<Game> getGames(int count) 
    {
        return gameRepo.getGames(count);
    }
    
}
