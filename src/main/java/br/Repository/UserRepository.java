package br.Repository;

import br.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}

