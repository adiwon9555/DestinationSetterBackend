package entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gamestats")
public class GameStats {
    @Id
    private String id;
    private String studentId;
    private String correct;
    private String wrong;
    private String unattempted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }

    public String getWrong() {
        return wrong;
    }

    public void setWrong(String wrong) {
        this.wrong = wrong;
    }

    public String getUnattempted() {
        return unattempted;
    }

    public void setUnattempted(String unattempted) {
        this.unattempted = unattempted;
    }

    public static class Constants  {

        public static final String STUDENT_ID = "studentId";
        public static final String GAME_ID = "gameId";
    }
}
