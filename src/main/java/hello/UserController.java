package hello;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @Autowired
    TestManager testManager;

    @RequestMapping("/addUser")
    public void addUser(User user){
        testManager.addUser(user);
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> getAllUsers() {
       return testManager.getUsers();
    }

}
