package me.dio.santanderapi.domain.repository;
import me.dio.santanderapi.domain.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByAccountNumber(String accountNumber);
}
