package me.dio.santanderapi.domain.model.usuario;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_news")
public class News extends BaseItem {

}
