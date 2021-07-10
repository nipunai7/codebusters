package intergrative.mit.codebusters.Controllers;

import intergrative.mit.codebusters.Models.EmailConfig;
import intergrative.mit.codebusters.Models.Message;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;

@RestController
@RequestMapping("/message")
public class EmailController {

    private EmailConfig emailConfig;

    public EmailController(EmailConfig emailConfig) {this.emailConfig = emailConfig;}

    @PostMapping
    public void sendMessage(@RequestBody Message message,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ValidationException("Feedback is not valid");
        }

        // Create a mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailConfig.getHost());
        mailSender.setPort(this.emailConfig.getPort());
        mailSender.setUsername(this.emailConfig.getUsername());
        mailSender.setPassword(this.emailConfig.getPassword());

        // Create an email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("sensors@project.com");
        mailMessage.setTo("temperature@server.com");
        mailMessage.setSubject("High Temperature Warning ");
        mailMessage.setText(message.getMessage());

        // Send mail
        mailSender.send(mailMessage);

    }

}
