package first.example.journalApp.repository;
import first.example.journalApp.entity.ConfigJournalAppEntry;
import org.bson.types.ObjectId;
import first.example.journalApp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConfigJournalAppRepository extends MongoRepository <ConfigJournalAppEntry, ObjectId> {

}
