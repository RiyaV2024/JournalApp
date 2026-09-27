package first.example.journalApp.service;

import first.example.journalApp.entity.JournalEntry;
import first.example.journalApp.repository.JournalEntryRepository;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
//import java.util.logging.Logger;

import first.example.journalApp.entity.User;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private  UserEntryService userEntryService;
    @Transactional
    public void saveEntry (JournalEntry journalEntry , String userName) {
        try {
            User user = userEntryService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(journalEntry);
            user.getJournalEntries().add(saved);
            userEntryService.saveEntry(user);
        } catch (Exception e) {
            log.info("hahahaaha");
            log.warn("hahaaaha");
            log.error("hahahaaha");
            log.trace("hahahaaha");
            log.debug("hahahaaha");


//            throw new RuntimeException(e);
        }
        }
    public void saveEntry (JournalEntry journalEntry  ) {
        journalEntryRepository.save(journalEntry);
    }


        public List<JournalEntry> getAll(){
        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntry > findById(ObjectId id){
        return journalEntryRepository.findById(id);
    }
    public void deleteById(ObjectId id, String userName){
        User user = userEntryService.findByUserName(userName);
        user.getJournalEntries().removeIf(x ->x.getId().equals(id));
        userEntryService.saveEntry(user);
        journalEntryRepository.deleteById(id);
    }
}
