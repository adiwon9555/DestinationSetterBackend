package hello;


import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("userDao")
public class UserDao {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    MongoOperations mongoOperations;

    final String COLLECTION = "user";

    public List<User> getAllUser(){
        Query query = new Query();
        Criteria criteria = new Criteria();
        query.addCriteria(Criteria.where(User.Constants.id).exists(true));
        return mongoTemplate.find(query, User.class, COLLECTION);
    }


    public void addUser(model.User user) {
        Query query = new Query();
        mongoOperations.insert(user);
    }
}
