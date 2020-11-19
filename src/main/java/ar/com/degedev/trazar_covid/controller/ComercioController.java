package ar.com.degedev.trazar_covid.controller;

import ar.com.degedev.trazar_covid.entity.Comercio;
import ar.com.degedev.trazar_covid.service.ComercioService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(path = "/comercio")
public class ComercioController {

    @Resource
    ComercioService comercioService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Comercio> getComercios() {
        return comercioService.getComercios();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Comercio createComercio(@RequestBody Comercio comercio) {
        return comercioService.createComercio(comercio);
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Comercio getComercioById(@PathVariable("id") Integer comercioId) {
        return comercioService.getComercioById(comercioId);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Comercio createComercio(@PathVariable("id") Integer comercioId, @RequestBody Comercio comercio) {
        return comercioService.updateComercio(comercioId, comercio);
    }

}
