package ar.com.degedev.trazar_covid.service;

import ar.com.degedev.trazar_covid.entities.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> getClientes();

    Cliente getClienteByDNI(Integer clienteDNI);
}
