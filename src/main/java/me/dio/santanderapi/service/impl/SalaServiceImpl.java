package me.dio.santanderapi.service.impl;

import me.dio.santanderapi.controller.request.SalaRequest;
import me.dio.santanderapi.domain.model.sala.Sala;
import me.dio.santanderapi.domain.model.usuario.Usuario;
import me.dio.santanderapi.domain.repository.SalaRepository;
import me.dio.santanderapi.domain.repository.UsuarioRepository;
import me.dio.santanderapi.service.SalaService;
import me.dio.santanderapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SalaServiceImpl implements SalaService {

    private final SalaRepository salaRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public SalaServiceImpl(SalaRepository sRepository, UsuarioRepository uRepository)
    {
        this.salaRepository = sRepository;
        this.usuarioRepository = uRepository;
    }

    @Override
    public Sala findById(Long id) {
        return salaRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Sala create(SalaRequest salaToCreate) {
        Usuario dono = usuarioRepository.findById(salaToCreate.getId_dono()).orElseThrow(NoSuchElementException::new);
        Sala sala = new Sala(dono, salaToCreate.getNome());
        return salaRepository.save(sala);
    }

    @Override
    public List<Sala> findAll() {
        return salaRepository.findAll();
    }

    @Override
    public Sala adicionar(Long id, Long idUsuario) {
        // Busca a sala pelo ID
        Sala sala = salaRepository.findById(id).orElseThrow(NoSuchElementException::new);

        // Busca o usuário pelo ID
        Usuario usuario = usuarioRepository.findById(idUsuario).orElseThrow(NoSuchElementException::new);

        // Adiciona o usuário à lista de participantes
        sala.adicionarParticipante(usuario);

        // Salva a sala atualizada
        return salaRepository.save(sala);
    }
}
