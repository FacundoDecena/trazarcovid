package ar.com.degedev.trazar_covid.service;

import ar.com.degedev.trazar_covid.entity.Comercio;
import ar.com.degedev.trazar_covid.repository.ComercioRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ComercioServiceImpl implements ComercioService {

    @Resource
    ComercioRepository comercioRepository;

    @Override
    public List<Comercio> getComercios() {
        return comercioRepository.findAll();
    }

    @Override
    public Comercio getComercioById(Integer comercioId) {
        return comercioRepository.findById(comercioId).orElse(null);
    }

    @Override
    public Comercio createComercio(Comercio comercio) {
        return comercioRepository.save(comercio);
    }

    @Override
    public Comercio updateComercio(Integer comercioId, Comercio comercio) {
        Comercio oldComercio = comercioRepository.findById(comercioId).orElse(null);
        if (oldComercio == null) {
            return null;
        }

        comercio.setId(comercioId);
        return comercioRepository.save(comercio);
    }
}
