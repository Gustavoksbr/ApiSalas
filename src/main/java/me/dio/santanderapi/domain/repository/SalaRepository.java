package me.dio.santanderapi.domain.repository;

import me.dio.santanderapi.domain.model.sala.Sala;
import me.dio.santanderapi.domain.model.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala,Long> {
    Usuario findByDono(Usuario dono);
}
