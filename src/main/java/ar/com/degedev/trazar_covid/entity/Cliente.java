package ar.com.degedev.trazar_covid.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Cliente {
    @Id
    private Integer DNI;

    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
}
