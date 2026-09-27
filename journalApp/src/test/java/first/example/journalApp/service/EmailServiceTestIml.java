package first.example.journalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTestIml {
    @Autowired
    private  EmailService emailService;
    @Test
    void testSendMail(){
        emailService.sendEmail("","Testing Java mail sender","Hi,app kaisa ho");
    }
}
