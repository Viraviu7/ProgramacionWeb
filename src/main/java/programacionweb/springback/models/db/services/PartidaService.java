package programacionweb.springback.models.db.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import programacionweb.springback.models.db.entities.Partida;
import programacionweb.springback.models.db.repositories.PartidaRepository;

import java.util.List;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    public List<Partida> obtenerTodasLasPartidas() {
        return partidaRepository.findAll();
    }
}
