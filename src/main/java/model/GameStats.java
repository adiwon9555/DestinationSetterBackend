package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameStats {

    private String gameId;
    private String studentId;
    private String correct;
    private String wrong;
    private String unattempted;

}
