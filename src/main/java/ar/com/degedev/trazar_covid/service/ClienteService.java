package ar.com.degedev.trazar_covid.service;

import ar.com.degedev.trazar_covid.entity.Cliente;
import ar.com.degedev.trazar_covid.entity.Registro;

import java.util.List;

public interface ClienteService {

    Cliente createCliente(Cliente cliente);

    List<Cliente> getClientes();

    Cliente getClienteByDNI(Integer clienteDNI);

    List<Cliente> getClienteByApellido(String apellido);
}
