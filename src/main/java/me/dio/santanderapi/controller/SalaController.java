package me.dio.santanderapi.controller;

import me.dio.santanderapi.controller.request.SalaRequest;
import me.dio.santanderapi.domain.model.sala.Sala;
import me.dio.santanderapi.domain.model.usuario.Usuario;
import me.dio.santanderapi.domain.repository.SalaRepository;
import me.dio.santanderapi.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sala")
public class SalaController {
    @Autowired
    private SalaService salaRepository;
    @PostMapping
    public Sala cadastrar(@RequestBody SalaRequest sala)
    {
        return salaRepository.create(sala);

    }
    @GetMapping
    public List<Sala> listar()
    {
        return salaRepository.findAll();
    }
    @GetMapping("/{id}")
    public Sala escolher(@PathVariable Long id)
    {
        return salaRepository.findById(id);
    }

    @PutMapping("/{id}/adicionar/{idUsuario}")
    public Sala adicionar(@PathVariable Long id,@PathVariable Long idUsuario)
    {
        return salaRepository.adicionar(id,idUsuario);
    }

}
