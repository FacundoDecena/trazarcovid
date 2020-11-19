package ar.com.degedev.trazar_covid.controller;

import ar.com.degedev.trazar_covid.entities.Cliente;
import ar.com.degedev.trazar_covid.service.ClienteService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {

    @Resource
    ClienteService clienteService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @RequestMapping(path = "/{dni}", method = RequestMethod.GET)
    public Cliente getClienteByDNI(@PathVariable("dni") Integer clienteDNI) {
        return clienteService.getClienteByDNI(clienteDNI);
    }
}
