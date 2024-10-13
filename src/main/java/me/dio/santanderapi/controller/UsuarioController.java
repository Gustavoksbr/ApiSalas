package me.dio.santanderapi.controller;

import me.dio.santanderapi.domain.model.usuario.Usuario;
import me.dio.santanderapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    public UserService usuarioRepository;
    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario)
    {
        return usuarioRepository.create(usuario);

    }
    @GetMapping
    public List<Usuario> listar()
    {
        return usuarioRepository.findAll();
    }
    @GetMapping("/{id}")
    public Usuario escolher(@PathVariable Long id)
    {
        return usuarioRepository.findById(id);
    }
}
