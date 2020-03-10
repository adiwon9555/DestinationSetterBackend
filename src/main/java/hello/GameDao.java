package hello;

import entities.Game;
import entities.GameStats;
import model.Message;
import model.Question;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("gameDao")
public class GameDao {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    MongoOperations mongoOperations;

    final String COLLECTION = "game";


    public void updateGame(Game game){
        mongoTemplate.insert(game);
    }

    public void addOneCorrect(String studentId, String gameId) {
        Query query = new Query();
        Criteria andCriteria1 = new Criteria().andOperator(Criteria.where(GameStats.Constants.STUDENT_ID).is(studentId), Criteria.where((GameStats.Constants.GAME_ID)).is(gameId));
        GameStats gameStats = mongoOperations.findOne(query, GameStats.class);

        int correct = Integer.parseInt(gameStats.getCorrect());

        Query q =  new Query();
        Criteria andCriteria = new Criteria().andOperator(Criteria.where(GameStats.Constants.STUDENT_ID).is(studentId), Criteria.where((GameStats.Constants.GAME_ID)).is(gameId));
        q.addCriteria(andCriteria);
        Update update = new Update();
        update.set("correct"  , correct + 1);
        mongoTemplate.updateFirst(q,  update, GameStats.class);
    }

    public void addOneIncorrect(String studentId, String gameId) {
        Query query = new Query();
        Criteria andCriteria1 = new Criteria().andOperator(Criteria.where(GameStats.Constants.STUDENT_ID).is(studentId), Criteria.where((GameStats.Constants.GAME_ID)).is(gameId));
        GameStats gameStats = mongoOperations.findOne(query, GameStats.class);

        int wrong = Integer.parseInt(gameStats.getWrong());

        Query q =  new Query();
        Criteria andCriteria = new Criteria().andOperator(Criteria.where(GameStats.Constants.STUDENT_ID).is(studentId), Criteria.where((GameStats.Constants.GAME_ID)).is(gameId));
        q.addCriteria(andCriteria);
        Update update = new Update();
        update.set("correct"  , wrong + 1);
        mongoTemplate.updateFirst(q,  update, GameStats.class);
    }

    public void addOneUnattempted(String studentId, String gameId) {
        Query query = new Query();
        Criteria andCriteria1 = new Criteria().andOperator(Criteria.where(GameStats.Constants.STUDENT_ID).is(studentId), Criteria.where((GameStats.Constants.GAME_ID)).is(gameId));
        GameStats gameStats = mongoOperations.findOne(query, GameStats.class);

        int unattempted = Integer.parseInt(gameStats.getUnattempted());

        Query q =  new Query();
        Criteria andCriteria = new Criteria().andOperator(Criteria.where(GameStats.Constants.STUDENT_ID).is(studentId), Criteria.where((GameStats.Constants.GAME_ID)).is(gameId));
        q.addCriteria(andCriteria);
        Update update = new Update();
        update.set("correct"  , unattempted + 1);
        mongoTemplate.updateFirst(q,  update, GameStats.class);
    }

    public List<GameStats> getGameStat(String gameId) {
        Query q = new Query();
        q.addCriteria(Criteria.where(GameStats.Constants.GAME_ID).is(gameId));
        return mongoOperations.find(q, GameStats.class);
    }

    public Game fetchNewGame() {
        Query q = new Query();
        q.addCriteria(Criteria.where(Game.Constants.GAME_IS_VALID).is("VALID_GAME"));
        return mongoOperations.findOne(q, Game.class);
    }

    public void updateGameStat(Message message, Game game) {
        Query q = new Query();
        GameStats update = new GameStats();
        update.setId(game.getId());
        update.setStudentId(message.get_id());
        update.setCorrect("0");
        update.setWrong("0");
        update.setUnattempted("0");
        mongoOperations.insert(update);
    }

    public List<Question> getQuestions() {
        Query query = new Query();
        Criteria criteria = new Criteria();
        query.addCriteria(Criteria.where(Question.Constants.id).exists(true));
        query.limit(10);
        return mongoTemplate.find(query, Question.class, COLLECTION);
    }
}
