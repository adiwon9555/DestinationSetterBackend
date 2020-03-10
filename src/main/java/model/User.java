package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    public String name;
    public String email;
    public String mobile;
    public int level;
    public String nickname;
    public String _id;

    public static class Constants  {
        public static final String id = "_id";
    }
}


