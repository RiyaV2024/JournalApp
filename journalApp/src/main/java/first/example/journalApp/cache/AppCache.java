package first.example.journalApp.cache;

import first.example.journalApp.entity.ConfigJournalAppEntry;
import first.example.journalApp.repository.ConfigJournalAppRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {
    @Autowired
    private ConfigJournalAppRepository configJournalAppRepository;
    public Map<String, String> App_Cache = new HashMap<>();

    @PostConstruct
    public void init() {
        List<ConfigJournalAppEntry> all = configJournalAppRepository.findAll();
        System.out.println("=== AppCache loaded entries: " + all.size() + " ===");
        for (ConfigJournalAppEntry configJournalAppEntry : all) {
            System.out.println("KEY: [" + configJournalAppEntry.getKey() + "] VALUE: [" + configJournalAppEntry.getValue() + "]");
            App_Cache.put(configJournalAppEntry.getKey(), configJournalAppEntry.getValue());
        }
    }
}