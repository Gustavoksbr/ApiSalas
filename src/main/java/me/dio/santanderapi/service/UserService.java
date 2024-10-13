package me.dio.santanderapi.service;

import me.dio.santanderapi.domain.model.usuario.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserService {
    Usuario findById(Long id);
    Usuario create(Usuario usuarioToCreate);
    List<Usuario> findAll();
}
