package first.example.journalApp.repository;
import first.example.journalApp.entity.User;
import org.bson.types.ObjectId;
import first.example.journalApp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User findByUserName(String username);
}