package first.example.journalApp.controller;

import first.example.journalApp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private EmailService emailService;

    // Hit this in browser: http://localhost:8080/test/email?to=your_email@gmail.com
    @GetMapping("/test/email")
    public String testEmail(@RequestParam String to) {
        emailService.sendEmail(
                to,
                "Test Email from Journal App",
                "Agar ye email tumhe mil gaya hai, to matlab tumhara email setup sahi kaam kar raha hai!"
        );
        return "Email bhejne ki koshish ho gayi! Apna inbox check karo: " + to;
    }
}