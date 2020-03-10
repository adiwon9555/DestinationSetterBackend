package hello;

import com.google.gson.Gson;
import model.HelloMessage;
import model.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;


@Controller
public class GreetingController {

    @Autowired
    LoggingController logger;

    @CrossOrigin("*")
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        logger.logger.info("reached here");
        logger.logger.info(new Gson().toJson(message));
        return new Greeting(HtmlUtils.htmlEscape(message.getName()), HtmlUtils.htmlEscape(message.getBody()));
    }
}
