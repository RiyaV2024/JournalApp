package first.example.journalApp.repository;

import first.example.journalApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryIml {

    @Autowired
    private MongoTemplate mongoTemplate;

    //    public List<User> getUserForSa() {
//        Query query = new Query();
//        query.addCriteria(Criteria.where("userName").is("riya"));
//        return mongoTemplate.find(query, User.class);
//    }
        public List<User> getUserForSa () {
            Query query = new Query();
            query.addCriteria(Criteria.where("email").regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"));
            query.addCriteria(Criteria.where("sentimentAnalysis").is(true));
            List<User> user=mongoTemplate.find(query, User.class);
            return user;
        }
    }
