package me.dio.santanderapi.domain.model.sala;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.dio.santanderapi.domain.model.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="sala")
public class Sala {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dono_id")
    public Usuario dono;
    @ManyToMany
    @JoinTable(name = "sala_participantes",
            joinColumns = @JoinColumn(name = "sala_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"sala_id", "usuario_id"}))
    public List<Usuario> participantes;
    public String nome;

    public Sala(Usuario d, String n)
    {
        this.dono = d;
        this.nome = n;
        participantes = new ArrayList<>();
    }
    public void adicionarParticipante(Usuario usuario) {
        participantes.add(usuario);
    }
}
