package com.enservsolutions.dig.web.controller;

import com.enservsolutions.dig.dto.ConfirmResetTokenReq;
import com.enservsolutions.dig.dto.ResetPW;
import com.enservsolutions.dig.dto.ResetPasswordReq;
import com.enservsolutions.dig.entity.User;
import com.enservsolutions.dig.repository.UserRepository;
import com.enservsolutions.dig.service.EmailService;
import com.enservsolutions.dig.service.MyUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

import java.util.Optional;


@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("reset")
@Slf4j
public class PasswordController {

    private final EmailService emailService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping
    public void emailResetUser(@RequestBody ResetPasswordReq resetPasswordReq) {
        Optional<User> optional = userRepository.findByEmail(resetPasswordReq.getEmail());
        log.info(String.valueOf(optional));
        if(optional.isPresent()) {
            User user = optional.get();
            log.info(String.valueOf(user));
            user.setResetToken(UUID.randomUUID().toString());
            userRepository.save(user);

            SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
            passwordResetEmail.setFrom("poudelsagar530@gmail.com");
            passwordResetEmail.setTo(user.getEmail());
            passwordResetEmail.setSubject("Password Reset Request");
            passwordResetEmail.setText("To reset your password, click the link below:\n" + "http://localhost:8101"
                    + "/reset-form/" + user.getResetToken());

            log.info(String.valueOf(passwordResetEmail));

            emailService.sendEmail(passwordResetEmail);
        }
    }

    @PostMapping("confirm")
    public void confirmNewPassword(@RequestBody ResetPW pw) {
        log.info(String.valueOf(pw));
        Optional<User> user = userRepository.findByResetToken(pw.getToken());
        log.info(String.valueOf(user));
        if (user.isPresent()) {
            User resetUser = user.get();
            resetUser.setPassword(bCryptPasswordEncoder.encode(pw.getPassword()));
            resetUser.setResetToken(null);
            userRepository.save(resetUser);
        }
    }


}
