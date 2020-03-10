package hello;


import model.Question;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    TestManager testManager;

    @RequestMapping(value = "/getQuestions", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Question> getQuestions() {
        return testManager.getQuestions();
    }
}
