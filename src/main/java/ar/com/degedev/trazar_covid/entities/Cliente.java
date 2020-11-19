package ar.com.degedev.trazar_covid.entities;

import lombok.Data;

import javax.persistence.Id;

@Data
public class Cliente {
    @Id
    private Integer DNI;

    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
}
