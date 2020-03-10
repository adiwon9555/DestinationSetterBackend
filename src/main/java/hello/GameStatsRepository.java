package hello;

import entities.GameStats;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameStatsRepository extends MongoRepository<GameStats,String> {

}
