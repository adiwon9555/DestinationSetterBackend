package entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "game")
public class Game {
    @Id
    private String id;
    private List<String> qIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getqIds() {
        return qIds;
    }

    public void setqIds(List<String> qIds) {
        this.qIds = qIds;
    }


    public static class Constants  {

        public static final String  GAME_IS_VALID= "VALID_GAME";
    }
}
