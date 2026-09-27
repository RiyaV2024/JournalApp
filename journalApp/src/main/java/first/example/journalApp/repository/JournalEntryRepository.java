package first.example.journalApp.repository;
import org.bson.types.ObjectId;
import first.example.journalApp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository <JournalEntry, ObjectId> {

}
