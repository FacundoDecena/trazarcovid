package ar.com.degedev.trazar_covid.controller;

import ar.com.degedev.trazar_covid.entity.Registro;
import ar.com.degedev.trazar_covid.service.ClienteService;
import ar.com.degedev.trazar_covid.service.RegistroService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    @Resource
    RegistroService registroService;

    @Resource
    ClienteService clienteService;

    @RequestMapping(method = RequestMethod.POST)
    public Registro createRegistro(@RequestBody Registro registro) {
        clienteService.createCliente(registro.getCliente());
        return registroService.createRegistro(registro);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Registro> getAll() {
        return registroService.getAll();
    }

    @RequestMapping(value = "/cliente/{dni}", method = RequestMethod.GET)
    public List<Registro> getRegistrosByClienteDNI(@PathVariable("dni") Integer dni) {
        return registroService.getRegistrosByClienteDNI(dni);
    }

    @RequestMapping(value = "/comercio/{id}", method = RequestMethod.GET)
    public List<Registro> getRegistrosByComercioId(@PathVariable("id") Integer id) {
        return registroService.getRegistrosByComercioId(id);
    }

    @RequestMapping(value = "/fecha", method = RequestMethod.GET)
    public List<Registro> getRegistrosBetweenDates(
            @RequestParam(name = "desde") LocalDateTime desde,
            @RequestParam(name = "hasta") LocalDateTime hasta
    ) {
        return registroService.getRegistrosBetweenDates(desde, hasta);
    }

}
