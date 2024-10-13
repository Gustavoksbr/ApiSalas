package me.dio.santanderapi.service;

import me.dio.santanderapi.controller.request.SalaRequest;
import me.dio.santanderapi.domain.model.sala.Sala;
import me.dio.santanderapi.domain.model.usuario.Usuario;

import java.util.List;

public interface SalaService {
    Sala findById(Long id);
    Sala create(SalaRequest salaToCreate);
    List<Sala> findAll();

    Sala adicionar(Long id, Long idUsuario);
}