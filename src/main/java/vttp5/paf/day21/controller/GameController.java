package vttp5.paf.day21.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp5.paf.day21.model.Game;
import vttp5.paf.day21.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping
public class GameController {
    
    @Autowired
    private GameService gameSvc;

    @GetMapping("/games")
    public ModelAndView getGames(@RequestParam (defaultValue = "5") int count) 
    {
        List<Game> games = gameSvc.getGames(count);

        ModelAndView mav = new ModelAndView("games");
        mav.addObject("games", games);
        mav.setStatus(HttpStatusCode.valueOf(200));

        return mav;
    }
    
}
