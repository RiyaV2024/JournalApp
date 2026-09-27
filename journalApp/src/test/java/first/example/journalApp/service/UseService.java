package first.example.journalApp.service;

import first.example.journalApp.entity.User;
import first.example.journalApp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
@SpringBootTest
public class UseService {
    @Autowired
    private UserRepository userRepository;
    @BeforeEach
    void setUp(){
        
    }

    @ParameterizedTest
    @CsvSource({
            "riya",
            "khushi",
            "vipul",
    })

    public void testFindByUserName(String name){
  assertNotNull(userRepository.findByUserName(name));
//   assertEquals(4,2+2);
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,2"
    })

    public void test (int a, int b,int excepted){
        assertEquals(excepted,a+b);
    }
}

