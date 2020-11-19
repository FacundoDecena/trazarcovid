package ar.com.degedev.trazar_covid.service;

import ar.com.degedev.trazar_covid.entity.Cliente;
import ar.com.degedev.trazar_covid.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Resource
    ClienteRepository clienteRepository;

    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente getClienteByDNI(Integer clienteDNI) {
        return clienteRepository.findById(clienteDNI).orElse(null);
    }
}
