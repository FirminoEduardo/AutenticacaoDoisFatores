package br.Service;

import br.Model.User;
import br.RegistrationForm.RegistrationForm;
import br.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class UserService {
    private UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(RegistrationForm registrationForm) {
        if (registrationForm.getPassword() == null) {
            System.out.println("VAZIO");
        }

        User user = new User();
        user.setName(registrationForm.getName());
        user.setEmail(registrationForm.getEmail());
        String encodedPassword = passwordEncoder.encode(registrationForm.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public boolean login(String email, String password) {
        // Buscar o usuário no banco de dados pelo email
        User user = userRepository.findByEmail(email);

        // Verificar se o usuário existe e se a senha está correta
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Login bem-sucedido
            return true;
        } else {
            // Login falhou
            return false;
        }
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
