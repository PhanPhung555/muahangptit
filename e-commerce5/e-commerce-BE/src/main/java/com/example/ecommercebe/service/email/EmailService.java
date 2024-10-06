package com.example.ecommercebe.service.email;



import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@AllArgsConstructor
public class EmailService {

    JavaMailSender mailSender;

    public void sendPasswordResetOTP(String mail, String otp){

       String title = "Mã OTP";
        String message = "<html><body>"
                + "<h3>Mã OTP của bạn là: <strong>" + otp + "</strong></h3>"
                + "</body></html>";
        sendHtmlEmail(mail,title,message);

   }

   void sendHtmlEmail(String to, String subject, String htmlBody){
       try {
           MimeMessage message = mailSender.createMimeMessage();
           MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
           helper.setTo(to);
           helper.setSubject(subject);
           helper.setText(htmlBody, true);
           mailSender.send(message);
       } catch (MessagingException e) {
           // Handle exception appropriately
           e.printStackTrace();
       }
   }
}
