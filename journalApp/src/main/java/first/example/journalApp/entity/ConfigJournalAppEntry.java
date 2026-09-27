
package first.example.journalApp.entity;

import java.time.LocalDateTime;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "config_journal_app")
@Data
@NoArgsConstructor
public class ConfigJournalAppEntry {
    private String key;
    private String value;

}
