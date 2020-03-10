package hello;

import entities.Game;
import entities.GameStats;
import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
public class LeaderboardController {

    @Autowired
    private GameStatsRepository gameStatsRepository;

    @Autowired
    private TestManager testManager;

    @MessageMapping("/updateLeaderBoard")
    @SendTo("/test/join")
    public List<GameStats> updateLeaderBoard(GameState gameState){
        return testManager.updateGameStat(gameState);
    }

    @MessageMapping("/startTest")
    @SendTo("test/start")
    public Game startTest(Message message){
        return testManager.getGame(message);
    }

}
