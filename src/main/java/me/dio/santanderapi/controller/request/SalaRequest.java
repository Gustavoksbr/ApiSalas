package me.dio.santanderapi.controller.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SalaRequest {
    public String nome;
    public long id_dono;
}
