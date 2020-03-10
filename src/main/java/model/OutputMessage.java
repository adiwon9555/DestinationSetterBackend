package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputMessage
{
    private String from;
    private String message;
    private String topic;
    private Date time = new Date();

    public OutputMessage(String from, String text, String time) {
        this.from = from;
        this.message = text;
        this.time = new Date(time);
    }
}

