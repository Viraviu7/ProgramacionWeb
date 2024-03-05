package programacionweb.springback.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import programacionweb.springback.models.db.entities.Sugerencia;
import programacionweb.springback.models.db.repositories.SugerenciaRepository;

import java.util.List;

@Service
public class SugerenciaService {

    @Autowired
    private SugerenciaRepository sugerenciaRepository;

    public List<Sugerencia> obtenerTodasLasSugerencias() {
        return sugerenciaRepository.findAll();
    }
}