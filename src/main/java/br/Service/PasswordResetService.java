package br.Service;

import br.Model.User;
import br.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PasswordResetService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private UserRepository userRepository; // Supondo que você tenha uma classe UserRepository para interagir com o banco de dados

    public void sendPasswordResetToken(String email) {
        // Verifica se o e-mail do usuário existe no banco de dados
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("Usuário não encontrado");
        }

        // Gera um token único
        String token = UUID.randomUUID().toString();

        // Salva o token junto com o email do usuário (por exemplo, em um banco de dados)
        user.setResetToken(token);
        userRepository.save(user);

        // Envia o token por e-mail
        sendEmailWithToken(user.getEmail(), token);
    }

    private void sendEmailWithToken(String email, String token) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Recuperação de senha");
        mailMessage.setText("Use este token para redefinir sua senha: " + token);
        javaMailSender.send(mailMessage);
    }
}

