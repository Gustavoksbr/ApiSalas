package me.dio.santanderapi.service.impl;

import me.dio.santanderapi.domain.model.usuario.Usuario;
import me.dio.santanderapi.domain.repository.UsuarioRepository;
import me.dio.santanderapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private UsuarioRepository usuarioRepository;


    @Autowired
    public UserServiceImpl(UsuarioRepository usuarioRepository)
    {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Usuario create(Usuario usuarioToCreate) {
        if (usuarioRepository.existsByAccountNumber(usuarioToCreate.getAccount().getNumber()))
        {
            throw new IllegalArgumentException("this user IO already exists");
        }
        return usuarioRepository.save(usuarioToCreate);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}
