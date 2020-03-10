package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    public String _id;
    public String text;
    public String picurl;
    public String solution;
    public String[] option;

    public static class Constants {
        public static final String id = "_id";
    }
}
