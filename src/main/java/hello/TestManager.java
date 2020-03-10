package hello;

import entities.Game;
import entities.GameStats;
import model.GameState;
import model.Message;
import model.Question;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestManager {

    @Autowired
    GameDao gameDao;

    @Autowired
    UserDao userDao;

    public String getTest(String name){
        return null;
    }

    public Game getGame(Message message) {
        Game game  = gameDao.fetchNewGame();
        gameDao.updateGameStat(message, game);
        return game;
    }

    public List<GameStats> updateGameStat(GameState gameState) {
        if(gameState.getResult() == 1){
            gameDao.addOneCorrect(gameState.getStudentId(), gameState.getGameId());
        }
        else if(gameState.getResult() == -1){
          gameDao.addOneIncorrect(gameState.getStudentId(), gameState.getGameId());
        }
        else if(gameState.getResult() == 0){
            gameDao.addOneUnattempted(gameState.getStudentId(), gameState.getGameId());
        }
        return gameDao.getGameStat(gameState.getGameId());
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public List<User> getUsers() {
        return userDao.getAllUser();
    }

    public List<Question> getQuestions(){
        return gameDao.getQuestions();
    }
}
